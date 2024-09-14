package br.com.fiap.credmail.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

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
import br.com.fiap.credmail.componentes.EmailCard

import br.com.fiap.credmail.database.repository.EmailRepository


@Composable
fun SpamsScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?) {

    val context = LocalContext.current
    val emailRepository = EmailRepository(context)
    var listemailbyname by remember {
        mutableStateOf(emailRepository.listByIdUsuario(id))
    }
    /* TODO */
    /*colocar a variavel de cor escolhida p pssa */
    var corEscolhida = 0xFFDAC8CD

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Header
            if (id != null) {
                CabecalhoEmails(titulo = "Spams", 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id, corEscolhida)
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                //.background(Color.Red)
                .height(700.dp)){
                LazyColumn (){
                    items(listemailbyname){
                        EmailCard(emails = it,𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿)
                    }
                }
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                    //.background(color = Color.Cyan),
                    verticalArrangement = Arrangement.Bottom
                ){
                    if (id != null) {
                        BarraInferior(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id,corEscolhida)
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
