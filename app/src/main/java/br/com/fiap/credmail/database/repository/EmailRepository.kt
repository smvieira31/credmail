package br.com.fiap.credmail.database.repository

import android.content.Context
import br.com.fiap.credmail.database.AppDatabase
import br.com.fiap.credmail.model.Email

class EmailRepository(context: Context) {
    private val db = AppDatabase.getDatabase(context).emailDao()

    fun listarTodos(): List<Email>{
        return db.listAll()
    }

    fun salvarEmail(email: Email): Long{
        return db.salvarEmail(email)
    }

    fun listByIdUsuario(idUsuario: Long?): List<Email>{
        return db.listByIdUsuario(idUsuario)
    }

    fun buscaEmail(id: Long?): Email{
        return db.findById(id)
    }

    fun emailLido(lido: Boolean, idEmail: Long?){
        db.emailLido(lido,idEmail)
    }

    fun buscaCategoria(categoria: String, id: Long?): List<Email>{
        return db.buscarCategoria(categoria,id)
    }

}