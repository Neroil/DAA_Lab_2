package ch.heigvd.iict.daa.template

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/*
Auteurs : Junod Arthur, Dunant Guillaume et Häffner Edwin
Activité qui permet de demander à l'utilisateur de saisir son nom ou de le modifier
 */
class UsernameInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_username_input)

        val textField = findViewById<EditText>(R.id.usernameInput)
        val button = findViewById<Button>(R.id.saveUsername)

        textField.setText(intent.getStringExtra("existingName"))

        button.setOnClickListener {
            val fieldValue = textField.text.toString()
            val data = Intent()
            data.putExtra(USERNAME_KEY, fieldValue)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    companion object {
        const val USERNAME_KEY = "NAME_KEY"
    }
}