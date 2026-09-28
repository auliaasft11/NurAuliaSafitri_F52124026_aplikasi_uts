package com.Nurauliasafitri_F52124026.aplikasi_uts

object WisataData {
    fun getWisataList(): ArrayList<Wisata> {
        return arrayListOf(
            Wisata(
                id = 1,
                nama = "Kepulauan Togean",
                kabupaten = "Kab. Tojo Una-Una",
                kategori = "Wisata Bahari",
                rating = 4.9,
                hargaTiket = "Rp 25.000",
                jamOperasional = "24 Jam",
                deskripsi = "Surga bawah laut dunia dengan terumbu karang langka, gunung api bawah laut Una-Una, dan ubur-ubur tanpa sengat di Danau Mariona.",
                lokasiDetail = "Teluk Tomini, Kabupaten Tojo Una-Una, Sulawesi Tengah",
                imageResId = R.drawable.img_togean
            ),
            Wisata(
                id = 2,
                nama = "Danau Paisupok",
                kabupaten = "Kab. Banggai Kepulauan",
                kategori = "Danau & Air Terjun",
                rating = 4.9,
                hargaTiket = "Rp 10.000",
                jamOperasional = "07:00 - 18:00 WITA",
                deskripsi = "Danau dengan air super jernih bagaikan kaca berwarna biru kehitaman yang dikelilingi hutan tropis rindang di Banggai Kepulauan.",
                lokasiDetail = "Desa Luk Panenteng, Bulagi Utara, Kabupaten Banggai Kepulauan, Sulawesi Tengah",
                imageResId = R.drawable.danau_paisupok
            ),
            Wisata(
                id = 3,
                nama = "Danau Poso",
                kabupaten = "Kab. Poso",
                kategori = "Danau & Air Terjun",
                rating = 4.8,
                hargaTiket = "Rp 10.000",
                jamOperasional = "06:00 - 18:00 WITA",
                deskripsi = "Danau terbesar ketiga di Indonesia dengan pasir kuning keemasan yang unik dan air danau jernih kehijauan di kaki pegunungan.",
                lokasiDetail = "Tentena, Kecamatan Pamona Poso Kota, Kabupaten Poso",
                imageResId = R.drawable.danau_poso
            ),
            Wisata(
                id = 4,
                nama = "Air Terjun Saluopa",
                kabupaten = "Kab. Poso",
                kategori = "Danau & Air Terjun",
                rating = 4.9,
                hargaTiket = "Rp 15.000",
                jamOperasional = "08:00 - 17:00 WITA",
                deskripsi = "Air terjun bertingkat 21 yang terkenal dengan julukan 'Air Meluncur'. Aliran airnya sangat jernih membelah hutan tropis asri.",
                lokasiDetail = "Desa Tonusu, Pamona Utara, Kabupaten Poso",
                imageResId = R.drawable.img_saluopa
            ),
            Wisata(
                id = 5,
                nama = "Air Terjun Piala",
                kabupaten = "Kab. Banggai",
                kategori = "Danau & Air Terjun",
                rating = 4.8,
                hargaTiket = "Rp 10.000",
                jamOperasional = "08:00 - 17:00 WITA",
                deskripsi = "Air terjun eksotis dengan air berwarna hijau toska yang jernih dan kolam alami bertingkat di dekat Kota Luwuk.",
                lokasiDetail = "Hanga-Hanga, Luwuk Selatan, Kabupaten Banggai, Sulawesi Tengah",
                imageResId = R.drawable.air_terjun_piala
            ),
            Wisata(
                id = 6,
                nama = "Gunung Nokilalaki 2355 MDPL",
                kabupaten = "Kab. Sigi",
                kategori = "Gunung & Alam",
                rating = 4.7,
                hargaTiket = "Rp 15.000",
                jamOperasional = "24 Jam",
                deskripsi = "Gunung megah berketinggian 2.355 mdpl di kawasan Taman Nasional Lore Lindu yang menjadi favorit para pendaki & pecinta alam.",
                lokasiDetail = "Kecamatan Nokilalaki, Kabupaten Sigi, Sulawesi Tengah",
                imageResId = R.drawable.gn_nokilalaki
            ),
            Wisata(
                id = 7,
                nama = "Gunung Gawalise 2023 MDPL",
                kabupaten = "Kota Palu & Kab. Sigi",
                kategori = "Gunung & Alam",
                rating = 4.7,
                hargaTiket = "Rp 10.000",
                jamOperasional = "24 Jam",
                deskripsi = "Gunung berketinggian 2.023 mdpl yang menjadi latar lanskap panorama Kota Palu, populer untuk pendakian & camping.",
                lokasiDetail = "Desa Salena, Ulujadi, Kota Palu / Kab. Sigi, Sulawesi Tengah",
                imageResId = R.drawable.gn_gawalise
            ),
            Wisata(
                id = 8,
                nama = "Gunung Rore Katimbu 2400 MDPL",
                kabupaten = "Kab. Sigi & Poso",
                kategori = "Gunung & Alam",
                rating = 4.8,
                hargaTiket = "Rp 15.000",
                jamOperasional = "24 Jam",
                deskripsi = "Salah satu puncak tertinggi di Sulawesi Tengah (2.400 mdpl) dengan keanekaragaman flora hutan lumut tropis yang memukau.",
                lokasiDetail = "Sedoa, Lore Utara, Kabupaten Poso / Kab. Sigi, Sulawesi Tengah",
                imageResId = R.drawable.mt_rore
            ),
            Wisata(
                id = 9,
                nama = "Gunung Torenali 2526 MDPL",
                kabupaten = "Kab. Sigi",
                kategori = "Gunung & Alam",
                rating = 4.7,
                hargaTiket = "Rp 15.000",
                jamOperasional = "24 Jam",
                deskripsi = "Puncak pegunungan hijau (2.500 mdpl) di kawasan Lore Lindu yang menawarkan petualangan alam terbuka menantang.",
                lokasiDetail = "Kawasan Taman Nasional Lore Lindu, Kabupaten Sigi, Sulawesi Tengah",
                imageResId = R.drawable.mt_torenali
            ),
            Wisata(
                id = 10,
                nama = "Situs Megalitikum Lore Lindu",
                kabupaten = "Kab. Poso & Sigi",
                kategori = "Sejarah & Budaya",
                rating = 4.8,
                hargaTiket = "Rp 10.000",
                jamOperasional = "08:00 - 16:00 WITA",
                deskripsi = "Warisan cagar budaya purbakala ribuan tahun berupa patung-patung batu peninggalan megalitikum di Lembah Bada dan Besoa.",
                lokasiDetail = "Taman Nasional Lore Lindu, Lembah Bada, Sulawesi Tengah",
                imageResId = R.drawable.megalitikum_sulteng
            ),
            Wisata(
                id = 11,
                nama = "Pusentasi Donggala",
                kabupaten = "Kab. Donggala",
                kategori = "Wisata Bahari",
                rating = 4.7,
                hargaTiket = "Rp 10.000",
                jamOperasional = "07:00 - 18:00 WITA",
                deskripsi = "Sumur raksasa alami berdiameter 10 meter berdinding batu kapur dengan air laut jernih kebiruan yang terhubung langsung ke laut.",
                lokasiDetail = "Desa Towale, Kecamatan Banawa Tengah, Kabupaten Donggala",
                imageResId = R.drawable.pusat_laut
            ),
            Wisata(
                id = 12,
                nama = "Pantai Talise & Teluk Palu",
                kabupaten = "Kota Palu",
                kategori = "Wisata Bahari",
                rating = 4.6,
                hargaTiket = "Gratis",
                jamOperasional = "24 Jam",
                deskripsi = "Ikon kebanggaan Kota Palu tempat menikmati pemandangan matahari terbenam (sunset) indah dengan latar Teluk Palu dan pegunungan.",
                lokasiDetail = "Jl. Rajamoili, Besusu Barat, Palu Timur, Kota Palu",
                imageResId = R.drawable.pantai_talise
            ),
            Wisata(
                id = 13,
                nama = "Pulau Dua Luwuk",
                kabupaten = "Kab. Banggai",
                kategori = "Wisata Bahari",
                rating = 4.9,
                hargaTiket = "Rp 20.000",
                jamOperasional = "06:00 - 18:00 WITA",
                deskripsi = "Destinasi laut tropis dengan terumbu karang eksotis, bukit teletubbies hijau, dan gugusan pulau yang menawan di Kabupaten Banggai.",
                lokasiDetail = "Desa Balantak, Kabupaten Banggai, Sulawesi Tengah",
                imageResId = R.drawable.pulau_dua
            ),
            Wisata(
                id = 14,
                nama = "Puncak Matantimali",
                kabupaten = "Kab. Sigi",
                kategori = "Gunung & Alam",
                rating = 4.8,
                hargaTiket = "Rp 15.000",
                jamOperasional = "24 Jam",
                deskripsi = "Spot paralayang terbaik di Asia Tenggara di ketinggian 1.500 mdpl dengan pemandangan lanskap panorama Kota Palu & Lembah Sigi.",
                lokasiDetail = "Desa Wayu, Kecamatan Marawola Barat, Kabupaten Sigi",
                imageResId = R.drawable.bukit_matntimali
            ),
            Wisata(
                id = 15,
                nama = "Kepulauan Sombori",
                kabupaten = "Kab. Morowali",
                kategori = "Wisata Bahari",
                rating = 4.9,
                hargaTiket = "Rp 30.000",
                jamOperasional = "07:00 - 17:00 WITA",
                deskripsi = "Sering dijuluki sebagai 'Raja Ampat-nya Sulawesi Tengah', gugusan tebing karst megah di atas air laut jernih kristal.",
                lokasiDetail = "Menui Kepulauan, Kabupaten Morowali, Sulawesi Tengah",
                imageResId = R.drawable.pulau_sumbori
            ),
            Wisata(
                id = 16,
                nama = "Taman Nasional Lore Lindu",
                kabupaten = "Kab. Sigi & Poso",
                kategori = "Gunung & Alam",
                rating = 4.7,
                hargaTiket = "Rp 20.000",
                jamOperasional = "08:00 - 17:00 WITA",
                deskripsi = "Kawasan biosfer UNESCO yang menjadi habitat flora dan fauna endemik Sulawesi seperti Anoa, Babirusa, dan Burung Maleo.",
                lokasiDetail = "Kabupaten Sigi dan Poso, Sulawesi Tengah",
                imageResId = R.drawable.danau_lindu
            )
        )
    }
}