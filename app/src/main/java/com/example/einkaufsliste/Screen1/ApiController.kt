package com.example.einkaufsliste.Screen1

import android.util.Log
import com.google.gson.Gson
import java.net.URL

class ApiController {


    private val URL_LINK = "http://pascalpex.ddns.net/api/products.json"


    fun getWare() : List<products> {

        val url = URL(URL_LINK)
        val gson = Gson()

        try{
            Log.d("Fehler1","Hier3")
            val receivedText = url.readText()
            Log.d("Fehler1","$receivedText")
            val warenListe = gson.fromJson(receivedText, WarenListe::class.java)
            Log.d("Fehler1","Hier1")
            return warenListe.waren
        }catch (e: Exception){
            Log.d("Fehler1","")
            e.printStackTrace()
            Log.d("Fehler1","Hier")
        }


        return emptyList()
    }
}