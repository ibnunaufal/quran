package com.naufall.quran.data

import android.content.Context
import com.google.gson.Gson
import com.naufall.quran.data.model.juz.DataJuz
import com.naufall.quran.data.model.juz.ModelAllJuz
import com.naufall.quran.data.model.surahperjuz.ModelSurahPerJuz
import com.naufall.quran.data.model.surat.DataSurah
import com.naufall.quran.data.model.surat.ModelAllSurah

object SharedPreferences {
    private const val PREFS_NAME = "my_shared_prefs"

    //    ==============================================================================================

    fun getAllJuz(): ModelAllJuz {
        return Gson().fromJson(allJuzString, ModelAllJuz::class.java)
    }

    fun getJuzById(id: Int): DataJuz {
        return getAllJuz().data.first { it.id == id }
    }

    fun getAllSurah(): ModelAllSurah {
        return Gson().fromJson(allSurahString, ModelAllSurah::class.java)
    }

    fun getSurahById(id: Int): DataSurah {
        return getAllSurah().data.first { it.id == id }
    }

    fun getAllSurahPerJuz(): List<ModelSurahPerJuz> {
        val allSurah = getAllSurah()
        val allJuz = getAllJuz()
        val returnedValue: MutableList<ModelSurahPerJuz> = mutableListOf()

        allJuz.data.forEach { juz ->
            val surahList: MutableList<Int> = mutableListOf()
            allSurah.data.forEach { surah ->
                if (surah.page in juz.start.page..juz.end.page) {
                    surahList.add(surah.id)
                }
            }
            returnedValue.add(ModelSurahPerJuz(juz.juz, surahList))
        }
        return returnedValue
    }

    private const val allJuzString = """
        {
            "data":[
                {
                    "id": 1,
                    "juz": 1,
                    "start":{
                        "page":1,
                        "image": "QK_001.webp"
                    },
                    "end":{
                        "page":21,
                        "image": "QK_021.webp"
                    }
                },
                {
                    "id": 2,
                    "juz": 2,
                    "start":{
                        "page":22,
                        "image": "QK_022.webp"
                    },
                    "end":{
                        "page":41,
                        "image": "QK_041.webp"
                    }
                },
                {
                    "id": 3,
                    "juz": 3,
                    "start":{
                        "page":42,
                        "image": "QK_042.webp"
                    },
                    "end":{
                        "page":61,
                        "image": "QK_061.webp"
                    }
                },
                {
                    "id": 4,
                    "juz": 4,
                    "start":{
                        "page":62,
                        "image": "QK_042.webp"
                    },
                    "end":{
                        "page":81,
                        "image": "QK_081.webp"
                    }
                },
                {
                    "id": 5,
                    "juz": 5,
                    "start":{
                        "page":82,
                        "image": "QK_082.webp"
                    },
                    "end":{
                        "page":101,
                        "image": "QK_101.webp"
                    }
                },
                {
                    "id": 6,
                    "juz": 6,
                    "start":{
                        "page":102,
                        "image": "QK_102.webp"
                    },
                    "end":{
                        "page":121,
                        "image": "QK_121.webp"
                    }
                },
                {
                    "id": 7,
                    "juz": 7,
                    "start":{
                        "page":122,
                        "image": "QK_122.webp"
                    },
                    "end":{
                        "page":141,
                        "image": "QK_141.webp"
                    }
                },
                {
                    "id": 8,
                    "juz": 8,
                    "start":{
                        "page":142,
                        "image": "QK_142.webp"
                    },
                    "end":{
                        "page":161,
                        "image": "QK_161.webp"
                    }
                },
                {
                    "id": 9,
                    "juz": 9,
                    "start":{
                        "page":162,
                        "image": "QK_162.webp"
                    },
                    "end":{
                        "page":181,
                        "image": "QK_181.webp"
                    }
                },
                {
                    "id": 10,
                    "juz": 10,
                    "start":{
                        "page":182,
                        "image": "QK_182.webp"
                    },
                    "end":{
                        "page":201,
                        "image": "QK_201.webp"
                    }
                },
                {
                    "id": 11,
                    "juz": 11,
                    "start":{
                        "page":202,
                        "image": "QK_202.webp"
                    },
                    "end":{
                        "page":221,
                        "image": "QK_221.webp"
                    }
                },
                {
                    "id": 12,
                    "juz": 12,
                    "start":{
                        "page":222,
                        "image": "QK_222.webp"
                    },
                    "end":{
                        "page":241,
                        "image": "QK_241.webp"
                    }
                },
                {
                    "id": 13,
                    "juz": 13,
                    "start":{
                        "page":242,
                        "image": "QK_242.webp"
                    },
                    "end":{
                        "page":261,
                        "image": "QK_261.webp"
                    }
                },
                {
                    "id": 14,
                    "juz": 14,
                    "start":{
                        "page":262,
                        "image": "QK_262.webp"
                    },
                    "end":{
                        "page":281,
                        "image": "QK_281.webp"
                    }
                },
                {
                    "id": 15,
                    "juz": 15,
                    "start":{
                        "page":282,
                        "image": "QK_282.webp"
                    },
                    "end":{
                        "page":301,
                        "image": "QK_301.webp"
                    }
                },
                {
                    "id": 16,
                    "juz": 16,
                    "start":{
                        "page":302,
                        "image": "QK_302.webp"
                    },
                    "end":{
                        "page":321,
                        "image": "QK_321.webp"
                    }
                },
                {
                    "id": 17,
                    "juz": 17,
                    "start":{
                        "page":322,
                        "image": "QK_322.webp"
                    },
                    "end":{
                        "page":341,
                        "image": "QK_341.webp"
                    }
                },
                {
                    "id": 18,
                    "juz": 18,
                    "start":{
                        "page":342,
                        "image": "QK_342.webp"
                    },
                    "end":{
                        "page":361,
                        "image": "QK_361.webp"
                    }
                },
                {
                    "id": 19,
                    "juz": 19,
                    "start":{
                        "page":362,
                        "image": "QK_362.webp"
                    },
                    "end":{
                        "page":381,
                        "image": "QK_381.webp"
                    }
                },
                {
                    "id": 20,
                    "juz": 20,
                    "start":{
                        "page":382,
                        "image:": "QK_382.webp"
                    },
                    "end":{
                        "page":401,
                        "image": "QK_401.webp"
                    }
                },
                {
                    "id": 21,
                    "juz": 21,
                    "start":{
                        "page":402,
                        "image": "QK_402.webp"
                    },
                    "end":{
                        "page":421,
                        "image": "QK_421.webp"
                    }
                },
                {
                    "id": 22,
                    "juz": 22,
                    "start":{
                        "page":422,
                        "image": "QK_422.webp"
                    },
                    "end":{
                        "page":441,
                        "image": "QK_441.webp"
                    }
                },
                {
                    "id": 23,
                    "juz": 23,
                    "start":{
                        "page":442,
                        "image": "QK_442.webp"
                    },
                    "end":{
                        "page":461,
                        "image": "QK_461.webp"
                    }
                },
                {
                    "id": 24,
                    "juz": 24,
                    "start":{
                        "page":462,
                        "image": "QK_462.webp"
                    },
                    "end":{
                        "page":481,
                        "image": "QK_481.webp"
                    }
                },
                {
                    "id": 25,
                    "juz": 25,
                    "start":{
                        "page":482,
                        "image": "QK_482.webp"
                    },
                    "end":{
                        "page":501,
                        "image": "QK_501.webp"
                    }
                },
                {
                    "id": 26,
                    "juz": 26,
                    "start":{
                        "page":502,
                        "image": "QK_502.webp"
                    },
                    "end":{
                        "page":521,
                        "image": "QK_521.webp"
                    }
                },
                {
                    "id": 27,
                    "juz": 27,
                    "start":{
                        "page":522,
                        "image": "QK_522.webp"
                    },
                    "end":{
                        "page":541,
                        "image": "QK_541.webp"
                    }
                },
                {
                    "id": 28,
                    "juz": 28,
                    "start":{
                        "page":542,
                        "image": "QK_542.webp"
                    },
                    "end":{
                        "page":561,
                        "image": "QK_561.webp"
                    }
                },
                {
                    "id": 29,
                    "juz": 29,
                    "start":{
                        "page":562,
                        "image": "QK_562.webp"
                    },
                    "end":{
                        "page":581,
                        "image": "QK_581.webp"
                    }
                },
                {
                    "id": 30,
                    "juz": 30,
                    "start":{
                        "page":582,
                        "image": "QK_582.webp"
                    },
                    "end":{
                        "page":604,
                        "image": "QK_604.webp"
                    }
                }
            ]
        }
    """
    private const val allSurahString = """
        {
          "data": [
            {
              "id": 1,
              "arabic": " الفاتحة",
              "latin": "Al-Fātiḥah ",
              "transliteration": "Al-Fatihah",
              "translation": "Pembuka",
              "num_ayah": 7,
              "page": 1,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 2,
              "arabic": " البقرة",
              "latin": "Al-Baqarah ",
              "transliteration": "Al-Baqarah",
              "translation": "Sapi",
              "num_ayah": 286,
              "page": 2,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 3,
              "arabic": " اٰل عمرٰن",
              "latin": "Āli ‘Imrān",
              "transliteration": "Ali ‘Imran",
              "translation": "Keluarga Imran",
              "num_ayah": 200,
              "page": 50,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 4,
              "arabic": "النّساۤء",
              "latin": "An-Nisā' ",
              "transliteration": "An-Nisa'",
              "translation": "Perempuan",
              "num_ayah": 176,
              "page": 77,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 5,
              "arabic": " الماۤئدة",
              "latin": "Al-Mā'idah",
              "transliteration": "Al-Ma'idah",
              "translation": "Hidangan",
              "num_ayah": 120,
              "page": 106,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 6,
              "arabic": " الانعام",
              "latin": "Al-An‘ām ",
              "transliteration": "Al-An‘am",
              "translation": "Binatang Ternak",
              "num_ayah": 165,
              "page": 128,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 7,
              "arabic": " الاعراف",
              "latin": "Al-A‘rāf",
              "transliteration": "Al-A‘raf",
              "translation": "Tempat Tertinggi",
              "num_ayah": 206,
              "page": 151,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 8,
              "arabic": " الانفال",
              "latin": "Al-Anfāl",
              "transliteration": "Al-Anfal",
              "translation": "Rampasan Perang",
              "num_ayah": 75,
              "page": 177,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 9,
              "arabic": "التّوبة",
              "latin": "At-Taubah",
              "transliteration": "At-Taubah",
              "translation": "Pengampunan",
              "num_ayah": 129,
              "page": 187,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 10,
              "arabic": " يونس",
              "latin": "Yūnus",
              "transliteration": "Yunus",
              "translation": "Yunus",
              "num_ayah": 109,
              "page": 208,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 11,
              "arabic": " هود",
              "latin": "Hūd",
              "transliteration": "Hud",
              "translation": "Hud",
              "num_ayah": 123,
              "page": 221,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 12,
              "arabic": " يوسف",
              "latin": "Yūsuf",
              "transliteration": "Yusuf",
              "translation": "Yusuf",
              "num_ayah": 111,
              "page": 235,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 13,
              "arabic": " الرّعد",
              "latin": "Ar-Ra‘d",
              "transliteration": "Ar-Ra‘d",
              "translation": "Guruh",
              "num_ayah": 43,
              "page": 249,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 14,
              "arabic": " ابرٰهيم",
              "latin": "Ibrāhīm",
              "transliteration": "Ibrahim",
              "translation": "Ibrahim",
              "num_ayah": 52,
              "page": 255,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 15,
              "arabic": " الحجر",
              "latin": "Al-Ḥijr",
              "transliteration": "Al-Hijr",
              "translation": "Hijr",
              "num_ayah": 99,
              "page": 262,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 16,
              "arabic": "النّحل",
              "latin": "An-Naḥl",
              "transliteration": "An-Nahl",
              "translation": "Lebah",
              "num_ayah": 128,
              "page": 267,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 17,
              "arabic": " الاسراۤء",
              "latin": "Al-Isrā'",
              "transliteration": "Al-Isra'",
              "translation": "Memperjalankan di Malam Hari",
              "num_ayah": 111,
              "page": 282,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 18,
              "arabic": " الكهف",
              "latin": "Al-Kahf",
              "transliteration": "Al-Kahf",
              "translation": "Gua",
              "num_ayah": 110,
              "page": 293,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 19,
              "arabic": " مريم",
              "latin": "Maryam",
              "transliteration": "Maryam",
              "translation": "Maryam",
              "num_ayah": 98,
              "page": 305,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 20,
              "arabic": " طٰهٰ",
              "latin": "Ṭāhā",
              "transliteration": "Taha",
              "translation": "Taha",
              "num_ayah": 135,
              "page": 312,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 21,
              "arabic": " الانبياۤء",
              "latin": "Al-Anbiyā' ",
              "transliteration": "Al-Anbiya'",
              "translation": "Para Nabi",
              "num_ayah": 112,
              "page": 322,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 22,
              "arabic": "الحجّ",
              "latin": "Al-Ḥajj",
              "transliteration": "Al-Hajj",
              "translation": "Haji",
              "num_ayah": 78,
              "page": 332,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 23,
              "arabic": " المؤمنون",
              "latin": "Al-Mu'minūn",
              "transliteration": "Al-Mu'minun",
              "translation": "Orang-Orang Mukmin",
              "num_ayah": 118,
              "page": 342,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 24,
              "arabic": " النّور",
              "latin": "An-Nūr",
              "transliteration": "An-Nur",
              "translation": "Cahaya",
              "num_ayah": 64,
              "page": 350,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 25,
              "arabic": " الفرقان",
              "latin": "Al-Furqān",
              "transliteration": "Al-Furqan",
              "translation": "Pembeda",
              "num_ayah": 77,
              "page": 359,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 26,
              "arabic": "الشّعراۤء",
              "latin": "Asy-Syu‘arā'",
              "transliteration": "Asy-Syu‘ara'",
              "translation": "Para Penyair",
              "num_ayah": 227,
              "page": 367,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 27,
              "arabic": "النّمل",
              "latin": "An-Naml",
              "transliteration": "An-Naml",
              "translation": "Semut",
              "num_ayah": 93,
              "page": 377,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 28,
              "arabic": " القصص",
              "latin": "Al-Qaṣaṣ",
              "transliteration": "Al-Qasas",
              "translation": "Kisah-Kisah",
              "num_ayah": 88,
              "page": 385,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 29,
              "arabic": " العنكبوت",
              "latin": "Al-‘Ankabūt",
              "transliteration": "Al-‘Ankabut",
              "translation": "Laba-Laba",
              "num_ayah": 69,
              "page": 396,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 30,
              "arabic": " الرّوم",
              "latin": "Ar-Rūm",
              "transliteration": "Ar-Rum",
              "translation": "Romawi",
              "num_ayah": 60,
              "page": 404,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 31,
              "arabic": " لقمٰن",
              "latin": "Luqmān ",
              "transliteration": "Luqman",
              "translation": "Luqman",
              "num_ayah": 34,
              "page": 411,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 32,
              "arabic": " السّجدة",
              "latin": "As-Sajdah",
              "transliteration": "As-Sajdah",
              "translation": "Sajdah",
              "num_ayah": 30,
              "page": 415,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 33,
              "arabic": " الاحزاب",
              "latin": "Al-Aḥzāb",
              "transliteration": "Al-Ahzab",
              "translation": "Golongan Yang Bersekutu",
              "num_ayah": 73,
              "page": 418,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 34,
              "arabic": " سبأ",
              "latin": "Saba' ",
              "transliteration": "Saba'",
              "translation": "Saba'",
              "num_ayah": 54,
              "page": 428,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 35,
              "arabic": " فاطر",
              "latin": "Fāṭir",
              "transliteration": "Fatir",
              "translation": "Pencipta",
              "num_ayah": 45,
              "page": 434,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 36,
              "arabic": " يٰسۤ",
              "latin": "Yāsīn",
              "transliteration": "Yasin",
              "translation": "Yasin",
              "num_ayah": 83,
              "page": 440,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 37,
              "arabic": " الصّٰۤفّٰت",
              "latin": "Aṣ-Ṣāffāt",
              "transliteration": "As-Saffat",
              "translation": "Barisan-Barisan",
              "num_ayah": 182,
              "page": 446,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 38,
              "arabic": "صۤ",
              "latin": "Ṣād ",
              "transliteration": "Sad",
              "translation": "Ṣād ",
              "num_ayah": 88,
              "page": 453,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 39,
              "arabic": "الزّمر",
              "latin": "Az-Zumar",
              "transliteration": "Az-Zumar",
              "translation": "Rombongan",
              "num_ayah": 75,
              "page": 458,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 40,
              "arabic": " غافر",
              "latin": "Gāfir ",
              "transliteration": "Gafir",
              "translation": "Maha Pengampun",
              "num_ayah": 85,
              "page": 467,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 41,
              "arabic": " فصّلت",
              "latin": "Fuṣṣilat",
              "transliteration": "Fussilat",
              "translation": "Dijelaskan",
              "num_ayah": 54,
              "page": 477,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 42,
              "arabic": "الشّورٰى",
              "latin": "Asy-Syūrā",
              "transliteration": "Asy-Syura",
              "translation": "Musyawarah",
              "num_ayah": 53,
              "page": 483,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 43,
              "arabic": "الزّخرف",
              "latin": "Az-Zukhruf",
              "transliteration": "Az-Zukhruf",
              "translation": "Perhiasan dari Emas",
              "num_ayah": 89,
              "page": 489,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 44,
              "arabic": "الدّخان",
              "latin": "Ad-Dukhān",
              "transliteration": "Ad-Dukhan",
              "translation": "Kabut Asap",
              "num_ayah": 59,
              "page": 496,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 45,
              "arabic": " الجاثية",
              "latin": "Al-Jāṡiyah",
              "transliteration": "Al-Jasiyah",
              "translation": "Berlutut",
              "num_ayah": 37,
              "page": 499,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 46,
              "arabic": " الاحقاف",
              "latin": "Al-Aḥqāf",
              "transliteration": "Al-Ahqaf",
              "translation": "Ahqaf",
              "num_ayah": 35,
              "page": 502,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 47,
              "arabic": " محمّد",
              "latin": "Muḥammad ",
              "transliteration": "Muhammad",
              "translation": "Nabi Muhammad",
              "num_ayah": 38,
              "page": 507,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 48,
              "arabic": " الفتح",
              "latin": "Al-Fatḥ",
              "transliteration": "Al-Fath",
              "translation": "Kemenangan",
              "num_ayah": 29,
              "page": 511,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 49,
              "arabic": " الحجرٰت",
              "latin": "Al-Ḥujurāt",
              "transliteration": "Al-Hujurat",
              "translation": "Kamar-Kamar",
              "num_ayah": 18,
              "page": 515,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 50,
              "arabic": "قۤ",
              "latin": "Qāf",
              "transliteration": "Qaf",
              "translation": "Qaf",
              "num_ayah": 45,
              "page": 518,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 51,
              "arabic": " الذّٰريٰت",
              "latin": "Aż-Żāriyāt",
              "transliteration": "Az-Zariyat",
              "translation": "Yang Menerbangkan",
              "num_ayah": 60,
              "page": 520,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 52,
              "arabic": "الطّور",
              "latin": "Aṭ-Ṭūr",
              "transliteration": "At-Tur",
              "translation": "Gunung",
              "num_ayah": 49,
              "page": 523,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 53,
              "arabic": "النّجم",
              "latin": "An-Najm",
              "transliteration": "An-Najm",
              "translation": "Bintang",
              "num_ayah": 62,
              "page": 526,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 54,
              "arabic": " القمر",
              "latin": "Al-Qamar",
              "transliteration": "Al-Qamar",
              "translation": "Bulan",
              "num_ayah": 55,
              "page": 528,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 55,
              "arabic": "الرّحمٰن",
              "latin": "Ar-Raḥmān",
              "transliteration": "Ar-Rahman",
              "translation": "Yang Maha Pengasih",
              "num_ayah": 78,
              "page": 531,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 56,
              "arabic": " الواقعة",
              "latin": "Al-Wāqi‘ah",
              "transliteration": "Al-Waqi‘ah",
              "translation": "Hari Kiamat Yang Pasti Terjadi",
              "num_ayah": 96,
              "page": 534,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 57,
              "arabic": " الحديد",
              "latin": "Al-Ḥadīd",
              "transliteration": "Al-Hadid",
              "translation": "Besi",
              "num_ayah": 29,
              "page": 537,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 58,
              "arabic": " المجادلة",
              "latin": "Al-Mujādalah",
              "transliteration": "Al-Mujadalah",
              "translation": "Gugatan",
              "num_ayah": 22,
              "page": 542,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 59,
              "arabic": " الحشر",
              "latin": "Al-Ḥasyr",
              "transliteration": "Al-Hasyr",
              "translation": "Pengusiran",
              "num_ayah": 24,
              "page": 545,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 60,
              "arabic": " الممتحنة",
              "latin": "Al-Mumtaḥanah",
              "transliteration": "Al-Mumtahanah",
              "translation": "Wanita Yang Diuji",
              "num_ayah": 13,
              "page": 549,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 61,
              "arabic": " الصّفّ",
              "latin": "Aṣ-Ṣaff",
              "transliteration": "As-Saff",
              "translation": "Barisan",
              "num_ayah": 14,
              "page": 551,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 62,
              "arabic": " الجمعة",
              "latin": "Al-Jumu‘ah",
              "transliteration": "Al-Jumu‘ah",
              "translation": "Jumat",
              "num_ayah": 11,
              "page": 553,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 63,
              "arabic": " المنٰفقون",
              "latin": "Al-Munāfiqūn",
              "transliteration": "Al-Munafiqun",
              "translation": "Orang-Orang Munafik",
              "num_ayah": 11,
              "page": 554,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 64,
              "arabic": "التّغابن",
              "latin": "At-Tagābun",
              "transliteration": "At-Tagabun",
              "translation": "Pengungkapan Kesalahan",
              "num_ayah": 18,
              "page": 556,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 65,
              "arabic": "الطّلاق",
              "latin": "Aṭ-Ṭalāq",
              "transliteration": "At-Talaq",
              "translation": "Talak",
              "num_ayah": 12,
              "page": 558,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 66,
              "arabic": "التّحريم",
              "latin": "At-taḥrīm",
              "transliteration": "At-tahrim",
              "translation": "Pengharaman",
              "num_ayah": 12,
              "page": 560,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 67,
              "arabic": "المُلك",
              "latin": "Al-Mulk",
              "transliteration": "Al-Mulk",
              "translation": "Kerajaan",
              "num_ayah": 30,
              "page": 562,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 68,
              "arabic": " القلم",
              "latin": "Al-Qalam",
              "transliteration": "Al-Qalam",
              "translation": "Pena",
              "num_ayah": 52,
              "page": 564,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 69,
              "arabic": " الحاۤقّة",
              "latin": "Al-Ḥāqqah",
              "transliteration": "Al-Haqqah",
              "translation": "Hari Kiamat Yang Pasti Terjadi",
              "num_ayah": 52,
              "page": 566,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 70,
              "arabic": " المعارج",
              "latin": "Al-Ma‘ārij",
              "transliteration": "Al-Ma‘arij",
              "translation": "Tempat-Tempat Naik",
              "num_ayah": 44,
              "page": 568,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 71,
              "arabic": " نوح",
              "latin": "Nūḥ",
              "transliteration": "Nuh",
              "translation": "Nuh",
              "num_ayah": 28,
              "page": 570,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 72,
              "arabic": "الجنّ",
              "latin": "Al-Jinn",
              "transliteration": "Al-Jinn",
              "translation": "Jin",
              "num_ayah": 28,
              "page": 572,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 73,
              "arabic": " المزّمّل",
              "latin": "Al-Muzzammil",
              "transliteration": "Al-Muzzammil",
              "translation": "Orang Berkelumun",
              "num_ayah": 20,
              "page": 574,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 74,
              "arabic": " المدّثّر",
              "latin": "Al-Muddaṡṡir",
              "transliteration": "Al-Muddassir",
              "translation": "Orang Berselimut",
              "num_ayah": 56,
              "page": 575,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 75,
              "arabic": " القيٰمة",
              "latin": "Al-Qiyāmah",
              "transliteration": "Al-Qiyamah",
              "translation": "Hari Kiamat",
              "num_ayah": 40,
              "page": 577,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 76,
              "arabic": " الانسان",
              "latin": "Al-Insān",
              "transliteration": "Al-Insan",
              "translation": "Manusia",
              "num_ayah": 31,
              "page": 578,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 77,
              "arabic": " المرسلٰت",
              "latin": "Al-Mursalāt",
              "transliteration": "Al-Mursalat",
              "translation": "Malaikat Yang Diutus",
              "num_ayah": 50,
              "page": 580,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 78,
              "arabic": "النّبأ",
              "latin": "An-Naba'",
              "transliteration": "An-Naba'",
              "translation": "Berita",
              "num_ayah": 40,
              "page": 582,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 79,
              "arabic": " النّٰزعٰت",
              "latin": "An-Nāzi‘āt",
              "transliteration": "An-Nazi‘at",
              "translation": "Yang Mencabut Dengan Keras",
              "num_ayah": 46,
              "page": 583,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 80,
              "arabic": " عبس",
              "latin": "‘Abasa",
              "transliteration": "‘Abasa",
              "translation": "Berwajah Masam",
              "num_ayah": 42,
              "page": 585,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 81,
              "arabic": "التّكوير",
              "latin": "At-Takwīr",
              "transliteration": "At-Takwir",
              "translation": "Penggulungan",
              "num_ayah": 29,
              "page": 586,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 82,
              "arabic": " الانفطار",
              "latin": "Al-Infiṭār",
              "transliteration": "Al-Infitar",
              "translation": "Terbelah",
              "num_ayah": 19,
              "page": 587,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 83,
              "arabic": " المطفّفين",
              "latin": "Al-Muṭaffifīn",
              "transliteration": "Al-Mutaffifin",
              "translation": "Orang-Orang Yang Curang",
              "num_ayah": 36,
              "page": 587,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 84,
              "arabic": " الانشقاق",
              "latin": "Al-Insyiqāq",
              "transliteration": "Al-Insyiqaq",
              "translation": "Terbelah",
              "num_ayah": 25,
              "page": 589,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 85,
              "arabic": " البروج",
              "latin": "Al-Burūj",
              "transliteration": "Al-Buruj",
              "translation": "Gugusan Bintang",
              "num_ayah": 22,
              "page": 590,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 86,
              "arabic": "الطّارق",
              "latin": "Aṭ-Ṭāriq",
              "transliteration": "At-Tariq",
              "translation": "Yang Datang Pada Malam Hari",
              "num_ayah": 17,
              "page": 591,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 87,
              "arabic": " الاعلى",
              "latin": "Al-A‘lā",
              "transliteration": "Al-A‘la",
              "translation": "Yang Maha Tinggi",
              "num_ayah": 19,
              "page": 591,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 88,
              "arabic": " الغاشية",
              "latin": "Al-Gāsyiyah",
              "transliteration": "Al-Gasyiyah",
              "translation": "Hari Kiamat Yang Menghilangkan Kesadaran",
              "num_ayah": 26,
              "page": 592,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 89,
              "arabic": " الفجر",
              "latin": "Al-Fajr",
              "transliteration": "Al-Fajr",
              "translation": "Fajar",
              "num_ayah": 30,
              "page": 593,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 90,
              "arabic": " البلد",
              "latin": "Al-Balad",
              "transliteration": "Al-Balad",
              "translation": "Negeri",
              "num_ayah": 20,
              "page": 594,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 91,
              "arabic": "الشّمس",
              "latin": "Asy-Syams",
              "transliteration": "Asy-Syams",
              "translation": "Matahari",
              "num_ayah": 15,
              "page": 595,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 92,
              "arabic": " الّيل",
              "latin": "Al-Lail",
              "transliteration": "Al-Lail",
              "translation": "Malam",
              "num_ayah": 21,
              "page": 595,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 93,
              "arabic": "الضّحى",
              "latin": "Aḍ-Ḍuḥā",
              "transliteration": "Ad-Duha",
              "translation": "Duha",
              "num_ayah": 11,
              "page": 596,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 94,
              "arabic": "الشّرح",
              "latin": "Asy-Syarḥ",
              "transliteration": "Asy-Syarh",
              "translation": "Pelapangan",
              "num_ayah": 8,
              "page": 596,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 95,
              "arabic": "التّين",
              "latin": "At-Tīn",
              "transliteration": "At-Tin",
              "translation": "Buah Tin",
              "num_ayah": 8,
              "page": 597,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 96,
              "arabic": " العلق",
              "latin": "Al-‘Alaq",
              "transliteration": "Al-‘Alaq",
              "translation": "Segumpal Darah",
              "num_ayah": 19,
              "page": 597,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 97,
              "arabic": " القدر",
              "latin": "Al-Qadr",
              "transliteration": "Al-Qadr",
              "translation": "Al-Qadar",
              "num_ayah": 5,
              "page": 598,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 98,
              "arabic": " البيّنة",
              "latin": "Al-Bayyinah",
              "transliteration": "Al-Bayyinah",
              "translation": "Bukti Nyata",
              "num_ayah": 8,
              "page": 598,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 99,
              "arabic": "الزّلزلة",
              "latin": "Az-Zalzalah",
              "transliteration": "Az-Zalzalah",
              "translation": "Guncangan",
              "num_ayah": 8,
              "page": 599,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 100,
              "arabic": " العٰديٰت",
              "latin": "Al-‘Ādiyāt",
              "transliteration": "Al-‘Adiyat",
              "translation": "Kuda Perang Yang Berlari Kencang",
              "num_ayah": 11,
              "page": 599,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 101,
              "arabic": " القارعة",
              "latin": "Al-Qāri‘ah",
              "transliteration": "Al-Qari‘ah",
              "translation": "Al-Qāri‘ah",
              "num_ayah": 11,
              "page": 600,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 102,
              "arabic": "التّكاثر",
              "latin": "At-Takāṡur",
              "transliteration": "At-Takasur",
              "translation": "Berbangga-Bangga Dalam Memperbanyak Dunia",
              "num_ayah": 8,
              "page": 600,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 103,
              "arabic": " العصر",
              "latin": "Al-‘Aṣr",
              "transliteration": "Al-‘Asr",
              "translation": "Masa",
              "num_ayah": 3,
              "page": 601,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 104,
              "arabic": " الهمزة",
              "latin": "Al-Humazah",
              "transliteration": "Al-Humazah",
              "translation": "Pengumpat",
              "num_ayah": 9,
              "page": 601,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 105,
              "arabic": " الفيل",
              "latin": "Al-Fīl",
              "transliteration": "Al-Fil",
              "translation": "Gajah",
              "num_ayah": 5,
              "page": 601,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 106,
              "arabic": " قريش",
              "latin": "Quraisy",
              "transliteration": "Quraisy",
              "translation": "Orang Quraisy",
              "num_ayah": 4,
              "page": 602,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 107,
              "arabic": " الماعون",
              "latin": "Al-Mā‘ūn",
              "transliteration": "Al-Ma‘un",
              "translation": "Bantuan",
              "num_ayah": 7,
              "page": 602,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 108,
              "arabic": " الكوثر",
              "latin": "Al-Kauṡar",
              "transliteration": "Al-Kausar",
              "translation": "Nikmat Yang Banyak",
              "num_ayah": 3,
              "page": 602,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 109,
              "arabic": " الكٰفرون",
              "latin": "Al-Kāfirūn",
              "transliteration": "Al-Kafirun",
              "translation": "Orang-Orang kafir",
              "num_ayah": 6,
              "page": 603,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 110,
              "arabic": "النّصر",
              "latin": "An-Naṣr",
              "transliteration": "An-Nasr",
              "translation": "Pertolongan",
              "num_ayah": 3,
              "page": 603,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 111,
              "arabic": "اللّهب",
              "latin": "Al-Lahab",
              "transliteration": "Al-Lahab",
              "translation": "Gejolak Api",
              "num_ayah": 5,
              "page": 603,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 112,
              "arabic": " الاخلاص",
              "latin": "Al-Ikhlāṣ",
              "transliteration": "Al-Ikhlas",
              "translation": "Ikhlas",
              "num_ayah": 4,
              "page": 604,
              "location": "Makkiyah",
              "updated_at": null
            },
            {
              "id": 113,
              "arabic": " الفلق",
              "latin": "Al-Falaq",
              "transliteration": "Al-Falaq",
              "translation": "Fajar",
              "num_ayah": 5,
              "page": 604,
              "location": "Madaniyah",
              "updated_at": null
            },
            {
              "id": 114,
              "arabic": "النّاس",
              "latin": "An-Nās",
              "transliteration": "An-Nas",
              "translation": "Manusia",
              "num_ayah": 6,
              "page": 604,
              "location": "Madaniyah",
              "updated_at": null
            }
          ]
        }
    """
}