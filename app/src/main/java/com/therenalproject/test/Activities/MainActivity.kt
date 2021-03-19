package com.therenalproject.test.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.therenalproject.test.Fragments.PostFragment
import com.therenalproject.test.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ft=supportFragmentManager.beginTransaction()
        ft.replace(R.id.framentContainer,PostFragment())
        ft.commit()
    }
}