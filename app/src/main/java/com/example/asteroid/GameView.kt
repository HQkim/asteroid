package com.example.asteroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.SurfaceHolder
import android.widget.Toast

/**
 * GameView is our playground.
 */

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {
    private val thread: GameThread
    private var asteroids: ArrayList<Asteroid> = ArrayList()
    private var asteroids2: ArrayList<Asteroid2> = ArrayList()

    private var touched: Boolean = false
    private var touched_x: Int = 0
    private var touched_y: Int = 0

    private var score: Int = 0
    private var score2: Int = 0

    init {

        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        // game objects
        for (i in 1..1) {
            asteroids.add(Asteroid(BitmapFactory.decodeResource(resources, R.drawable.asteroid)))
        }


        for (i in 1..1) {
            asteroids2.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
        }

        // start the game thread
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
        Toast.makeText(context, "야야야", Toast.LENGTH_SHORT).show()
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {
        var retry = true
        while (retry) {
            try {
                thread.setRunning(false)
                thread.join()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            retry = false
        }
    }

    /**
     * Function to update the positions of sprites
     */
    fun update() {

        for (asteroid in asteroids) {
            asteroid!!.update()
        }

        for (asteroid in asteroids2) {
            asteroid!!.update()
        }

        if (touched) {
            for (asteroid in asteroids) {
                val term1 = (touched_x >= asteroid.x && touched_x <= asteroid.x + asteroid.w)
                val term2 = (touched_y >= asteroid.y && touched_y <= asteroid.y + asteroid.h)
                if (term1 && term2) {
                    val index = asteroids.indexOf(asteroid)
                    asteroids.removeAt(index)
                    asteroids.add(Asteroid(BitmapFactory.decodeResource(resources, R.drawable.asteroid)))
                    score++
                }
            }

            for (asteroid in asteroids2) {
                val term1 = (touched_x >= asteroid.x && touched_x <= asteroid.x + asteroid.w)
                val term2 = (touched_y >= asteroid.y && touched_y <= asteroid.y + asteroid.h)
                if (term1 && term2) {
                    val index = asteroids2.indexOf(asteroid)
                    asteroids2.removeAt(index)
                    asteroids2.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
                    score2++
                }
            }
        }


        for (asteroid in asteroids) {
            val y_asteroid = asteroid.y
            if (y_asteroid > asteroid.screenHeight - asteroid.h) {
//                Toast.makeText(context, "Asteroids hit the earth!",Toast.LENGTH_SHORT).show()
//                Log.d("TagGameView","Asteroids hit the earth!")
                // Change Activity from GameActivity to ScoreActivity

                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                context.startActivity(intent)
                thread.setRunning(false)
            }

        }

        for (asteroid in asteroids2) {
            val y_asteroid = asteroid.y
            if (y_asteroid > asteroid.screenHeight - asteroid.h) {
//                Toast.makeText(context, "Asteroids hit the earth!",Toast.LENGTH_SHORT).show()
//                Log.d("TagGameView","Asteroids hit the earth!")
                // Change Activity from GameActivity to ScoreActivity

                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                context.startActivity(intent)
                thread.setRunning(false)
            }

        }
    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        for (asteroid in asteroids) {
            asteroid!!.draw(canvas)
        }

        for (asteroid in asteroids2) {
            asteroid!!.draw(canvas)
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // when ever there is a touch on the screen,
        // we can get the position of touch
        // which we may use it for tracking some of the game objects
        touched_x = event.x.toInt()
        touched_y = event.y.toInt()

        val action = event.action
        when (action) {
            MotionEvent.ACTION_DOWN -> touched = true
            MotionEvent.ACTION_MOVE -> touched = true
            MotionEvent.ACTION_UP -> touched = false
            MotionEvent.ACTION_CANCEL -> touched = false
            MotionEvent.ACTION_OUTSIDE -> touched = false
        }
        return true
    }


    fun pause() {
        thread.setRunning(false)
    }

    fun resume() {
        thread.setRunning(true)
    }


}