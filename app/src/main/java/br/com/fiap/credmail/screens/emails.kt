package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.Cabecalho
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.componentes.TextoTipo4

@Composable
fun EmailsScreen(){

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Header
            Cabecalho(titulo = "Todos os e-mails")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(5.dp, 1.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                TextoTipo2Right(texto = "Categoria de e-mail")
                Spacer(modifier = Modifier.height(10.dp))
                Row (//Aqui é o filtro
                    modifier = Modifier
                        .background(Color.Blue)
                        .height(90.dp)
                        .fillMaxWidth()
                ){
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Filtros") }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Filtros") }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Filtros") }

                }

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .height(450.dp)){
                //Aqui é são os e-mails
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "PicPay") }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Decolar") }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Amil") }
            }
            Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()) {
                //Aqui é o menu de baixo
                Row {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Email") }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Contatos") }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Enviar") }

                }
            }
        }

    }




}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailsScreenPreview() {
    EmailsScreen()
}
