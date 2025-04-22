package com.mostrans.toasify.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ToastManager {
    private val _toastState = MutableStateFlow<ToastData?>(null)
    val toastState = _toastState.asStateFlow()

    fun showInfo(
        title: String? = "Info",
        message: String,
        position: ToastPosition? = null,
    ) {
        _toastState.value =
            ToastData(title = title, message = message, type = ToastType.Info, position = position)
    }

    fun showSuccess(
        title: String? = "Success",
        message: String,
        position: ToastPosition? = null,
    ) {
        _toastState.value = ToastData(
            title = title, message = message, type = ToastType.Success, position = position
        )
    }

    fun showError(
        title: String? = "Error",
        message: String,
        position: ToastPosition? = null,
    ) {
        _toastState.value =
            ToastData(title = title, message = message, type = ToastType.Error, position = position)
    }

    fun showWarning(
        title: String? = "Warning",
        message: String, position: ToastPosition? = null,
    ) {
        _toastState.value = ToastData(
            title = title, message = message, type = ToastType.Warning, position = position
        )
    }

    fun showLoading(
        title: String = "Loading",
        position: ToastPosition? = null,
    ) {
        _toastState.value = ToastData(title = title, type = ToastType.Loading, position = position)
    }

    fun showCustom(
        content: @Composable () -> Unit,
        position: ToastPosition? = null,
    ) {
        _toastState.value = ToastData(
            content = content, type = ToastType.Custom,
            position = position
        )
    }

    fun clearToast() {
        _toastState.value = null
    }
}

data class ToastData(
    val title: String? = "",
    val message: String? = "",
    val position: ToastPosition? = ToastPosition.Top,
    val type: ToastType = ToastType.Default,
    val content: (@Composable () -> Unit)? = null,
)

enum class ToastType {
    Success, Error, Warning, Default, Loading, Custom, Info
}

enum class ToastPosition {
    Top, Center, Bottom
}

fun ToastPosition.toAlignType(): Alignment {
    return when (this) {
        ToastPosition.Top -> Alignment.TopCenter
        ToastPosition.Center -> Alignment.Center
        ToastPosition.Bottom -> Alignment.BottomCenter
    }
}