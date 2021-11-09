package android.example.shoestore

import android.example.shoestore.databinding.ShoeDetailFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController


class ShoeDetail : Fragment() {
    val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate view and obtain an instance of the binding class
        binding = ShoeDetailFragmentBinding.inflate(
            inflater, container, false
        )

        binding.cancelButton.setOnClickListener { cancel ->
            cancel.findNavController().navigate(
                ShoeDetailDirections.actionShoeDetailToShoeList()
            )
        }

        binding.saveButton.setOnClickListener { save ->
            viewModel.saveShoe()
            save.findNavController().navigate(
                ShoeDetailDirections.actionShoeDetailToShoeList()
            )
        }
        return binding.root
    }
}
