package br.com.fiap.credmail.database.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.fiap.credmail.model.Email

@Dao
interface EmailDao {

    @Query(value = "SELECT * FROM Email")
    fun listAll() : List<Email>

}