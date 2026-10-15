package com.example.memoria.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.memoria.R
import com.example.memoria.R.layout.activity_main
import com.example.memoria.databinding.ActivityMainBinding
import com.example.memoria.domain.MemoEntity
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            supportFragmentManager.commit{
                if(binding.fcvAddition.getFragment<NewMemoFragment?>() == null){
                    replace(binding.fcvAddition.id, NewMemoFragment())
                } else{
                    Log.e(TAG, " Fragment already created! ")
                }
            }
        }

        supportFragmentManager.commit {
            replace(binding.fcvMemoCard.id, MemoCardListFragment())
        }

    }
}