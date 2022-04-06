package com.example.musicknob

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicknob.ui.theme.MusicKnobTheme
import java.lang.Math.PI
import kotlin.math.atan2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicKnobTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicKnobb(
    modifier: Modifier,
    limitAngle: Float = 25f,
    onValueChange: (Float) -> Unit
) {

    var rotation by remember {
        mutableStateOf(limitAngle)
    }

    var touchX by remember {
        mutableStateOf(0f)
    }

    var touchY by remember {
        mutableStateOf(0f)
    }

    var centerX by remember {
        mutableStateOf(0f)
    }

    var centerY by remember {
        mutableStateOf(0f)
    }


    Image(painter = painterResource(id = R.drawable.music_knob),
        contentDescription = "",
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                val windowbounds = it.boundsInWindow()
                centerX = windowbounds.size.width / 2f;
                centerY = windowbounds.size.height / 2f;
            }
            .pointerInteropFilter { motionEVent ->
                {



//                    touchX = motionEVent.x
//                    touchY = motionEVent.y
//
//                    var angle = -atan2(centerX - touchY, centerY - touchY) * (180f / PI).toFloat()
//
////                    when (motionEVent.action) {
////                        MotionEvent.ACTION_DOWN,
////                        MotionEvent.ACTION_MOVE -> {
////                            if (angle !in -limitAngle..limitAngle) {
////
////                                val fixedAngle = if (angle in 180f..-limitAngle) {
////                                    360f + angle
////                                } else {
////                                    angle
////                                }
////
////                                rotation = fixedAngle
////
////                                val percent = (fixedAngle - limitAngle) / (360f - 2 * limitAngle)
////
////                                onValueChange(percent)
////                                true
////
////                            } else false
////                        }
////                        else -> false
////                    }
                }
                )

            }

}


        @Preview(showBackground = true)
        @Composable
        fun DefaultPreview() {
            MusicKnobTheme {
                MusicKnobb(onValueChange = {

                })
            }
        }
}