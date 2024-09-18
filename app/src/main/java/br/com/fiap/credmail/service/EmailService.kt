package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.HomeEmailDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmailService {

    @GET("email/entrada/{id}")
    fun lerEmail(@Path("id") id: Long): Call<HomeEmailDTO>
}