package com.example.memoria.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memoria.databinding.MemoCardListFragmentBinding
import com.example.memoria.domain.MemoEntity


class MemoCardListFragment: Fragment() {

    private val TAG = "MemoCardList"
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MemoCardListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MemoCardListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        Log.i(TAG, "MemoCardListFragment is created!")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =  MemoCardListRecyclerViewAdapter(viewModel.memoList)

        viewModel.lastMemoAddedLiveData.observe(viewLifecycleOwner){
            binding.rvMemoList.adapter = adapter
            binding.rvMemoList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}