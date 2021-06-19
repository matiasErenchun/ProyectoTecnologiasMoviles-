package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilVeterinario.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilVeterinario : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var myView: View;
    lateinit var nombres: TextView;
    lateinit var apellidos: TextView;
    lateinit var universidad: TextView;
    private val miViewModel : MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.myView = inflater.inflate(R.layout.fragment_perfil__veterinario, container, false)
        this.nombres = this.myView.findViewById(R.id.id_nombrePerfilVet)
        this.apellidos = this.myView.findViewById(R.id.id_apellidosPerfilVet)
        this.universidad = this.myView.findViewById(R.id.id_universidadPerfilVet)
        this.nombres.text = this.miViewModel.getVeterinario().nombres;
        this.apellidos.text = this.miViewModel.getVeterinario().apellidos;
        this.universidad.text =this.miViewModel.getVeterinario().universidad;
        return this.myView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Perfil_Veterinario.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfilVeterinario().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}