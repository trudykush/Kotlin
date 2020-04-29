package com.kush.learningkotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kush.learningkotlin.R
import com.kush.learningkotlin.data.PersonListAdapter
import com.kush.learningkotlin.model.Person
import kotlinx.android.synthetic.main.activity_recycler_view_u_i.*

class RecyclerViewUI : AppCompatActivity() {

    private var adapter: PersonListAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var personList: ArrayList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_u_i)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        // Setup recyclerView
        recyclerViewID.layoutManager = layoutManager
        recyclerViewID.adapter = adapter

        // load Data
        for (i in 0..16) {
            val person = Person()
            person.name = "Kush" + i
            person.age = 25 + i

            personList?.add(person)
        }

        adapter!!.notifyDataSetChanged()

    // End of onCreate
    }
}
