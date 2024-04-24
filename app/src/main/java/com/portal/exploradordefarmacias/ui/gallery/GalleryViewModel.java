package com.portal.exploradordefarmacias.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<Integer> mutableMapa;
    private MutableLiveData<String> mutableIdioma;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMutableIdioma() {
        if (mutableIdioma == null){
            mutableIdioma = new MutableLiveData<>();
        }
        return mutableIdioma;
    }


    public LiveData<Integer> getMutableMapa() {
        if (mutableMapa == null){
            mutableMapa = new MutableLiveData<>();
        }
        return mutableMapa;
    }

    public void modificarMapa(String tipo, boolean flag ) {

        if (tipo.equals("Satelital") && flag ) {
            mutableMapa.setValue(2);

        }
        if (tipo.equals("Normal") && flag) {
            mutableMapa.setValue(1);
        }
    }

    public void modificarIdioma(String idioma, Boolean flag){

        if (idioma.equals("Ingles")&& flag){
            mutableIdioma.setValue("types of map");
        }
        if (idioma.equals("Español")&& flag){
            mutableIdioma.setValue("tipo de mapa");
        }


    }




}