package br.com.fiap.credmail.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    private val URL = "https://api-credmail-bcgbefasaahgf0e3.westus-01.azurewebsites.net/"

    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)// Define o nível de log
        setLevel(HttpLoggingInterceptor.Level.BASIC)
        setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    // Crie o cliente OkHttp e adicione o interceptor
    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun postCadastroService() : CadastroService{
        return retrofitFactory.create(CadastroService::class.java)
    }

    fun postLoginService() : LoginService{
        return retrofitFactory.create(LoginService::class.java)
    }

    fun postHomeService(): HomeService{
        return retrofitFactory.create(HomeService::class.java)
    }
}