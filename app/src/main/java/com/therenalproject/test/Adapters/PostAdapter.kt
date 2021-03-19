package com.therenalproject.test.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.therenalproject.test.Activities.CommentsActivity
import com.therenalproject.test.Constants.Companion.POSTKEY
import com.therenalproject.test.Models.PostClass
import com.therenalproject.test.R
import kotlinx.android.synthetic.main.list_posts.view.*


class PostAdapter(val context: Context):RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    private val differcallback=object:DiffUtil.ItemCallback<PostClass>(){
        override fun areItemsTheSame(oldItem: PostClass, newItem: PostClass): Boolean {
            return oldItem ==newItem
        }

        override fun areContentsTheSame(oldItem: PostClass, newItem: PostClass): Boolean {
            return oldItem==newItem
        }

    }
    var difflist=AsyncListDiffer(this, differcallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.list_posts, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val listofdata=difflist.currentList[position]


            val name= listofdata.owner.firstName +""+listofdata.owner.lastName
            val email=listofdata.owner.email
            val profilepicture=listofdata.owner.picture
            val image=listofdata.image
            val captionPhoto=listofdata.text
            val postlink=listofdata.link
            val postid=listofdata.id
            val totallikes=listofdata.likes
            val pubdate=listofdata.publishDate
            val tags=listofdata.tags

            val tagsAdapeter=TagsAdapeter(context)
            tagsAdapeter.difflist.submitList(tags)
            holder.itemView.apply {
                userName.text=name
                userEmail.text=email

                Glide.with(context)
                    .load(profilepicture)
                    .into(profilepic)
                Glide.with(context)
                    .load(image)
                    .into(postphoto)
                postcaption.text=captionPhoto
                postLink.text=postlink

                likes.text=totallikes
                dateuploaded.text=pubdate
                //tagRecyclerview.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
                tagRecyclerview.adapter=tagsAdapeter
                getPostComments.setOnClickListener {
                    val intent= Intent(context,CommentsActivity::class.java)
                    intent.putExtra(POSTKEY,postid)
                    context.startActivity(intent)
                }

        }



    }

    override fun getItemCount(): Int {
        return difflist.currentList.size
    }



}