package android.example.shoestore

import android.example.shoestore.databinding.ShoeListFragmentBinding
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class ShoeList : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    private lateinit var binding: ShoeListFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false
        )
        binding.shoeToDetailFloatingButton.setOnClickListener { shoe ->
            shoe.findNavController().navigate(
                ShoeListDirections.actionShoeListToShoeDetail()
            )
        }
        viewModel.storedShoes.observe(viewLifecycleOwner, { shoes ->
            val textView = TextView(requireContext()).apply {
                textSize = 20F
                setTextColor(resources.getColor(R.color.primaryDarkColor))
                setPadding(16, 16, 16, 16)
                text = shoes.joinToString("\n\n")
            }
            binding.shoeList.addView(textView)
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.side_menu, menu)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = this.findNavController()
        navController.navigate(NavigationDirections.actionGlobalLoginFragment())
        return super.onOptionsItemSelected(item)
    }
}