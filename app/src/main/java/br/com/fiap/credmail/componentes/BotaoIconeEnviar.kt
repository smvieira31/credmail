package br.com.fiap.credmail.componentes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.model.EmailEnviado
import br.com.fiap.credmail.model.EnvioDto
import br.com.fiap.credmail.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun BotaoIconeEnviar(
    color: Color,
    imagemicone: Int,
    descricao: String,
    𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController,
    id: Long,
    destinatario: String,
    assunto: String,
    texto: String

){
    Button(
        onClick = { val call = RetrofitFactory().postEmailService()
            .escreverEmail(EmailEnviado(para = destinatario, titulo = assunto, conteudo = texto, idUsuario = id))
            call.enqueue(object : Callback<EnvioDto> {
                override fun onResponse(
                    call: Call<EnvioDto>,
                    response: Response<EnvioDto>
                ) {
                    Log.i("informação", "onResponse ${response.code()} e o body ${response.body()}")
                    var mensagem = response.body()!!
                    𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("home/${id}")

                }

                override fun onFailure(call: Call<EnvioDto>, t: Throwable) {
                    t.printStackTrace()
                    TODO("Not yet implemented")
                }
            }) },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.size(width = 20.dp, height = 20.dp), contentPadding = PaddingValues(0.dp), shape = RectangleShape
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp)){
            Image(
                painter = painterResource(id = imagemicone),
                contentDescription = descricao,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp)
            )
        }

    }

}