package com.example.memoria.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.example.memoria.databinding.MemoCardListFragmentBinding
import com.example.memoria.domain.MemoEntity


class MemoCardListFragment: Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: MemoCardListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MemoCardListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        var margin = 0

        val memoLiveDataObserver = Observer<MemoEntity>{ memo ->

             margin += view.layoutParams.height

            val fragment = MemoCardFragment.newInstance(memo.name, memo.description, margin)

            parentFragmentManager.commit {
                add(binding.fcvMemoListContainer.id, fragment)
            }
        }

        viewModel.lastMemoAddedLiveData.observe(viewLifecycleOwner, memoLiveDataObserver)

        return view

    }
}