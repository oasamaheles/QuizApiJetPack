package com.example.myallwork.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.myallwork.Model.City
import com.example.myallwork.Model.Items
@Composable
fun ServiceColumn(work: Items, city: City, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = work.coverImage,
                ),
                contentDescription = "Service Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            work.title?.let { title ->
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            work.details?.let { Text(text = it) }
            Spacer(modifier = Modifier.height(8.dp))
            city.title?.let {
                Text(
                    text = "City: $it",
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

