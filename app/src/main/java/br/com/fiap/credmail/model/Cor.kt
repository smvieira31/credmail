package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cor(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_cor") val id: Long? = 0L,
    @ColumnInfo("ds_cor")val cor: String = "",
    @ColumnInfo("ds_rdrab") val rdra: Int,
    @ColumnInfo("ds_hexa") val hexa: Long,
    @ColumnInfo("fl_ativo") val flagAtivo: Boolean

)