package com.mostrans.toasify.utils

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ToastManager {
    private val _toastState = MutableStateFlow<ToastData?>(null)
    val toastState = _toastState.asStateFlow()

    fun showToast(message: String, type: ToastType = ToastType.Default) {
        _toastState.value = ToastData(message, type)
        Log.d("TAG", "showToast: test")
    }

    fun clearToast() {
        _toastState.value = null
    }
}

data class ToastData(
    val message: String,
    val type: ToastType
)

enum class ToastType {
    Success, Error, Warning, Default, Loading, Custom
}