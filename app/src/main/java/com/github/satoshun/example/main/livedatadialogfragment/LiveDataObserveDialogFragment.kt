package com.github.satoshun.example.main.livedatadialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import com.github.satoshun.example.databinding.LiveDataObserveDialogFragBinding

class LiveDataObserveDialogFragment : DialogFragment() {
  private lateinit var binding: LiveDataObserveDialogFragBinding

  private val viewModel by viewModels<LiveDataObserveDialogFragmentViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = LiveDataObserveDialogFragBinding.inflate(inflater)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.userName.observe(viewLifecycleOwner) {
      println(it)
    }
  }
}

class LiveDataObserveDialogFragmentViewModel : ViewModel() {
  val userName = MutableLiveData("test")
}
