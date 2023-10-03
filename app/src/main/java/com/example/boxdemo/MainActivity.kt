package com.example.boxdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boxdemo.ui.theme.BoxDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

/**
 * Utilizando Box Layout para criar layouts mais responsivos,
 * Para trbalharmos com uma box pequena de conteudo temos que definir uma box dentro de uma box
 * como fazemos abaixo, se definirmos so uma box como layout ela aplicara a tela inteira
 */

@Composable
private fun MainScreen() {
    Box(
        // definindo alinhamento do Box no pai
        // contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        // constantes que definem tamanho das caixas
        // val height = 200.dp
        // val width = 200.dp

        Box(
            // usando clip e definindo uma forma especifica para o box
            modifier = Modifier.size(400.dp, 200.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Cyan)
                .align(Alignment.Center)
        ) {

            TextCell(text = "CenterStart", modifier = Modifier
                .align(Alignment.CenterStart)
                .size(130.dp, height = 50.dp))
            TextCell(text = "Center", modifier = Modifier
                .align(Alignment.Center)
                .size(130.dp, height = 50.dp))
            TextCell(text = "CenterEnd", modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(130.dp, height = 50.dp))
        }

        // definindo alinhamento direto nos filhos do Box
        TextCell(text = "TopStart", modifier = Modifier
            .align(Alignment.TopStart)
            .size(130.dp, height = 50.dp))
        TextCell(text = "TopCenter", modifier = Modifier
            .align(Alignment.TopCenter)
            .size(130.dp, height = 50.dp))
        TextCell(text = "TopEnd", modifier = Modifier
            .align(Alignment.TopEnd)
            .size(130.dp, height = 50.dp))

        TextCell(text = "BotomStart", modifier = Modifier
            .align(Alignment.BottomStart)
            .size(130.dp, height = 50.dp))
        TextCell(text = "BotCenter", modifier = Modifier
            .align(Alignment.BottomCenter)
            .size(130.dp, height = 50.dp))
        TextCell(text = "BottomEnd", modifier = Modifier
            .align(Alignment.BottomEnd)
            .size(130.dp, height = 50.dp))
    }
}

@Composable
private fun TextCell(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = modifier
            .border(2.dp, Color.Black)
            .padding(4.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BoxDemoTheme {
        MainScreen()
    }
}