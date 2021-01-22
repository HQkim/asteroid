package com.example.asteroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.asteroid.databinding.ActivityRuleBinding

class RuleActivity: AppCompatActivity() {

    private lateinit var binding: ActivityRuleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRuleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ruleBtnStart.setOnClickListener {
            Toast.makeText(this, "RuleActivity->GameActivity", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}