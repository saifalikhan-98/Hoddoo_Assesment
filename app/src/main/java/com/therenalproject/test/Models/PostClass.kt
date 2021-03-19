package com.therenalproject.test.Models

data class PostClass(
    val owner: OwnerClass,
    val id: String,
    val image: String,
    val publishDate:String,
    val text: String,
    val tags: List<String>,
    val link: String,
    val likes: String
){

}