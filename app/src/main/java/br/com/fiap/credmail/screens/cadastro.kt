package br.com.fiap.credmail.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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

@Composable
fun CadastroScreen(){

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
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
                        CaixadeEntrada(value = "", placeHolder = "Digite um nome de usuário", keyboardType = KeyboardType.Text)
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(value = "", placeHolder = "Digite um e-mail", keyboardType = KeyboardType.Email)
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(value = "", placeHolder = "Digite sua senha", keyboardType = KeyboardType.Password)
                        Spacer(modifier = Modifier.height(16.dp))
                        CaixadeEntrada(value = "", placeHolder = "Confirme sua senha", keyboardType = KeyboardType.Password)
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Cadastrar")
                        Spacer(modifier = Modifier.height(16.dp))
                        Botao(text = "Voltar")

                    }
                }

            }
        }

         }




}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroScreenPreview() {
    CadastroScreen()
}
