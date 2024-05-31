package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R

@Composable
fun CaixadeEntrada(
    value: String,
    placeHolder: String,
    keyboardType: KeyboardType
    ) {

    OutlinedTextField(
        value = value,
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = placeHolder,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.azul_700),
            unfocusedBorderColor = Color.White,
            focusedTextColor = colorResource(id = R.color.azul_700),
            unfocusedTextColor = Color.LightGray,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}

@Composable
fun Botao(
    text: String

){
    Button(
        onClick = {},
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
fun ItemsMenus(
    imagem: Int,
    descricao: String,
    textomenu: String) {

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

@Composable
fun Cabecalho(
    titulo: String

) {
    var title by remember {
        mutableStateOf("")
    }

    Card (//Aqui é o cabeçalho
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom

        ){
            Row(//Titulo de Emails
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Esse texto vai ser alterado conforme o filtro
                TextoPrincipal(texto = titulo)

            }
            Spacer(modifier = Modifier.height(16.dp))
            Row (//Menus e pesquisa
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.sanduiche),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(27.dp)
//                        .padding(top = 10.dp)
                )
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
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
                    shape = RoundedCornerShape(8.dp)                        )

            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

