package com.naufall.quran.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naufall.quran.ui.bookmark.BookmarkFragment
import com.naufall.quran.ui.juz.JuzFragment
import com.naufall.quran.ui.surat.SuratFragment

private const val NUM_TABS = 3
class HomeViewPagerAdapter(
    private val suratFragment: SuratFragment,
    private val juzFragment: JuzFragment,
    private val bookmarkFragment: BookmarkFragment,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return suratFragment
            1 -> return juzFragment
            2 -> return bookmarkFragment
        }
        return juzFragment
    }
}