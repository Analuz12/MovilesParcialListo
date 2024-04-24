package com.portal.exploradordefarmacias.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.ui.gallery.GalleryFragment;

public class MapsFragment extends Fragment {
    private MapsFragmentViewModel viewModel;
    private GoogleMap mMap;//representa el mapa google.

    private Marker MarcadorU;//mantiene una referencia al marcadosde ubicacion

    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap; //le asigno a la variable mMap el objeto googleMap(representa el mapa)
            mMap.setMapType(GalleryFragment.MAPA);

            // Agregar marcadores de farmacias
            LatLng farmacia1 = new LatLng(-32.94088655056055, -65.03995216281601);
            mMap.addMarker(new MarkerOptions().position(farmacia1).title("Farmacia botiquin del Carmen"));

            LatLng farmacia2 = new LatLng(-32.91329083868033, -65.3756299540477);
            mMap.addMarker(new MarkerOptions().position(farmacia2).title("Farmacia del Pueblo"));

            LatLng farmacia3 = new LatLng(-32.91406315044086, -65.3759735599626);
            mMap.addMarker(new MarkerOptions().position(farmacia3).title("Farmacia San Miguel Arcangel"));


            // Agregar marcador de ubicación actual del usuario
            viewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
                @Override
                public void onChanged(Location location) {
                    if (location != null) {//si la ubicacion no es nulla
                        LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                        //crea un nuevo objeto con la ubicacion recibida
                        if (MarcadorU != null) {  // Si el marcador de la ubicación actual ya existe,
                            // actualizar su posición
                            MarcadorU.setPosition(currentLatLng);
                        } else {// Si no existe, añadir un nuevo marcador
                         MarcadorU=mMap.addMarker(new MarkerOptions().position(currentLatLng).title("Ubicación Actual"));
                        }
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng));
                        // Mueve la cámara del mapa a la ubicación actual
                    }

                }

            });
            viewModel.lecturaPermantente();

        }

    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //instancio el viewModel
        viewModel = new ViewModelProvider(this).get(MapsFragmentViewModel.class);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {//comprueba que encuentre el mapa
            mapFragment.getMapAsync(callback);
            //Este método solicita al fragmento que prepare el mapa de Google
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.pararLecturaPermanente();
    }
}