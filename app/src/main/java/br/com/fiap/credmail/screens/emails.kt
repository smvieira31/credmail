package br.com.fiap.credmail.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.componentes.BarraInferior
import br.com.fiap.credmail.componentes.CabecalhoEmails
import br.com.fiap.credmail.componentes.EmailCard
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.componentes.TextoTipo5
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.model.HomeCategoriaDTO
import br.com.fiap.credmail.model.HomeDTO
import br.com.fiap.credmail.model.HomeEmailDTO
import br.com.fiap.credmail.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("MutableCollectionMutableState")
@Composable
fun EmailsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    var listEmail by remember {
        mutableStateOf(mutableListOf<HomeEmailDTO>())
    }
    var listCategoria by remember {
        mutableStateOf(mutableListOf<HomeCategoriaDTO>())
    }
    var isLoading by remember { mutableStateOf(true) }
    var selectedCategory by remember { mutableStateOf<Int?>(null) } // Categoria selecionada
    var listFiltroEmail by remember {
        mutableStateOf(mutableListOf<HomeEmailDTO>())
    }

    Log.i("informação", "requisição = "+id)
    val call = RetrofitFactory().postHomeService().iniciaHome(id)
    call.enqueue(object : Callback<HomeDTO> {
        override fun onResponse(
            call: Call<HomeDTO>,
            response: Response<HomeDTO>
        ) {
            Log.i("informação", "onResponse ${response.code()} e o body ${response.body()}")
            val homeDTO = response.body()!!
            listEmail = homeDTO.emailDTOList.toMutableList()
            listCategoria = homeDTO.categoriaDTOList.toMutableList()
            listFiltroEmail = listEmail
            isLoading =false
        }

        override fun onFailure(
            call: Call<HomeDTO>,
            t: Throwable
        ) {
            t.printStackTrace()
            TODO("Not yet implemented")
        }
    })

    if(!isLoading){
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
                    Row(//Aqui é o filtro
                        modifier = Modifier
                            .height(90.dp)
                            .fillMaxWidth()
                    ) {
                        LazyRow(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            items(listCategoria) {
                                categoria -> Button(
                                    onClick = {
                                        selectedCategory = categoria.id.toInt()
                                        listFiltroEmail =
                                            listEmail.filter { it.categoria.toLong() ==categoria.id}.toMutableList()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = colorResource(
                                            id = categoria.corTexto
                                        )
                                    ),
                                    modifier = Modifier.size(width = 105.dp, height = 80.dp),
                                    contentPadding = PaddingValues(15.dp, 5.dp),
                                    shape = RoundedCornerShape(16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                            .padding(0.dp),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Image(
                                            painter = painterResource(id = categoria.imagem),
                                            contentDescription = categoria.categoria,
                                            modifier = Modifier
                                                .size(28.dp)
                                                .padding(0.dp)
                                        )
                                        TextoTipo5(
                                            texto = categoria.categoria,
                                            color = colorResource(id = categoria.corImagem)
                                        )
                                    }

                                }
                            }
                        }

                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.background(Color.Red)
                        .height(550.dp)
                ) {
                    LazyColumn() {
                        items(listFiltroEmail) {
                            EmailCard(emails = it, 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿)
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
