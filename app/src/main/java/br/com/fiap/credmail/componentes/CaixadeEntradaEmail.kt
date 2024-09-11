package br.com.fiap.credmail.componentes

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.credmail.R

@Composable
fun CaixadeEntradaEmail(
    value: String,
    color: Color,
    placeHolder: String,
    keyboardType: KeyboardType,
    atualizaValor: (String) -> Unit
) {
    var texto by remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        value = value,
        onValueChange = atualizaValor,
        modifier = Modifier.width(200.dp),
        placeholder = {
            Text(
                text = placeHolder,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = color,
            unfocusedBorderColor = color,
            focusedTextColor = colorResource(id = R.color.azul_700),
            unfocusedTextColor = Color.LightGray,
            focusedContainerColor = color,
            unfocusedContainerColor = color
        ),
        //shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}