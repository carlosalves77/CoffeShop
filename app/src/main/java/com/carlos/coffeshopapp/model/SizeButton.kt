package com.carlos.coffeshopapp.model

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.MutableStateFlow

data class SizeButton(
    val name: String,
    var isButtonSizeActivate: MutableState<Boolean>
)
