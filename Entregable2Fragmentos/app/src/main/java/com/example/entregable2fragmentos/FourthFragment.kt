package com.example.entregable2fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.entregable2fragmentos.databinding.FragmentFourthBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

//Aquí copie el fragmento 1 y renombre las clases de first a third
class FourthFragment : Fragment() {
                            //Esto tambien lo renombre
    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //private const val ARG_resultadoPago= "resultadoPago"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                    //esto tambien lo renombre
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }

    //override fun onCreate(savedInstanceState: Bundle?){
     //   super.onCreate(savedInstanceState)
     //   arguments?.let {
     //       resultadoPago = ARG_resultadoPago
     //   }
   // }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aqui cambie la id del boton la cambie y le añadi la navegacion
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_FirstFragment)
        }

        //binding.botonPaginaWeb.setOnClickListener {
        //    val mActivity = MainActivity()
        //    mActivity.mandarPaginaWeb()
        //}
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}