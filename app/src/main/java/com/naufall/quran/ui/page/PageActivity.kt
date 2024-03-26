package com.naufall.quran.ui.page

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.naufall.quran.R
import com.naufall.quran.Utils
import com.naufall.quran.databinding.ActivityPageBinding
import com.naufall.quran.utils.OnSwipeTouchListener

class PageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPageBinding
    private var currentPage = 1
    private var isFullScreen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentPage = intent.getIntExtra("page", 1)
        // https://raw.githubusercontent.com/ibnunaufal/quran-image-kemenag/main/img/QK_001.webp
        // QK_001.webp
//        currentPage = if (currentPage.length == 1) "00$currentPage" else if (currentPage.length == 2) "0$currentPage" else currentPage

        // detect swipe right or left
        binding.ivPage.setOnTouchListener(object : OnSwipeTouchListener(this) {

            override fun onSwipeRight() {
                super.onSwipeRight()
                // swipe right
                // open previous page
                if (currentPage < 604) {
                    currentPage++
                    loadImage()
                }
            }

            override fun onSwipeLeft() {
                super.onSwipeLeft()
                // swipe left
                // open next page
                if (currentPage > 1) {
                    currentPage--
                    loadImage()
                }
            }
        })

        loadImage()

        binding.ivPage.setOnClickListener {
            toggleFullScreen()
        }

    }

    private fun toggleFullScreen(){
        Log.d("PageActivity", "toggleFullScreen")
        isFullScreen = !isFullScreen
        if (isFullScreen){
            enableEdgeToEdge()
        } else {
            ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
                )
                insets
            }
        }
    }
    private fun loadImage(){
        val pageString = if (currentPage < 10) "00$currentPage" else if (currentPage < 100) "0$currentPage" else currentPage.toString()
        val imageUrl = "https://raw.githubusercontent.com/ibnunaufal/quran-image-kemenag/main/img/QK_$pageString.webp"
        // show image using glide
        Glide.with(this)
            .load(imageUrl)
            .into(binding.ivPage)

        // if device is in dark mode, invert the color
        if (resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            binding.ivPage.setColorFilter(resources.getColor(R.color.white))
        } else {
            // remove color filter
            binding.ivPage.clearColorFilter()
        }

    }
}