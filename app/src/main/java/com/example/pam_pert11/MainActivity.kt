package com.example.pam_pert11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.pam_pert11.ui.MahasiswaMainApp
import com.example.pam_pert11.ui.home.pages.HomeScreen
import com.example.pam_pert11.ui.navigation.PengelolaHalaman
import com.example.pam_pert11.ui.theme.PAMpert11Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAMpert11Theme {
                Scaffold(
                    //modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    //topBar = {TopAppBar(scrollBehavior = scrollBehavior)},
                ){
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    ){
                        PengelolaHalaman()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PAMpert11Theme {
        Greeting("Android")
    }
}