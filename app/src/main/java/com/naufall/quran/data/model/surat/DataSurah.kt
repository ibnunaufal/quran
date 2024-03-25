package com.naufall.quran.data.model.surat

data class DataSurah(
    val arabic: String,
    val id: Int,
    val latin: String,
    val location: String,
    val num_ayah: Int,
    val page: Int,
    val translation: String,
    val transliteration: String,
    val updated_at: Any
)