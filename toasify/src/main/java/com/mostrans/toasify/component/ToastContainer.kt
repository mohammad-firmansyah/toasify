package com.mostrans.toasify.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mostrans.toasify.utils.ToastManager
import com.mostrans.toasify.utils.ToastPosition
import com.mostrans.toasify.utils.ToastType
import com.mostrans.toasify.utils.toAlignType
import kotlinx.coroutines.delay

@Composable
fun ToastContainer(
    modifier : Modifier = Modifier,
    position: ToastPosition = ToastPosition.Top
) {
    val toastState by ToastManager.toastState.collectAsState()

    LaunchedEffect(toastState) {
        if (toastState != null) {
            delay(3000) // Auto-dismiss after 3 sec
            ToastManager.clearToast()
        }
    }

    Box(
        modifier = modifier
            .zIndex(Float.MAX_VALUE)
            .fillMaxSize()
            .padding(
                vertical = 40.dp,
                horizontal = 20.dp
            ),
        contentAlignment = if(toastState?.position != null) toastState?.position?.toAlignType()  ?: Alignment.TopCenter else position.toAlignType()
    ) {
        AnimatedVisibility(
            visible = toastState != null,
            enter = fadeIn() + slideInVertically(initialOffsetY = { -50 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -50 })
        ) {
            toastState?.let { toast ->
                CustomToast(
                    title = toast.title.toString(),
                    message = toast.message.toString(),
                    type = toast.type,
                    content = toast.content
                )
            }
        }
    }
}