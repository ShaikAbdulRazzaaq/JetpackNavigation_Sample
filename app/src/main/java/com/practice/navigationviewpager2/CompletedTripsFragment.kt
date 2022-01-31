package com.practice.navigationviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.navigationviewpager2.databinding.FragmentCompletedTripsBinding


class CompletedTripsFragment : Fragment(R.layout.fragment_completed_trips) {
    private var _completedTripsBinding: FragmentCompletedTripsBinding? = null
    private val binding get() = _completedTripsBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _completedTripsBinding = FragmentCompletedTripsBinding.bind(view)
        binding.btnDetailedCompletedTrips.setOnClickListener {
            findNavController().navigate(R.id.action_completedTripsFragment_to_completedTripsDetailed)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _completedTripsBinding = null
    }
}