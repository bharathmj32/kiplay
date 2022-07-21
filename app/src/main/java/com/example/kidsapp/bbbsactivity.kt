package com.example.kidsapp


import android.databinding.DataBindingUtil
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.AudioManager.*
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.example.kidsapp.databinding.ActivityBbbsactivityBinding


class bbbsactivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    private lateinit var binding:ActivityBbbsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_bbbsactivity)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        mp = MediaPlayer()
        mp = MediaPlayer.create(this, R.raw.bbbs)
        //mp!!.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp!!.setLooping(true)
        //mp!!.prepareAsync()
        mp!!.start()

    }

    override fun onBackPressed() {
        finish()
        System.exit(0)
    }
}

