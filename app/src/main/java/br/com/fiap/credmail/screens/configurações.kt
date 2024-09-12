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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BotaoIcone
import br.com.fiap.credmail.componentes.BotaoIconesNavi
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.CaixadeEntradaConfig
import br.com.fiap.credmail.componentes.CaixadeEntradaEmail
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.database.repository.EmailRepository
import br.com.fiap.credmail.database.repository.UsuarioRepository


@Composable
fun ConfiguracoesScreen(

){
    var textNomeSobrenome: MutableState<String> = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.azul_200))) {
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
                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "voltar",
                    modifier = Modifier
                        .size(15.dp)
////                        .padding(top = 10.dp)
                )
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
                    value = textNomeSobrenome.value,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome.value = novoValor
                    })

                TextoMenu(texto = "Alterar Email")

                CaixadeEntradaConfig(
                    placeHolder = "email do fulano atual",
                    keyboardType = KeyboardType.Text,
                    value = textNomeSobrenome.value,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome.value = novoValor
                    })

                TextoMenu(texto = "Alterar Senha")

                CaixadeEntradaConfig(
                    placeHolder = "*****",
                    keyboardType = KeyboardType.Text,
                    value = textNomeSobrenome.value,
                    atualizaValor = { novoValor ->
                        textNomeSobrenome.value = novoValor
                    })

                TextoMenu(texto = "Alterar Tema")

                Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

                    var opcaoselecionada by remember {
                        mutableStateOf("claro")
                    }
                    Card(
                        modifier = Modifier.width(150.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = opcaoselecionada == "claro",
                                onClick = {opcaoselecionada = "claro"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.Black))
                            Text(text = "Claro")}
                    }
                    Card(
                        modifier = Modifier.width(150.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = opcaoselecionada == "escuro",
                                onClick = {opcaoselecionada = "escuro"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.LightGray))
                            Text(text = "Escuro")}
                    }




                }



            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConfigScreenPreview() {
    ConfiguracoesScreen()
}