package br.com.fiap.credmail.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.credmail.database.dao.EmailDao
import br.com.fiap.credmail.database.dao.UsuarioDao
import br.com.fiap.credmail.model.Email
import br.com.fiap.credmail.model.Usuario


@Database(entities = [Usuario::class, Email::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao

    abstract fun emailDao() : EmailDao
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