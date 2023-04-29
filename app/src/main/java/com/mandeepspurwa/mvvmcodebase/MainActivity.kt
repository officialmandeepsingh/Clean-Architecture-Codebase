package com.mandeepspurwa.mvvmcodebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandeepspurwa.mvvmcodebase.databinding.ActivityMainBinding
import com.mandeepspurwa.mvvmcodebase.databinding.ItemTextBinding
import com.mandeepspurwa.mvvmcodebase.util.extension.newbindData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        binding.rcyName.newbindData(
//            data = listOf("item1", "item2", "item3", "item4", "item4", "item4", "item4", "item14"),
////            VB = ActivityMainBinding.inflate(LayoutInflater.from(baseContext)),
//            layoutInflator = ItemTextBinding::inflate,
//            VB = ItemTextBinding,
//            bindFun = { binding, item ->
//                binding.apply {
//
//                }
//
//            }
//        ) { item -> Log.d("TAG", "onCreate() called with: item = $item") }
//        val itemBinding = ItemTextBinding.inflate(layoutInflater,View, false)
//        binding.rcyName.newbindData<String, ItemTextBinding>(
//            itemBinding,
//            data = listOf("item1", "item2", "item3", "item4", "item4",  "item14")
//        ) { binding, item ->
//            binding.textView.text = item
//        }
    }
}