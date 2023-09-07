package com.example.artspaceapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    var image by mutableStateOf(R.drawable.pic1)
        private set

    var titleText by mutableStateOf("Starry Night")
        private set

    var artistText by mutableStateOf("Van Gogh (1889)")
        private set

    fun changeImage(num: Int){
        image = when(num){
            1 -> R.drawable.pic1
            2 -> R.drawable.pic2
            3 -> R.drawable.pic3
            else -> R.drawable.picreturn
        }
    }

    fun changeTitle(num:Int){
        titleText = when(num){
            1 -> "Starry Night"
            2 -> "Mona Lisa"
            3 -> "Tree at a track"
            else -> ""
        }
    }

    fun changeArtist(num:Int){
        artistText = when(num){
            1 -> "Van Gogh (1889)"
            2 -> "Leonardo da vinci (XVI)"
            3 -> "Adolf Hitler (1911)"
            else -> ""
        }
    }

}