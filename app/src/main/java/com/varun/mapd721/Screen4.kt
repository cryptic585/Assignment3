package com.varun.mapd721

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.horizontalDrag
import androidx.compose.foundation.gestures.verticalDrag
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun Animation4Screen(navController: NavController) {
    val offsetX = remember { Animatable(0f) }
    val offsetY = remember { Animatable(0f) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.DarkGray
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    coroutineScope {
                        while (true) {
                            val velocityTracker = VelocityTracker()
                            offsetX.stop()
                            offsetY.stop()
                            awaitPointerEventScope {
                                val pointerId = awaitFirstDown().id
                                horizontalDrag(pointerId) { change ->

                                    launch {
                                        offsetX.snapTo(
                                            offsetX.value + change.positionChange().x
                                        )
                                    }
                                    velocityTracker.addPosition(
                                        change.uptimeMillis,
                                        change.position
                                    )
                                }
                            }
                            awaitPointerEventScope {
                                val pointerId = awaitFirstDown().id
                                verticalDrag(pointerId) { change ->

                                    launch {
                                        offsetY.snapTo(
                                            offsetY.value + change.positionChange().y
                                        )
                                    }
                                    velocityTracker.addPosition(
                                        change.uptimeMillis,
                                        change.position
                                    )
                                }
                            }
                        }
                    }
                }
        ) {
            Box(
                Modifier
                    .offset(x = offsetX.value.dp, y = offsetY.value.dp) // Offset by both X and Y values
                    .size(100.dp)
                    .background(Color.Yellow)
                    .border(width = 1.dp, color = Color.Black)
            )
        }
    }
}
