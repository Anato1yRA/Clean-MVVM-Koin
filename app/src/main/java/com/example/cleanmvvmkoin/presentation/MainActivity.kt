package com.example.cleanmvvmkoin.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanmvvmkoin.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("AAA", "Activity create")

        vm.resultLive.observe(this) {
            binding.dataTextView.text = it
        }

        binding.bSetData.setOnClickListener {
            val firstText = binding.firstStringEditText.text.toString()
            val lastText = binding.lastStringEditText.text.toString()

            vm.set(firstText, lastText)
        }

        binding.bGetData.setOnClickListener {
            vm.get()
        }
    }
}