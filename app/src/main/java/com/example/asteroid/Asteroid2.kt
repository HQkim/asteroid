package com.example.asteroid

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import java.util.*


class Asteroid2(var image: Bitmap) {
    var x: Int = 0
    var y: Int = 0
    var w: Int = 0
    var h: Int = 0
    private var xVelocity = 0
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    val random = Random()

    var isVisible = true

    init {
        w = image.width
        h = image.height

//        x = screenWidth/2
        x= random.nextInt(screenWidth-w)
        y = 300 // screenHeight/2

        y = random.nextInt(200)+100
        yVelocity = random.nextInt(10) +8

    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    fun update() {
        // val randomNum = ThreadLocalRandom.current().nextInt(1, 5)

//        if (x > screenWidth - image.width || x < image.width) {
//            xVelocity = xVelocity * -1
//        }
//        if (y > screenHeight - image.height  || y < image.height) {
//            yVelocity = yVelocity * -1
//        }
        if (y > screenHeight - image.height ) {
            yVelocity = 0
        }

        x += (xVelocity)
        y += (yVelocity)
    }

}