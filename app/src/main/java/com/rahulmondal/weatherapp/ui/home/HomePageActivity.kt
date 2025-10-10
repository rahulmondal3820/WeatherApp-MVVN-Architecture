package com.rahulmondal.weatherapp.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rahulmondal.weatherapp.MyApplication
import com.rahulmondal.weatherapp.R
import com.rahulmondal.weatherapp.di.component.DaggerActivityComponent
import com.rahulmondal.weatherapp.di.module.ActivityModule
import javax.inject.Inject

class HomePageActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: CurrentWeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        injectDependencies()

    }
    private fun injectDependencies(){

        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}