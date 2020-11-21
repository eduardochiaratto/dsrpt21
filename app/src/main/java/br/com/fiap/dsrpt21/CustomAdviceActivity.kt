package br.com.fiap.dsrpt21

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_advice.*

class CustomAdviceActivity : AppCompatActivity() {

    lateinit var editTextAddAdvice : EditText
    lateinit var buttonAddAdvice : Button

    lateinit var buttonGoToAdvice: ImageView
    lateinit var buttonGoToCustom: ImageView
    lateinit var buttonGoToList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_advice)

        editTextAddAdvice = findViewById(R.id.editTextAddAdvice)
        buttonAddAdvice = findViewById(R.id.buttonAddAdvice)

        buttonGoToAdvice = findViewById(R.id.buttonGoToAdvice)
        buttonGoToCustom = findViewById(R.id.buttonGoToCustom)
        buttonGoToList = findViewById(R.id.buttonGoToList)

        buttonAddAdvice.setOnClickListener {
            Toast.makeText(applicationContext, "Advice add successfully", Toast.LENGTH_SHORT).show()
        }

        buttonGoToAdvice.setOnClickListener {
            val intent = Intent(this, AdviceActivity:: class.java)
            startActivity(intent)
        }

        buttonGoToCustom.setOnClickListener {
            val intent = Intent(this, CustomAdviceActivity:: class.java)
            startActivity(intent)
        }

        buttonGoToList.setOnClickListener {
            val intent = Intent(this, ListAdviceActivity:: class.java)
            startActivity(intent)
        }
    }
}