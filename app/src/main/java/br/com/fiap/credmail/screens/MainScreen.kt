package br.com.fiap.credmail.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.credmail.R
import br.com.fiap.credmail.componentes.BottomBarScreen
import br.com.fiap.credmail.componentes.BottomNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Emails,
        BottomBarScreen.Contatos,
        BottomBarScreen.Enviar,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar (
        containerColor = colorResource(id = R.color.azul_200),
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        )
    ) {
        screens.forEach {screen ->
            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)

        }

    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = colorResource(id = R.color.azul_700),
            selectedIconColor = Color.DarkGray
        ),
        onClick = {
                  navController.navigate(screen.route)
        },
        icon = { Icon(
        painterResource(id = screen.icon) ,
        contentDescription = "Navigation Icon",
    )}, label = { Text(text = screen.title)})
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    //LoginScreen()
    MainScreen()
}