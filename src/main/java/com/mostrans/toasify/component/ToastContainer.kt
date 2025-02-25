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
import kotlinx.coroutines.delay

@Composable
fun ToastContainer() {
    val toastState by ToastManager.toastState.collectAsState()

    LaunchedEffect(toastState) {
        if (toastState != null) {
            delay(3000) // Auto-dismiss after 3 sec
            ToastManager.clearToast()
        }
    }

    Box(
        modifier = Modifier
            .zIndex(9999999999f)
            .fillMaxSize()
            .padding(vertical = 40.dp,
                horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        AnimatedVisibility(
            visible = toastState != null,
            enter = fadeIn() + slideInVertically(initialOffsetY = { -50 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -50 })
        ) {
            toastState?.let { toast ->
                CustomToast(message = toast.message, type = toast.type)
            }
        }
    }
}