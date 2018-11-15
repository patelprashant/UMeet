package com.example.umeet

import android.app.Application
import com.example.umeet.data.PeopleRepository

class UMetApp : Application() {
    fun getPeopleRepository() = PeopleRepository(this)
}