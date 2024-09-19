package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.EmailEnviado
import br.com.fiap.credmail.model.EmailSaidaDTORes
import br.com.fiap.credmail.model.EnvioDto
import br.com.fiap.credmail.model.HomeEmailDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EmailService {

    @GET("email/entrada/{id}")
    fun lerEmail(@Path("id") id: Long): Call<HomeEmailDTO>

    @POST("email/saida")
    fun escreverEmail(@Body escrita: EmailEnviado): Call<EnvioDto>

    @GET("email/saida/{id}")
    fun buscarEmailSaida(@Path("id") id: Long): Call<List<EmailSaidaDTORes>>
}