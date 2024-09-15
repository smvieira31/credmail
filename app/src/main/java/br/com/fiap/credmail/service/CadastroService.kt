package br.com.fiap.credmail.service

import br.com.fiap.credmail.model.CadastroUsuarioReq
import br.com.fiap.credmail.model.CadastroUsuarioRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CadastroService {

    @POST("cadastro")
    @Headers("Content-type: application/json")
    fun setCadastro(@Body usuario: CadastroUsuarioReq): Call<CadastroUsuarioRes>
}