package android.example.shoestore


import android.example.shoestore.databinding.LoginFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )
        binding.newLoginButton.setOnClickListener { login ->
            login.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcome()
            )
        }
        binding.existingUserButton.setOnClickListener { eUser ->
            eUser.findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcome()
            )
        }
        return binding.root
    }
}