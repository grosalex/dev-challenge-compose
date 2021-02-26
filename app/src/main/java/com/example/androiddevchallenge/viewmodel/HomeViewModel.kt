package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.models.Puppy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HomeViewModel : ViewModel() {

    val puppies: Flow<List<Puppy>> = flowOf(
        listOf(
            Puppy("Beethoven", "https://images.dog.ceo/breeds/stbernard/n02109525_1575.jpg"),
            Puppy("Slinky", "https://www.pnglib.com/wp-content/uploads/2020/10/toy-story-slinky-dog_5f81c8cb0e3e3.png"),
            Puppy("Lassie", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Rough_Collie_600.jpg/500px-Rough_Collie_600.jpg"),
            Puppy("Laika", "https://cdn-s-www.republicain-lorrain.fr/images/D3FD6D02-C285-4818-AA01-671BC5A1021A/NW_raw/laika-(photo-rue-des-archives)-1508760736.jpg")
        )
    )
}