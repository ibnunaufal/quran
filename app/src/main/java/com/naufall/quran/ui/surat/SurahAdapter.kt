package com.naufall.quran.ui.surat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.naufall.quran.Utils.openPage
import com.naufall.quran.data.model.surat.DataSurah
import com.naufall.quran.databinding.ItemSurahSurahBinding

class SurahAdapter: RecyclerView.Adapter<SurahAdapter.ViewHolder>(){
    private val surah = mutableListOf<DataSurah>()
    fun setSurah(data: List<DataSurah>){
        surah.clear()
        surah.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSurahSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(surah[position])
    }

    override fun getItemCount(): Int = surah.size
    
    inner class ViewHolder(private val binding: ItemSurahSurahBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(dataSurah: DataSurah) {
            with(binding){
                tvSurahNumber.text = dataSurah.id.toString()
                tvSurahName.text = "Surat ${dataSurah.latin} (${dataSurah.translation})"
                tvSurahAyah.text = "${dataSurah.location} ${dataSurah.num_ayah} Ayat"
                tvSurahPage.text = "${dataSurah.page}"
                binding.root.setOnClickListener {
                    // show toast
                    openPage(binding.root.context, dataSurah.page)
                }
            }
        }
    }
}