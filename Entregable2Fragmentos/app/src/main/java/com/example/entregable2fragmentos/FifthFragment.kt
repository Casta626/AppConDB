package com.example.entregable2fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//Me lo importa pero no funciona
import androidx.lifecycle.viewModelScope

import androidx.navigation.fragment.findNavController
import com.example.entregable2fragmentos.databinding.FragmentFifthBinding

import kotlinx.coroutines.launch

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

    //////      Retrofit        //////
    private val _estado = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _estado
    private val _textoProductos = MutableLiveData<String>()
    val texto: LiveData<String>
        get() = _textoProductos

    private suspend fun getEstateProperties() {
        // Importo arriba el viewModelScopelaunch
       // viewModelScope.launch {
            try {
                val listResult = CustomerObject.retrofitService.getProperties()
                _estado.value = "Success: ${listResult.size} Mars properties retrieved"
                if (listResult.isNotEmpty()) {
                    //Log.i("Error en el pago:::")
                }
            } catch (e: Exception) {
                _estado.value = "Failure: ${e.message}"
            }
        }
    //}

    init {
        //getEstateProperties()
    }

    private val _estadoCompra = MutableLiveData<String>()
    val estado: LiveData<String>
        get() = _estadoCompra

    }

