package ru.gureev.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.gureev.models.database.MarketNewsEntity

@Dao
interface MarketNewsDao {
    @Query("SELECT * FROM MarketNewsEntity")
    fun getAll(): List<MarketNewsEntity>

    @Query("SELECT * FROM MarketNewsEntity WHERE category == :category")
    fun getByCategory(category: String): List<MarketNewsEntity>

    @Query("select category from MarketNewsEntity group by category")
    fun getNewsCategories(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(marketNews: List<MarketNewsEntity>)

    @Delete
    fun delete(marketNewsEntity: MarketNewsEntity)


}
