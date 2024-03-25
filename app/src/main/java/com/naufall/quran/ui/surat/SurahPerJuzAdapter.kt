package com.naufall.quran.ui.surat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.naufall.quran.R
import com.naufall.quran.Utils.openPage
import com.naufall.quran.data.SharedPreferences
import com.naufall.quran.data.model.surahperjuz.ModelSurahPerJuz
import com.naufall.quran.data.model.surat.DataSurah
import com.naufall.quran.databinding.ItemSurahJuzBinding

class SurahPerJuzAdapter: RecyclerView.Adapter<SurahPerJuzAdapter.ViewHolder>(){
    private val surahPerJuz = mutableListOf<ModelSurahPerJuz>()
    fun setSurahPerJuz(data: List<ModelSurahPerJuz>){
        surahPerJuz.clear()
        surahPerJuz.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSurahJuzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(surahPerJuz[position])
    }

    override fun getItemCount(): Int = surahPerJuz.size

    inner class ViewHolder(private val binding: ItemSurahJuzBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(modelSurahPerJuz: ModelSurahPerJuz) {
            with(binding){
                val juz = SharedPreferences.getJuzById(modelSurahPerJuz.juz)
                tvJuz.text = "Juz ${juz.juz}"
                tvPageJuz.text = juz.start.page.toString()
                llJuz.setOnClickListener {
                    // show toast
                    openPage(binding.root.context, juz.start.page)
                }
                val allDataSurah: MutableList<DataSurah> = mutableListOf()
                for (i in modelSurahPerJuz.surahList){
                    val dataSurah = SharedPreferences.getSurahById(i)
                    allDataSurah.add(dataSurah)
                }
                val adapter = SurahAdapter()
                adapter.setSurah(allDataSurah)
                rvSurah.adapter = adapter
            }
        }
    }
}