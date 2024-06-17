package br.com.fiap.credmail.screens

import br.com.fiap.credmail.componentes.Botao
import br.com.fiap.credmail.componentes.BotaoIconeVec


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BotaoLogin
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.database.repository.UsuarioRepository


@Composable
fun ErroScreen() {


    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Column {
                Card (
                    modifier = Modifier
                        .width(340.dp)
                        .offset(y = (230).dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column (modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        TextoPrincipal(texto = "Ops! Algo deu errado...")
                        TextoTipo2(texto = "Clique para tentar novamente")
                        Spacer(modifier = Modifier.height(20.dp))
                        Botao(text = "Voltar")

                    }
                }

            }

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErroScreenPreview() {
    ErroScreen()
}




