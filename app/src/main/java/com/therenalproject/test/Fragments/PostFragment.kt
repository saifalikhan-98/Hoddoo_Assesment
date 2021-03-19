package com.therenalproject.test.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.therenalproject.test.Adapters.PostAdapter
import com.therenalproject.test.DataRepo.GetData
import com.therenalproject.test.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PostFragment : Fragment() {

    private lateinit var recylerview:RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_post, container, false)
        recylerview=view.findViewById(R.id.postRecycelrView)
        postAdapter= PostAdapter(requireContext())
        progressBar=view.findViewById(R.id.postprogs)
        CoroutineScope(Dispatchers.IO).launch {
            GetData.getPost(postAdapter,recylerview,progressBar)

        }


        return view
    }


}