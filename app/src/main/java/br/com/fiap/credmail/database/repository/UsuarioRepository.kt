package br.com.fiap.credmail.database.repository

import android.content.Context
import br.com.fiap.credmail.database.AppDatabase
import br.com.fiap.credmail.model.Usuario

class UsuarioRepository(context: Context) {
    private val db = AppDatabase.getDatabase(context).usuarioDao()

    fun salvar(usuario: Usuario) : Long{
        return db.salvar(usuario)
    }

    fun listar() : List<Usuario>{
        return db.buscaTodos()
    }

    fun buscarPorId(id: Int) : Usuario{
        return db.findById(id)
    }
}