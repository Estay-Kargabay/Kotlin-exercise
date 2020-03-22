package com.demo.seekbarpercentage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var value = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        // seekbar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                value = editText_pricce.text.toString().removePrefix("$").toFloatOrNull() ?: 0f
                editText_pricce.setText("打折（$p1%)")
                calculateResult()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        editText_pricce.setOnEditorActionListener{ textView, actionId, keyEvent ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                value = editText_pricce.text.toString().removePrefix("$").toFloatOrNull() ?: 0f
                editText_pricce.setText("$$value")
                calculateResult()
            }

            // hide keybord
            editText_pricce.clearFocus()
            false

        }

    }

    private fun calculateResult() {
        val discount = seekBar.progress * value / 100
        val total = value - discount
        textView_dicount.text = String.format("%.2f", discount)
        textView_result.text = String.format("%.2f", total)
    }
}