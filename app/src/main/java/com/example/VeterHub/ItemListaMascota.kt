package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemListaMascota.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemListaMascota : Fragment() {
    // TODO: Rename and change types of parameters
    private var nombre: String? = null
    private var duenno: String? = null
    lateinit var myView: View;
    lateinit var nombreMascota: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nombre = it.getString(ARG_PARAM1)
            duenno = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.myView = inflater.inflate(R.layout.fragment_item_lista_mascota, container, false)
        this.nombreMascota = this.myView.findViewById(R.id.id_item_nombre_mascotas);
        this.nombreMascota.text = this.nombre;
        return this.myView;
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre;
    }
}