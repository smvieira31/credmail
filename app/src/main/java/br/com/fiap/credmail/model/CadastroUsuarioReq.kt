package br.com.fiap.credmail.model

data class CadastroUsuarioReq(
    val nome: String = "",
    val password: String = "",
    val confirma: String = "",
    val email: String =""
)
