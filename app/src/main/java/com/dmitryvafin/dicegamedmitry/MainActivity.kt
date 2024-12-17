package com.dmitryvafin.dicegamedmitry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitryvafin.dicegamedmitry.model.Dice
import com.dmitryvafin.dicegamedmitry.ui.theme.DiceGameDmitryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceGameDmitryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    var puntos by rememberSaveable { mutableIntStateOf(20) }
    var num by rememberSaveable { mutableIntStateOf(Dice.throwDiceNFaces(6)) }
    var numAnterior by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Dado Mágico de Dmitry", fontSize = 25.sp)
                Text(text = "- Las flechas son para apostar que saldrá un número mayor (⬆) o menor (⬇) que el dado.", fontSize = 15.sp)
                Text(text = "- Los números son para apostar que saldrá ese número en el dado.", fontSize = 15.sp)
                Text(text = "Flechas: paga 1 y gana 3", fontSize = 15.sp)
                Text(text = "Números: paga 3 y gana 15", fontSize = 15.sp)
            }
        }
        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { }, modifier = Modifier.size(100.dp), shape = RoundedCornerShape(10.dp)) {
                    Text(text = "$num", fontSize = 50.sp)
                }
            }
            Column(modifier = Modifier.padding(start = 30.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Puntos:", fontSize = 15.sp)
                Text(text = "$puntos", fontSize = 50.sp)
            }
        }
        if (puntos > 0) {
            Row{
                Column { Button(onClick = { num = Dice.throwDiceNFaces(6)
                    puntos-=3
                    if(num==1) puntos+=15
                }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                    Text(text = "1", fontSize = 25.sp)
                }
                    Button(onClick = { num = Dice.throwDiceNFaces(6)
                        puntos-=3
                        if(num==2) puntos+=15
                    }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                        Text(text = "2", fontSize = 25.sp)
                    }
                    Button(onClick = { num = Dice.throwDiceNFaces(6)
                        puntos-=3
                        if(num==3) puntos+=15
                    }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                        Text(text = "3", fontSize = 25.sp)
                    }
                }
                Column { Button(onClick = { num = Dice.throwDiceNFaces(6)
                    puntos-=3
                    if(num==4) puntos+=15
                }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                    Text(text = "4", fontSize = 25.sp)
                }
                    Button(onClick = { num = Dice.throwDiceNFaces(6)
                        puntos-=3
                        if(num==5) puntos+=15
                    }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                        Text(text = "5", fontSize = 25.sp)
                    }
                    Button(onClick = { num = Dice.throwDiceNFaces(6)
                        puntos-=3
                        if(num==6) puntos+=15
                    }, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                        Text(text = "6", fontSize = 25.sp)
                    }
                }
                Column { Button(onClick = { numAnterior = num
                    num = Dice.throwDiceNFaces(6)
                    puntos--
                    if(num>numAnterior) puntos+=3}, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                    Text(text = "⬆", fontSize = 25.sp)
                }

                    Button(onClick = { numAnterior = num
                        num = Dice.throwDiceNFaces(6)
                        puntos--
                        if(num<numAnterior) puntos+=3}, modifier = Modifier.size(50.dp), shape = RoundedCornerShape(10.dp)){
                        Text(text = "⬇", fontSize = 25.sp)
                    }
                }
            }
        } else {
            Button(onClick = { puntos = 20 }, shape = RoundedCornerShape(10.dp)) {
                Text(text = "Reiniciar Juego", fontSize = 20.sp)
            }
        }
        Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom) {
            Text(text = "Dmitry Vafin")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContent() {
    DiceGameDmitryTheme {
        Content()
    }
}
