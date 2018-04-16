package examen.cr.ac.una.registroconsumodeagua;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

import examen.cr.ac.una.registroconsumodeagua.model.RegistroAgua;

/**
 * Created by Daniel on 15/04/2018.
 */

public class ListAdapterMes extends ArrayAdapter<RegistroAgua> implements View.OnClickListener{

    private ArrayList<RegistroAgua> dataSet;
    Context mContext;
    private ArrayList<Integer> meses;


    public ListAdapterMes(ArrayList<RegistroAgua> data, Context context, ArrayList<Integer>meses) {
        super(context, R.layout.list_item_mes, data);
        this.dataSet = data;
        this.mContext = context;
        this.meses = meses;


    }

    @Override
    public void onClick(View view) {

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        for(RegistroAgua rg : dataSet){
            if (rg == null){
                dataSet.remove(rg);
            }
        }

        Logica logica = new Logica();

        if (convertView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            convertView = vi.inflate(R.layout.list_item, null);
        }



        RegistroAgua registro = getItem(position);




        ArrayList<String>m = logica.promedioMes(this.dataSet, position, this.meses);


        TextView fecha = (TextView) convertView.findViewById(R.id.listMes);
        TextView mililitros = (TextView) convertView.findViewById(R.id.listPromMl);
        TextView peso = (TextView) convertView.findViewById(R.id.listPromKg);
        String fechaF = String.valueOf(  registro.getFecha().getMonth()+1 );
        if(m!=null) {
            for (int i = 0; i < m.size(); i++) {
                if (m.get(i) != null)
                    System.out.println("M: " + m.get(i));
            }





            fecha.setText(getContext().getString(R.string.mes) + m.get(0));


            mililitros.setText(getContext().getString(R.string.promMl) + m.get(1) + getContext().getString(R.string.mililitros));

            peso.setText(getContext().getString(R.string.promKg) + m.get(2) +  getContext().getString(R.string.kilogramos));

        }




        if(!logica.aguaRecomendadaMensual(registro, meses)){
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
