package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var btnLogin : Button;
    private lateinit var miView : View;
    private lateinit var textLoginOk : TextView;
    private lateinit var textEmail : EditText;
    private lateinit var textPassword: EditText;
    private val miViewModel : MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_login, container, false)
        this.textLoginOk = this.miView.findViewById(R.id.LoginnnnOk);
        textLoginOk.text = miViewModel.getEmail();
        return this.miView;
    }

    private  fun login()
    {
        var reeturn = " error ";
        val correo = this.textEmail.text.toString();
        val passworD =this.textPassword.text.toString();
        if(correo.isEmpty())
        {
            Toast.makeText(context,"correo sin elementos",Toast.LENGTH_SHORT).show()
        }
        else if (passworD.isEmpty())
        {
            Toast.makeText(context,"password sin elementos",Toast.LENGTH_SHORT).show()
        }
        else
        {
            // esto es un print pero en la cara a lo choro
            Toast.makeText(context,correo,Toast.LENGTH_LONG).show()
            Toast.makeText(context,passworD,Toast.LENGTH_LONG).show()
            val arr = FirebaseAuth.getInstance().signInWithEmailAndPassword(correo,passworD)
                .addOnCompleteListener {
                    if (it.isSuccessful)
                    {
                        reeturn = it.result?.user?.email?: " no email";
                        this.miViewModel.setEmail(reeturn);
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