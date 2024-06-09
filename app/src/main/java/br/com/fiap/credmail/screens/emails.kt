package br.com.fiap.credmail.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.resolveDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BarraInferior
import br.com.fiap.credmail.componentes.BotaoCategoria
import br.com.fiap.credmail.componentes.CabecalhoEmails
import br.com.fiap.credmail.componentes.EmailCard
import br.com.fiap.credmail.componentes.TextoEmail
import br.com.fiap.credmail.componentes.TextoEmailTipo3
import br.com.fiap.credmail.componentes.TextoEmailipo2
import br.com.fiap.credmail.componentes.TextoPrincipal
import br.com.fiap.credmail.componentes.TextoTipo2
import br.com.fiap.credmail.componentes.TextoTipo2Right
import br.com.fiap.credmail.componentes.TextoTipo3
import br.com.fiap.credmail.componentes.TextoTipo4
import br.com.fiap.credmail.componentes.TextoTipo5
import br.com.fiap.credmail.componentes.TextoTipo5Email
import br.com.fiap.credmail.repository.getAllCategorias
import br.com.fiap.credmail.repository.getAllEmails

@Composable
fun EmailsScreen(){

    var listemailbyname by remember {
        mutableStateOf(getAllEmails())
    }

    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //Header
            CabecalhoEmails(titulo = "Todos os e-mails")

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
                        .height(90.dp)
                        .fillMaxWidth()
                ){
                    LazyRow(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically){
                        items(getAllCategorias()){
                            BotaoCategoria(categoriasCards = it)
                        }
                    }

                }

            }
            Column(modifier = Modifier
                .fillMaxWidth()
                //.background(Color.Red)
                .height(370.dp)){
                LazyColumn (){
                    items(listemailbyname){
                        EmailCard(emails = it)
                    }
                }
            }
            Column (modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
                //.background(color = Color.Cyan),
                verticalArrangement = Arrangement.Bottom


            ){
                BarraInferior()

            }

        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmailsScreenPreview() {
    EmailsScreen()
}
