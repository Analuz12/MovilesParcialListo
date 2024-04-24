package com.portal.exploradordefarmacias.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Location> mLocation;
    private FusedLocationProviderClient fused;//accede a los servicio de ubicacion
    private LocationCallback callback;

    public MapsFragmentViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());

    }

    public LiveData<Location> getMLocation() {

        if (mLocation == null) {
            this.mLocation = new MutableLiveData<>();
        }

        return mLocation;
    }

    public void lecturaPermantente(){
       /* LocationRequest request = LocationRequest.create();
        request.setInterval(5000);
        request.setFastestInterval(5000);
        request.setPriority(Priority.PRIORITY_HIGH_ACCURACY);*/

        LocationRequest request=new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();

        //define locationcallback la cual maneja la respuesta de la ubicacion
        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) {//si locationresult no es nulo
                    return;
                }
                Location location = locationResult.getLastLocation();//obtiene la ultima ubicacion
                mLocation.postValue(location);//publica la ubicacion obtenida
            }
        };


        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fused.requestLocationUpdates(request, callback, null);
    }
    public void pararLecturaPermanente() {
        fused.removeLocationUpdates(callback);

    }
}

