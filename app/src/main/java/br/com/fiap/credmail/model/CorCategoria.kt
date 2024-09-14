package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CorCategoria(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_corcat") val id: Long? = 0L,
    @ColumnInfo("ds_cor")val cor: String = "",
    @ColumnInfo("ds_rdrab_icone") val rdra_icone: Int,
    @ColumnInfo("ds_hexa_icone") val hexa_icone: Long,
    @ColumnInfo("ds_rdrab_fundo") val rdra_fundo: Int,
    @ColumnInfo("ds_hexa_funo") val hexa_fundo: Long,


)