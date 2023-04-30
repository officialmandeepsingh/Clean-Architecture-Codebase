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

        val itemBinding = ItemTextBinding.inflate(layoutInflater)
        binding.rcyName.newbindData<String, ItemTextBinding>(
            itemBinding,
            data = listOf("item1", "item2", "item3", "item4", "item4",  "item14")
        ) { binding, item ->
            binding.textView.text = item
        }
    }
}