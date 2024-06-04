package br.com.fiap.credmail.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.credmail.model.Usuario

class CadastroViewModel: ViewModel() {

    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password


    fun onNomeChanged(novoNome: String){
        _nome.value = novoNome
    }

    fun onEmailChanged(novoEmail: String){
        _email.value = novoEmail
    }

    fun onPasswordChanged(novoPassword: String){
        _password.value = novoPassword
    }

    fun salvarUsuario(usuario: Usuario){

    }

}