package com.rahulmondal.weatherapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rahulmondal.weatherapp.MyApplication
import com.rahulmondal.weatherapp.R
import com.rahulmondal.weatherapp.data.model.CurrentWeatherResponse
import com.rahulmondal.weatherapp.databinding.ActivityHomePageBinding
import com.rahulmondal.weatherapp.di.component.DaggerActivityComponent
import com.rahulmondal.weatherapp.di.module.ActivityModule
import com.rahulmondal.weatherapp.ui.base.UiState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePageActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModel: CurrentWeatherViewModel
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        injectDependencies()
        setupObserve()

    }

    private fun setupUiState(weatherResponse: CurrentWeatherResponse){

        binding.apply {
            cityTextView.text=weatherResponse.location.name
            temTextView.text=weatherResponse.current.temp.toString()
            humidityNumberTextView.text=weatherResponse.current.humidity.toString()
            windSpeedNumberTextView.text=weatherResponse.current.windSpeed.toString()
            cloudPercentNumberTextView.text=weatherResponse.current.cloudPercent.toString()
        }
    }

    private fun setupObserve(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
        viewModel.uiState.collect {

            when(it){
                is UiState.Loading->{
                    binding.progressBarview.visibility= View.VISIBLE
                }
                is UiState.Success->{
                    binding.progressBarview.visibility= View.GONE
                    setupUiState(it.data)
                }
                is UiState.Error->{
                    Toast.makeText(this@HomePageActivity,it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
         }
          }
    }
    private fun injectDependencies(){

        DaggerActivityComponent.builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}