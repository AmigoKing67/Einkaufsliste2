package com.example.einkaufsliste.Screen1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random




@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Produktkarte( product : products ) {



    var showDialog = remember {mutableStateOf(false)}


    val randomRed = 2 + Random.nextInt(239)
    val randomGreen = 10 + Random.nextInt(239)
    val randomBlue = 2 + Random.nextInt(239)

    val randomColor = remember { Color(240 - randomRed, 240 - randomGreen, 240 - randomBlue, 150) }

     val bdialog = beschreibung(
         showDialog ,
         dialogTitle = "ESSEN",
         dialogText = "Beschreibung"
     )

    Box(

        modifier = Modifier

            .fillMaxWidth()
            .padding(8.dp)
            .background(randomColor)


    ) {

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text( product.name,modifier = Modifier.padding(), color = Color.White)

            Spacer(modifier = Modifier.width(50.dp))

            Text( product.price, modifier = Modifier.padding(), color = Color.White)

            Spacer(modifier = Modifier.width(50.dp))

            Button(

                onClick = {

                         showDialog.value = true


                },
                colors = ButtonDefaults.buttonColors(Color.White),
            ) {
                Text(text = "Ansehen", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun beschreibung(
    showDialog : MutableState<Boolean>,
    dialogTitle: String,
    dialogText: String,

    ) {

    if (showDialog.value) {
        AlertDialog(

            title = {
                Text(text = dialogTitle)
            },
            text = {
                Text(text = dialogText)
            },
            onDismissRequest = {
                showDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text("hinzufügen")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog.value = false
                    }
                ) {
                    Text("Abbrechen")
                }
            }
        )
    }
}




