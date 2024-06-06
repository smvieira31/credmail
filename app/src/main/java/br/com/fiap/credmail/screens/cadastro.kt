package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import br.com.fiap.credmail.componentes.CaixadeEntrada
import br.com.fiap.credmail.componentes.TextoPrincipal

@Composable

fun CadastroScreen(cadastroViewModel: CadastroViewModel){

    val nome by cadastroViewModel.nome.observeAsState(initial = "")
    val email by cadastroViewModel.email.observeAsState(initial = "")
    val password by cadastroViewModel.password.observeAsState(initial = "")


    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                //Aqui ficaria a imagem
                Row (modifier = Modifier
                    .background(Color.Cyan)
                    .size(300.dp, 90.dp)
                ){
                    Text(text = "Aqui vai a imagem")
                }
            }
            Column {
                Card (
                    modifier = Modifier.width(340.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column (modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        TextoPrincipal(texto = "Cadastre sua conta")
                        Spacer(modifier = Modifier.height(20.dp))
                        CaixadeEntrada(placeHolder = "Digite um nome de usuário", keyboardType = KeyboardType.Text,value = nome, atualizaValor = {cadastroViewModel.onNomeChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(placeHolder = "Digite um e-mail", keyboardType = KeyboardType.Email,value = email, atualizaValor = {cadastroViewModel.onEmailChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(placeHolder = "Digite sua senha", keyboardType = KeyboardType.Password, value = password, atualizaValor = {cadastroViewModel.onPasswordChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada( placeHolder = "Confirme sua senha", keyboardType = KeyboardType.Password, value = "", atualizaValor = {cadastroViewModel.onNomeChanged(it)})
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Cadastrar")
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Voltar")

//                Row (modifier = Modifier
//                    .background(Color.Cyan)
//                    .size(500.dp, 90.dp)
//                ){
//                    Text(text = "")
//                }
//            }
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Card(
                        modifier = Modifier.width(340.dp).offset(y = (200).dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.azul_200)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextoPrincipal(texto = "Cadastre sua conta")
                            Spacer(modifier = Modifier.height(20.dp))
                            CaixadeEntrada(
                                placeHolder = "Digite um nome de usuário",
                                keyboardType = KeyboardType.Text
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            CaixadeEntrada(
                                placeHolder = "Digite um e-mail",
                                keyboardType = KeyboardType.Email
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            CaixadeEntrada(
                                placeHolder = "Digite sua senha",
                                keyboardType = KeyboardType.Password
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            CaixadeEntrada(
                                placeHolder = "Confirme sua senha",
                                keyboardType = KeyboardType.Password
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Botao(onclick = {}, text = "Cadastrar")
                            Spacer(modifier = Modifier.height(16.dp))
                            //Botao(onclick = {navController.navigate("menu")}, text = "voltar")
                            Botao(onclick = {}, text = "voltar")
                        }
                    }
                    Image(
                        painter = painterResource(id = R.drawable.cadastro),
                        contentDescription = "logo",
                        modifier = Modifier
                            .size(340.dp)
                            .offset(y = (-500).dp)
//                        .padding(top = 10.dp)
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroScreenPreview() {
    CadastroScreen(CadastroViewModel())
}
