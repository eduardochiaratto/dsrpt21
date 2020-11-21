package br.com.fiap.dsrpt21

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.lang.Exception

class ConnectionActivity : AppCompatActivity() {

    lateinit var buttonUsb : ImageButton
    lateinit var buttonBluetooth : ImageButton
    lateinit var progressBar: ProgressBar
    lateinit var textViewConnected: TextView
    private val SPLASH_TIME_OUT:Long = 3000 // 1 sec

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)

        buttonUsb = findViewById(R.id.buttonUsb)
        buttonBluetooth = findViewById(R.id.buttonBluetooth)
        progressBar = findViewById(R.id.progressBar)
        textViewConnected = findViewById(R.id.textViewConnected)

        buttonBluetooth.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            textViewConnected.visibility = View.VISIBLE
            buttonBluetooth.setBackgroundResource(R.drawable.rounded_corners)
            buttonBluetooth.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.orange));
            buttonBluetooth.setImageResource(R.drawable.ic_bluetooth_white)


            val background = object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(3000)
                        val intent = Intent(baseContext, AdviceActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            background.start()
        }

        buttonUsb.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            textViewConnected.visibility = View.VISIBLE
            buttonUsb.setBackgroundResource(R.drawable.rounded_corners)
            buttonUsb.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.orange));
            buttonUsb.setImageResource(R.drawable.ic_usb_white)


            val background = object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(3000)
                        val intent = Intent(baseContext, AdviceActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            background.start()
        }

    }
}