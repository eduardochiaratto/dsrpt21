package br.com.fiap.dsrpt21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class AdviceActivity : AppCompatActivity() {

    lateinit var buttonLike: ImageButton
    lateinit var buttonDislike: ImageButton
    lateinit var textViewAdvice: TextView
    lateinit var progressBar: ProgressBar
    lateinit var textViewBack: TextView

    lateinit var buttonGoToAdvice: ImageView
    lateinit var buttonGoToCustom: ImageView
    lateinit var buttonGoToList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice)

        buttonLike = findViewById(R.id.buttonLike)
        buttonDislike = findViewById(R.id.buttonDislike)
        textViewBack = findViewById(R.id.textViewBack)

        buttonGoToAdvice = findViewById(R.id.buttonGoToAdvice)
        buttonGoToCustom = findViewById(R.id.buttonGoToCustom)
        buttonGoToList = findViewById(R.id.buttonGoToList)

        getCurrentAdvice()


        buttonLike.setOnClickListener {
            val intent = Intent(this, DownloadActivity:: class.java)
            startActivity(intent)
        }

        buttonDislike.setOnClickListener {
            getCurrentAdvice()
        }

        textViewBack.setOnClickListener {
            val intent = Intent(this, ConnectionActivity:: class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
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

    private fun getCurrentAdvice() {

        textViewAdvice = findViewById(R.id.textViewAdvice)
        progressBar = findViewById(R.id.progressBar)

        textViewAdvice.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.adviceslip.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: Service = retrofit.create(Service::class.java)

        GlobalScope.launch(Dispatchers.IO) {

            val response = service.getAdvices().awaitResponse()

            if(response.isSuccessful) {
                val data = response.body()!!
                Log.d("Main", data.slip.toString())

                withContext(Dispatchers.Main) {
                    progressBar.visibility = View.GONE
                    textViewAdvice.visibility = View.VISIBLE
                    textViewAdvice.text = data.slip.advice
                }
            }
        }
    }
}