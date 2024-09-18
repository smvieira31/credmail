package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.LoginReq
import br.com.fiap.credmail.model.LoginRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    @Headers("Content-type: application/json")
    fun realizarLogin(@Body loginreq: LoginReq): Call<LoginRes>
}