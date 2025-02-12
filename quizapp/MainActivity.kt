package com.example.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                QuizScreen{message -> Toast.makeText(this,message,Toast.LENGTH_SHORT).show()}
            }
        }
    }
}

@Composable
fun QuizScreen(showFeedback:(String)->Unit) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),verticalArrangement= Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Quiz App",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp) 
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Is the Sky Blue?")
        Spacer(modifier = Modifier.height(24.dp))
        Row{
            Button(onClick ={showFeedback("Correct! The Sky is Blue.")}){
                Text("True")
            }
            Button(onClick ={showFeedback("Wrong")}){
                Text("False")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizAppTheme {
        QuizScreen {}
    }
}
