package android.example.shoestore

import android.example.shoestore.databinding.WelcomeFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class Welcome : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false
        )

        binding.welcomeToInstructionsButton.setOnClickListener { login ->
            login.findNavController().navigate(
                WelcomeDirections.actionWelcomeToInstructions()
            )
        }
        return binding.root
    }
}