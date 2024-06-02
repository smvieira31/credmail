package br.com.fiap.credmail.repository

import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.CategoriasCards
import br.com.fiap.credmail.model.ContatoAgenda
import br.com.fiap.credmail.model.Emails

fun getAllContatos(): List<ContatoAgenda> {
    return listOf(
        ContatoAgenda(id = 1, nome = "Sara Souza", email = "sara.souza@exemplo.com", rosto = R.drawable.user),
        ContatoAgenda(id = 1, nome = "Davi João", email = "davi.joao@exemplo.com", rosto = R.drawable.user)
    )
}

fun getAllCategorias(): List<CategoriasCards> {
    return listOf(
        CategoriasCards(id = 1, categoria = "Mobilidade",  imagem = R.drawable.mobilidade, corimagem = R.color.amarelo, corTexto = R.color.amarelinho),
        CategoriasCards(id = 2, categoria = "Financeiros",  imagem = R.drawable.bag, corimagem = R.color.vermelho, corTexto = R.color.vermelhinho),
        CategoriasCards(id = 2, categoria = "Bem-Estar",  imagem = R.drawable.coracao, corimagem = R.color.outroazul, corTexto = R.color.outroazulzinho),
    )
}
fun getAllEmails(): List<Emails> {
    return listOf(
        Emails(id = 1, remetente = "PicPay",titulo = "Dê mais pique pro seu dinheiro!",categoria = "Financeiro", conteudo = "...", corTexto = R.color.vermelho, corCard = R.color.vermelhinho),
        Emails(id = 2, remetente = "Decolar",titulo = "Eba! Sua viagem está confirmada",categoria = "Mobilidade", conteudo = "...", corTexto = R.color.amarelo, corCard = R.color.amarelinho),
        Emails(id = 3, remetente = "Amil",titulo = "Quer viver a vida ao máximo",categoria = "Bem-estar", conteudo = "...", corTexto = R.color.outroazul, corCard = R.color.outroazulzinho),

    )
}


fun getContatosByNome(nome: String): List<ContatoAgenda>{
    return getAllContatos().filter {
        it.nome.startsWith(prefix = nome,ignoreCase = true )
    }
}

fun getEmailsByRemetente(remetente: String): List<Emails>{
    return getAllEmails().filter {
        it.remetente.startsWith(prefix = remetente,ignoreCase = true )
    }
}
fun getEmailsByCategoria(categoria: String): List<Emails>{
    return getAllEmails().filter {
        it.categoria.startsWith(prefix = categoria,ignoreCase = true )
    }
}