package br.com.fiap.credmail.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.Botao
import br.com.fiap.credmail.componentes.BotaoLogin
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.database.repository.UsuarioRepository
import br.com.fiap.credmail.model.Usuario


@Composable
//fun LoginScreen(navController: NavController){
fun LoginScreen(navController: NavController, loginViewModel: LoginViewModel) {
//    var nome by remember {
//        mutableStateOf("")
//
//    }
//    var password by remember {
//        mutableStateOf("")
//    }

    val email by loginViewModel.email.observeAsState(initial = "")
    val password by loginViewModel.password.observeAsState(initial = "")

    val context = LocalContext.current
    val usuarioRepository = UsuarioRepository(context)

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
                    modifier = Modifier
                        .width(340.dp)
                        .offset(y = (230).dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column (modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        TextoPrincipal(texto = "Bem Vindo!")
                        TextoTipo2(texto = "entre com usuário e senha")
                        Spacer(modifier = Modifier.height(20.dp))
                        CaixadeEntrada(placeHolder = "Digite seu e-mail.", keyboardType = KeyboardType.Email, value = email, atualizaValor = {loginViewModel.onEmailChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(placeHolder = "Digite sua senha.", keyboardType = KeyboardType.Password, value = password, atualizaValor = {loginViewModel.onPasswordChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                val usuario = usuarioRepository.buscarPorEmail(email)
                                Log.i("info", "home/${usuario.id}")
//                                if(!loginViewModel.validarUsuario(usuario,password))
//                                    navController.navigate("𝗹𝗼𝗴𝗶𝗻")
                                navController.navigate("home/${usuario.id}")
                            },
                            modifier = Modifier
                                .width(120.dp)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.amarelinho))
                        ) {
                            Text(
                                text = "Login",
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.azul_700),
                                fontSize = 11.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        BotaoLogin(text = "cadastrar", navController = navController,"cadastro")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.login),
                    contentDescription = "logo",
                    modifier = Modifier
                        .size(340.dp)
                        .offset(y = (-315).dp)
//                        .padding(top = 10.dp)
                )

                }

            }

        }
    }


/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}*/




