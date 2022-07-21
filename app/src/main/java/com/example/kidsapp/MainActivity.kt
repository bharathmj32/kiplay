package com.example.kidsapp

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import com.example.kidsapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener  {
    private lateinit var binding: ActivityMainBinding
    private var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        tts= TextToSpeech(this,this)
        binding.apply {
            alphabets.setOnClickListener{
                startActivity(Intent(this@MainActivity,alphabetactivity::class.java))
                tts!!.speak("english alphabet",TextToSpeech.QUEUE_FLUSH,null,"")
            }
            colors.setOnClickListener{
                startActivity(Intent(this@MainActivity,colorsactivity::class.java))
                tts!!.speak("colors",TextToSpeech.QUEUE_FLUSH,null,"")
            }
            animals.setOnClickListener{
                startActivity(Intent(this@MainActivity,animalactivity::class.java))
                tts!!.speak("animals",TextToSpeech.QUEUE_FLUSH,null,"")
            }
            days.setOnClickListener{
                startActivity(Intent(this@MainActivity,daysactivity::class.java))
                tts!!.speak("days of the week",TextToSpeech.QUEUE_FLUSH,null,"")
            }
            draw.setOnClickListener{
                startActivity(Intent(this@MainActivity,drawactivity::class.java))
                tts!!.speak("drawing",TextToSpeech.QUEUE_FLUSH,null,"")
            }
            rhymes.setOnClickListener({
                startActivity(Intent(this@MainActivity,rhymesactivity::class.java))
                tts!!.speak("rhymes",TextToSpeech.QUEUE_FLUSH,null,"")
            })
            fruits.setOnClickListener({
                startActivity(Intent(this@MainActivity,fruitsactivity::class.java))
                tts!!.speak("fruits",TextToSpeech.QUEUE_FLUSH,null,"")
            })

        }
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
    override fun onDestroy() {
        if(tts!=null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}

