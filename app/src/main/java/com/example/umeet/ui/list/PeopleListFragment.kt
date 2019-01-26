package com.example.umeet.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umeet.R
import com.example.umeet.UMetApp
import com.example.umeet.data.model.People
import kotlinx.android.synthetic.main.fragment_people_list.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PeopleListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PeopleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class PeopleListFragment : Fragment(),
    PeopleListAdapter.OnItemClickListener {
    private lateinit var viewModel: PeoplesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(PeoplesListViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    private fun populatePeopleList(peopleList: MutableList<People>) {
        peopleRecyclerView.adapter = PeopleListAdapter(peopleList, this)
        peopleRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Start observing people list
        viewModel.getPeopleList().observe(this, Observer<List<People>> { peoples ->
            peoples?.let {
                populatePeopleList(peoples as MutableList<People>)
            }
        })
    }

    private fun getAllPeople(peopleList: MutableList<People>) {
        val peopleListAdapter = PeopleListAdapter(peopleList, this)
        peopleRecyclerView.layoutManager = LinearLayoutManager(context)
        peopleRecyclerView.adapter = peopleListAdapter
    }

    override fun onItemClick(people: People, itemView: View) {
        //Open Detail Intent Here
    }
}
