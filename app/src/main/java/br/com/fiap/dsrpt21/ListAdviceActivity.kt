package br.com.fiap.dsrpt21

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListAdviceActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    lateinit var buttonGoToAdvice: ImageView
    lateinit var buttonGoToCustom: ImageView
    lateinit var buttonGoToList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_advice)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = AdviceAdapter(advices())
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonGoToAdvice = findViewById(R.id.buttonGoToAdvice)
        buttonGoToCustom = findViewById(R.id.buttonGoToCustom)
        buttonGoToList = findViewById(R.id.buttonGoToList)

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

    private fun advices(): List<String> {
        return listOf(
            "If you don't like the opinion you've been given, get another one.",
            "One of the single best things about being an adult, is being able to buy as much LEGO as you want.",
            "Don't give a speech. Put on a show.",
            "Try to do the things that you're incapable of.",
            "Do not check work email on your days off.",
            "There is no reason at all to believe that White Wine is any different to water when it comes to removing Red Wine stains."
        )
    }
}