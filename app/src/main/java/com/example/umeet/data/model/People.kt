package com.example.umeet.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class People(
    var name: String = "",
    var metAt: String = "",
    var contact: String = "",
    var eMail: String = "",
    var facebook: String = "",
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)