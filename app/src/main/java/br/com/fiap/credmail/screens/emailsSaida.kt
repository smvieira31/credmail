package br.com.fiap.credmail.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.componentes.BarraInferior
import br.com.fiap.credmail.componentes.CabecalhoEmails
import br.com.fiap.credmail.componentes.EmailSaidaCard
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.model.EmailSaidaDTORes
import br.com.fiap.credmail.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("MutableCollectionMutableState")
@Composable
fun EmailSaidaScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    var listEmail by remember {
        mutableStateOf(mutableListOf<EmailSaidaDTORes>())
    }
    var isLoading by remember { mutableStateOf(true) }

    Log.i("informação", "requisição = " + id)
    val call = RetrofitFactory().postEmailService().buscarEmailSaida(id)
    call.enqueue(object : Callback<List<EmailSaidaDTORes>> {
        override fun onResponse(
            call: Call<List<EmailSaidaDTORes>>,
            response: Response<List<EmailSaidaDTORes>>
        ) {
            Log.i("informação", "onResponse ${response.code()} e o body ${response.body()}")
            val saidaDTO = response.body()!!
            listEmail = saidaDTO.toMutableList()
            isLoading = false
        }

        override fun onFailure(call: Call<List<EmailSaidaDTORes>>, t: Throwable) {
            t.printStackTrace()
            TODO("Not yet implemented")
        }
    })

    if (!isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Header
                if (id != null) {
                    CabecalhoEmails(titulo = "Todos os e-mails", 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(5.dp, 1.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Spacer(modifier = Modifier.height(10.dp))
                    TextoTipo2Right(texto = "Categoria de e-mail")
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.background(Color.Red)
                        .height(550.dp)
                ) {
                    LazyColumn() {
                        items(listEmail) {
                            EmailSaidaCard(emails = it, 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        //.background(color = Color.Cyan),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        if (id != null) {
                            BarraInferior(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id)
                        }
                    }
                }

            }

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun EmailsScreenPreview() {
//    EmailsScreen()
//}
