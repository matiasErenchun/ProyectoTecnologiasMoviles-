package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class PantallaInicial : Fragment() {
    private lateinit var btnInicioSesion : Button;
    private lateinit var btnRegistrarse : Button;
    private lateinit var btnNavegarSinConexion : Button;
    private lateinit var textCorreo : TextInputEditText;
    private lateinit var textContrasena : TextInputEditText;
    private lateinit var miView : View;
    private val miViewModel : MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView= inflater.inflate(R.layout.fragment_pantalla_inicial, container, false);
        this.btnInicioSesion = this.miView.findViewById(R.id.botonIniciarSesio);
        this.btnRegistrarse = this.miView.findViewById(R.id.botonRegistrarse);
        this.btnNavegarSinConexion = this.miView.findViewById(R.id.botonNavegarSinConexion);
        this.textCorreo = this.miView.findViewById(R.id.correoInput);
        this.textContrasena = this.miView.findViewById(R.id.contrseñaInput);
        this.btnRegistrarse.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val cliente0RegistrarseFragment =  Cliente0Registrarse();
                activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.containerFragment,cliente0RegistrarseFragment)?.
                addToBackStack(null)?.
                commit()
            }
        });
        this.btnInicioSesion.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                login();
            }
        })
        return this.miView;
    }


    private  fun login()
    {
        var reeturn = " error ";
        val correo = this.textCorreo.text.toString();
        val passworD =this.textContrasena.text.toString();
        if(correo.isEmpty())
        {
            Toast.makeText(context,"correo sin elementos", Toast.LENGTH_SHORT).show()
        }
        else if (passworD.isEmpty())
        {
            Toast.makeText(context,"password sin elementos", Toast.LENGTH_SHORT).show()
        }
        else
        {
            // esto es un print pero en la cara a lo choro
            // Toast.makeText(context,correo, Toast.LENGTH_LONG).show()
            // Toast.makeText(context,passworD, Toast.LENGTH_LONG).show()
            val arr = FirebaseAuth.getInstance().signInWithEmailAndPassword(correo,passworD)
                .addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        reeturn = it.result?.user?.email?: " no email";
                        this.miViewModel.setEmail(reeturn);
                        val logInFragment =  LoginFragment();
                        activity?.supportFragmentManager?.
                        beginTransaction()?.
                        replace(R.id.containerFragment,logInFragment)?.
                        addToBackStack(null)?.
                        commit()
                    }
                    else
                    {
                        reeturn = "mal login"
                        this.miViewModel.setEmail(reeturn);
                    }
                }
        }

    }

}