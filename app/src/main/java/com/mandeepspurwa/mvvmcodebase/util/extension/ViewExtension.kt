package com.mandeepspurwa.mvvmcodebase.util.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import coil.load

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.util.extension
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Wed 26 Apr, 2023
 *
 **/

infix fun ImageView.LoadImage(url: String) {
    load(url)
}

infix fun View.onClick(click: () -> Unit) {
    setOnClickListener { click() }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}