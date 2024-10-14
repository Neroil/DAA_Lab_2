package ch.heigvd.iict.daa.template.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ch.heigvd.iict.daa.template.R

class StepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backStackEntryCount = parentFragmentManager.backStackEntryCount

        view.findViewById<TextView>(R.id.stepNumberText).text = (backStackEntryCount).toString()
    }
}
