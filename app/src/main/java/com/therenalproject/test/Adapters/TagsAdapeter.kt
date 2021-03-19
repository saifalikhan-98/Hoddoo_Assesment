package com.therenalproject.test.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.therenalproject.test.Models.Tags
import com.therenalproject.test.R
import kotlinx.android.synthetic.main.list_tag.view.*

class TagsAdapeter(val context:Context):RecyclerView.Adapter<TagsAdapeter.ViewHolder>() {

    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){

    }

    private val diffcallback=object:DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

    }
    val difflist=AsyncListDiffer(this,diffcallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_tag,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tagsList=difflist.currentList[position]

        val tag=tagsList
        holder.itemView.apply {

            posttags.text=tag
        }



    }

    override fun getItemCount(): Int {

        return difflist.currentList.size
    }
}