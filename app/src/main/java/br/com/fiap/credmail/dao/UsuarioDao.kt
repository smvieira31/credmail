package br.com.fiap.credmail.dao

import androidx.room.Dao
import androidx.room.Index
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.credmail.model.Usuario

@Dao
interface UsuarioDao {
    @Query(value = "SELECT * FROM Usuario")
    fun buscaTodos() : List<Usuario>

    @Insert
    fun salvar(vararg usuario: Usuario);
}