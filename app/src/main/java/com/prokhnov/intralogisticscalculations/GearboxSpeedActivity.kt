package com.prokhnov.intralogisticscalculations

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.prokhnov.intralogisticscalculations.databinding.ActivityGearboxSpeedBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class GearboxSpeedActivity : AppCompatActivity() {

    private var shaftDiameter = 0.0
    private var speedOfConveyorMeterPerSecond = 0.0


    private lateinit var bindingClass: ActivityGearboxSpeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityGearboxSpeedBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickBack(view: View) {
        finish()
    }

    fun onClickCalculateGearbox(view: View) {
        calculateGearboxSpeed()
    }

    private fun calculateGearboxSpeed() {


        val diameter = bindingClass.etDriveShaftDiameter.text.toString()
        val speed = bindingClass.etSpeedOfConveyor.text.toString()

        if (diameter.isBlank()) {
            bindingClass.tvDriveShaftDiameter.setTextColor(Color.RED)
        } else {
            bindingClass.tvDriveShaftDiameter.setTextColor(Color.BLACK)
        }

        if (speed.isBlank()) {
            bindingClass.tvSpeedOfConveyor.setTextColor(Color.RED)
        } else {
            bindingClass.tvSpeedOfConveyor.setTextColor(Color.BLACK)
        }

        if (diameter.isNotBlank() && speed.isNotBlank()) {
            bindingClass.tvDriveShaftDiameter.setTextColor(Color.BLACK)
            bindingClass.tvSpeedOfConveyor.setTextColor(Color.BLACK)

            shaftDiameter = diameter.toDouble()
            speedOfConveyorMeterPerSecond = speed.toDouble()

            val speedOfConveyorMeterPerMinute = speedOfConveyorMeterPerSecond * 60

            bindingClass.tvSpeedOfConveyorMMin.text =
                speedOfConveyorMeterPerMinute.toInt().toString()
            val drumCircumferenceLength = Math.PI * shaftDiameter

            val outputSpeed = (speedOfConveyorMeterPerMinute / drumCircumferenceLength) * 1000
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING

            bindingClass.tvOutputShaftSpeed.text = df.format(outputSpeed)

        }

    }
}