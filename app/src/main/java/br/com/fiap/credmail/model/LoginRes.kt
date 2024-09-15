package br.com.fiap.credmail.model

data class LoginRes(
    val status: String = "",
    val mensagem: String ="",
    val id: String ="",
    val email: String = "",
    val nome: String =""
)
