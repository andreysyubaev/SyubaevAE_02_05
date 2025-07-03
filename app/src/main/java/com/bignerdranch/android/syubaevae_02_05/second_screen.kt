package com.bignerdranch.android.syubaevae_02_05

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class second_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        val tvMovieName : TextView = findViewById(R.id.tvMovieName)
        val ivMoviePreview : ImageView = findViewById(R.id.ivMoviePreview)

        val b1 : Button = findViewById(R.id.b1)
        val b2 : Button = findViewById(R.id.b2)
        val b3 : Button = findViewById(R.id.b3)
        val b4 : Button = findViewById(R.id.b4)

        b2.setOnClickListener {
            val intent = Intent(this@second_screen, info::class.java)

            val movieName = tvMovieName.text.toString()
            val moviePreview = ivMoviePreview.drawable

            intent.putExtra("MOVIENAME", movieName)
            intent.putExtra("MOVIEPREVIEW", moviePreview)

            startActivity(intent)
        }

    }
}

private fun Intent.putExtra(s: String, moviePreview: Drawable?) {
    TODO("Not yet implemented")
}
