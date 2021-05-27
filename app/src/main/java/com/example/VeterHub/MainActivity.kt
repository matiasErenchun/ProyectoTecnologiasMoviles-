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
    private val fragmentTrasaction = supportFragmentManager.beginTransaction()
    private val miViewModel : MainViewModel by viewModels();
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun onClick( view: View)
    {
        val fragmentExample = FragmentExample();
        val fragment2 = Fragmento2();
        val loginFragment = LoginFragment();

       when (view.id)
       {
           R.id.GoToLogin ->
           {

               fragmentTrasaction.replace(R.id.containerFragment, loginFragment)
               fragmentTrasaction.commit()
           }
           R.id.Button2 ->
           {
               fragmentTrasaction.replace(R.id.containerFragment, fragment2)
               fragmentTrasaction.commit()
           }
           R.id.LogIn ->
           {
               loginFragment.login()
               println(this.miViewModel.getEmail())
               fragmentTrasaction.replace(R.id.containerFragment, fragmentExample)
               fragmentTrasaction.commit()
           }
       }
    }

}