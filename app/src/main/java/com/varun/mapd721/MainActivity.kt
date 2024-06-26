package com.varun.mapd721


//Main Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.varun.mapd721.ui.theme.MAPD721Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721Theme {
                val navController = rememberNavController()

                // adding navigation
                NavHost(navController, startDestination = "mainScreen") {
                    composable("mainScreen") { MainScreen(navController) }
                    composable("animation1Screen") { Animation1Screen(navController) }
                    composable("animation2Screen") { Animation2Screen(navController) }
                    composable("animation3Screen") { Animation3Screen(navController) }
                    composable("animation4Screen") { Animation4Screen(navController) }
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonDemo("Screen 1") {
                    navController.navigate("Animation1Screen")
                }
                Spacer(modifier = Modifier.height(16.dp))
                ButtonDemo("Screen 2") {
                    navController.navigate("Animation2Screen")
                }
              Spacer(modifier = Modifier.height(16.dp))
                ButtonDemo("Screen 3") {
                    navController.navigate("Animation3Screen")
                }
                Spacer(modifier = Modifier.height(16.dp))
               ButtonDemo("Screen 4") {
                  navController.navigate("Animation4Screen")
                }
            }
            ContainerWithStudentInfo()
        }
    }
}

@Composable
fun ButtonDemo(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 10.dp) // Adding more padding
    ) {
        Text(text = text, modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun ContainerWithStudentInfo() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        color = Color(0x0000FF)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Varun Bhatt",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = "301364446",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }
}
