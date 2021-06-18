package com.example.VeterHub

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.navigation.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuInicialVeterinario.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuInicialVeterinario : Fragment() {
    lateinit var miView: View;
    lateinit var toolbar: androidx.appcompat.widget.Toolbar;



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_menu_inicial_veterinario, container, false)
        this.toolbar =  this.miView.findViewById(R.id.id_toolbar_veterinario);
        this.toolbar.inflateMenu(R.menu.navigation_vet);
        this.toolbar.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.id_perfil_Veterinario -> {
                    val perfil = PerfilVeterinario();
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.containerFragment, perfil)?.addToBackStack(null)?.commit()
                    true
                }
                R.id.id_subcategoriaEditarPerfil -> {
                    // save profile changes
                    true
                }
                else -> {
                    Log.e("hola", "holaaaaa")
                    false
                }
            }
        }
        return this.miView;
    }
}