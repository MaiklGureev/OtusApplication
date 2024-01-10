package ru.gureev.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.gureev.models.database.MarketNewsEntity

@Database(entities = [MarketNewsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun marketNewsDao(): MarketNewsDao
}
