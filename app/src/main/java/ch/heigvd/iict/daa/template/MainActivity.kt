package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val getName = registerForActivityResult(PickNameContract()) {
        // on reçoit le résultat de la seconde activité ici
        findViewById<TextView>(R.id.welcomeText).setText("Bienvenue $it!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            getName.launch(null)
        }
    }

}