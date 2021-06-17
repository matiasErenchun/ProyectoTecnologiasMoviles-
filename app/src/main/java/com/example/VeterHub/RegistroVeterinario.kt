package com.example.VeterHub

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RegistroVeterinario : Fragment()
{
    private lateinit var correo: EditText;
    private lateinit var nombres: EditText;
    private lateinit var apellidos: EditText;
    private lateinit var contacto: EditText;
    private lateinit var nombreUsuario: EditText
    private lateinit var contrasenna: EditText;
    private lateinit var confirmarContrasenna: EditText;
    private lateinit var gradoMaximo: EditText;
    private lateinit var universidad: EditText;
    private lateinit var codigoTitulo: EditText;
    private lateinit var miView: View;
    private lateinit var btnRegistrar: Button;

    private val miViewModel : MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_registro_veterinario, container, false);
        this.nombres = this.miView.findViewById(R.id.id_nombres);
        this.apellidos = this.miView.findViewById(R.id.id_apellidos);
        this.correo = this.miView.findViewById(R.id.id_email);
        this.contacto = this.miView.findViewById(R.id.id_celular);
        this.nombreUsuario = this.miView.findViewById(R.id.id_nick);
        this.contrasenna = this.miView.findViewById(R.id.id_password);
        this.confirmarContrasenna = this.miView.findViewById(R.id.id_conf_pass);
        this.gradoMaximo = this.miView.findViewById(R.id.id_grado);
        this.universidad = this.miView.findViewById(R.id.id_universidad);
        this.codigoTitulo = this.miView.findViewById(R.id.id_cod_titulo);
        this.btnRegistrar = this.miView.findViewById(R.id.btn_registrar);
        this.btnRegistrar.setOnClickListener( object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                //miViewModel.addCliente(correo.text.toString(), contrasenna.text.toString())
                if (validarCampos())
                {
                    var veterinario: Veterinario = Veterinario(
                        "nono",
                        correo.text.toString(),
                        nombres.text.toString(),
                        apellidos.text.toString(),
                        contacto.text.toString(),
                        nombreUsuario.text.toString(),
                        gradoMaximo.text.toString(),
                        universidad.text.toString(),
                        codigoTitulo.text.toString()
                    );
                    crearUsuario(veterinario, contrasenna.text.toString());
                }
            }

        });

        return this.miView;
    }
    private fun validarCampos(): Boolean
    {
        return true;
    }
    private fun crearUsuario(veterinario: Veterinario, contrasenna: String)
    {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(veterinario.correo ,contrasenna).
        addOnSuccessListener{
            if(it.user?.uid != null)
            {
                var texxto: String = it.user?.uid.toString()
                veterinario.id = texxto;
                FirebaseFirestore.getInstance().
                collection("/Usuario/Rol/Veterinario")
                    .document(texxto).set(veterinario)
                    .addOnSuccessListener {
                        Toast.makeText(context,"salio bien", Toast.LENGTH_SHORT).show()
                        val inicio =  PantallaInicial();
                        activity?.supportFragmentManager?.
                        beginTransaction()?.
                        replace(R.id.containerFragment,inicio)?.
                        addToBackStack(null)?.
                        commit()
                    }
                    .addOnFailureListener { Toast.makeText(context,"salio mal", Toast.LENGTH_SHORT).show()  }
            }
            else
            {
                Toast.makeText(context,"error al crear el usuario", Toast.LENGTH_SHORT).show();
            }
        }.addOnFailureListener { error ->
            Log.e("error", error.cause.toString() + " " + error.message.toString());

        }
    }

}