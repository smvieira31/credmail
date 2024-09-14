package br.com.fiap.credmail.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.credmail.R
import br.com.fiap.credmail.model.CategoriaIcone

@Composable
fun CardIcones(
    categoriasIcones: CategoriaIcone,
    value: String
){

    Card(
        modifier = Modifier.width(70.dp).height(90.dp),

        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        shape = RoundedCornerShape(16.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoriasIcones.rdra), colorFilter = ColorFilter.tint(Color.DarkGray),
                contentDescription = categoriasIcones.descricao,
                modifier = Modifier
                    .size(50.dp)
                //.padding(5.dp)
            )

        }
    }


}