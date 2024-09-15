package br.com.fiap.credmail.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "https://api-credmail-bcgbefasaahgf0e3.westus-01.azurewebsites.net/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun postCadastroService() : CadastroService{
        return retrofitFactory.create(CadastroService::class.java)
    }

    fun postLoginService() : LoginService{
        return retrofitFactory.create(LoginService::class.java)
    }
}