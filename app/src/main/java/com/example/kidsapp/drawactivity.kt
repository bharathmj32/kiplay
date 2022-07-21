package com.example.kidsapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.LinearLayout

class drawactivity: AppCompatActivity() {
    private var drawView: DrawingView? = null
    private var currPaint: ImageButton? = null
    private var clear: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_drawactivity)
        clear=findViewById(R.id.clear)
        clear!!.setOnClickListener {
            val intent = Intent(this@drawactivity, com.example.kidsapp.drawactivity::class.java)
            startActivity(intent)
        }
        drawView = findViewById<View>(R.id.drawing) as DrawingView
        val paintLayout = findViewById<View>(R.id.paint_colors) as LinearLayout
        currPaint = paintLayout.getChildAt(0) as ImageButton
        currPaint!!.setImageDrawable(resources.getDrawable(R.drawable.paint_pressed))

    }
    fun paintClicked(view: View) {
        //use chosen color
        if (view !== currPaint) {
//update color
            val imgView = view as ImageButton
            val color = view.getTag().toString()
            drawView!!.setColor(color)
            imgView.setImageDrawable(resources.getDrawable(R.drawable.paint_pressed))
            currPaint!!.setImageDrawable(resources.getDrawable(R.drawable.paint))
            currPaint = view
        }
    }
}

