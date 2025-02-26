import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingToastBar(modifier : Modifier = Modifier) {
    // Infinite transition for animation
    val transition = rememberInfiniteTransition()
    val offsetX by transition.animateFloat(
        initialValue = 1200f,
        targetValue = 0f, // Adjust width based on screen size
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Red, Color.Yellow, Color.Green, Color.Cyan, Color.Blue, Color.Magenta
                    ),
                    start = Offset(offsetX+1200f ,y=0f),
                    end = Offset(x = offsetX-1200f, y = 0f)
                )
            )
    ){}
}

@Preview
@Composable
fun PreviewLoadingToastBar() {
    LoadingToastBar()
}
