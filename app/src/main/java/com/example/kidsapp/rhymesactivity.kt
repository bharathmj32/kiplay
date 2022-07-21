package com.example.kidsapp

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kidsapp.databinding.ActivityRhymesactivityBinding


class rhymesactivity : AppCompatActivity() {
    private lateinit var binding: ActivityRhymesactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_rhymesactivity)

        binding.apply {
            ttls.setOnClickListener{
                startActivity(Intent().setClass(this@rhymesactivity,ttlsactivity::class.java))
            }
            bbbs.setOnClickListener{
                startActivity(Intent(this@rhymesactivity,bbbsactivity::class.java))
            }
        }
    }
}
