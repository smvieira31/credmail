package br.com.fiap.credmail.model

data class HomeEmailDTO(val id: Long,
                        val remetente: String,
                        val titulo: String,
                        val categoria: Int,
                        val conteudo: String,
                        val flagLido: Boolean,
                        val corTexto: Int,
                        val corCard: Int,
                        val idUsuario: Long)
