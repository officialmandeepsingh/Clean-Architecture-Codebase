package com.mandeepspurwa.mvvmcodebase.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.util.base
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Tue 25 Apr, 2023
 *
 **/
class BaseFragment<VB : ViewBinding>(private val bindingInflater: (LayoutInflater) -> VB) :
    Fragment() {
    open val TAG: String? = this::class.simpleName

    private var _binding: VB? = null
    open val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        _binding?.let {
            return it.root
        } ?: throw IllegalArgumentException("Binding variable is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindInitAdapters()
        bindInitViews()
        callApi()
        bindListeners()
        bindObservers()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    open fun callApi() {}
    open fun bindInitViews() {}
    open fun bindInitAdapters() {}
    open fun bindListeners() {}
    open fun bindObservers() {}
}