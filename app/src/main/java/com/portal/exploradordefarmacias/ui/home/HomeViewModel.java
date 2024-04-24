package com.portal.exploradordefarmacias.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.modelo.Farmacia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<List<Farmacia>> listaFarmacia;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        listaFarmacia = new MutableLiveData<>();
        inicializarListaFarmacia();
    }

    public  LiveData<List<Farmacia>> getListaFarmacia() {
        return listaFarmacia;
    }

    private void inicializarListaFarmacia() {
        List<Farmacia> farmacias = new ArrayList<>();

        List<String> farmauno = Arrays.asList("atencion solo de Lunes a Sabado", "Asesoramiento farmacéutico","Amplio surtido de productos.");
        farmacias.add(new Farmacia("Farmacia botequin ", "perdenera 300 Villa Del Carmen, San Luis.",
                "Horarios: 8 a 20.",
                R.drawable.farmacia1, farmauno));

        List<String> farmados = Arrays.asList("atencion las 24 hs", "envios a domicilio y zonas aledañas","guardia permanente","Servicios de salud adicionales.");
        farmacias.add(new Farmacia("Farmacia del pueblo ", "lafinur 300 Naschel, San Luis.",
                "Horarios: 8 a 20.",
                R.drawable.imagen3, farmados));

        List<String> farmatres = Arrays.asList("atencion de Lunes a Sabado", "envios a domicilio","Venta de productos de cuidado especializado.");
        farmacias.add(new Farmacia("Farmacia San Miguel de Arcangel ", "San martin 600 Naschel, San Luis..",
                "Horarios: 8 a 20.",
                R.drawable.imagen2, farmatres));

        List<String> farmacuatro = Arrays.asList("atencion las 24 hs", "envios a domicilio","guardia permanente", "Asesoramiento nutricional.");
        farmacias.add(new Farmacia("Farmacia Norte", "San Martin 700 Tilisarao, San luis.",
                " Horarios: 8 a 20.",
                R.drawable.farmacia4, farmacuatro));



        listaFarmacia.setValue(farmacias);
    }
}