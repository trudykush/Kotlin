package com.kush.learningkotlin

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_image_filter.*
import java.util.*

class ImageFilter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_filter)

        dogImageView.setOnClickListener {
            val colorArray = arrayOf(Color.BLACK, Color.WHITE, Color.CYAN, Color.CYAN, Color.LTGRAY, Color.RED)
            dogImageView.setColorFilter(colorArray[getRandomNumber(colorArray.size)], PorterDuff.Mode.OVERLAY)
        }

        var dataFromMainActivity = intent.extras
        var name: String? = ""
        if (dataFromMainActivity != null) {
            name = dataFromMainActivity.get("Name").toString()
            Toast.makeText(this, name, Toast.LENGTH_LONG).show()
        }

        goBackBtn.setOnClickListener {
            var returnData = this.intent
            returnData.putExtra("Name", "Hello $name, How are you?")
            setResult(Activity.RESULT_OK, returnData)
            finish()
        }
    }

    fun getRandomNumber(arraySize : Int): Int {
        var rand = Random()
        var randomNumber = rand.nextInt(arraySize)
        return randomNumber
    }
}
