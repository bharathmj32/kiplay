package com.example.kidsapp
import android.databinding.DataBindingUtil
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.example.kidsapp.databinding.ActivityTtlsactivityBinding

class ttlsactivity : AppCompatActivity() {
    var mp: MediaPlayer? = null
    private lateinit var binding: ActivityTtlsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding= DataBindingUtil.setContentView(this, R.layout.activity_ttlsactivity)
        val anim = RotateAnimation(0f, 350f, 15f, 15f)
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = Animation.INFINITE
        anim.duration = 1000
        binding.img1!!.startAnimation(anim)

        val anim2 = RotateAnimation(0f, 350f, 15f, 15f)
        anim2.interpolator = LinearInterpolator()
        anim2.repeatCount = Animation.INFINITE
        anim2.duration = 1000
        binding.img2!!.startAnimation(anim2)

        val anim3 = RotateAnimation(0f, 350f, 15f, 15f)
        anim3.interpolator = LinearInterpolator()
        anim3.repeatCount = Animation.INFINITE
        anim3.duration = 1000
        binding.img3!!.startAnimation(anim3)

        val anim4 = RotateAnimation(0f, 350f, 15f, 15f)
        anim4.interpolator = LinearInterpolator()
        anim4.repeatCount = Animation.INFINITE
        anim4.duration = 1000
        binding.img4!!.startAnimation(anim4)

        mp = MediaPlayer()
        mp = MediaPlayer.create(this, R.raw.ttls)
        //mp!!.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mp!!.setLooping(true)
       // mp!!.prepareAsync()
        mp!!.start()
    }

    override fun onBackPressed() {
        finish()
        System.exit(0)
    }
}
