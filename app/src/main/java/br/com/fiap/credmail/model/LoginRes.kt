package br.com.fiap.credmail.model

data class LoginRes(
    val status: Int = 0,
    val mensagem: String ="",
    val id: Long = 0,
    val email: String = "",
    val nome: String =""
)
