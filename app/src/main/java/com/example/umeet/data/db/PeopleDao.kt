package com.example.umeet.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.umeet.data.model.People

@Dao
interface PeopleDao {
    // Queries

    // Select All
    @Query("SELECT * FROM People ORDER BY id DESC")
    fun getAll(): LiveData<List<People>>

    // Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People)

    // Delete All
    @Query("DELETE FROM People")
    fun deleteAll()

    // Select by id
    @Query("SELECT * FROM People WHERE id = :id")
    fun findById(id: Int): LiveData<People>

    // Select by name
    @Query("SELECT * FROM People WHERE name LIKE '%' || :name || '%'  ")
    fun findByName(name: String): LiveData<List<People>>
}