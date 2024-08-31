package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.CategoriasCards
import br.com.fiap.credmail.model.ContatoAgenda
import br.com.fiap.credmail.model.Email
import br.com.fiap.credmail.repository.getAllContatos
import br.com.fiap.credmail.repository.getAllEmails
import br.com.fiap.credmail.repository.getContatosByNome

@Composable
fun CabecalhoContatos(
        titulo: String,
        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController,
        id: Long

    ) {
        var title by remember {
            mutableStateOf("")
        }

        var listContatobyNome by remember {
            mutableStateOf(getAllContatos())
        }

        Card(//Aqui é o cabeçalho
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom

            ) {
                Row(//Titulo de Emails
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Esse texto vai ser alterado conforme o filtro
                    TextoPrincipal(texto = titulo)

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(//Menus e pesquisa
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BotaoIcone(
                        color = colorResource(id = R.color.azul_200),
                        imagemicone = R.drawable.sanduiche,
                        descricao = "Menu",
                        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id, "excluir"

                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = {
                            listContatobyNome = getContatosByNome(title)
                        },
                        //modifier = Modifier
                        //.width(280.dp)
                        //.height(30.dp),
                        label = {
                            TextoTipo4(texto = "Pesquisar", color = Color.LightGray)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedTextColor = Color.LightGray,
                            focusedBorderColor = Color.LightGray,
                            unfocusedBorderColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

@Composable
fun CabecalhoEmails(
        titulo: String,
        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController,
        id: Long

    ) {
        var title by remember {
            mutableStateOf("")
        }

        var listemailbyname by remember {
            mutableStateOf(getAllEmails())
        }

        Card(//Aqui é o cabeçalho
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Bottom

            ) {
                Row(//Titulo de Emails
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Esse texto vai ser alterado conforme o filtro
                    TextoPrincipal(texto = titulo)

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(//Menus e pesquisa
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BotaoIcone(
                        color = colorResource(id = R.color.azul_200),
                        imagemicone = R.drawable.sanduiche,
                        descricao = "Menu",
                        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿, id, "menu"
                    )
                    OutlinedTextField(
                        value = title,
                        onValueChange = {
                            title = it
                        },
                        modifier = Modifier
                        .width(280.dp)
                        .height(30.dp),
                        label = {
                            TextoTipo4(texto = "Pesquisar", color = Color.Black)
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }


