package com.therenalproject.test.DataRepo

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.therenalproject.test.Adapters.CommentsAdapter
import com.therenalproject.test.Adapters.PostAdapter
import com.therenalproject.test.Models.CommentsBaseClass
import com.therenalproject.test.Models.CommentsList
import com.therenalproject.test.Models.PostClass
import com.therenalproject.test.Models.basedata
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetData {

    companion object{


        fun getPost(postAdapter: PostAdapter,recyclerView: RecyclerView,progressBar: ProgressBar){
            RetrofitInstnce.sericeApi.getPost().enqueue(object:Callback<basedata>{


                override fun onResponse(
                    call: Call<basedata>,
                    response: Response<basedata>
                ) {
                    Log.d("apiresponse",response.body()?.data.toString())
                  /*  val dataarray=response.body()?.get(0)?.data?.get(0)
                    val name=dataarray?.owner?.firstName
                    Log.d("apiresponse",name?:"error")*/
                    progressBar.visibility=View.GONE
                    showResponse(response.body()?.data,postAdapter,recyclerView)
                    val tags=response.body()?.data?.get(0)?.tags
                    Log.d("tags",tags.toString())
                }

                override fun onFailure(call: Call<basedata>, t: Throwable) {
                    Log.d("apiresponse",t.localizedMessage)
                }

            })
        }


        fun getAllComments(post:String,commentsAdapter: CommentsAdapter,recyclerView: RecyclerView,nocomment:TextView,progressBar: ProgressBar){
            RetrofitInstnce.sericeApi.getComments(post).enqueue(object:Callback<CommentsBaseClass>{
                override fun onResponse(
                    call: Call<CommentsBaseClass>,
                    response: Response<CommentsBaseClass>
                ) {
                    Log.d("apiresponse",response.body()?.data.toString())
                    progressBar.visibility=View.GONE
                    showCommentsResponse(response.body()?.data,commentsAdapter,recyclerView,nocomment)
                }

                override fun onFailure(call: Call<CommentsBaseClass>, t: Throwable) {
                    Log.d("apiresponse",t.localizedMessage)
                }

            })
        }

        private fun showCommentsResponse(
            data: List<CommentsList>?,
            commentsAdapter: CommentsAdapter,
            recyclerView: RecyclerView,
            nocomment: TextView
        ) {

            recyclerView.setHasFixedSize(true)
            commentsAdapter.difflist.submitList(data)
            val commentsdata=commentsAdapter.difflist.currentList.size
            if(commentsdata==0){
                nocomment.visibility= View.VISIBLE
            }else{
                nocomment.visibility= View.GONE
            }
            recyclerView.adapter=commentsAdapter
        }

        private fun showResponse(body: List<PostClass>?, postAdapter: PostAdapter, recyclerView: RecyclerView) {
            recyclerView.setHasFixedSize(true)

            Log.d("body",body.toString())
            postAdapter.difflist.submitList(body)
            recyclerView.adapter=postAdapter

        }
    }
}