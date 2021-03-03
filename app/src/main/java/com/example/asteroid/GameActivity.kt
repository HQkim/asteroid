package com.example.asteroid

import android.graphics.PixelFormat
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class GameActivity: AppCompatActivity() {

    private var gameView : GameView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        overridePendingTransition(0,0)

        // Setup your SurfaceView
        gameView = GameView(this)
        gameView!!.setZOrderOnTop(true)
        gameView!!.holder.setFormat(PixelFormat.TRANSPARENT)

        // Setup your ImageView
        var bgImagePanel: ImageView = ImageView(this)
        bgImagePanel.setBackgroundResource(R.drawable.background)

        // Use a RelativeLayout to overlap both SurfaceView and ImageView
        var fillParentLayout: RelativeLayout.LayoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT
        )
        var rootPanel : RelativeLayout = RelativeLayout(this)
        rootPanel.layoutParams = fillParentLayout
        rootPanel.addView(gameView, fillParentLayout)
        rootPanel.addView(bgImagePanel, fillParentLayout)

        setContentView(rootPanel)


//        setContentView(gameView)
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