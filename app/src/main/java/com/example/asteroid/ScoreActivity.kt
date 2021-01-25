package com.example.asteroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.asteroid.databinding.ActivityScoreBinding

class ScoreActivity :AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var score: Int = intent.getStringExtra("score")!!.toInt()
        var score2: Int = intent.getStringExtra("score2")!!.toInt()
        var score_t: Int = score * 3 + score2

        binding.scoreTextScore.text = intent.getStringExtra("score") + "개 x 3점"
        binding.scoreTextScore2.text = intent.getStringExtra("score2") + "개 x 1점"
        binding.scoreTextTotal.text = "총 "+ score_t.toString() +"점!"

        binding.scoreBtnRule.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}