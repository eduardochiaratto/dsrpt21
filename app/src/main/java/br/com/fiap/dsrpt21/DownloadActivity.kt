package br.com.fiap.dsrpt21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DownloadActivity : AppCompatActivity() {

    lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        buttonBack = findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener {
            val intent = Intent(this, AdviceActivity:: class.java)
            startActivity(intent)
        }
    }
}