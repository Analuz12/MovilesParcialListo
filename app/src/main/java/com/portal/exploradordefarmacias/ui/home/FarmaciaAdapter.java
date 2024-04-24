package com.portal.exploradordefarmacias.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.portal.exploradordefarmacias.R;
import com.portal.exploradordefarmacias.modelo.Farmacia;

import java.util.List;

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.ViewHolderPepe> {
    private  List<Farmacia> listaDeFarmacia;
    private Context context;
    private LayoutInflater li;

    public FarmaciaAdapter(List<Farmacia> listaDeFarmacia, Context context, LayoutInflater li) {
        this.listaDeFarmacia = listaDeFarmacia;
        this.context = context;
        this.li = li;
    }

    public void setFarmacia(List<Farmacia> farmacia) {
        listaDeFarmacia.clear();
        listaDeFarmacia.addAll(farmacia);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderPepe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item, parent, false);
        return new ViewHolderPepe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPepe holder, int position) {
        Farmacia farmacia = listaDeFarmacia.get(position);

        holder.nombre.setText(farmacia.getNombre());
        holder.direccion.setText(farmacia.getDireccion());
        holder.foto.setImageResource(farmacia.getFoto());


        holder.boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("farmacia",farmacia);
                Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.action_nav_home_to_segundoFragment, bundle);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeFarmacia.size();
    }

    public class ViewHolderPepe extends RecyclerView.ViewHolder {

        TextView nombre, direccion;
        ImageView foto;
        Button boton;

        public ViewHolderPepe(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            direccion = itemView.findViewById(R.id.tvDireccion);
            foto = itemView.findViewById(R.id.imageView2Item);
            boton = itemView.findViewById(R.id.btVerMas);
        }
    }
}
