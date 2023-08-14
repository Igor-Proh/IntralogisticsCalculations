package com.prokhnov.intralogisticscalculations

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.prokhnov.intralogisticscalculations.databinding.ActivityDriveDrumCylinderBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class DriveDrumCylinderActivity : AppCompatActivity() {

    private lateinit var bindingClass: ActivityDriveDrumCylinderBinding

    private var b = 0.0           // drum width
    private var de = 0.0          // drum diameter
    private var e = 0.0           // cone width
    private var eMin = 0.0        // cone width min
    private var eMax = 0.0        // cone width man
    private var bc = 0.0          // drum cylindrical section width
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityDriveDrumCylinderBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    private fun calcDriveDrumCylinder(dd: Double, dl: Double) {
        b = dl
        e = (dd + 100) / 500
        bc = b / 2
        eMin = 2*(0.001*dd+0.075)
        eMax = 3*(0.001*dd+0.075)

    }

    fun onClickCalculateDriveDrumCylinder(view: View){
        val dd = bindingClass.etDriveDrumDiameter.text.toString()
        val dl = bindingClass.etDriveDrumLength.text.toString()

        if (dd.isBlank()) {
            bindingClass.textView6.setTextColor(Color.RED)
        } else {
            bindingClass.textView6.setTextColor(Color.BLACK)
        }

        if (dl.isBlank()) {
            bindingClass.textView2.setTextColor(Color.RED)
        } else {
            bindingClass.textView2.setTextColor(Color.BLACK)
        }

        if (dd.isNotBlank() && dl.isNotBlank()) {
            calcDriveDrumCylinder(dd.toDouble(), dl.toDouble())
            bindingClass.tvCylindricalSection.text = bc.toString()
            bindingClass.tvTaperSize.text = e.toString()

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN



            bindingClass.tvTaperSizeMin.text = df.format(eMin).toString()
            bindingClass.tvTaperSizeMax.text = df.format(eMax).toString()
        }
    }

    fun onClickBackDriveDrumCylinder(view: View) {
        finish()
    }

}