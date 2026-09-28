package com.Nurauliasafitri_F52124026.aplikasi_uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class WisataAdapter(
    context: Context,
    private val listWisata: ArrayList<Wisata>,
    private val onFavoriteClick: (Wisata) -> Unit
) : ArrayAdapter<Wisata>(context, 0, listWisata) {

    // ViewHolder pattern untuk efisiensi performa memori ListView
    private class ViewHolder(view: View) {
        val imgWisata: ImageView = view.findViewById(R.id.imgWisata)
        val tvNamaWisata: TextView = view.findViewById(R.id.tvNamaWisata)
        val tvKabupaten: TextView = view.findViewById(R.id.tvKabupaten)
        val tvKategori: TextView = view.findViewById(R.id.tvKategori)
        val tvRating: TextView = view.findViewById(R.id.tvRating)
        val tvHargaTiket: TextView = view.findViewById(R.id.tvHargaTiket)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDeskripsi)
        val btnFavorite: ImageView = view.findViewById(R.id.btnFavorite)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_destinasi, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = getItem(position)
        if (item != null) {
            // Memasang data teks
            viewHolder.tvNamaWisata.text = item.nama
            viewHolder.tvKabupaten.text = item.kabupaten
            viewHolder.tvRating.text = item.rating.toString()
            viewHolder.tvHargaTiket.text = item.hargaTiket
            viewHolder.tvDeskripsi.text = item.deskripsi
            viewHolder.tvKategori.text = item.kategori

            // Memasang foto/gambar dari res/drawable/ menggunakan imageResId dari WisataData
            viewHolder.imgWisata.setImageResource(item.imageResId)

            // Desain badge kategori dinamis
            when (item.kategori) {
                "Wisata Bahari" -> {
                    viewHolder.tvKategori.setBackgroundResource(R.drawable.bg_badge_bahari)
                    viewHolder.tvKategori.setTextColor(ContextCompat.getColor(context, R.color.badge_bahari_text))
                }
                "Danau & Air Terjun" -> {
                    viewHolder.tvKategori.setBackgroundResource(R.drawable.bg_badge_danau)
                    viewHolder.tvKategori.setTextColor(ContextCompat.getColor(context, R.color.badge_danau_text))
                }
                "Sejarah & Budaya" -> {
                    viewHolder.tvKategori.setBackgroundResource(R.drawable.bg_badge_sejarah)
                    viewHolder.tvKategori.setTextColor(ContextCompat.getColor(context, R.color.badge_sejarah_text))
                }
                "Gunung & Alam" -> {
                    viewHolder.tvKategori.setBackgroundResource(R.drawable.bg_badge_gunung)
                    viewHolder.tvKategori.setTextColor(ContextCompat.getColor(context, R.color.badge_gunung_text))
                }
                else -> {
                    viewHolder.tvKategori.setBackgroundResource(R.drawable.bg_badge_bahari)
                    viewHolder.tvKategori.setTextColor(ContextCompat.getColor(context, R.color.badge_bahari_text))
                }
            }

            // Ikon Favorit (Hati terisi / garis luar)
            if (item.isFavorite) {
                viewHolder.btnFavorite.setImageResource(R.drawable.ic_heart_filled)
            } else {
                viewHolder.btnFavorite.setImageResource(R.drawable.ic_heart_outline)
            }

            // Listener tombol favorit
            viewHolder.btnFavorite.setOnClickListener {
                item.isFavorite = !item.isFavorite
                notifyDataSetChanged()
                onFavoriteClick(item)
            }
        }

        return view
    }
}