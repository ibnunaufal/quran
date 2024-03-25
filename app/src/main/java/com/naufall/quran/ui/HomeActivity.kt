package com.naufall.quran.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.naufall.quran.ui.bookmark.BookmarkFragment
import com.naufall.quran.databinding.ActivityHomeBinding
import com.naufall.quran.ui.juz.JuzFragment
import com.naufall.quran.ui.surat.SuratFragment

class HomeActivity : AppCompatActivity() {

    val tabTitleArray = arrayOf(
        "Surat",
        "Juz",
        "Bookmark"
    )

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = HomeViewPagerAdapter(
            SuratFragment(),
            JuzFragment(),
            BookmarkFragment(),
            supportFragmentManager,
            lifecycle
        )

        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = tabTitleArray[position]
            }.attach()
        }
    }
}