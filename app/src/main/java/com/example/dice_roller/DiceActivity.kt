package com.example.dice_roller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random
import kotlin.reflect.typeOf


class DiceActivity : AppCompatActivity() {
    private lateinit var rollBtn: Button
    private var diceTypes = listOf(4, 6, 8, 10, 12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        rollBtn = findViewById(R.id.rollbtn2)
        rollBtn.setOnClickListener(listener)
    }

    @SuppressLint("SetTextI18n")
    private val listener = View.OnClickListener { view ->
        when (view.id) {
            R.id.rollbtn2 -> {
                var rollsView = findViewById<TextView>(R.id.rollsView)
                rollsView.text = ""
                var sum = 0
                var rolledDice = mutableListOf<String>()
                var rolledAmount = listOf(
                    findViewById<TextView>(R.id.d4).text.toString(),
                    findViewById<TextView>(R.id.d6).text.toString(),
                    findViewById<TextView>(R.id.d8).text.toString(),
                    findViewById<TextView>(R.id.d10).text.toString(),
                    findViewById<TextView>(R.id.d12).text.toString()
                )

                for (i in 0..4) {
                    if (rolledAmount[i] != "") {
                        rolledDice.add(diceTypes[i].toString() + "-" + rolledAmount[i])
                    }
                }
                if(rolledDice.size == 0){
                    Toast.makeText(applicationContext,"You must roll a number of dice",Toast.LENGTH_SHORT).show()
                }else {
                    var rolls = mutableListOf<String>()
                    var sumView = findViewById<TextView>(R.id.sumView)

                    for (item in rolledDice){
                        var split = item.split('-')
                        repeat(Integer.parseInt(split[1])){
                            val roll = Random.nextInt(0,Integer.parseInt(split[0])) + 1
                            sum += roll
                            rolls.add(roll.toString())

                        }
                    }
                    sumView.text = sum.toString()
                    var runs = 0
                    repeat(rolls.size){

                        if(runs == rolls.size - 1){
                            rollsView.text = rollsView.text.toString() + rolls[runs]
                        }else{
                            rollsView.text = rollsView.text.toString() + rolls[runs] + " + "
                        }
                        runs++
                    }
                }
            }
        }
    }
}

/*var rolls = mutableListOf<String>()
                        var sumView= findViewById<TextView>(R.id.sum)

                        for (item in rolledDice) {
                            sumView.text = sumView.text.toString() + item
                        /*
                            var split = item.split('-')
                            var restRolls = Integer.parseInt(split[1])
                            while (restRolls > 0 ){
                                val roll = Random.nextInt(0,Integer.parseInt(split[0])) + 1
                                sum += roll
                                rolls.add(roll.toString())
                            }

                             */
                        }


                        var sumView= findViewById<TextView>(R.id.sum)
                        sumView.text += item

                         */