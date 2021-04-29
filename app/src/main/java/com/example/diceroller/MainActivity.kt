package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        // Listen for the click before executing the code
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
            Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT).show()
        }
        rollDice()
        rollDice2()




    }

    private fun rollDice2() {
        // Create a second Dice with 6 sides and roll it
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val drawableResource2 = when (diceRoll2) {
          1 -> R.drawable.dice_1
          2 -> R.drawable.dice_2
          3 -> R.drawable.dice_3
          4 -> R.drawable.dice_4
          5 -> R.drawable.dice_5
          else -> R.drawable.dice_6
        }
        // Update ImageView with the correct drawable resource ID
        diceImage2.setImageResource(drawableResource2)
        // Update the content description
        diceImage2.contentDescription = diceRoll2.toString()
    }

    /**
     *  Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Dice Image is shown corresponding to the dice roll number
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content Description
        diceImage.contentDescription = diceRoll.toString()
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