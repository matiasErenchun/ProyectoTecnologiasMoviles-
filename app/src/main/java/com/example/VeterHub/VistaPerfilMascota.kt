package com.example.VeterHub

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

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
    lateinit var myView: View;
    private val miViewModel : MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.myView = inflater.inflate(R.layout.fragment_vista_perfil_mascota, container, false)
        val btnAddMascota =this.myView.findViewById<FloatingActionButton>(R.id.id_add_mascota_floatingActionButton)
        btnAddMascota.setOnClickListener {
            Log.i("funka", "funkaaaaaaaaaaaa")
            val registrarMascota =  AgregarMascotaFragment();
            activity?.supportFragmentManager?.
            beginTransaction()?.
            replace(R.id.id_container_Fragment_cliente,registrarMascota)?.
            addToBackStack(null)?.
            commit()
        }
        Log.e("mascotas", this.miViewModel.userCliente.mascotas.toString())
        getMascotas();
        return this.myView;
    }

    fun getMascotas()
    {
        var fireRef =  FirebaseFirestore.getInstance().collection("/Mascota/");
        var cliente = this.miViewModel.getCliente()
        cliente.mascotas.forEach { it ->
            fireRef.document(it).get().addOnSuccessListener { data ->
                if (data.exists())
                {
                    var id = data.get("id").toString()
                    var idDueño = data.get("idDueño").toString()
                    var nombreDueño = data.get("nombreDueño").toString()
                    var tipo = data.get("tipo").toString();
                    var nombre = data.get("nombre").toString()
                    var raza = data.get("raza").toString()
                    var color = data.get("color").toString()
                    var pesoS = data.get("peso").toString()
                    var peso = pesoS.toFloat();
                    var mascota = ItemListaMascota();
                    mascota.setNombre(nombre);
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.add(R.id.id_caja_gestionarmascotas, mascota)
                        ?.addToBackStack(null)?.commit()
                }
            }
        }
    }


}