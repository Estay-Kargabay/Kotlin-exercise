package com.demo.scalableimageview

import android.os.Bundle
import android.provider.ContactsContract
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.time.Instant


class MainActivity : AppCompatActivity() {
    val imgURL = listOf<String>(
       "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRh-aDmLVhtfQhlTPkp6KxD9JCvKQKfhCM1SFWeFx2-AUI4zrkJ"
    ,"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQc6gGSMwaK23Vb0wzW8DS6SkS6MIkqa4UmzoIbNR8jPB3K7MWk")
  //  val imgURL = "https://inducesmile.com/wp-content/uploads/2019/02/android_imageview_picaso.jpg"
    var im =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ImageView = findViewById<ImageView>(R.id.imageView2)

        ImageView.setOnClickListener {
            Toast.makeText(this, "Works", Toast.LENGTH_SHORT).show()
            Picasso.get().load(imgURL.component2()).into(ImageView)
        }
    }
        override fun onTouchEvent(event: MotionEvent?): Boolean {

            when(event?.actionMasked)
            {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(this,"action down",Toast.LENGTH_SHORT).show()
                    println("action down")
                }
                MotionEvent.ACTION_POINTER_DOWN -> {
                    Toast.makeText(this,"pointer down",Toast.LENGTH_SHORT).show()

                    println("pointer down")
                }
                MotionEvent.ACTION_MOVE -> {
                    Toast.makeText(this,"action move",Toast.LENGTH_SHORT).show()

                    println("action move")
                }
                MotionEvent.ACTION_POINTER_UP -> {

                    Toast.makeText(this,"pointer up",Toast.LENGTH_SHORT).show()

                    println("pointer up")
                }
                MotionEvent.ACTION_UP -> {
                    Toast.makeText(this,"action up",Toast.LENGTH_LONG).show()

                    println("action up")
                }
            }
            return super.onTouchEvent(event)
        }
    }

