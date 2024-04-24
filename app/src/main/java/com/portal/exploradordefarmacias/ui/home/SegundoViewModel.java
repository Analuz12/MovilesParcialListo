package com.portal.exploradordefarmacias.ui.home;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.portal.exploradordefarmacias.modelo.Farmacia;

import java.util.List;

public class SegundoViewModel extends AndroidViewModel{

        private MutableLiveData<Farmacia> farmaciaMutable;
        public SegundoViewModel(@NonNull Application application) {

            super(application);
        }

        public LiveData<Farmacia> getFarmaciaMutable() {
            if (farmaciaMutable == null){
                farmaciaMutable = new MutableLiveData<>();
            }
            return farmaciaMutable;
        }
        public void actualizarDatosFarmacia(Farmacia farmacia) {
            if (farmacia != null) {
                farmacia.setCaracteristicasCadena(getCaracteristicaString(farmacia.getCaracteristicas()));
                farmaciaMutable.setValue(farmacia);
            }
        }

        // Método para recuperar la farmacia del Intent del adapter
        public void recuperarFarmacia(Bundle bundle) {

            Farmacia farmacia= null;
            if (bundle!=null) {
                farmacia =(Farmacia) bundle.getSerializable("farmacia");
            }
            if (farmacia != null) {
                farmaciaMutable.setValue(farmacia);

            }

        }


        //convierte una lista de nombres en una sola cadena
        private String getCaracteristicaString(List<String> caracteristica) {
            StringBuilder builder = new StringBuilder();
            for (String actor : caracteristica) {
                builder.append(actor).append(", ");
            }

            if (builder.length() > 0) {
                builder.delete(builder.length() - 2, builder.length());
            }
            return builder.toString();
        }
}
