package com.Nurauliasafitri_F52124026.aplikasi_uts

data class Wisata(
    val id: Int,
    val nama: String,
    val kabupaten: String,
    val kategori: String,
    val rating: Double,
    val hargaTiket: String,
    val jamOperasional: String,
    val deskripsi: String,
    val lokasiDetail: String,
    val imageResId: Int,
    var isFavorite: Boolean = false
)