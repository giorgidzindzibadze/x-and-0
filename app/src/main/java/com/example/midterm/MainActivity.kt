package com.example.midterm

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var rename1: TextView
    private lateinit var rename2: TextView
    private var fungame=0
    private var scorefirst=0
    private var scoresecond=0

    private lateinit var scorepirveli : TextView
    private lateinit var scoremeore : TextView

    private var activPlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        scorepirveli=findViewById(R.id.score1)
        scoremeore=findViewById(R.id.score2)

        resetButton.setOnClickListener {
            reset()
        }


    }

    private fun init() {


        val name1=intent.extras?.getString("firsPlayer")
        val name2=intent.extras?.getString("secondPlayer")


        rename1=findViewById(R.id.playerFirst)
        rename2=findViewById(R.id.playerSecond)

        rename1.text=name1
        rename2.text=name2






        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        button1.setOnClickListener(this)
        button1.setOnClickListener(this)
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            var buttonNumber = 0
            when (clickedView.id) {
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0) {
                playgame(clickedView, buttonNumber)
            }
        }
    }

    private fun playgame(clickedView: Button, buttonNumber: Int) {
        if (activPlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GRAY)
            activPlayer = 2
            firstPlayer.add(buttonNumber)

        } else if (activPlayer == 2) {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.GREEN)
            activPlayer = 1
            secondPlayer.add(buttonNumber)

        }
        clickedView.isEnabled = false
        if(fungame==0){
            check()
        }
        if(fungame==1){
            activPlayer=3
        }
    }

    private fun check() {
        var winnerplayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerplayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerplayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerplayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerplayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerplayer = 2
        }


        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerplayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerplayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)) {
            winnerplayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)) {
            winnerplayer = 2
        }
        if(winnerplayer==1){
            fungame=1
            scorefirst+=1
            scorepirveli.text=scorefirst.toString()
            Toast.makeText(this, "გამარჯვებულია X", Toast.LENGTH_SHORT).show()
        }
        if (winnerplayer==2){
            fungame=1
            scoresecond+=1
            scoremeore.text=scoresecond.toString()
            Toast.makeText(this, "გამარჯვებულია 0", Toast.LENGTH_SHORT).show()
        }
        if(firstPlayer.size + secondPlayer.size ==9 && winnerplayer==0){
            Toast.makeText(this, "ფრე", Toast.LENGTH_SHORT).show()
        }

    }

    private fun reset() {
        button1.text=""
        button2.text=""
        button3.text=""
        button4.text=""
        button5.text=""
        button6.text=""
        button7.text=""
        button8.text=""
        button9.text=""

        button1.setBackgroundColor(Color.WHITE)
        button2.setBackgroundColor(Color.WHITE)
        button3.setBackgroundColor(Color.WHITE)
        button4.setBackgroundColor(Color.WHITE)
        button5.setBackgroundColor(Color.WHITE)
        button6.setBackgroundColor(Color.WHITE)
        button7.setBackgroundColor(Color.WHITE)
        button8.setBackgroundColor(Color.WHITE)
        button9.setBackgroundColor(Color.WHITE)

        activPlayer=1

        fungame=0

        button1.isEnabled=true
        button2.isEnabled=true
        button3.isEnabled=true
        button4.isEnabled=true
        button5.isEnabled=true
        button6.isEnabled=true
        button7.isEnabled=true
        button8.isEnabled=true
        button9.isEnabled=true

        firstPlayer.clear()
        secondPlayer.clear()
    }



}