package com.github.satoshun.example.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.satoshun.example.databinding.ViewPager2FragBinding

class ViewPager2Fragment : Fragment() {
  private lateinit var binding: ViewPager2FragBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = ViewPager2FragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.viewPager.adapter = ViewPager2FragmentAdapter(this)
  }
}


class ViewPager2FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 100

  override fun createFragment(position: Int): Fragment {
    return ViewPager2ChildFragment().apply { userId = position }
  }
}

class ViewPager2ChildFragment : Fragment() {

  var userId: Int = 0

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    println("onCreateView $userId")
    return TextView(requireContext()).apply { text = "$userId" }
  }

  override fun onStart() {
    super.onStart()
    println("onStart $userId")
  }

  override fun onResume() {
    super.onResume()
    println("onResume $userId")
  }

  override fun onPause() {
    super.onPause()
    println("onPause $userId")
  }

  override fun onStop() {
    super.onStop()
    println("onStop $userId")
  }
}
