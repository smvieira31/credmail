package br.com.fiap.credmail.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.fiap.credmail.dao.UsuarioDao
import br.com.fiap.credmail.model.Usuario

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabas : RoomDatabase() {
    abstract fun userDao(): UsuarioDao
}