package com.example.codetal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    private lateinit var buraxon: ImageView
    private lateinit var mediaPlayer: MediaPlayer
    private var xPosition = 0
    private var yPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.achtbit)
        mediaPlayer.isLooping = true // Für das Endlosspielen der Musik
        mediaPlayer.start()
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)
        buraxon = findViewById(R.id.imageView2)

        // Hier starten Sie die Musikwiedergabe innerhalb der onCreate-Methode



        buraxon.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN) {
                when (keyCode) {
                    KeyEvent.KEYCODE_W -> yPosition -= 10 // Verschiebe nach oben
                    KeyEvent.KEYCODE_S -> yPosition += 10 // Verschiebe nach unten
                    KeyEvent.KEYCODE_A -> xPosition -= 10 // Verschiebe nach links
                    KeyEvent.KEYCODE_D -> xPosition += 10 // Verschiebe nach rechts
                    KeyEvent.KEYCODE_SPACE -> {
                        if (isBuraxonNearButton()) {
                            // Öffne die neue Seite nur, wenn Buraxon in der Nähe des Buttons ist
                            val intent = Intent(this@MainActivity, test::class.java)
                            startActivity(intent)
                        }
                        // Hier können Sie weitere Aktionen für die Leertaste hinzufügen
                    }
                }
              buraxon.translationX = xPosition.toFloat()
                buraxon.translationY = yPosition.toFloat()
            }
            true
        })

      buraxon.isFocusableInTouchMode = true
        buraxon.requestFocus()
    }
    private fun isBuraxonNearButton(): Boolean {
        val buttonCoords = IntArray(2)
        button.getLocationOnScreen(buttonCoords)

        val buraxonCoords = IntArray(2)
        buraxon.getLocationOnScreen(buraxonCoords)

        val buttonCenterX = buttonCoords[0] + button.width / 2
        val buttonCenterY = buttonCoords[1] + button.height / 2

        val buraxonCenterX = buraxonCoords[0] + buraxon.width / 2
        val buraxonCenterY = buraxonCoords[1] + buraxon.height / 2

        // Berechnen Sie den Abstand zwischen Buraxon und dem Button
        val distance =
            abs(buttonCenterX - buraxonCenterX) + abs(buttonCenterY - buraxonCenterY)

        // Definieren Sie die maximale Distanz, bei der Buraxon als "in der Nähe" des Buttons gilt
        val maxDistance = 200// Passen Sie dies an Ihre Anforderungen an

        return distance <= maxDistance
    }
}
