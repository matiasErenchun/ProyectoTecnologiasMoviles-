package com.example.VeterHub

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuInicialCliente.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuInicialCliente : Fragment() {

    lateinit var miView: View;
    lateinit var toolbar: androidx.appcompat.widget.Toolbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_menu_inicial_cliente, container, false);
        this.toolbar = this.miView.findViewById(R.id.id_toolbar_cliente);
        this.toolbar.inflateMenu(R.menu.navigation_drawer_client);
        this.toolbar.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.id_perfilCliente ->
                {
                    true
                }
                R.id.id_historialDeMensajesCliente ->
                {
                    true
                }
                R.id.id_solicitarCitaCliente ->
                {
                    true
                }
                R.id.id_citaActualCliente ->
                {
                    true
                }
                R.id.id_veterinariosCliente ->
                {
                    true
                }
                R.id.id_gestionarMascotasCliente ->
                {
                    val gestionarMascotas = VistaPerfilMascota()
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.id_container_Fragment_cliente, gestionarMascotas)
                        ?.addToBackStack(null)?.commit()
                    true
                }
                else ->
                {
                    Log.e("hola", "holaaaaa")
                    false
                }
            }
        }
        return this.miView;
    }

}