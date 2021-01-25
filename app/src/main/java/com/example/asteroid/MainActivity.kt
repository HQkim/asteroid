package com.example.asteroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.asteroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)

        binding.mainBtnRule.setOnClickListener {
            val intent = Intent(this, RuleActivity::class.java)
            startActivity(intent)
//            Toast.makeText(this, "MainActivity->RuleActivity",Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}