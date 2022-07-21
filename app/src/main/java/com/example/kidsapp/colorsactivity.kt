package com.example.kidsapp

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import com.example.kidsapp.databinding.ActivityColorsactivityBinding
import java.util.*

class colorsactivity : AppCompatActivity(), TextToSpeech.OnInitListener{
    private lateinit var binding: ActivityColorsactivityBinding
    private var tts:TextToSpeech? = null
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_colorsactivity)
        tts= TextToSpeech(this, this)
    }
    fun paintandspeak(view: View) {
        var str:String= view.getTag() as String
        tts!!.speak(str,TextToSpeech.QUEUE_FLUSH,null,"")
        when (view.id) {
            R.id.red-> { binding.backkground.setBackgroundColor(Color.parseColor("#FF0026"))
                binding.backkground.setText("RED")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))
                }
            R.id.purple->{binding.backkground.setBackgroundColor(Color.parseColor("#800080"))
                binding.backkground.setText("PURPLE")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.brown->{binding.backkground.setBackgroundColor(Color.parseColor("#FF660000"))
                 binding.backkground.setText("BROWN")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.green->{binding.backkground.setBackgroundColor(Color.parseColor("#FF009900"))
                binding.backkground.setText("GREEN")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.orange->{binding.backkground.setBackgroundColor(Color.parseColor("#D8FB6F11"))
                binding.backkground.setText("ORANGE")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF")) }
            R.id.yellow->{binding.backkground.setBackgroundColor(Color.parseColor("#FFFFCC00"))
                binding.backkground.setText("YELLOW")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.blue->{binding.backkground.setBackgroundColor(Color.parseColor("#E82FD8F6"))
                binding.backkground.setText("BLUE")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.pink->{binding.backkground.setBackgroundColor(Color.parseColor("#FD2AFD"))
                binding.backkground.setText("PINK")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))}
            R.id.violet->{binding.backkground.setBackgroundColor(Color.parseColor("#8f00ff"))
                binding.backkground.setText("VIOLET")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF")) }
            R.id.gray->{binding.backkground.setBackgroundColor(Color.parseColor("#FF787878"))
                binding.backkground.setText("GRAY")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF")) }
            R.id.white->{binding.backkground.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                binding.backkground.setText("WHITE")
                binding.backkground.setTextColor(Color.parseColor("#FF000000"))
                }
            R.id.black->{binding.backkground.setBackgroundColor(Color.parseColor("#FF000000"))
                binding.backkground.setText("BLACK")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            else->{binding.backkground.setBackgroundColor(Color.parseColor("#FF000000"))
                binding.backkground.setText("Click A Color")
                binding.backkground.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
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
