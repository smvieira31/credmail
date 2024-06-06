package br.com.fiap.credmail.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.credmail.model.Usuario

class LoginViewModel: ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onEmailChanged(novoEmail: String){
        _email.value = novoEmail
    }

    fun onPasswordChanged(novoPassword: String){
        _password.value = novoPassword
    }

    fun validarUsuario(usuario: Usuario, password: String) : Boolean{
        if(usuario.senha.equals(password))
            return true
        return false
    }
}