package com.rafaelm.filmescoroutines.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainRepository {

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

}