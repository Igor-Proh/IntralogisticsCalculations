package com.prokhnov.intralogisticscalculations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.prokhnov.intralogisticscalculations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickBeltConveyorCalculation(view: View) {
        val intent = Intent(this, BeltConveyorCalculationActivity::class.java)
        startActivity(intent)
    }

    fun onClickGearboxSpeedOnOutputShaft(view: View) {
        val intent = Intent(this, GearboxSpeedActivity::class.java)
        startActivity(intent)
    }
}