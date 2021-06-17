package com.example.VeterHub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity()
{
    private val miViewModel : MainViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTrasaction = supportFragmentManager.beginTransaction()
        val pantallaDeInicioFragment = PantallaInicial();
        fragmentTrasaction.replace(R.id.containerFragment, pantallaDeInicioFragment);
        fragmentTrasaction.commit()

    }
}