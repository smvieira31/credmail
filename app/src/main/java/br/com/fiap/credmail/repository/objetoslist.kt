package br.com.fiap.credmail.repository

import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.CategoriasCards
import br.com.fiap.credmail.model.ContatoAgenda
import br.com.fiap.credmail.model.Cor
import br.com.fiap.credmail.model.Email

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