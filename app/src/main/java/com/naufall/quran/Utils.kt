package com.naufall.quran

import android.content.Context
import android.widget.Toast

object Utils {

    fun openPage(context: Context, page: Int){
        // open page
        Toast.makeText(context, "Open page $page", Toast.LENGTH_SHORT).show()
    }
}