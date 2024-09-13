package br.com.fiap.credmail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmailEnviado(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_email_enviado")val id: Long? = 0L,
    @ColumnInfo(name = "ds_destinatario")val destinatario: String ="",
    @ColumnInfo(name = "ds_texto")val texto: String ="",
    @ColumnInfo(name = "ds_titulo")val titulo: String ="",
    @ColumnInfo(name = "fl_spam")val spam: Boolean
)
