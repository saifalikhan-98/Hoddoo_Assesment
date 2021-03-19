package com.therenalproject.test.Apis

import com.therenalproject.test.Models.CommentsBaseClass
import com.therenalproject.test.Models.basedata
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCalls {
    @GET("post?limit=10")
    fun getPost(): Call<basedata>

    @GET("post/{postid}/comment?limit=10")
    fun getComments(
        @Path("postid") postid:String
    ):Call<CommentsBaseClass>
}