package com.naufall.quran

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.naufall.quran.ui.page.PageActivity

object Utils {

    fun openPage(context: Context, page: Int){
        // open page
        Toast.makeText(context, "Open page $page", Toast.LENGTH_SHORT).show()
        val i = Intent(context, PageActivity::class.java)
        i.putExtra("page", page)
        context.startActivity(i)
    }
}