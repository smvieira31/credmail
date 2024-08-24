package br.com.fiap.credmail.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.credmail.model.Email

@Dao
interface EmailDao {

    @Query(value = "SELECT * FROM Email")
    fun listAll() : List<Email>

    @Insert
    fun salvarEmail(email: Email): Long

    @Query(value = "SELECT * FROM Email WHERE id_usuario = :idUsuario")
    fun listByIdUsuario(idUsuario: Long): List<Email>;

    @Query(value = "SELECT * FROM Email where id_email = :id")
    fun findById(id: Long?) : Email;

    @Query(value = "UPDATE Email SET fl_lido = :lido where id_email = :id")
    fun emailLido(lido: Boolean, id: Long?);

    @Query(value = "SELECT * FROM Email WHERE ds_categoria = :categoria and id_usuario = :id")
    fun buscarCategoria(categoria: String, id: Long?): List<Email>

}