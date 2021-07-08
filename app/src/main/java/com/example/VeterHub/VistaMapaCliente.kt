package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VistaMapaCliente.newInstance] factory method to
 * create an instance of this fragment.
 */
class VistaMapaCliente : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mimapa: MapaV;
    lateinit var miVista: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        miVista = inflater.inflate(R.layout.fragment_vista_mapa_cliente, container, false)
        mimapa = MapaV()
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.id_caja_mapa, mimapa)
            ?.addToBackStack(null)?.commit()
        return miVista
    }

}