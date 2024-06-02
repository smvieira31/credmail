package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BotaoIcone
import br.com.fiap.credmail.componentes.CaixadeEntradaEmail
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.componentes.TextoTipo2noAlig

@Composable
fun EnviarScreen() {
    var texto by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Header
            Column {
                //Aqui é o cabeçalho
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    verticalAlignment    = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly

                ) {
                    BotaoIcone(color = Color.LightGray, imagemicone = R.drawable.voltar, descricao = "Voltar")

                    TextoTipo2(texto = "Enviar e -mail")
                }

            }
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                //Aqui é a parte inicial do email
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,

                ){

                    BotaoIcone(color = Color.White, imagemicone = R.drawable.icon_send, descricao = "Anexar")
                    Spacer(modifier = Modifier.width(10.dp))
                    BotaoIcone(color = Color.White, imagemicone = R.drawable.anexo, descricao = "Anexar")
                    Spacer(modifier = Modifier.width(10.dp))
                    BotaoIcone(color = Color.White, imagemicone = R.drawable.anexo, descricao = "Anexar")

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoTipo2noAlig(texto = "De")
                    Text(
                        text = "esseseuemail@example.com",
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    )
                }
                Divider(modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(), color = Color.LightGray)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextoTipo2noAlig(texto = "Para")
                    CaixadeEntradaEmail(color = Color.White, "email@example.com", keyboardType = KeyboardType.Text)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(Color.LightGray),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    TextoTipo2noAlig(texto = "Assunto")
                    CaixadeEntradaEmail(color = Color.LightGray, placeHolder = "Digite", keyboardType = KeyboardType.Text)

                //Text(text = "Seu Assunto Aqui")
                }
                Column {
                    TextField(value = texto,
                        onValueChange = {letra ->
                        texto = letra },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedTextColor = colorResource(id = R.color.azul_700),
                            unfocusedTextColor = Color.LightGray,
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        //shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        placeholder = {
                            Text(
                                text = "Escrever e-mail",
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EnviarScreenPreview() {
    EnviarScreen()
}
