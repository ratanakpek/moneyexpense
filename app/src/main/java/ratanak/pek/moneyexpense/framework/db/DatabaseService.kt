package ratanak.pek.moneyexpense.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ExpanseEntity::class], version = 1)
abstract class DatabaseService : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    companion object {
        private const val DATABASE_NAME = "expense.db"
        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()

        fun getInstance(context: Context): DatabaseService =
            (instance ?: create(context)).also { instance = it }
    }
}