package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Faskes::class], version = 1)
abstract class FaskesDatabase: RoomDatabase() {
    abstract fun faskesDao(): FaskesDao
}
