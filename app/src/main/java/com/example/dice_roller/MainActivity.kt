package com.example.dice_roller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var rollBtn : Button
    lateinit var adv : CheckBox
    private lateinit var dis : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollBtn = findViewById(R.id.rollbtn)
        rollBtn.setOnClickListener(listener)
        //dis.setOnCheckedChangeListener(checkChange)
    }

    private val listener= View.OnClickListener { view ->
        when (view.id) {
            R.id.rollbtn -> {
                val roll = Random.nextInt(0,20) + 1
                val rollView = findViewById<TextView>(R.id.mainRoll)
                val discard = findViewById<TextView>(R.id.second)
                adv = findViewById(R.id.advantage)
                dis = findViewById(R.id.disadvantage)
                if (adv.isChecked || dis.isChecked) {
                    val roll2 = Random.nextInt(0,20) + 1

                    if(adv.isChecked){
                        rollView.text = maxOf(roll, roll2).toString()
                        discard.text = minOf(roll,roll2).toString()
                    }else{
                        rollView.text = minOf(roll, roll2).toString()
                        discard.text = maxOf(roll,roll2).toString()
                    }
                }else {
                    discard.text = ""
                    rollView.text = roll.toString();
                }
            }
        }
    }
}
