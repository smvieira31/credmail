package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.CaixadeEntradaConfig
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.Voltar


@Composable
fun ConfiguracoesScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?){
    var textNomeSobrenome by remember {
        mutableStateOf("")
    }

    var corEscolhida = 0xFFDAC8CD



    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(corEscolhida))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            //.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Aqui é o cabeçalho
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                verticalAlignment    = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {

                Voltar(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id)
                TextoMenu(texto = "Configurações")
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ){
                TextoMenu(texto = "Alterar Nome e Sobrenome")

                CaixadeEntradaConfig(
                    placeHolder = "nome atual",
                    keyboardType = KeyboardType.Text,
                    value = textNomeSobrenome,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome = novoValor
                    })

                TextoMenu(texto = "Alterar Email")

                CaixadeEntradaConfig(
                    placeHolder = "email do fulano atual",
                    keyboardType = KeyboardType.Text,
                    value = textNomeSobrenome,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome = novoValor
                    })

                TextoMenu(texto = "Alterar Senha")

                CaixadeEntradaConfig(
                    placeHolder = "*****",
                    keyboardType = KeyboardType.Text,
                    value = textNomeSobrenome,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome = novoValor
                    })

                TextoMenu(texto = "Alterar Tema")

                Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

                    var opcaoselecionada by remember {
                        mutableStateOf("claro")
                    }
                    Card(
                        modifier = Modifier.width(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.outroazul)),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = opcaoselecionada == "azul",
                                onClick = {opcaoselecionada = "azul"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.LightGray))
                            Text(text = "Azul", color = Color.White)}
                    }
                    Card(
                        modifier = Modifier.width(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.amarelo)),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = opcaoselecionada == "amarelo",
                                onClick = {opcaoselecionada = "amarelo"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.LightGray))
                            Text(text = "Amarelo", color = Color.White)}
                    }
                    Card(
                        modifier = Modifier.width(120.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.vermelho)),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = opcaoselecionada == "rosa",
                                onClick = {opcaoselecionada = "rosa"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.LightGray))
                            Text(text = "Rosa", color = Color.White)}
                    }




                }



            }
        }

    }

}
/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfigScreenPreview() {
    ConfiguracoesScreen()
}*/
