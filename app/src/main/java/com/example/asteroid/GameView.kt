package com.example.asteroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.*
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
    private var asteroids3: ArrayList<Asteroid2> = ArrayList()
    private var asteroids4: ArrayList<Asteroid2> = ArrayList()

    private var touched: Boolean = false
    private var touchedX: Int = 0
    private var touchedY: Int = 0

    private var score: Int = 0
    private var score2: Int = 0
    private var scoreTotal: Int = 0

    private var paint: Paint = Paint()
    var timeSecond: Long = 0

    init {

        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)

        // set paint
        paint.color = Color.WHITE
        paint.textSize = 60f
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        // asteroid created
        for (i in 1..1) {
            asteroids.add(Asteroid(BitmapFactory.decodeResource(resources, R.drawable.asteroid)))
        }

        // asteroid2 created
        for (i in 1..1) {
            asteroids2.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
        }

        // asteroid3 created
        for (i in 1..1) {
            asteroids3.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
        }

        for (i in 1..1) {
            asteroids4.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
        }

        // start the game thread
        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
//        Toast.makeText(context, "SurfaceChanged", Toast.LENGTH_SHORT).show()
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
     * Function to update the positions of asteroids
     */
    fun update() {

        for (asteroid in asteroids) {
            asteroid!!.update()
        }

        for (asteroid in asteroids2) {
            asteroid!!.update()
        }

        for (asteroid in asteroids3) {
            asteroid!!.update()
        }

        for (asteroid in asteroids4) {
            asteroid!!.update()
        }

        if (touched) {
            for (asteroid in asteroids) {
                val term1 = (touchedX >= asteroid.x - 0*asteroid.w && touchedX <= asteroid.x + 1*asteroid.w)
                val term2 = (touchedY >= asteroid.y - 0*asteroid.h && touchedY <= asteroid.y + 1*asteroid.h)
                if (term1 && term2) {
                    val index = asteroids.indexOf(asteroid)
                    asteroids.removeAt(index)
                    asteroids.add(Asteroid(BitmapFactory.decodeResource(resources, R.drawable.asteroid)))
                    score++
                }
            }

            for (asteroid in asteroids2) {
                val term1 = (touchedX >= asteroid.x - 0*asteroid.w && touchedX <= asteroid.x + 1*asteroid.w)
                val term2 = (touchedY >= asteroid.y - 0*asteroid.h && touchedY <= asteroid.y + 1*asteroid.h)
                if (term1 && term2) {
                    val index = asteroids2.indexOf(asteroid)
                    asteroids2.removeAt(index)
                    asteroids2.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
                    score2++
                }
            }

            for (asteroid in asteroids3) {
                val term1 = (touchedX >= asteroid.x - 0*asteroid.w && touchedX <= asteroid.x + 1*asteroid.w)
                val term2 = (touchedY >= asteroid.y - 0*asteroid.h && touchedY <= asteroid.y + 1*asteroid.h)
                if (term1 && term2) {
                    val index = asteroids3.indexOf(asteroid)
                    asteroids3.removeAt(index)
                    asteroids3.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
                    score2++
                }
            }

            for (asteroid in asteroids4) {
                val term1 = (touchedX >= asteroid.x - 0*asteroid.w && touchedX <= asteroid.x + 1*asteroid.w)
                val term2 = (touchedY >= asteroid.y - 0*asteroid.h && touchedY <= asteroid.y + 1*asteroid.h)
                if (term1 && term2) {
                    val index = asteroids4.indexOf(asteroid)
                    asteroids4.removeAt(index)
                    asteroids4.add(Asteroid2(BitmapFactory.decodeResource(resources, R.drawable.asteroid2)))
                    score2++
                }
            }
        }


        // Game Over when asteroids hit the ground

        for (asteroid in asteroids) {
            val asteroidY = asteroid.y
            if (asteroidY > asteroid.screenHeight - asteroid.h - 5) {
                // Change Activity from GameActivity to ScoreActivity
                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                intent.putExtra("time", timeSecond.toString())
                context.startActivity(intent)
                thread.setRunning(false)
            }
        }

        for (asteroid in asteroids2) {
            val asteroidY = asteroid.y
            if (asteroidY > asteroid.screenHeight - asteroid.h) {
                // Change Activity from GameActivity to ScoreActivity
                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                intent.putExtra("time", timeSecond.toString())
                context.startActivity(intent)
                thread.setRunning(false)
            }

        }

        for (asteroid in asteroids3) {
            val asteroidY = asteroid.y
            if (asteroidY > asteroid.screenHeight - asteroid.h) {
                // Change Activity from GameActivity to ScoreActivity
                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                intent.putExtra("time", timeSecond.toString())
                context.startActivity(intent)
                thread.setRunning(false)
            }

        }

        for (asteroid in asteroids4) {
            val asteroidY = asteroid.y
            if (asteroidY > asteroid.screenHeight - asteroid.h) {
                // Change Activity from GameActivity to ScoreActivity
                val intent = Intent(context, ScoreActivity::class.java)
                intent.putExtra("score", score.toString())
                intent.putExtra("score2", score2.toString())
                intent.putExtra("time", timeSecond.toString())
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

        canvas!!.drawColor(0, PorterDuff.Mode.CLEAR)

        for (asteroid in asteroids) {
            asteroid!!.draw(canvas)
        }

        for (asteroid in asteroids2) {
            asteroid!!.draw(canvas)
        }

        for (asteroid in asteroids3) {
            asteroid!!.draw(canvas)
        }

        for (asteroid in asteroids4) {
            asteroid!!.draw(canvas)
        }

        scoreTotal = score * 3 + score2

        canvas!!.drawText("Score:  $scoreTotal", 200f, 60f, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // when ever there is a touch on the screen,
        // we can get the position of touch
        // which we may use it for tracking some of the game objects
        touchedX = event.x.toInt()
        touchedY = event.y.toInt()

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