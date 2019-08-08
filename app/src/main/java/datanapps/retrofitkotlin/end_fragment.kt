package datanapps.retrofitkotlin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_end_fragment.*
import kotlinx.android.synthetic.main.view_holder_project.*


class EndFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_end_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            textViewHeight.text = "${it.getString(getString(R.string.EMP_height))}"
            textViewWidth.text = "${it.getString(getString(R.string.EMP_width))}"
            textViewLength.text = it.getString(getString(R.string.EMP_length))
            textViewID.text = "${it.getString(getString(R.string.EMP_ID))}"
        }
    }

}
