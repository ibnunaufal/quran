package com.naufall.quran.ui.surat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufall.quran.R
import com.naufall.quran.data.SharedPreferences
import com.naufall.quran.databinding.FragmentSuratBinding

class SuratFragment : Fragment() {

    private lateinit var binding: FragmentSuratBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuratBinding.inflate(inflater, container, false)

        val allSurahPerJuz = SharedPreferences.getAllSurahPerJuz()
        val surahPerJuzAdapter = SurahPerJuzAdapter()
        surahPerJuzAdapter.setSurahPerJuz(allSurahPerJuz)
        binding.rvSurat.adapter = surahPerJuzAdapter
        return binding.root
    }
}