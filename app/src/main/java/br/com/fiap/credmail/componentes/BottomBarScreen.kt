package br.com.fiap.credmail.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import br.com.fiap.credmail.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object  Emails: BottomBarScreen(
        route = "emails",
        title = " Emails",
        icon = R.drawable.icon_email

    )
    object  Contatos: BottomBarScreen(
        route = "contatos",
        title = " Contatos",
        icon = R.drawable.icon_person
    )
    object  Enviar: BottomBarScreen(
        route = "enviar",
        title = " Enviar",
        icon = R.drawable.icon_send
    )
}