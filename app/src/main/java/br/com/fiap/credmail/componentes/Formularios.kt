package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
fun CaixadeEntrada(
    value: String,
    placeHolder: String,
    keyboardType: KeyboardType,
    atualizaValor: (String) -> Unit
    ) {
    var texto by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = value,
        onValueChange = atualizaValor,
        modifier = Modifier.fillMaxWidth(),
        //label = {Text("danadinho apareceu",color = Color.Black)},
        placeholder = {
            Text(
                text = placeHolder,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.Gray,
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.azul_700),
            unfocusedBorderColor = Color.White,
            focusedTextColor = colorResource(id = R.color.azul_700),
            unfocusedTextColor = Color.LightGray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedLabelColor = Color.Transparent,

        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    )

}@Composable
fun CaixadeEntradaEmail(
    color: Color,
    placeHolder: String,
    keyboardType: KeyboardType
    ) {
    var texto by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = texto,
        onValueChange = {letra ->
                        texto = letra
        },
        modifier = Modifier.width(200.dp),
        placeholder = {
            Text(
                text = placeHolder,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color,
            unfocusedBorderColor = color,
            focusedTextColor = colorResource(id = R.color.azul_700),
            unfocusedTextColor = Color.LightGray,
            focusedContainerColor = color,
            unfocusedContainerColor = color
        ),
        //shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}

@Composable
fun Botao(
    text: String
){
    Button(
        onClick = {  },
        modifier = Modifier
            .width(120.dp)
            .height(48.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelinho))
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.azul_700),
            fontSize = 11.sp
        )
    }
}
@Composable
fun BotaoIcone(
    color: Color,
    imagemicone: Int,
    descricao: String,
    𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController,
    id: Long

){
    Button(
        onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("menu/${id}") },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.size(width = 20.dp, height = 20.dp), contentPadding = PaddingValues(0.dp), shape = RectangleShape
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp)){
            Image(
                painter = painterResource(id = imagemicone),
                contentDescription = descricao,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp)
            )
        }

    }

}
@Composable
fun BotaoIconeVec(
    color: Color,
    imagemicone: Int,
    descricao: String

){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier.size(width = 20.dp, height = 20.dp), contentPadding = PaddingValues(0.dp), shape = RectangleShape
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp)){
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = descricao,
                tint = colorResource(id = R.color.azul_700),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(0.dp)
            )
        }

    }
}
@Composable
fun BotaoCategoria(
    categoriasCards: CategoriasCards
){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = categoriasCards.corTexto)),
        modifier = Modifier.size(width = 105.dp, height = 80.dp), contentPadding = PaddingValues(15.dp, 5.dp), shape = RoundedCornerShape(16.dp)
    ) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = categoriasCards.imagem),
                contentDescription = categoriasCards.categoria,
                modifier = Modifier
                    .size(28.dp)
                    .padding(0.dp)
            )
            TextoTipo5(texto = categoriasCards.categoria, color = colorResource(id =  categoriasCards.corimagem))
        }

    }
}

@Composable
fun ContatoCard(contatoAgenda: ContatoAgenda){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors =  ButtonDefaults.buttonColors(containerColor = Color.White)

    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id =contatoAgenda.rosto), contentDescription = "Imagem User", modifier = Modifier.size(100.dp))
            Column (
                //modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center){
                TextoMenu(texto = contatoAgenda.nome)
                TextoContatoTipo2(texto = contatoAgenda.email)
            }
        }
    }
}
@Composable
fun EmailCard(emails: Email, 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿: NavHostController){
    Button(onClick = { 𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿.navigate("ler/${emails.idUsuario}/${emails.id}")},
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors =  ButtonDefaults.buttonColors(containerColor = Color.White)

    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Column (
                //modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.Center){
                if(emails.flagLido){
                    TextoEmail(texto = emails.remetente, color = Color.Gray)
                    TextoEmailipo2(texto = emails.titulo, color = Color.Gray)
                    TextoEmailTipo3(texto = emails.conteudo, color = Color.Gray)
                }
                else{
                    TextoEmail(texto = emails.remetente, color = Color.Black)
                    TextoEmailipo2(texto = emails.titulo, color = Color.Black)
                    TextoEmailTipo3(texto = emails.conteudo, color = Color.Black)
                }
                Card (colors = CardDefaults.cardColors(colorResource(id = emails.corCard))){
                    TextoTipo5Email(texto = emails.categoria, color = emails.corTexto)
                }
            }
        }
    }
}


@Composable
fun TextoPrincipal(
    texto: String
){
    Text(text = texto, modifier = Modifier.fillMaxWidth(),
    fontSize = 20.sp,
    fontWeight = FontWeight.ExtraBold,
    color = colorResource(id = R.color.azul_700),
    textAlign = TextAlign.Center,
    //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoMenu(
    texto: String
){
    Text(text = texto,
    modifier = Modifier.padding(10.dp),
    fontSize = 20.sp,
    fontWeight = FontWeight.ExtraBold,
    color = colorResource(id = R.color.azul_700),
    textAlign = TextAlign.Start,
    //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}
@Composable
fun TextoEmail(
    texto: String,
    color: Color
){
    Text(text = texto,
    modifier = Modifier.padding(10.dp),
    fontSize = 20.sp,
    fontWeight = FontWeight.ExtraBold,
    color = color,
    textAlign = TextAlign.Start,
    //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}



@Composable
fun TextoTipo2(
    texto: String
){
    Text(text = texto, modifier = Modifier.fillMaxWidth(),
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        textAlign = TextAlign.Center,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}@Composable
fun TextoEmailipo2(
    texto: String,
    color: Color
){
    Text(text = texto,
        modifier = Modifier.padding(10.dp),
        fontSize = 12.sp,
        fontWeight = FontWeight.ExtraBold,
        color = color,
        textAlign = TextAlign.Start,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoContatoTipo2(
    texto: String
){
    Text(text = texto, modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        textAlign = TextAlign.Start,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoTipo2noAlig(
    texto: String
){
    Text(text = texto,
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoTipo2Right(
    texto: String
){
    Text(text = texto, modifier = Modifier.fillMaxWidth(),
        fontSize = 15.sp,
        fontWeight = FontWeight.ExtraBold,
        color = colorResource(id = R.color.azul_700),
        textAlign = TextAlign.Start,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoTipo3(
    texto: String
){
    Text(text = texto, modifier = Modifier.fillMaxWidth(),
        fontSize = 12.sp,
        color = colorResource(id = R.color.azul_700),
        textAlign = TextAlign.Center,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoTipo4(
    texto: String,
    color: Color
){
    Text(text = texto,
        //modifier = Modifier.fillMaxWidth(),
        fontSize = 10.sp,
        color = color,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}
@Composable
fun TextoEmailTipo3(
    texto: String,
    color: Color,
){
    Text(text = texto,
        //modifier = Modifier.fillMaxWidth(),
        fontSize = 10.sp,
        color = color,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun TextoTipo5(
    texto: String,
    color: Color
){
    Text(text = texto,
        //modifier = Modifier.fillMaxWidth(),
        fontSize = 10.sp,
        color = color,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}
@Composable
fun TextoTipo5Email(
    texto: String,
    color: Int
){
    Text(
        text = texto,
        //modifier = Modifier.fillMaxWidth(),
        fontSize = 10.sp,
        color = colorResource(id = color),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        //fontFamily = Montserrat -- Arrumar essa Fonte para todo o projeto!!
    )
}

@Composable
fun ItemsMenus(
    //onclick: () -> Unit,
    imagem: Int,
    descricao: String,
    textomenu: String) {

    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth(),
        //.height(100.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.azul_200))

    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imagem),
                contentDescription = descricao,
                modifier = Modifier
                    .size(20.dp)
            )
            TextoMenu(texto = textomenu)
        }
    }
}
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
                        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id

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
                        𝗻𝗮𝘃𝗖𝗼𝗻𝘁𝗿𝗼𝗹𝗹𝗲𝗿,id
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


