package com.mostrans.toasify.utils

import androidx.compose.runtime.Composable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ToastManager {
    private val _toastState = MutableStateFlow<ToastData?>(null)
    val toastState = _toastState.asStateFlow()

    fun showInfo(title: String? = "Warning", message: String) {
        _toastState.value = ToastData(title = title, message = message, type = ToastType.Info)
    }

    fun showSuccess(title: String? = "Success", message: String) {
        _toastState.value = ToastData(title = title, message = message, type = ToastType.Success)
    }

    fun showError(title: String? = "Warning", message: String) {
        _toastState.value = ToastData(title = title, message = message, type = ToastType.Error)
    }

    fun showWarning(
        title: String? = "Warning",
        message: String,
    ) {
        _toastState.value = ToastData(title = title, message = message, type = ToastType.Warning)
    }

    fun showLoading(
        title: String = "Loading",
    ) {
        _toastState.value = ToastData(title = title, type = ToastType.Loading)
    }

    fun showCustom(
        content: @Composable () -> Unit,
    ) {
        _toastState.value = ToastData(content = content, type = ToastType.Custom)
    }

    fun clearToast() {
        _toastState.value = null
    }
}

data class ToastData(
    val title: String? = "",
    val message: String? = "",
    val type: ToastType = ToastType.Default,
    val content: (@Composable () -> Unit)? = null,
)

enum class ToastType {
    Success, Error, Warning, Default, Loading, Custom, Info
}