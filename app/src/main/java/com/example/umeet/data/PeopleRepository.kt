package com.example.umeet.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.umeet.data.db.PeopleDao
import com.example.umeet.data.db.PeopleDatabase
import com.example.umeet.data.model.People

class PeopleRepository(application: Application) {
    private val peopleDao: PeopleDao

    init {
        val peoplDatabase = PeopleDatabase.getInstancce(application)
        peopleDao = peoplDatabase.peopleDao()
    }

    fun getAllPeople(): LiveData<List<People>> {
        return peopleDao.getAll()
    }

    fun insertPeople(people: People) {
        peopleDao.insert(people)
    }

    fun findPeople(id: Int): LiveData<People> {
        return peopleDao.findById(id)
    }

    fun findPeople(name: String): LiveData<List<People>> {
        return peopleDao.findByName(name)
    }
}