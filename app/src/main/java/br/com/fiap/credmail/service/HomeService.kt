package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.HomeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface HomeService {
    @GET("home/{id}")
    @Headers("Content-type: application/json")
    fun iniciaHome(@Path("id") id:Long): Call<HomeDTO>
}