package com.naufall.quran.ui.juz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naufall.quran.R
import com.naufall.quran.databinding.FragmentJuzBinding
import com.naufall.quran.databinding.FragmentSuratBinding

class JuzFragment : Fragment() {

    private lateinit var binding: FragmentJuzBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentJuzBinding.inflate(inflater, container, false)

        return binding.root
    }
}