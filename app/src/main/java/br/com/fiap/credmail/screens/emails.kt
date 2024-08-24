package br.com.fiap.credmail.screens

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
import br.com.fiap.credmail.componentes.BotaoCategoria
import br.com.fiap.credmail.componentes.CabecalhoEmails
import br.com.fiap.credmail.componentes.EmailCard
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.componentes.TextoTipo5
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.repository.getAllCategorias
import br.com.fiap.credmail.repository.getAllEmails

@Composable
fun EmailsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    var listemailbyname by remember {
        mutableStateOf(emailRepository.listByIdUsuario(id))
    }
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Header
            if (id != null) {
                CabecalhoEmails(titulo = "Todos os e-mails", 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
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
                Row (//Aqui é o filtro
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                ){
                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        items(getAllCategorias()){
                            Button(
                                onClick = { listemailbyname = emailRepository.buscaCategoria(it.categoria,id) },
                                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = it.corTexto)),
                                modifier = Modifier.size(width = 105.dp, height = 80.dp), contentPadding = PaddingValues(15.dp, 5.dp), shape = RoundedCornerShape(16.dp)
                            ) {
                                Column (modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                                    .padding(0.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally){
                                    Image(
                                        painter = painterResource(id = it.imagem),
                                        contentDescription = it.categoria,
                                        modifier = Modifier
                                            .size(28.dp)
                                            .padding(0.dp)
                                    )
                                    TextoTipo5(texto = it.categoria, color = colorResource(id =  it.corimagem))
                                }

                            }
                        }
                    }

                }

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                //.background(Color.Red)
                .height(550.dp)){
                LazyColumn (){
                    items(listemailbyname){
                        EmailCard(emails = it,𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿)
                    }
                }
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                    //.background(color = Color.Cyan),
                    verticalArrangement = Arrangement.Bottom
                ){
                    if (id != null) {
                        BarraInferior(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
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
