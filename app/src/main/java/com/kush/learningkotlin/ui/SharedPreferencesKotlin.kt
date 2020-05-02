package com.kush.learningkotlin.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kush.learningkotlin.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesKotlin : AppCompatActivity() {

    val PREFS_NAME = "myPrefs"
    val MODE = Context.MODE_PRIVATE
    var myPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        saveSharedPref.setOnClickListener {
            myPref = this.getSharedPreferences(PREFS_NAME, MODE)
            var editor: SharedPreferences.Editor = myPref!!.edit()
            var message = enterForSharedPref.text.toString()
            if (!(TextUtils.isEmpty(message))) {
                editor.putString("USERTEXT", message)
                editor.apply()
            } else {
                Toast.makeText(this, "Please Enter Something!",
                        Toast.LENGTH_LONG).show()
            }
        }

        var getDataBack: SharedPreferences = getSharedPreferences(PREFS_NAME, MODE)
        if(getDataBack.contains("USERTEXT")) {
            var getMessage = getDataBack.getString("USERTEXT", "Not Found!")
            resultSharedPref.text = getMessage
        }

    }
}
