package ch.heigvd.iict.daa.template.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.template.R

/*
Auteurs : Junod Arthur, Dunant Guillaume et Häffner Edwin
Un fragment qui affiche le numéro de l'étape dans la pile
 */
class StepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backStackEntryCount = parentFragmentManager.backStackEntryCount

        view.findViewById<TextView>(R.id.stepNumberText).text = (backStackEntryCount).toString()
    }
}
