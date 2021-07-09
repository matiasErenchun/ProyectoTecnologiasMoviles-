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
 * Use the [Veterinarios.newInstance] factory method to
 * create an instance of this fragment.
 */
class Veterinarios : Fragment() {
    lateinit var miView: View;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView =inflater.inflate(R.layout.fragment_veterinarios, container, false)
        val listaveteriarios = listaVeterinarios()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.id_caja_veterinarios_clientes, listaveteriarios)
            ?.addToBackStack(null)?.commit()
        return this.miView
    }

}