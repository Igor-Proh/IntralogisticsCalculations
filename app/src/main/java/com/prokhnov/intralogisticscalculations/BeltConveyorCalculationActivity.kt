package com.prokhnov.intralogisticscalculations

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.prokhnov.intralogisticscalculations.databinding.ActivityBeltConveyorCalculationBinding
import com.prokhnov.intralogisticscalculations.databinding.ActivityMainBinding

class BeltConveyorCalculationActivity : AppCompatActivity() {

    var conveyorLength = 0.0;
    var geometricBeltLength = 0.0;
    var beltWidth = 0;
    var loadPerMeterOfConveyor = 0.0;
    var totalLoadOnTheConveyor = 0.0;
    var angleOfDriveDrumEnvelope = 0;
    var freeFallAcceleration = 9.81;
    var weightOfASupportRoller = 0.0;
    var beltSpeed = 0.0;
    var weightOfRollers = 0.0;
    var conveyorInclinationAngle = 0.0;

    /*
        <string name="calc_friction_coeff_table">Friction Coefficient on Table Support (µT)</string>
        <string name="calc_friction_coeff_roller">Friction Coefficient on Roller</string>
        <string name="calc_total_belt_weight">Total Belt Weight</string>
        <string name="calc_belt_area_weight">Weight of 1m² of Belt (per belt specifications)</string>
        <string name="calc_belt_width_2">Belt Width</string>
        <string name="calc_factor_c1">Factor C1 (as per hint)</string>
        <string name="calc_factor_c2">Factor C2 (calculated value)</string>
        <string name="calc_factor_c3">Factor C3 (as per right table)</string>
        <string name="calc_tabulated_value_sliver">Tabulated Value (as per Sliver Specifications)</string>
        <string name="calc_tabulated_value_right">Tabulated Value (as per right table)</string>
        <string name="calc_gearmotor_efficiency">Gearmotor Efficiency</string>
    */

    private lateinit var bindingClass: ActivityBeltConveyorCalculationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityBeltConveyorCalculationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


    }

    fun onClickCalculate(view: View) {
        calcGeometricBeltLength()
    }

    private fun calcGeometricBeltLength() {

        if (bindingClass.etConveyorLength.text.toString().isBlank()) {
            bindingClass.tvConveyorLength.setTextColor(Color.RED)
        }

        if (bindingClass.etConveyorLength.text.toString().isNotBlank()) {
            conveyorLength = bindingClass.etConveyorLength.text.toString().toDouble()
            bindingClass.tvGeometricBeltLength.text = "${conveyorLength * 2}"
            bindingClass.tvConveyorLength.setTextColor(Color.BLACK)
        }


    }

    fun onClickBack(view: View) {
        finish()
    }
}