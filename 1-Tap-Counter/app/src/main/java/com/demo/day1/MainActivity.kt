package com.demo.day1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private  var count_nomber= 0//globall value of count nomber
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        count()//functionn of count I  mean when u onclick  textview will be display the count nomber
    }
    private fun count() {
        tap_btn.setOnClickListener {
            count_nomber+=1
            textView_count.text=count_nomber.toString()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
          R.id.restBTN->{
              this.count_nomber=0
              this.textView_count.setText("0")
          }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater :MenuInflater= menuInflater
        inflater.inflate(R.menu.menu_btn,menu)
        return true
    }
}
