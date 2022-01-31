package com.practice.navigationviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.navigationviewpager2.databinding.FragmentRunningTripBinding

class RunningTripFragment : Fragment(R.layout.fragment_running_trip) {
    private var fragmentRunningTripBinding: FragmentRunningTripBinding? = null
    private val binding get() = fragmentRunningTripBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentRunningTripBinding = FragmentRunningTripBinding.bind(view)

        binding.btnDetailedRunningTrip.setOnClickListener {
            findNavController().navigate(R.id.action_runningTripFragment_to_runningTripFragmentDetailed)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentRunningTripBinding = null
    }
}