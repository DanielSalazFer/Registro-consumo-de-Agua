package examen.cr.ac.una.registroconsumodeagua;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import examen.cr.ac.una.registroconsumodeagua.model.RegistroAgua;

/**
 * Created by Daniel on 15/04/2018.
 */

public class ListAdapter extends ArrayAdapter<RegistroAgua> implements View.OnClickListener{

    private ArrayList<RegistroAgua> dataSet;
    Context mContext;


    public ListAdapter(ArrayList<RegistroAgua> data, Context context) {
        super(context, R.layout.list_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View view) {

    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Logica logica = new Logica();

        if (convertView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            convertView = vi.inflate(R.layout.list_item, null);
        }



        RegistroAgua registro = getItem(position);





        TextView fecha = (TextView) convertView.findViewById(R.id.listFecha);
        TextView mililitros = (TextView) convertView.findViewById(R.id.listMililitros);
        TextView peso = (TextView) convertView.findViewById(R.id.listPeso);

        fecha.setText(registro.getFecha().toString());


        mililitros.setText(String.valueOf(registro.getMililitros()) + getContext().getString(R.string.mililitros));

        peso.setText(String.valueOf(registro.getPeso()) + getContext().getString(R.string.kilogramos));



        if(!logica.aguaRecomendada(registro)){
            fecha.setBackgroundColor(convertView.getResources().getColor(R.color.rojo));
            mililitros.setBackgroundColor(convertView.getResources().getColor(R.color.rojo));
            peso.setBackgroundColor(convertView.getResources().getColor(R.color.rojo));
        }
        else{
            fecha.setBackgroundColor(convertView.getResources().getColor(R.color.verde));
            mililitros.setBackgroundColor(convertView.getResources().getColor(R.color.verde));
            peso.setBackgroundColor(convertView.getResources().getColor(R.color.verde));
        }





        return convertView;
    }
}
