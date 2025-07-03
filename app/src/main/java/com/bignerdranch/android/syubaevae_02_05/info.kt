package com.bignerdranch.android.syubaevae_02_05

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val tvMovieName : TextView = findViewById(R.id.tvMovieName)
        val ivMoviePreview : ImageView = findViewById(R.id.ivMoviePreview)
        val bBack : Button = findViewById(R.id.bBack)

        tvMovieName.text = intent.getStringExtra("MOVIENAME")
        ivMoviePreview.setImageResource(R.drawable.moviepreview)

        bBack.setOnClickListener {
            val intent = Intent(this@info, login::class.java)
            startActivity(intent)
        }
    }
}