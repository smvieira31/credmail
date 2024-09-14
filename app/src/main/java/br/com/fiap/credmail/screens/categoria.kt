package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BotaoSalvar
import br.com.fiap.credmail.componentes.CaixadeEntradaCategoria
import br.com.fiap.credmail.componentes.CaixadeEntradaConfig
import br.com.fiap.credmail.componentes.TextoMenu
import br.com.fiap.credmail.componentes.Voltar
import br.com.fiap.credmail.repository.getAllIcons
import br.com.fiap.credmail.repository.getCoresCategoria


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
                    .height(100.dp),
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
                    atualizaValor = {

//                        novoValor ->
//                        textNomeCategoria = novoValor
/*TODO*/
/* Queria limitar os caracteres*/

                        if (it.length <= 20) {
                            textNomeCategoria = it
                        }
                    })


                TextoMenu(texto = "Escolha a imagem")

                //Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

                LazyVerticalGrid(
                    columns = GridCells.Fixed(5), // Define 2 colunas
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp), // Padding da grid
                    horizontalArrangement = Arrangement.spacedBy(8.dp), // Espaçamento horizontal entre os itens
                    verticalArrangement = Arrangement.spacedBy(8.dp) // Espaçamento vertical entre os itens
                )  {
                    items(getAllIcons()){
                        var opcaoselecionada by remember {
                            mutableStateOf("claro")
                        }
                        Card(
                            modifier = Modifier.width(70.dp).height(70.dp),

                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = it.rdra),
                                    colorFilter = ColorFilter.tint(Color.DarkGray),
                                    contentDescription = it.descricao,
                                    modifier = Modifier
                                        .size(50.dp)
                                    .padding(8.dp)
                                )
                                RadioButton(
                                    selected = opcaoselecionada == it.descricao,
                                    onClick = { opcaoselecionada = it.descricao },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.LightGray,
                                        unselectedColor = Color.DarkGray
                                    ),
                                    modifier = Modifier.size(8.dp)
                                )

                            }
                        }
                    }
                }
                TextoMenu(texto = "Escolha a cor")

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                )  {
                    items(getCoresCategoria()){
                        var corselecionada by remember {
                            mutableStateOf("claro")
                        }
                        Card(
                            modifier = Modifier.width(120.dp).height(40.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(it.hexa_fundo)),
                            shape = RoundedCornerShape(8.dp)
                        ){
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                RadioButton(
                                    selected = corselecionada == it.cor,
                                    onClick = {corselecionada = it.cor},
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.White,
                                        unselectedColor = Color.DarkGray))
                                Text(text = it.cor, fontWeight = FontWeight.ExtraBold, color = Color(it.hexa_icone))
                            }
                        }
                    }
                }
                Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
                    BotaoSalvar()
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
