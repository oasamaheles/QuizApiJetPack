package com.example.myallwork
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myallwork.Model.City
import com.example.myallwork.Model.Items
import com.example.myallwork.View.ServiceColumn
import com.example.myallwork.ViewModel.AllWorkViewModel
import com.example.myallwork.ui.theme.MyAllWorkTheme

class MainActivity : ComponentActivity() {
    private val allWorkViewModel by viewModels<AllWorkViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAllWorkTheme {
                Greeting(allWorkViewModel.listAllWorkLiveData) { itemId ->
                    // Handle item click here
                }
            }
        }
        allWorkViewModel.getAllWork()
    }
}

@Composable
fun Greeting(services: List<Items>, onItemClick: (Int) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn {
            itemsIndexed(items = services) { index, service ->
                ServiceColumn(service, City(), onItemClick = { onItemClick(index) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAllWorkTheme {
        Greeting(emptyList()) {}
    }
}
