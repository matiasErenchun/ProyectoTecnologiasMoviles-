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
 * Use the [VistaPerfilMascota.newInstance] factory method to
 * create an instance of this fragment.
 */
class VistaPerfilMascota : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var myView: View;
    private var mascota1: Mascota = Mascota("pepe el perro")
    private var mascota2: Mascota = Mascota("juan el gato")
    private var mascotas: ArrayList<Mascota> = arrayListOf(mascota1,mascota2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.myView = inflater.inflate(R.layout.fragment_vista_perfil_mascota, container, false)
        this.mascotas.forEach{
            var mascota = ItemListaMascota();
            mascota.setNombre(it.getNombre());
            activity?.supportFragmentManager?.beginTransaction()
                ?.add(R.id.id_caja_gestionarmascotas, mascota)
                ?.addToBackStack(null)?.commit()
        }
        return this.myView;
    }

}