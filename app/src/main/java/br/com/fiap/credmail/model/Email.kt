package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Email(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_email") val id: Long? = 0L,
    @ColumnInfo("ds_remetente")val remetente: String = "",
    @ColumnInfo("ds_titulo")val titulo: String  = "",
    @ColumnInfo("ds_categoria")val categoria: String = "",
    @ColumnInfo("ds_conteudo")val conteudo: String = "",
    @ColumnInfo("ds_cor_texto")val corTexto: Int,
    @ColumnInfo("ds_cor_Card")val corCard: Int,
    @ColumnInfo("id_usuario") val idUsuario: Long,
    @ColumnInfo("fl_lido") val flagLido: Boolean

)