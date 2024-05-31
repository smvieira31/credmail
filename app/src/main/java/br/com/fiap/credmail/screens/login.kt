package br.com.fiap.credmail.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.Botao
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.ui.theme.CredmailTheme
import br.com.fiap.credmail.ui.theme.Montserrat


@Composable
//fun LoginScreen(navController: NavController){
fun LoginScreen(){
//    var nome by remember {
//        mutableStateOf("")
//
//    }
//    var password by remember {
//        mutableStateOf("")
//    }
//
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
//            Column (modifier = Modifier.offset(y = (-5).dp)){
//                //Aqui ficaria a imagem
//
////                Card (modifier = Modifier
////                    .background(Color.Magenta)
////                    .size(340.dp, 100.dp)
////                ){
////                        Text(text = "Aqui vai a imagem")
////                }
//            }
            Column {
                Card (
                    modifier = Modifier.width(340.dp).offset(y = (230).dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column (modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        TextoPrincipal(texto = "Bem Vindo!")
                        TextoTipo2(texto = "entre com usuário e senha")
                        Spacer(modifier = Modifier.height(20.dp))
                        CaixadeEntrada(value = "", placeHolder = "Digite seu e-mail.", keyboardType = KeyboardType.Email)
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(value = "", placeHolder = "Digite sua senha.", keyboardType = KeyboardType.Password)
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Login")
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Cadastrar")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(340.dp).offset(y = (-335).dp)
//                        .padding(top = 10.dp)
                )

                }

            }

        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}




