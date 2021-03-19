package com.therenalproject.test.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.therenalproject.test.Adapters.CommentsAdapter
import com.therenalproject.test.Constants.Companion.POSTKEY
import com.therenalproject.test.DataRepo.GetData
import com.therenalproject.test.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentsActivity : AppCompatActivity() {

    private lateinit var commentsrecycler:RecyclerView
    private lateinit var noComments:TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        commentsrecycler=findViewById(R.id.commentsRecycelrView)
        noComments=findViewById(R.id.noTextPresent)
        progressBar=findViewById(R.id.commentsprogs)
        val getPostId=intent.getStringExtra(POSTKEY)
        val commentsAdapter=CommentsAdapter(this)
        CoroutineScope(Dispatchers.IO).launch {
            GetData.getAllComments(getPostId!!,commentsAdapter,commentsrecycler,noComments,progressBar)

        }

    }
}