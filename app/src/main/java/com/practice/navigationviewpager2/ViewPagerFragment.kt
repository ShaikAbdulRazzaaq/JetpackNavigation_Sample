package com.practice.navigationviewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commitNow
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.practice.navigationviewpager2.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {
    private var fragmentViewPagerBinding: FragmentViewPagerBinding? = null
    private val binding get() = fragmentViewPagerBinding!!
    private lateinit var tabLayoutMediator: TabLayoutMediator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentViewPagerBinding = FragmentViewPagerBinding.bind(view)

        val navGraphIds = listOf(R.navigation.running_trip, R.navigation.completed_trip)
        val tabLabels = listOf("Running", "Completed")

        binding.viewPagerMain.adapter =
            NavHostFragmentAdapter(childFragmentManager, viewLifecycleOwner.lifecycle, navGraphIds)
        tabLayoutMediator = TabLayoutMediator(
            binding.viewPagerTab,
            binding.viewPagerMain
        ) { tab, position -> tab.text = tabLabels[position] }.apply {
            attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentViewPagerBinding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        tabLayoutMediator.detach()
    }
}


class NavHostFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val navGraphIds: List<Int>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    init {
        registerFragmentTransactionCallback(object : FragmentTransactionCallback() {
            override fun onFragmentMaxLifecyclePreUpdated(
                fragment: Fragment,
                maxLifecycleState: Lifecycle.State
            ) = if (maxLifecycleState == Lifecycle.State.RESUMED) {
                OnPostEventListener {
                    fragment.parentFragmentManager.commitNow {
                        setPrimaryNavigationFragment(fragment)
                    }
                }
            } else {
                super.onFragmentMaxLifecyclePreUpdated(fragment, maxLifecycleState)
            }
        })
    }

    override fun createFragment(position: Int): Fragment {
        return NavHostFragment.create(navGraphIds[position])
    }

    override fun getItemCount(): Int = navGraphIds.size

}