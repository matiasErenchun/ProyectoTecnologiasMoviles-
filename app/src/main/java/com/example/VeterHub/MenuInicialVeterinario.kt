package com.example.VeterHub

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.navigation.*
import com.google.android.material.navigation.NavigationView

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
        this.toolbar.inflateMenu(R.menu.navigation_vet)
        return this.miView;
    }

}