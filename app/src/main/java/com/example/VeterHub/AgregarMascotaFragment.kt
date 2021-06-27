package com.example.VeterHub

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarMascotaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarMascotaFragment : Fragment() {

    lateinit var tipo: TextInputEditText;
    lateinit var nombre: TextInputEditText;
    lateinit var raza: TextInputEditText;
    lateinit var color: TextInputEditText;
    lateinit var peso: TextInputEditText;
    lateinit var btnGuardar: Button;
    lateinit var btnCancelar: Button;
    lateinit var myView:View;
    private val miViewModel : MainViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.myView = inflater.inflate(R.layout.fragment_agregar_mascota, container, false)
        this.tipo = this.myView.findViewById(R.id.id_tipoMascotaInput)
        this.nombre= this.myView.findViewById(R.id.id_nombreMascotaInput)
        this.color= this.myView.findViewById(R.id.id_colorMascotaInput)
        this.raza = this.myView.findViewById(R.id.id_razaMascotaInput)
        this.peso = this.myView.findViewById(R.id.id_peso_mascota_input)
        this.btnGuardar = this.myView.findViewById(R.id.id_btn_guardarMascota)
        this.btnCancelar = this.myView.findViewById(R.id.id_btn_cancelar)
        this.btnCancelar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val gestionarmascotas =  VistaPerfilMascota();
                activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.id_container_Fragment_cliente,gestionarmascotas)?.
                addToBackStack(null)?.
                commit()
            }
        });
        this.btnGuardar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addmascota();
                Log.e("usuario", miViewModel.getCliente().id)
            }
        });
        return this.myView;
    }

    fun validarDatos(): Boolean
    {
        return true
    }

    fun addmascota()
    {
        var id= " "
        var idDueño = miViewModel.userCliente.id
        var nombreDueño = miViewModel.userCliente.nombres + " " + miViewModel.userCliente.apellidos
        var tipo: String = this.tipo.text.toString() ;
        var nombre = this.nombre.text.toString();
        var raza: String = this.raza.text.toString();
        var color: String = this.color.text.toString()
        var peso: Float = this.peso.text.toString().toFloat()
        if( validarDatos())
        {
            var nuevaMascota: Mascota = Mascota(id, idDueño, nombreDueño, tipo, nombre, raza, color, peso)
            this.agregarMascota(nuevaMascota)

        }
    }

    fun agregarMascota(nuevaMascota: Mascota)
    {
        Log.e("usuario", this.miViewModel.getCliente().id)
        var uid: String =this.miViewModel.getCliente().id;
        var fireRef =  FirebaseFirestore.getInstance().collection("/Mascota/").document();
        nuevaMascota.id = fireRef.id
        fireRef.set(nuevaMascota).addOnSuccessListener {
            this.miViewModel.getCliente().mascotas.add(nuevaMascota.id)
            var refCliente = FirebaseFirestore.getInstance().collection("/Usuario/Rol/Cliente/").document(uid);
            refCliente.set(this.miViewModel.getCliente()).addOnSuccessListener {
                Toast.makeText(context,"mascota agregada correctamente", Toast.LENGTH_SHORT).show()
                val gestionarmascotas =  VistaPerfilMascota();
                activity?.supportFragmentManager?.
                beginTransaction()?.
                replace(R.id.id_container_Fragment_cliente,gestionarmascotas)?.
                addToBackStack(null)?.
                commit()
            }.addOnFailureListener {
                fireRef.delete()
                Toast.makeText(context,"error al agregar la mascota intente denuevo", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            fireRef.delete()
            Toast.makeText(context,"error al agregar la mascota intente denuevo", Toast.LENGTH_SHORT).show()
        }

    }
}