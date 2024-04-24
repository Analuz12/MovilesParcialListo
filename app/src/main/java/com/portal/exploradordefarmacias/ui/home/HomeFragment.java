package com.portal.exploradordefarmacias.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.databinding.FragmentHomeBinding;
import com.portal.exploradordefarmacias.modelo.Farmacia;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private HomeViewModel homeViewModel;
    private FarmaciaAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.lista;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapter = new FarmaciaAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        recyclerView.setAdapter(adapter);

        homeViewModel.getListaFarmacia().observe(getViewLifecycleOwner(), new Observer<List<Farmacia>>() {
            @Override
            public void onChanged(List<Farmacia> farmacias) {
                adapter.setFarmacia(farmacias);
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