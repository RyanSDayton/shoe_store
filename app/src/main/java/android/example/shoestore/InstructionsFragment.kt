package android.example.shoestore

import android.example.shoestore.databinding.InstructionsFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater, R.layout.instructions_fragment, container, false
        )

        binding.instructionsToShoeButton.setOnClickListener { shoe ->
            shoe.findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsToShoeList()
            )
        }
        return binding.root

    }

}