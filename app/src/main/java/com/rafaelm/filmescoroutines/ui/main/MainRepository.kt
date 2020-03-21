package com.rafaelm.filmescoroutines.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    //sem Coroutine
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "titulo 1"),
                    Filme(2, "titulo 2")
                )
            )
        }).start()
    }

    //Coroutine
    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default){
            delay(3000)
            listOf(
                Filme(1, "titulo 1"),
                Filme(2, "titulo 2")
            )
        }
    }
}