package com.github.satoshun.example.maxlifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.databinding.MaxLifecycleFragBinding

class MaxLifecycleFragment : Fragment() {
  private lateinit var binding: MaxLifecycleFragBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = MaxLifecycleFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.viewPager.adapter = MaxLifecycleFragmentAdapter(this)
  }
}


class MaxLifecycleFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 100

  override fun createFragment(position: Int): Fragment {
    return MaxLifecycleChildFragment()
  }
}

class MaxLifecycleChildFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return TextView(requireContext()).apply { text = "test" }
  }
}
