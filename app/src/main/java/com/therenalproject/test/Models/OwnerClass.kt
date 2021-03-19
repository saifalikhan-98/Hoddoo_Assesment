package com.therenalproject.test.Models

data class OwnerClass(
    val id:String,
    val email: String,
    val title: String,
    val picture: String,
    val firstName: String,
    val lastName: String
) {
    constructor():this("","","","","","")
}