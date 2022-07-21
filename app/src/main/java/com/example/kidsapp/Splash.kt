package com.example.kidsapp
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

class Splash : AppCompatActivity() {
    var mp: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({ // This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@Splash, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
        // Media Played during the Splash Screen Running for the set Duration
        mp = MediaPlayer()
        mp = MediaPlayer.create(this, R.raw.splashs1)
        mp!!.start()
    }
    override fun onBackPressed() {
        finish()
        System.exit(0)
    }
    companion object {
        // Splash screen timer
        private const val SPLASH_TIME_OUT = 4000
    }
}