package com.demo.imagepicker

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ACTION_CAMERA_REQUEST_CODE = 100
    private val ACTION_ALBUM_REQUEST_CODE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){}

        btn_camera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, ACTION_CAMERA_REQUEST_CODE)
        }
        btn_album.setOnClickListener{
            //takeImageFromAlbumWithIntent()
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, ACTION_ALBUM_REQUEST_CODE)
        }
     imageView.scaleType = ImageView.ScaleType.CENTER_CROP
    }
    private fun displayImage(bitmap: Bitmap) =imageView.setImageBitmap(bitmap)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println(" result code $requestCode")
        when(requestCode) {
            ACTION_CAMERA_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK && data != null){
                    displayImage(data.extras?.get("data") as Bitmap)
                }
            }
            ACTION_ALBUM_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK && data != null){
                    val resolver = this.contentResolver
                    val bitmap = MediaStore.Images.Media.getBitmap(resolver, data?.data)
                    displayImage(bitmap)

                }
            }
            else -> {
                println("no handler onActivityReenter")
            }
        }
    }
}