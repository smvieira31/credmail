package br.com.fiap.credmail.model

import androidx.room.Entity

@Entity
data class CategoriasCards(val id: Long = 0,
                           val categoria: String = "",
                           val imagem: Int,
                           val corimagem: Int,
                           val corTexto: Int)
