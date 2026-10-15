package com.example.memoria.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.memoria.databinding.NewMemoFragmentBinding


class NewMemoFragment : Fragment() {



    private val TAG = "NewMemoFragment"

    private var _binding: NewMemoFragmentBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel: MainViewModel by activityViewModels()  // надо изучиь как работают viewModel-и

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "NewMemoFragment создан!")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewMemoFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()

        binding.btnSubmit.setOnClickListener {
            val name = binding.etTaskName.text.toString()
            val description = binding.etTaskDescription.text.toString()

            mainViewModel.onSubmit(name, description)

            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
    }

}