package br.com.fiap.credmail.repository

import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.CategoriasCards
import br.com.fiap.credmail.model.ContatoAgenda
import br.com.fiap.credmail.model.Cor
import br.com.fiap.credmail.model.CorCategoria
import br.com.fiap.credmail.model.Email
import br.com.fiap.credmail.model.Icone

fun getAllContatos(): List<ContatoAgenda> {
    return listOf(
        ContatoAgenda(id = 1, nome = "Sara Souza", email = "sara.souza@exemplo.com", rosto = R.drawable.user),
        ContatoAgenda(id = 1, nome = "Davi João", email = "davi.joao@exemplo.com", rosto = R.drawable.user)
    )
}

fun getAllCategorias(): List<CategoriasCards> {
    return listOf(
        CategoriasCards(id = 1, categoria = "Mobilidade",  imagem = R.drawable.mobilidade, corimagem = R.color.amarelo, corTexto = R.color.amarelinho),
        CategoriasCards(id = 2, categoria = "Financeiro",  imagem = R.drawable.bag, corimagem = R.color.vermelho, corTexto = R.color.vermelhinho),
        CategoriasCards(id = 2, categoria = "Bem-estar",  imagem = R.drawable.coracao, corimagem = R.color.outroazul, corTexto = R.color.outroazulzinho),
    )
}
fun getAllEmails(): List<Email> {
    return listOf(
        Email(id = 1, remetente = "PicPay",titulo = "Dê mais pique pro seu dinheiro!",categoria = "Financeiro", conteudo = "...", corTexto = R.color.vermelho, corCard = R.color.vermelhinho, idUsuario = 1,flagLido = false),
        Email(id = 2, remetente = "Decolar",titulo = "Eba! Sua viagem está confirmada",categoria = "Mobilidade", conteudo = "...", corTexto = R.color.amarelo, corCard = R.color.amarelinho, idUsuario = 2,flagLido = false),
        Email(id = 3, remetente = "Amil",titulo = "Quer viver a vida ao máximo",categoria = "Bem-estar", conteudo = "...", corTexto = R.color.outroazul, corCard = R.color.outroazulzinho, idUsuario = 3,flagLido = false),

    )
}

fun getCor(): List<Cor> {
    return listOf(
        Cor(id = 1, cor = "Rosa", rdra = R.color.vermelhinho, hexa = 0xFFDAC8CD, flagAtivo = false),
        Cor(id = 2, cor = "Amarelo", rdra = R.color.amarelinho_fundo, hexa = 0xFFFFF3CF, flagAtivo = false),
        Cor(id = 3, cor = "Azul", rdra = R.color.azul_200, hexa = 0xFFBBDDF2, flagAtivo = true),

        )

}fun geIcone(): List<Icone> {
    return listOf(
        Icone(id = 1, descricao = "Bolsa", rdra = R.drawable.bag),
        Icone(id = 2, descricao = "Carro", rdra = R.drawable.mobilidade),
        Icone(id = 3, descricao = "Coracao", rdra = R.drawable.coracao),
        Icone(id = 4, descricao = "Paisagem", rdra = R.drawable.landscape),
        Icone(id = 5, descricao = "Camera", rdra = R.drawable.camera),
        Icone(id = 6, descricao = "Pasta", rdra = R.drawable.briefcase),
        Icone(id = 7, descricao = "Pincel", rdra = R.drawable.brush),
        Icone(id = 8, descricao = "Jogo", rdra = R.drawable.puzzle),
        Icone(id = 9, descricao = "Casa", rdra = R.drawable.home),
        Icone(id = 10, descricao = "Carrinho", rdra = R.drawable.cart)
        )
}

fun getCoresCategoria(): List<CorCategoria>{
    return listOf(
        CorCategoria(id= 1, cor= "Amarelo", rdra_icone= R.color.amarelo, hexa_icone = 0xFFA57C00, rdra_fundo = R.color.amarelinho_fundo, hexa_fundo = 0xFFFFF3CF),
        CorCategoria(id= 1, cor= "Laranja", rdra_icone= R.color.laranja, hexa_icone = 0xFFAF5C09, rdra_fundo = R.color.laranjinha, hexa_fundo = 0xFFFFE1C2),
        CorCategoria(id= 1, cor= "Verde", rdra_icone= R.color.verde, hexa_icone = 0xFF00690B, rdra_fundo = R.color.verdinho, hexa_fundo = 0xFFA3FFAC),
        CorCategoria(id= 1, cor= "Aqua", rdra_icone= R.color.aqua, hexa_icone = 0xFF156754, rdra_fundo = R.color.aquaclaro, hexa_fundo = 0xFF95FFE1),
        CorCategoria(id= 1, cor= "Cinza", rdra_icone= R.color.cinza, hexa_icone = 0xFF373737, rdra_fundo = R.color.cinzaclaro, hexa_fundo = 0xFFCCCCCC),
        CorCategoria(id= 1, cor= "Vermelho", rdra_icone= R.color.vermelho, hexa_icone = 0xFFD2325D, rdra_fundo = R.color.vermelhinho, hexa_fundo = 0xFFCCCCCC),
        CorCategoria(id= 1, cor= "Roxo", rdra_icone= R.color.roxo, hexa_icone = 0xFF4600A0, rdra_fundo = R.color.lilas, hexa_fundo = 0xFFC5B6D9),
        CorCategoria(id= 1, cor= "Azul", rdra_icone= R.color.outroazul, hexa_icone = 0xFF047382, rdra_fundo = R.color.outroazulzinho, hexa_fundo = 0xFF8BE0EB),
    )
}



fun getContatosByNome(nome: String): List<ContatoAgenda>{
    return getAllContatos().filter {
        it.nome.startsWith(prefix = nome,ignoreCase = true )
    }
}

fun getEmailsByRemetente(remetente: String): List<Email>{
    return getAllEmails().filter {
        it.remetente.startsWith(prefix = remetente,ignoreCase = true )
    }
}
fun getEmailsByCategoria(categoria: String): List<Email>{
    return getAllEmails().filter {
        it.categoria.startsWith(prefix = categoria,ignoreCase = true )
    }
}