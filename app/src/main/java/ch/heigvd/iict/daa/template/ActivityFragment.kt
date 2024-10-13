package ch.heigvd.iict.daa.template

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment

class ActivityFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        if (savedInstanceState == null) {
            replaceFragment(ColorFragment())
        }

        findViewById<Button>(R.id.next).setOnClickListener {
            navigateToNextFragment()
        }

        findViewById<Button>(R.id.back).setOnClickListener {
            backButton()
        }

        findViewById<Button>(R.id.close).setOnClickListener {
            finish()
        }
    }

    private fun navigateToNextFragment() {
        when (supportFragmentManager.findFragmentById(R.id.fragments)) {
            is ColorFragment -> replaceFragment(CounterFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun backButton() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        }
    }
}
