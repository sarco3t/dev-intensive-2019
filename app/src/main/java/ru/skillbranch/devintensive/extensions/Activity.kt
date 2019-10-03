package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.isKeyboardClosed():Boolean {
    return this.isKeyboardOpen().not()
}

fun Activity.isKeyboardOpen():Boolean {
    val rootView = findViewById<View>(android.R.id. content)
    rootView.getWindowVisibleDisplayFrame(Rect())
}