package com.practice.navigationviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practice.navigationviewpager2.databinding.FragmentCompletedTripsDetailedBinding

class CompletedTripsDetailed : Fragment(R.layout.fragment_completed_trips_detailed) {

    private var completedTripsDetailedBinding: FragmentCompletedTripsDetailedBinding? = null

    private val binding get() = completedTripsDetailedBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        completedTripsDetailedBinding = FragmentCompletedTripsDetailedBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        completedTripsDetailedBinding = null
    }
}