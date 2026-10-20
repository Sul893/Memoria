package com.example.memoria.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.doOnLayout
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.memoria.databinding.MemoCardBinding
import com.example.memoria.domain.dp
import kotlin.apply
class MemoCardFragment: Fragment() {

    companion object{
        private const val ARG_NAME = "name"
        private const val ARG_DESC = "description"
        private const val ARG_MARGIN = "margin"

        private val TAG = "MemoCardCompanion"

        fun newInstance(
            name: String,
            description: String,
            margin: Int
        ) = MemoCardFragment().apply{
            arguments = Bundle().apply{
                putString(ARG_NAME, name)
                putString(ARG_DESC,description)
                putInt(ARG_MARGIN, margin)
            }

            Log.i(TAG, "instansieted!")

        }
    }

    private val TAG = "MemoCardFragment"

    private var _binding: MemoCardBinding? = null
    private val binding get() = _binding!!  // надо разобраться с тем что такое Binding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(TAG, arguments.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MemoCardBinding.inflate(inflater, container, false)
        val view = binding.root

        val name = requireArguments().getString(ARG_NAME)
        val description = requireArguments().getString(ARG_DESC)


        binding.tvNameField.text = name
        binding.tvDescField.text = description

        return view
    }
}