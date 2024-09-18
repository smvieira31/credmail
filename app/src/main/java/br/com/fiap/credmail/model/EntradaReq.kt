package br.com.fiap.credmail.model

data class EntradaReq(val remetente: String="",
                      val titulo: String = "",
                      val conteudo: String = "",
                      val corTexto: Int = 0,
                      val corCard: Int = 0)
