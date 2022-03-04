package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FaskesDao {
    @Query("SELECT * FROM faskes")
    fun getAllFaskes():List<Faskes>

    @Insert
    fun insert(vararg faskes: Faskes)

    @Delete
    fun delete(faskes: Faskes)
}
