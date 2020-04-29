package com.kush.learningkotlin

import android.app.Activity
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.view.isVisible
import com.kush.learningkotlin.ui.RecyclerViewUI
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val marsGravity: Float = 0.38f
    val jupiterGravity: Float = 2.4f
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var enterWeight = weightET.text

        cilckMeBtn.setOnClickListener {
            var weightOnOtherPlanet = calculateWeighOnMars(enterWeight.toString().toDouble(),
                                   marsCheckBox.isChecked, jupiterCheckBox.isChecked)
            if (enterWeight.isEmpty()) {
                displayTV.text = "Please enter your weight for calculation"
            } else {
                displayTV.text = weightOnOtherPlanet
            }
        }

        goToImageFilterBtn.setOnClickListener {
            var goToImageFilterIntent = Intent(this, ImageFilter::class.java)
            goToImageFilterIntent.putExtra("Name", "Kush")
            startActivityForResult(goToImageFilterIntent, REQUEST_CODE)
        }

        marsCheckBox.setOnClickListener(this)
        jupiterCheckBox.setOnClickListener(this)

        if (TextUtils.isEmpty(weightET.text.toString())) {
            marsCheckBox.visibility = View.INVISIBLE
            jupiterCheckBox.visibility = View.INVISIBLE
        }

        weightET.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (TextUtils.isEmpty(weightET.text.toString())) {
                    marsCheckBox.visibility = View.INVISIBLE
                    jupiterCheckBox.visibility = View.INVISIBLE
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                marsCheckBox.visibility = View.VISIBLE
                jupiterCheckBox.visibility = View.VISIBLE
            }
        })

        goToListViewBtn.setOnClickListener {
            var goToListView = Intent(this, SimpleListView::class.java)
            startActivity(goToListView)
        }

        recyclerViewBtn.setOnClickListener {
            var goToRecyclerViewUI = Intent(this, RecyclerViewUI::class.java)
            startActivity(goToRecyclerViewUI)
        }

    // End of onCreate
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                var messageFromImageFilter = data?.extras?.get("Name").toString()
                Toast.makeText(this, messageFromImageFilter, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun Double.format(digit: Int) =
        java.lang.String.format("%.${digit}f", this)

    /*fun planetClicked(view: View) {
        view as CheckBox
        var whichPlanetChecked: Boolean = view.isChecked
        when (view.id) {
            R.id.marsCheckBox -> {
                if (whichPlanetChecked) {
                    Toast.makeText(this, "Mars Checked", Toast.LENGTH_LONG).show()
                }
            }
            R.id.jupiterCheckBox -> {
                if (whichPlanetChecked) {
                    Toast.makeText(this, "Jupiter Checked", Toast.LENGTH_LONG).show()
                }
            }
        }

    }*/

    private fun calculateWeighOnMars(
        earthWeight: Double,
        marsChecked: Boolean,
        jupiterChecked: Boolean
    ): String {
        if (marsChecked) {
            return "Your weight on Mars is: " + (earthWeight * marsGravity).format(2)
        } else {
            return "Your weight on Jupiter is: " + (earthWeight * jupiterGravity).format(2)
        }
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked

        when (v.id) {
            R.id.marsCheckBox -> {
                if(isChecked && !TextUtils.isEmpty(weightET.text.toString())) {
                    Toast.makeText(this, "Mars Clicked", Toast.LENGTH_LONG).show()
                    jupiterCheckBox.isChecked = false
                }
            }
            R.id.jupiterCheckBox -> {
                if (isChecked && !TextUtils.isEmpty(weightET.text.toString())) {
                    Toast.makeText(this, "Jupiter Clicked", Toast.LENGTH_LONG).show()
                    marsCheckBox.isChecked = false
                }
            }
        }
    }
}
