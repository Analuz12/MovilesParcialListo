package com.portal.exploradordefarmacias.ui.gallery;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.databinding.FragmentGalleryBinding;


import java.util.Locale;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    public static int MAPA=1;//STATIC HACE QUE ESTE DISPONIBLE EN todo el proyecto

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //mutable idioma

        galleryViewModel.getMutableIdioma().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String idioma) {
                binding.textMapa.setText(idioma);
            }
        });


        //mutable Mapa
        galleryViewModel.getMutableMapa().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                MAPA = integer;

            }
        });

        //dependiendo del click se modifica el mapa

        binding.rbnormal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                galleryViewModel.modificarMapa("Normal",isChecked);
            }
        });
        binding.rbmapaSatelital.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                galleryViewModel.modificarMapa("Satelital",isChecked);
            }
        });

        //dependiendo el click se modifica el idioma

        binding.rbespaOl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                galleryViewModel.modificarIdioma("Español", isChecked);
            }
        });

        binding.rbingles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                galleryViewModel.modificarIdioma("Ingles",isChecked);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}