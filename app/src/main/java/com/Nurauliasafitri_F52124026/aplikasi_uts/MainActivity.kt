package com.Nurauliasafitri_F52124026.aplikasi_uts

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {

    private lateinit var masterWisataList: ArrayList<Wisata>
    private val displayedWisataList = ArrayList<Wisata>()
    private lateinit var adapter: WisataAdapter
    private lateinit var lvWisata: ListView
    private lateinit var etSearch: EditText
    private lateinit var btnClearSearch: ImageView
    private lateinit var tvCountInfo: TextView
    private lateinit var tvFavoriteCount: TextView
    private lateinit var layoutEmpty: LinearLayout
    private lateinit var btnResetFilter: Button
    private lateinit var chipAll: TextView
    private lateinit var chipBahari: TextView
    private lateinit var chipDanau: TextView
    private lateinit var chipSejarah: TextView
    private lateinit var chipGunung: TextView

    private var selectedCategory: String = "Semua"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        initDataAndAdapter()
        setupListeners()
        updateFilter()
    }

    private fun initViews() {
        lvWisata = findViewById(R.id.lvWisata)
        etSearch = findViewById(R.id.etSearch)
        btnClearSearch = findViewById(R.id.btnClearSearch)
        tvCountInfo = findViewById(R.id.tvCountInfo)
        tvFavoriteCount = findViewById(R.id.tvFavoriteCount)
        layoutEmpty = findViewById(R.id.layoutEmpty)
        btnResetFilter = findViewById(R.id.btnResetFilter)

        chipAll = findViewById(R.id.chipAll)
        chipBahari = findViewById(R.id.chipBahari)
        chipDanau = findViewById(R.id.chipDanau)
        chipSejarah = findViewById(R.id.chipSejarah)
        chipGunung = findViewById(R.id.chipGunung)
    }

    private fun initDataAndAdapter() {
        masterWisataList = WisataData.getWisataList()
        displayedWisataList.addAll(masterWisataList)
        adapter = WisataAdapter(this, displayedWisataList) { wisata ->
            updateFavoriteCount()
            val msg = if (wisata.isFavorite) {
                "Ditambahkan ke favorit: ${wisata.nama}"
            } else {
                "Dihapus dari favorit: ${wisata.nama}"
            }
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        lvWisata.adapter = adapter
    }

    private fun setupListeners() {
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnClearSearch.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
                updateFilter()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        btnClearSearch.setOnClickListener {
            etSearch.text.clear()
        }

        chipAll.setOnClickListener { selectCategory("Semua", chipAll) }
        chipBahari.setOnClickListener { selectCategory("Wisata Bahari", chipBahari) }
        chipDanau.setOnClickListener { selectCategory("Danau & Air Terjun", chipDanau) }
        chipSejarah.setOnClickListener { selectCategory("Sejarah & Budaya", chipSejarah) }
        chipGunung.setOnClickListener { selectCategory("Gunung & Alam", chipGunung) }

        btnResetFilter.setOnClickListener {
            etSearch.text.clear()
            selectCategory("Semua", chipAll)
        }

        lvWisata.setOnItemClickListener { _, _, position, _ ->
            if (position in 0 until displayedWisataList.size) {
                val wisata = displayedWisataList[position]
                showDetailBottomSheet(wisata)
            }
        }
    }

    private fun selectCategory(category: String, selectedChip: TextView) {
        selectedCategory = category

        val unselectedBg = R.drawable.bg_chip_unselected
        val unselectedTextColor = ContextCompat.getColor(this, R.color.text_secondary)

        val chips = listOf(chipAll, chipBahari, chipDanau, chipSejarah, chipGunung)
        for (chip in chips) {
            chip.setBackgroundResource(unselectedBg)
            chip.setTextColor(unselectedTextColor)
        }

        selectedChip.setBackgroundResource(R.drawable.bg_chip_selected)
        selectedChip.setTextColor(ContextCompat.getColor(this, R.color.white))

        updateFilter()
    }

    private fun updateFilter() {
        val query = etSearch.text.toString().trim().lowercase()

        displayedWisataList.clear()

        for (wisata in masterWisataList) {
            val matchesCategory = (selectedCategory == "Semua") || (wisata.kategori.equals(selectedCategory, ignoreCase = true))
            val matchesSearch = query.isEmpty() ||
                    wisata.nama.lowercase().contains(query) ||
                    wisata.kabupaten.lowercase().contains(query) ||
                    wisata.deskripsi.lowercase().contains(query)

            if (matchesCategory && matchesSearch) {
                displayedWisataList.add(wisata)
            }
        }

        adapter.notifyDataSetChanged()

        tvCountInfo.text = "Menampilkan ${displayedWisataList.size} destinasi"
        updateFavoriteCount()

        if (displayedWisataList.isEmpty()) {
            lvWisata.visibility = View.GONE
            layoutEmpty.visibility = View.VISIBLE
        } else {
            lvWisata.visibility = View.VISIBLE
            layoutEmpty.visibility = View.GONE
        }
    }

    private fun updateFavoriteCount() {
        val favCount = masterWisataList.count { it.isFavorite }
        tvFavoriteCount.text = "❤️ $favCount Favorit"
    }

    private fun showDetailBottomSheet(wisata: Wisata) {
        val dialog = BottomSheetDialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_detail_wisata, null)

        val imgWisata: ImageView = view.findViewById(R.id.imgDetailWisata)
        val tvNama: TextView = view.findViewById(R.id.tvDetailNama)
        val tvKategori: TextView = view.findViewById(R.id.tvDetailKategori)
        val tvKabupaten: TextView = view.findViewById(R.id.tvDetailKabupaten)
        val tvRating: TextView = view.findViewById(R.id.tvDetailRating)
        val tvTiket: TextView = view.findViewById(R.id.tvDetailTiket)
        val tvJam: TextView = view.findViewById(R.id.tvDetailJam)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvDetailDeskripsi)
        val tvLokasi: TextView = view.findViewById(R.id.tvDetailLokasi)
        val btnShare: Button = view.findViewById(R.id.btnShare)
        val btnClose: Button = view.findViewById(R.id.btnCloseDetail)

        imgWisata.setImageResource(wisata.imageResId)

        tvNama.text = wisata.nama
        tvKategori.text = wisata.kategori
        tvKabupaten.text = wisata.kabupaten
        tvRating.text = "${wisata.rating} / 5.0"
        tvTiket.text = wisata.hargaTiket
        tvJam.text = wisata.jamOperasional
        tvDeskripsi.text = wisata.deskripsi
        tvLokasi.text = wisata.lokasiDetail

        btnShare.setOnClickListener {
            shareWisata(wisata)
        }

        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }

    private fun shareWisata(wisata: Wisata) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT,
                "🌟 Explore Sulawesi Tengah: ${wisata.nama}\n\n" +
                        "📍 Lokasi: ${wisata.kabupaten}\n" +
                        "🏷️ Kategori: ${wisata.kategori}\n" +
                        "⭐ Rating: ${wisata.rating}\n" +
                        "🎟️ Tiket Masuk: ${wisata.hargaTiket}\n\n" +
                        "📝 ${wisata.deskripsi}\n\n" +
                        "Ayo jelajahi keindahan wisata Sulawesi Tengah!"
            )
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Bagikan Destinasi Wisata"))
    }
}