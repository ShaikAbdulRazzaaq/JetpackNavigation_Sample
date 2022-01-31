package com.practice.navigationviewpager2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.practice.navigationviewpager2.databinding.FragmentRunningTripDetailedBinding

class RunningTripFragmentDetailed : Fragment(R.layout.fragment_running_trip_detailed) {
    private var fragmentRunningTripDetailedBinding: FragmentRunningTripDetailedBinding? = null
    private val binding get() = fragmentRunningTripDetailedBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentRunningTripDetailedBinding = FragmentRunningTripDetailedBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentRunningTripDetailedBinding = null
    }
}