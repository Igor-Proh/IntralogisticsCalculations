package com.prokhnov.intralogisticscalculations

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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

    fun onClickDriveDrumCylinder(view: View) {
        val intent = Intent(this, DriveDrumCylinderActivity::class.java)
        startActivity(intent)
    }


}