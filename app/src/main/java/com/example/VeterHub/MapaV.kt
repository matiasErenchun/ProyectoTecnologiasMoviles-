package com.example.VeterHub

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_mapa_v.*


class MapaV : Fragment(), OnMapReadyCallback {
    lateinit var googleMap: GoogleMap
    lateinit var miView: View;
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        this.miView = inflater.inflate(R.layout.fragment_mapa_v, container, false);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        return this.miView;
    }

    override fun onMapReady(map: GoogleMap) {
        Log.e("mapa","estoy dentro ");
        googleMap = map
        crearMarcador()
    }
    fun crearMarcador()
    {
        val coordenadas = LatLng(-34.9955, -71.2271)
        val marcadorActual = MarkerOptions().position(coordenadas).title("mi posicion actual")
        googleMap.addMarker(marcadorActual)
    }

    private fun crearMarcador1() {
        Log.e("mapa","estoy dentro ");
        if (activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED && activity?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            googleMap.isMyLocationEnabled = true
        }
        Log.e("mapa","estoy dentro ");
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
                Log.e("mapa","estoy dentro ");
                if (location != null)
                {
                    val coordenadas = LatLng(location.latitude,location.longitude)
                    val marcadorActual = MarkerOptions().position(coordenadas).title("mi posicion actual")
                    googleMap.addMarker(marcadorActual)
                }

            }
        Log.e("mapa","estoy fuera");
    }
    private fun permisosDelocalizacionAceptados()
        = activity?.let {
        ContextCompat.checkSelfPermission(
            it, Manifest.permission.ACCESS_FINE_LOCATION
        )
    } == PackageManager.PERMISSION_GRANTED

}