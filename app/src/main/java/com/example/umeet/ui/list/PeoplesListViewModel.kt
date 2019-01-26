package com.example.umeet.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.umeet.UMetApp
import com.example.umeet.data.model.People

class PeoplesListViewModel(applicaiton: Application) : AndroidViewModel(applicaiton) {
    private val peopleRepository = getApplication<UMetApp>().getPeopleRepository()
    private val peopleList = MediatorLiveData<List<People>>()

    init {
        getAllPeople()
    }

    fun getPeopleList(): LiveData<List<People>> {
        return peopleList
    }

    private fun getAllPeople() {
        peopleList.addSource(peopleRepository.getAllPeople()) { peoples ->
            peopleList.postValue(peoples)
        }
    }

}