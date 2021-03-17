package com.example.demopillar.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.demopillar.R
import com.example.demopillar.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var titleMain: TextView
    lateinit var container :FrameLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        toolbar =  findViewById(R.id.toolbar)
        titleMain = findViewById(R.id.titleMain)
        container = findViewById(R.id.container)
        openFragment()
    }

    private fun openFragment(){
        var mainFragment = MainFragment()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container,mainFragment)
                .commit()
    }
}