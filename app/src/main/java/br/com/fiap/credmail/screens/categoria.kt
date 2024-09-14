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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.CaixadeEntradaCategoria
import br.com.fiap.credmail.componentes.CaixadeEntradaConfig
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.Voltar

@Composable
fun CategoriasScreen(){

    var textNomeCategoria by remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
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

                Image(
                    painter = painterResource(id = R.drawable.voltar),
                    contentDescription = "voltar",
                    modifier = Modifier
                        .size(15.dp)
////                        .padding(top = 10.dp)
                )
                TextoMenu(texto = "Criar Categoria")
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ){
                TextoMenu(texto = "Nome da categoria")

                CaixadeEntradaCategoria(
                    placeHolder = "*Max 20 caracteres",
                    keyboardType = KeyboardType.Text,
                    value = textNomeCategoria,
                    atualizaValor = { novoValor ->
                        textNomeCategoria = novoValor
                    })


                TextoMenu(texto = "Escolha a imagem")

                Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

                    var opcaoselecionada by remember {
                        mutableStateOf("claro")
                    }
                    Card(
                        modifier = Modifier.width(70.dp).height(90.dp),

                        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                        shape = RoundedCornerShape(16.dp)
                    ){
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bag),
                                col
                                contentDescription = "Categoria",
                                modifier = Modifier
                                    .size(28.dp)
                                    .padding(5.dp)
                            )
                            RadioButton(
                                selected = opcaoselecionada == "azul",
                                onClick = {opcaoselecionada = "azul"},
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = Color.White,
                                    unselectedColor = Color.LightGray))

                        }
                    }





                }



            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoScreenPreview() {
    CategoriasScreen()
}
