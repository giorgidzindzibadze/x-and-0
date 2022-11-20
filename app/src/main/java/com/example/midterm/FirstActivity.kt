package com.example.midterm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var btn=findViewById<Button>(R.id.butt)
        var name1=findViewById<EditText>(R.id.edittext1)
        var name2=findViewById<EditText>(R.id.edittext2)

        btn.setOnClickListener {

            var resultName1=name1.text.toString()
            var resultName2=name2.text.toString()

            if(resultName1=="" || resultName2=="") {
                Toast.makeText(this, "გრაფა ცარიელია", Toast.LENGTH_SHORT).show()
            }else {
                val change = Intent(this,MainActivity::class.java).also {
                    intent.putExtra("firstPlayer",resultName1)
                    intent.putExtra("secondPlayer",resultName2)

                }

                startActivity(change)

            }


        }















    }
}