package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.template.UsernameInputActivity.Companion.USERNAME_KEY

/*
Auteurs : Junod Arthur, Dunant Guillaume et Häffner Edwin
Affiche le nom de l'utilisateur et permet de le modifier
 */
class MainActivity : AppCompatActivity() {

    private lateinit var welcomingTxt: TextView
    private var name : String? = null

    private val getName = registerForActivityResult(PickNameContract()) {
        //On reçoit le résultat de la seconde activité ici
        if (it != null) {
            name = it
            welcomingTxt.text = "Bienvenue $it!"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        welcomingTxt = findViewById<TextView>(R.id.welcomeText)
        name = savedInstanceState?.getString("name")  ?: ""

        if (savedInstanceState != null) {
            welcomingTxt.text = savedInstanceState.getString(USERNAME_KEY)
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            getName.launch(name)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USERNAME_KEY, findViewById<TextView>(R.id.welcomeText).text.toString())
        outState.putString("name", name)
    }

}