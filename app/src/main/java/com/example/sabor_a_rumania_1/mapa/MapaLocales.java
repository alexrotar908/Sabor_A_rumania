package com.example.sabor_a_rumania_1.mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.sabor_a_rumania_1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaLocales extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    //atributos
    EditText txtLatitud, txtlongitud;
    GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_locales);

        //txtLatitud=findViewById(R.id.txtLatitud);
        //txtlongitud=findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapaLocales);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap= googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng elDescanso= new LatLng(40.4492544,-3.5514985);
        mMap.addMarker(new MarkerOptions().position(elDescanso).title("El Descanso"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(elDescanso));

        LatLng laBunica= new LatLng(40.4286248,-3.6483616);
        mMap.addMarker(new MarkerOptions().position(laBunica).title("La Bunica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(laBunica));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
       // txtLatitud.setText(""+latLng.latitude);
        //txtlongitud.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        //txtLatitud.setText(""+latLng.latitude);
        //txtlongitud.setText(""+latLng.longitude);
    }
}