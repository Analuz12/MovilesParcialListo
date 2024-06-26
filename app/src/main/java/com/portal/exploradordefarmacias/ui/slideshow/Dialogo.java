package com.portal.exploradordefarmacias.ui.slideshow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.portal.exploradordefarmacias.databinding.ContentMainBinding;

public class Dialogo {

    public static void mostrarDialogo(Context context){
        new AlertDialog.Builder(context)
                .setTitle("confirma salida")
                .setMessage("¿desea SALIR? SI O NO")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
