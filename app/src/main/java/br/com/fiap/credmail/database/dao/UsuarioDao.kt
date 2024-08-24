package br.com.fiap.credmail.database.dao

import androidx.room.*
import br.com.fiap.credmail.model.Usuario

@Dao
interface UsuarioDao {
    @Query(value = "SELECT * FROM Usuario")
    fun buscaTodos() : List<Usuario>

    @Insert
    fun salvar(usuario: Usuario): Long;

    @Query(value = "SELECT * FROM Usuario WHERE id_usuario = :id")
    fun findById(id: Long?): Usuario;

    @Query(value = "SELECT * FROM Usuario WHERE ds_email = :email")
    fun findByEmail(email: String): Usuario
}