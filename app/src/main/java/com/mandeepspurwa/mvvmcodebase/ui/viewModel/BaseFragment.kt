package com.mandeepspurwa.mvvmcodebase.ui.viewModel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * App Name: MVVM Codebase
 * Package Name: com.mandeepspurwa.mvvmcodebase.ui.viewModel
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Sun 23 Apr, 2023
 *
 **/
abstract class BaseFragment<VB : ViewBinding>(private val bindingInflator: (LayoutInflater) -> VB) :
    Fragment() {
    open val TAG: String? = this::class.simpleName
    private var _binding: VB? = null
    open val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflator.invoke(inflater)
        _binding?.let {
            return it.root
        } ?: throw IllegalArgumentException("Binding variable is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModels()
        bindAdapters()
        callApis()
        bindViews()
        bindObservers()

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    open fun callApis() {}
    open fun bindViews() {}
    open fun bindAdapters() {}
    open fun bindObservers() {}
    open fun bindViewModels() {}

}