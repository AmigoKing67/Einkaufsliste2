package com.example.einkaufsliste.Screen1

import androidx.compose.runtime.mutableStateMapOf

class GlobaleDatenspeicher {


    val information = mutableListOf(42)

    val listOfinformation = mutableListOf<Int>()

    val mapOfinformation = mutableStateMapOf<String, Int>()

    companion object {

        private val instance = GlobaleDatenspeicher()
        public fun getInstance() : GlobaleDatenspeicher{
            return instance
        }
    }

}