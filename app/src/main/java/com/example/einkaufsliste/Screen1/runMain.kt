package com.example.einkaufsliste.Screen1

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.einkaufsliste.Screen2.MainActivity2
import com.example.einkaufsliste.Screen2.Warenkorb


@Composable
fun runMain() {

    var productList by remember { mutableStateOf(emptyList<products>()) }
    val apiController = ApiController()

    LaunchedEffect(key1 = true) {

        productList = apiController.getWare()
    }


    Scaffold(floatingActionButton = { warenkorb() })

    { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(innerPadding)
        )
        {

            LazyColumn() {


                productList.forEach { product ->
                   item {
                       Produktkarte(product)
                   }
                }

            }

        }

    }
}


@Composable
fun warenkorb(){

    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            val MainActivity2 = Intent(context, MainActivity2::class.java)
            context.startActivity(MainActivity2)
        }

    ) {
        Text(text = "Warenkorb")
    }


}
