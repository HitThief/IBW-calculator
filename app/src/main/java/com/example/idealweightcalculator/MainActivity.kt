package com.example.idealweightcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTV: TextView = findViewById(R.id.txtResult)
        var flag: String = "Male"
        val button: Button = findViewById(R.id.btResult)
        val txtHeight: EditText = findViewById(R.id.edHeight)
        val sp: Spinner = findViewById(R.id.genderSpinner)
        val genders = arrayOf("Male", "Female")
        sp.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, genders)

        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = genders.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        button.setOnClickListener { view ->
            var height: Double = txtHeight.text.toString().toDouble()
            if(height<30 || height>300)
                resultTV.text = "invalid height, min 30cm max 300cm".toString()
            else
                resultTV.text = "Ideal Body Weight is " + calcIdealBodyWeight(height, flag).toString()
        }
    }
}



public fun calcIdealBodyWeight(a: Double, b: String): Int{

    if(a>152.4)
        if(b == "Male")
            return (50+(0.91*(a-152.4))).roundToInt()
        else
            return (45.5+(0.91*(a-152.4))).roundToInt()
    else
        if(b == "Male")
            return 50
        else
            return 46
}

