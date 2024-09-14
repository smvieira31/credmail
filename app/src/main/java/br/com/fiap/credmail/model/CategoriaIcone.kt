package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoriaIcone(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_icone") val id: Long? = 0L,
    @ColumnInfo("ds_icone") val descricao: String,
    @ColumnInfo("ds_rdrab") val rdra: Int
)