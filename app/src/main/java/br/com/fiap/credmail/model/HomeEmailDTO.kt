package br.com.fiap.credmail.model

data class HomeEmailDTO(val id: Long =0,
                        val remetente: String ="",
                        val titulo: String="",
                        val categoria: Int=0,
                        val conteudo: String="",
                        val flagLido: Boolean =false,
                        val corTexto: Int = 0,
                        val corCard: Int =0,
                        val idUsuario: Long =0) {

}
