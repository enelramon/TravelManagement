package com.sagrd.travelmanagement.utils

import android.text.Editable
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun Editable?.getFloat(): Float {
    return this.toString().toFloatOrNull() ?: 0f
}

fun View.showMessage(message:String)
{
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
}