package com.example.kidsapp

import android.databinding.DataBindingUtil
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import com.example.kidsapp.databinding.ActivityFruitsactivityBinding
import java.util.*

class fruitsactivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private lateinit var binding:ActivityFruitsactivityBinding
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_fruitsactivity)
        tts= TextToSpeech(this,this)
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            var result = tts!!.setLanguage(Locale.US)
            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
                Log.e("TTS","Language specified is NOT SUPPORTED")
        }
        else{
            Log.e("TTS","Initialization Failed")
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun birdspeak(v: View){
        var str:String= v.getTag() as String
        tts!!.speak(str,TextToSpeech.QUEUE_FLUSH,null,"")
    }
    override fun onDestroy() {
        if(tts!=null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}