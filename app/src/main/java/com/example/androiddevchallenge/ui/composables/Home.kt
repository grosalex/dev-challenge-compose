package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.HomeViewModel
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.picasso.PicassoImage

@Composable
fun Home() {
    val homeViewModel = HomeViewModel()
    val puppies: List<Puppy> by homeViewModel.puppies.collectAsState(initial = emptyList())
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(puppies) { puppy ->
            PuppyCard(puppy = puppy)
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            GlideImage(
                data = puppy.picture,
                contentDescription = puppy.name,
                modifier = Modifier.widthIn(max = 72.dp).heightIn(72.dp).padding(8.dp)
            )
            Text(
                text = puppy.name,
                modifier = Modifier.padding(
                    vertical = 8.dp
                )
            )
        }
    }
}

@Preview(name = "Light")
@Composable
fun PreviewHome() {
    MyTheme(darkTheme = false) {
        Home()
    }
}

@Preview("Dark")
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}

@Preview
@Composable
fun PuppyCardPreview() {
    PuppyCard(puppy = Puppy("Test 1", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Rough_Collie_600.jpg/500px-Rough_Collie_600.jpg"))
}