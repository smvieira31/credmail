package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey @ColumnInfo(name = "id_usuario") val id: Long = 0L,
    @ColumnInfo(name = "nm_usuario")val nome: String ="",
    @ColumnInfo(name = "ds_email")val email: String = "",
    @ColumnInfo(name = "password")val senha: String = "")
