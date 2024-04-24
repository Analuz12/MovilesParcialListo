package com.portal.exploradordefarmacias.ui.home;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.databinding.FragmentSegundoBinding;
import com.portal.exploradordefarmacias.modelo.Farmacia;

public class SegundoFragment extends Fragment {

    private SegundoViewModel mViewModel;
    private FragmentSegundoBinding binding;

    public static SegundoFragment newInstance() {
        return new SegundoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding= FragmentSegundoBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        mViewModel= new ViewModelProvider(this).get(SegundoViewModel.class);
        mViewModel.getFarmaciaMutable().observe(getViewLifecycleOwner(), new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {

                binding.tvNombre.setText(farmacia.getNombre());
                binding.tvDireccion.setText(farmacia.getDireccion());
                binding.tvhorario.setText(farmacia.getHorario());
                binding.ivImg.setImageResource(farmacia.getFoto());
                binding.tvCaracteristicas.setText("caracteristicas: " + farmacia.getCaracteristicasCadena());

            }
        });
        mViewModel.recuperarFarmacia(getArguments());
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SegundoViewModel.class);
        // TODO: Use the ViewModel
    }

}