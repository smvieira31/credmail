package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.LoginRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @POST("cadastro")
    @Headers("Content-type: application/json")
    fun realizarLogin(@Body loginRes: LoginRes): Call<LoginRes>
}