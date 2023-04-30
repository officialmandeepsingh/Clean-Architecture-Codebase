package com.mandeepspurwa.mvvmcodebase.util.extension

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import java.util.Objects

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


class ViewHolder<K : ViewBinding>(val binding: K) : RecyclerView.ViewHolder(binding.root)

fun <T, K : ViewBinding> RecyclerView.newbindData(
    itemBinding: K,
    data: List<T>,
    bindFun: (viewBinding: K, listType: T) -> Unit,
) {
    adapter = object : RecyclerView.Adapter<ViewHolder<K>>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<K> {
            return ViewHolder(itemBinding)
        }
        override fun getItemCount(): Int = data.size
        override fun onBindViewHolder(holder: ViewHolder<K>, position: Int) {
            val listItem = data[position]
            bindFun(holder.binding, listItem)
        }

    }
}