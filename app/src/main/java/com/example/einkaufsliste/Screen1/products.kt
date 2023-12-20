package com.example.einkaufsliste.Screen1

data class products(val name : String, val price : String, val description : String)


fun getData(): List<products>{
    return listOf(


        products("Brot","2,49€",""),
        products("Banane","1,49€",""),
        products("kartoffel","5€",""),
        products("Karpfen","0,39€",""),
        products("Döner","7€",""),
        products("Söner","9€",""),
        products("Brot","2,49€",""),
        products("Banane","1,49€",""),
        products("kartoffel","5€",""),
        products("Karpfen","0,39€",""),
        products("Döner","7€",""),
        products("Söner","9€",""),



    )
}

