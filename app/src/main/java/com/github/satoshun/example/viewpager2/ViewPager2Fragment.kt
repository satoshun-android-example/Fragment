package com.github.satoshun.example.viewpager2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.github.satoshun.example.AppActivity
import com.github.satoshun.example.databinding.ViewPager2FragBinding

class ViewPager2Fragment : Fragment() {
  private lateinit var binding: ViewPager2FragBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = ViewPager2FragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.viewPager.expandFragmentCacheSize()
    binding.viewPager.adapter = ViewPager2FragmentAdapter(this)
  }
}

private fun ViewPager2.expandFragmentCacheSize() {
  val childView = this[0] as RecyclerView
  childView.setItemViewCacheSize(5)
}

class ViewPager2FragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
  override fun getItemCount(): Int = 100

  override fun createFragment(position: Int): Fragment {
    return ViewPager2ChildFragment().apply { userId = position }
  }
}

class ViewPager2ChildFragment : Fragment() {

  var userId: Int = 0

  private val viewModel: ViewPager2ChildFragmentViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println("onCreate $userId")
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    println("onCreateView $userId")
    return TextView(requireContext()).apply { text = "$userId" }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    println("onViewCreated $userId")

    view.setOnClickListener {
      startActivity(Intent(requireContext(), AppActivity::class.java))
    }
  }

  override fun onStart() {
    super.onStart()
    println("onStart $userId")
  }

  override fun onResume() {
    super.onResume()
    println("onResume $userId")

    viewModel.data.observe(viewLifecycleOwner, Observer {
      println("viewModel $it")
    })
  }

  override fun onPause() {
    super.onPause()
    println("onPause $userId")
  }

  override fun onStop() {
    super.onStop()
    println("onStop $userId")
  }

  override fun onDestroyView() {
    super.onDestroyView()
    println("onDestroyView $userId")
  }

  override fun onDestroy() {
    super.onDestroy()
    println("onDestroy $userId")
  }
}

class ViewPager2ChildFragmentViewModel : ViewModel() {
  val data = MutableLiveData<Int>()

  init {
    data.value = 10
  }
}
