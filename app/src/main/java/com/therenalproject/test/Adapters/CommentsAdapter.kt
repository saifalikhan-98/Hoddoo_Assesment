package com.therenalproject.test.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.therenalproject.test.Activities.CommentsActivity
import com.therenalproject.test.Constants
import com.therenalproject.test.Models.CommentsList
import com.therenalproject.test.Models.PostClass
import com.therenalproject.test.R
import kotlinx.android.synthetic.main.list_comment.view.*
import kotlinx.android.synthetic.main.list_posts.view.*
import kotlinx.android.synthetic.main.list_posts.view.profilepic

class CommentsAdapter(val context: Context): RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    private val differcallback=object: DiffUtil.ItemCallback<CommentsList>(){
        override fun areItemsTheSame(oldItem: CommentsList, newItem: CommentsList): Boolean {
            return oldItem ==newItem
        }

        override fun areContentsTheSame(oldItem: CommentsList, newItem: CommentsList): Boolean {
            return oldItem==newItem
        }

    }
    var difflist= AsyncListDiffer(this, differcallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.list_comment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val listofdata=difflist.currentList[position]


        val name= listofdata.owner.firstName +""+listofdata.owner.lastName
        val email=listofdata.owner.email
        val profilepicture=listofdata.owner.picture
        val message=listofdata.message


        holder.itemView.apply {
            commentuserName.text=name
            commentemail.text=email

            Glide.with(context)
                .load(profilepicture)
                .into(commentsprofilepic)

            actualcomment.text=message


        }



    }

    override fun getItemCount(): Int {
        return difflist.currentList.size
    }



}