package br.com.fiap.credmail.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.credmail.database.dao.UsuarioDao
import br.com.fiap.credmail.model.Usuario


@Database(entities = [Usuario::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    companion object{
        private lateinit var instance: AppDatabase
        fun getDatabase(context: Context): AppDatabase {
            if(!Companion::instance.isInitialized){
                instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java,"usuario_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}