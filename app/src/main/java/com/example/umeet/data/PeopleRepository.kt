package com.example.umeet.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.umeet.data.db.PeopleDao
import com.example.umeet.data.db.PeopleDatabase
import com.example.umeet.data.model.People
import com.example.umeet.data.net.PeopleInfoProvider

class PeopleRepository(application: Application) {
    private val peopleDao: PeopleDao

    init {
        val peopleDatabase = PeopleDatabase.getInstancce(application)
        peopleDao = peopleDatabase.peopleDao()
    }

    fun getAllPeople(): MutableList<People> {
        return PeopleInfoProvider.peopleList
//        return peopleDao.getAll()
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