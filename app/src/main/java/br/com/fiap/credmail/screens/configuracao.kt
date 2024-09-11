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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.CaixadeEntradaEmail
import br.com.fiap.credmail.componentes.NovaCaixadeEntrada
import br.com.fiap.credmail.componentes.TextoMenu


@Composable
fun ConfiguracoesScreen(𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController, id: Long?){
    var textNomeSobrenome by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize()
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
                TextField(
                    value = textNomeSobrenome,
                    onValueChange = { novoValor ->
                        textNomeSobrenome = novoValor
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words
                    ),
                    label = {
                        Text(text = "Nome e sobrenome")
                    },
                    shape = RoundedCornerShape(8.dp)
                )
                CaixadeEntrada(placeHolder = "Digite um nome de usuário", keyboardType = KeyboardType.Text,value = textNomeSobrenome, atualizaValor = { novoValor ->
                    textNomeSobrenome = novoValor })
                CaixadeEntradaEmail(value = textNomeSobrenome, color = Color.White, placeHolder = "Olá", keyboardType = KeyboardType.Text, atualizaValor = {textNomeSobrenome = it})
                NovaCaixadeEntrada(placeHolder = "Digite um nome de usuário", keyboardType = KeyboardType.Text,value = textNomeSobrenome, atualizaValor = { novoValor ->
                    textNomeSobrenome = novoValor })

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
