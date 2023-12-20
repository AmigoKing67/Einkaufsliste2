package com.example.einkaufsliste.Screen2

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.einkaufsliste.Screen1.MainActivity


@Composable
fun Warenkorb(){

    var showDialog = remember { mutableStateOf(false) }
    val bdialog = com.example.einkaufsliste.Screen1.beschreibung(
        showDialog,
        dialogTitle = "ESSEN",
        dialogText = "Beschreibung"
    )
    val context = LocalContext.current

 Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
     modifier = Modifier.fillMaxSize()) {

     Text(text = "Warenkorb", fontSize = 70.sp, fontWeight = FontWeight.Bold,modifier = Modifier.padding(vertical = 16.dp))


     Row(horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically) {

         Button(onClick = {

             val MainActivity = Intent(context, MainActivity::class.java)
             context.startActivity(MainActivity) }, colors = ButtonDefaults.buttonColors(Color.Black))
         {

             Text(text = "Zurück")
         }

         Spacer(modifier = Modifier.width(50.dp))


         Button(onClick = {

             showDialog.value = true


         }, colors = ButtonDefaults.buttonColors(Color.Black)


         ) {
             Text(text = "Kasse")
         }

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


/*
fun createNotiChannel(){

    val name = "Channel1"
    val description = "The first channel"

    val channel = NotificationChannel(

        "1",
        name,
        NotificationManager.IMPORTANCE_HIGH

    )

    channel.description = description
    channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    notificationManager.createNotificationChannel(channel)
}


fun sendNotification(context: Context){


    val builder = NotificationCompat.Builder(context,"1")
        .setContentTitle("Summe")
        .setContentText("summe beträgt")
        .setPriority(NotificationCompat.PRIORITY_MAX)


    with(NotificationManagerCompat.from(context)){
        if(ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
            ){
            return
        }

        cancelAll()
        notify(1,builder.build())
    }
}

 */