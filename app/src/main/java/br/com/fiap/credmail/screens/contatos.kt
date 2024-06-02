package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.solver.widgets.Rectangle
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.CabecalhoContatos
import br.com.fiap.credmail.componentes.ContatoCard
import br.com.fiap.credmail.componentes.TextoContatoTipo2
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.model.ContatoAgenda
import br.com.fiap.credmail.repository.getAllContatos

@Composable
fun ContatosScreen() {

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CabecalhoContatos(titulo = "Contatos")
            //Header
//            Column  {
//                //Aqui é o cabeçalho
//                Column (
//                    modifier = Modifier
//                        .background(Color.LightGray)
//                        .fillMaxWidth()
//                        .height(150.dp),
//                    verticalArrangement = Arrangement.Bottom
//
//                ){
//
//                    Column(//Titulo de Emails
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.Gray)
//                            .height(90.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        //Esse texto vai ser alterado conforme o filtro
//                        Text(text = "Aqui vai a Imagem")
//
//                    }
//                    Column (//Menus e pesquisa
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.DarkGray)
//                            .height(60.dp),
//                    ){
//                        Row (
//                            horizontalArrangement = Arrangement.SpaceEvenly,
//                            modifier = Modifier.fillMaxWidth()
//                        ){
//                            Text(text = "Menu")
//                            Column{
//                                Text(text = "Conta Ativa")
//                                Text(text = "jhon@example.com")
//                            }
//
//                        }
//                    }
//                }
//            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(5.dp, 1.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                TextoTipo2Right(texto = "Contas Registradas")
                Spacer(modifier = Modifier.height(10.dp))

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
                .padding(10.dp, 1.dp),){
                //Aqui é são os contatos
                LazyColumn(){
                    items(getAllContatos()){
                        ContatoCard(contatoAgenda = it)
                    }
                }
            }
            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()) {
                //Aqui é o menu de baixo
                Row {
                    Text(text = "Menu de baixo")

                }
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContatosScreenPreview() {
    ContatosScreen()
}


