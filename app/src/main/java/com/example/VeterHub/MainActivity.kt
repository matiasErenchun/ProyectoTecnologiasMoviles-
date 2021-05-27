package com.example.VeterHub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onClick( view: View)
    {
        val fragmentExample = FragmentExample()
        val fragment2 = Fragmento2()
        val fragmentTrasaction = supportFragmentManager.beginTransaction()
       when (view.id)
       {
           R.id.Boton1 ->
           {

               fragmentTrasaction.replace(R.id.containerFragment, fragmentExample)
               fragmentTrasaction.commit()
           }
           R.id.Button2 ->
           {
               fragmentTrasaction.replace(R.id.containerFragment, fragment2)
               fragmentTrasaction.commit()
           }
       }
    }
}