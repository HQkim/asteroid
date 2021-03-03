package com.example.asteroid

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    var prevStarted = "no"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Myapplication.prefs.setString("prevStarted", "yes")

        SystemClock.sleep(500)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()


        if (prevStarted!="no") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

//        prevStarted = Myapplication.prefs.getString("prevStarted", "no")

    }

}