package com.mandeepspurwa.mvvmcodebase.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mandeepspurwa.mvvmcodebase.R
import com.mandeepspurwa.mvvmcodebase.databinding.FragmentHomeBinding
import com.mandeepspurwa.mvvmcodebase.ui.viewModel.AppViewModel
import com.mandeepspurwa.mvvmcodebase.util.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate){
    private val viewModel:AppViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}