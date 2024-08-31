package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.model.CategoriasCards

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
