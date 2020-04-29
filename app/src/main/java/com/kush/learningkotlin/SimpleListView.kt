package com.kush.learningkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_simple_list_view.*

class SimpleListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list_view)

        var arrayOfName: Array<String> = arrayOf("Kush", "Kushal", "Piyush", "Billa",
                    "Jack", "Vishal", "Kartik", "Nimi", "Bhaggu", "Tushar", "Kandan",
                    "Sahil", "Jugal", "Shinde", "Baba", "Akhil", "Animesh", "Tau", "Sanket")

        var arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this,
                    android.R.layout.simple_expandable_list_item_1, arrayOfName)

        listview.adapter = arrayAdapter
        
        listview.setOnItemClickListener { adapterView, view, position, id ->
            var itemClicked: String = listview.getItemAtPosition(position).toString()
            Toast.makeText(this, "Id is: $id and" +
                    " Value is ${arrayOfName[position]} or $itemClicked", Toast.LENGTH_LONG).show()
        }

    }
}
