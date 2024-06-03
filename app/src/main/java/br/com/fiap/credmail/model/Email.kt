package br.com.fiap.credmail.model

data class Email(
    val id: Long = 0,
    val remetente: String = "",
    val titulo: String  = "",
    val categoria: String = "",
    val conteudo: String = "",
    val corTexto: Int,
    val corCard: Int
)