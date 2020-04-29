package com.kush.learningkotlin.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kush.learningkotlin.R
import com.kush.learningkotlin.model.Person

class PersonListAdapter(private val list: ArrayList<Person>,
                        private val context: Context) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItem(personItem: Person) {
            var name: TextView = itemView.findViewById(R.id.personName) as TextView
            var age: TextView = itemView.findViewById(R.id.personAge) as TextView

            name.text = personItem.name
            age.text = personItem.age.toString()

            itemView.setOnClickListener {
                Toast.makeText(context, name.text, Toast.LENGTH_LONG).show()
            }
        }
    }
}