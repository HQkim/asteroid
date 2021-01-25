package com.example.asteroid

import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity() {

    private var gameView : GameView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameView = GameView(this)
        setContentView(gameView)
//        setContentView(R.layout.activity_game)
    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this,"GameAcitivty onResume", Toast.LENGTH_SHORT).show()
//        gameView?.resume()
    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this,"GameAcitivty onPause", Toast.LENGTH_SHORT).show()
//        gameView?.pause()
//        val intent = Intent(this, RuleActivity::class.java)
//        startActivity(intent)
//        finish()
    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this,"GameAcitivty onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        Toast.makeText(this,"GameAcitivty onDestroy", Toast.LENGTH_SHORT).show()
    }


}