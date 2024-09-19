package br.com.fiap.credmail.model


data class EmailEnviado(
    val para: String = "",
    val titulo: String = "",
    val conteudo: String = "",
    val idUsuario: Long =0
)
