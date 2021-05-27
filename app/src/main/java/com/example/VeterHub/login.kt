package com.example.VeterHub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private val miViewModel : MainViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    public fun login()
    {
        var reeturn = " error ";
        val correo = R.id.TextEmailAddress.toString().trim();
        val passworD = R.id.TextPassword.toString().trim();
        FirebaseAuth.getInstance().signInWithEmailAndPassword(correo,passworD)
            .addOnCompleteListener {
                if (it.isSuccessful)
                {
                    reeturn = it.result?.user?.email?: " no email";
                    this.miViewModel.setEmail(reeturn);
                    println(reeturn)
                }
                else
                {
                    reeturn = "mal login"
                    this.miViewModel.setEmail(reeturn);
                }
            }
    }
}