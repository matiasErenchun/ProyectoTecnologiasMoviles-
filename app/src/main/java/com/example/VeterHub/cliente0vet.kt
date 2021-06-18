package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Cliente0Registrarse.newInstance] factory method to
 * create an instance of this fragment.
 */
class Cliente0Registrarse : Fragment()
{
    private lateinit var btnCliente : Button;
    private lateinit var btnVeterinario : Button;
    private lateinit var miView: View;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_cliente_0_vet, container, false);
        this.btnVeterinario = this.miView.findViewById(R.id.botonVeterinario);
        this.btnCliente = this.miView.findViewById(R.id.botonCliente);
        this.btnVeterinario.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val registrarVeterinarioFragment =  RegistroVeterinario();
                activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.containerFragment,registrarVeterinarioFragment)?.
                addToBackStack(null)?.
                commit()
            }
        });
        this.btnCliente.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val registroClienteFragment =  registroCliente();
                activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.containerFragment, registroClienteFragment)?.
                addToBackStack(null)?.
                commit()
            }
        })

        return this.miView;
    }

}