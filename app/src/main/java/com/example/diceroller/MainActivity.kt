package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        }
        rollButton.text = "Roll"



    }

    private fun rollDice2() {
        val dice2 = Dice(6)
        val diceRoll = dice2.roll()

        // Update the screen with the dice roll
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll.toString()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

/**
 * Blueprint of Dice
 */
class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}