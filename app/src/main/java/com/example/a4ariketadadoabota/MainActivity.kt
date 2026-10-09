package com.example.a4ariketadadoabota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4AriketaDadoaBotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DadoaBota(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DadoaBota(modifier: Modifier = Modifier) {
    var dadozenbakia by remember { mutableIntStateOf(1) }
    val dadoirudia = when (dadozenbakia) {1 -> R.drawable.dadoa_1
        2 -> R.drawable.dadoa_2
        3 -> R.drawable.dadoa_3
        4 -> R.drawable.dadoa_4
        5 -> R.drawable.dadoa_5
        else -> R.drawable.dadoa_6
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondodado),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = dadoirudia),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = "$dadozenbakia",
                fontSize = 32.sp,
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        dadozenbakia = (1..6).random()
                    },
                ) {
                    Text(
                        text = "Jaurti dadoa",
                        fontSize = 18.sp
                    )
                }


            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  _4AriketaDadoaBotaTheme() {
        DadoaBota()
    }


