package com.example.asteroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.asteroid.databinding.ActivityScoreBinding

class ScoreActivity :AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    private var score_high : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        overridePendingTransition(0,0)

        binding = ActivityScoreBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var score: Int = intent.getStringExtra("score")!!.toInt()
        var score2: Int = intent.getStringExtra("score2")!!.toInt()
        var score_t: Int = score * 3 + score2
        var time: String? = intent.getStringExtra("time")

        binding.scoreTextScore.text = intent.getStringExtra("score") + "개 x 3점"
        binding.scoreTextScore2.text = intent.getStringExtra("score2") + "개 x 1점"
        binding.scoreTextTotal.text = "총 "+ score_t.toString() +"점!"
        binding.scoreTextTime.text = "버틴 시간: "+ time+" 초"

        score_high = Myapplication.prefs.getString("score_high","0")?.toInt()

        if (score_high !=null){
            if (score_t > score_high) {
                Myapplication.prefs.setString("score_high", score_t.toString())
                binding.scoreTextHighMention.text = "최고 점수 갱신!!"
            }
            else{
                binding.scoreTextHighMention.text = "조금 더 분발하세요!!"
            }
        } else{
            Myapplication.prefs.setString("score_high", score_t.toString())
            binding.scoreTextHighMention.text = "한번 더 하시겠어요?"
        }

        binding.scoreTextHigh.text = "최고점수: "+ Myapplication.prefs.getString("score_high", "0") +"점"

        binding.scoreBtnRetry.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.scoreBtnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }





    }
}