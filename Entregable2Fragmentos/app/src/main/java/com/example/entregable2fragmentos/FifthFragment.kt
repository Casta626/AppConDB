package com.example.entregable2fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.entregable2fragmentos.databinding.FragmentFifthBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

//Aquí copie el fragmento 1 y renombre las clases de first a third
class FifthFragment : Fragment() {
                            //Aquí tambien lo cambie
    private var _binding: FragmentFifthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                    //Aquí tambien lo cambie
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aqui cambie la id del boton la cambie y le añadi la navegacion
        binding.button5.setOnClickListener {
            findNavController().navigate(R.id.action_fifthFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}