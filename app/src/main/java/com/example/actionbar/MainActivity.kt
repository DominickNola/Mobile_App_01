package com.example.actionbar

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.ToggleButton

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        toggleButton?.setOnCheckedChangeListener { _, isChecked ->
            val msg = "Text is " + if (isChecked) "OFF" else "ON"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            if(isChecked) {
                popup.visibility = GONE
            } else {
                popup.visibility = VISIBLE
            }

        }
        val toggleButton3 = findViewById<ToggleButton>(R.id.toggleButton3)
        toggleButton3?.setOnCheckedChangeListener { _, isChecked ->
            val msg = "Background Color " + if (isChecked) "BLUE" else "NORMAL"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            if(isChecked) {
                popup.setBackgroundColor(Color.BLUE)
            } else {
                popup.setBackgroundColor(Color.TRANSPARENT)
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        var selectedOption = ""
        if(item.itemId == R.id.menu_help) {

            selectedOption = "Clicked Help!"
            popup.text = "Clicked Help!"
        }
        if(item.itemId == R.id.action_settings) {

            selectedOption = "Settings"
        }
        Toast.makeText(this, "" + selectedOption, Toast.LENGTH_SHORT).show()

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
