package com.example.codetal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class test : AppCompatActivity() {
    private lateinit var imageView3: ImageView
    private lateinit var imageView4: ImageView
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView
    private lateinit var imageView7: ImageView
    private lateinit var imageView8: ImageView
    private lateinit var imageView9: ImageView



    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var  weiterBtn: Button

    private var currentImageView: ImageView? = null
    private var imageIndex = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        imageView7 = findViewById(R.id.imageView7)
        imageView8 = findViewById(R.id.imageView8)
        imageView9 = findViewById(R.id.imageView9)

        editText = findViewById(R.id.editTextText)

        button = findViewById(R.id.button3)
        weiterBtn  = findViewById(R.id.weiterBtn)

        var x = 0;
        Thread{
        weiterBtn.setOnClickListener {


    x++

    if (x == 1) {imageView3.visibility = View.GONE }
    if (x == 2) {imageView4.visibility = View.GONE }
    if (x == 3) {imageView5.visibility = View.GONE }
            if (x == 4) {imageView6.visibility = View.GONE }
            if (x == 5) {imageView7.visibility = View.GONE }
            if (x == 6) {imageView8.visibility = View.GONE
                editText.visibility = View.VISIBLE
                button.visibility = View.VISIBLE
            }


            button.setOnClickListener {
                val userInput = editText.text.toString()
                if (isInputValid(userInput)) {
                    // Wenn die Eingabe richtig ist, öffne die nächste Seite
                    val intent = Intent(this, quest_richtig::class.java) // Ersetzen Sie NextActivity mit der tatsächlichen Zielaktivität
                    startActivity(intent)
                } else {
                    // Wenn die printf Eingabe falsch ist, gib eine Fehlermeldung aus
                    // Sie können hier Toast, AlertDialog oder eine andere Form der Benachrichtigung verwenden
                    Toast.makeText(this, "Falsche Eingabe!", Toast.LENGTH_SHORT).show()
                }
            }

        }
        }.start()
    }
    private fun isInputValid(input: String): Boolean {
        val regex = Regex("""printf\("[^"]*"\);""")
        return regex.matches(input)
    }

}
