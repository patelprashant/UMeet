package com.example.umeet.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umeet.R
import com.example.umeet.data.model.People
import kotlinx.android.synthetic.main.layout_list_item.view.*

class PeopleListAdapter(
    private val peoplesList: MutableList<People>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(people: People, itemView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peoplesList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(peoplesList[position], clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(people: People, listener: OnItemClickListener) = with(itemView) {
            textViewName.text = people.name
            textViewMet.text = people.metAt
            buttonContact.text = people.contact
            buttonContact.setOnClickListener {
                //start phone intent

            }

            setOnClickListener {
                listener.onItemClick(people, it)
            }
        }
    }
}