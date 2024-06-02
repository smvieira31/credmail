package br.com.fiap.credmail.model


data class ContatoAgenda(
    val id: Long = 0,
    val nome: String = "",
    val email: String = "",
    val rosto: Int
)

data class CategoriasCards(
    val id: Long = 0,
    val categoria: String = "",
    val imagem: Int,
    val corimagem: Int,
    val corTexto: Int
)
data class Emails(
    val id: Long = 0,
    val remetente: String = "",
    val titulo: String  = "",
    val categoria: String = "",
    val conteudo: String = "",
    val corTexto: Int,
    val corCard: Int
)