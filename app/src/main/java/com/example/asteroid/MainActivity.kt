package com.example.asteroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asteroid.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isSplash by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)

        overridePendingTransition(0,0)

        isSplash = Myapplication.prefs.getInt("isSplash", 0)

        if (isSplash != 0) {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }

        Myapplication.prefs.setInt("isSplash", 1)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBtnRule.setOnClickListener {
            val intent = Intent(this, RuleActivity::class.java)
            startActivity(intent)
//            Toast.makeText(this, "MainActivity->RuleActivity",Toast.LENGTH_SHORT).show()
        }

        binding.mainBtnStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.mainBtnExit.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        overridePendingTransition(0,0)
    }

    override fun onDestroy() {
        super.onDestroy()
        Myapplication.prefs.setInt("isSplash", 1)
    }

}