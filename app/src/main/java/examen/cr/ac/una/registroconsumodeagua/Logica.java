package examen.cr.ac.una.registroconsumodeagua;

import java.util.ArrayList;
import java.util.HashSet;

import examen.cr.ac.una.registroconsumodeagua.model.RegistroAgua;

/**
 * Created by Daniel on 15/04/2018.
 */

public class Logica {

    public static final int CONSTANTE_DIVISION = 7;
    public static final int CONSTANTE_ML_VASO = 250;

    public Logica() {
    }

    public boolean aguaRecomendada (RegistroAgua registro){

        long vasosRecomendados = registro.getPeso() / CONSTANTE_DIVISION;
        long mLRecomendados = vasosRecomendados * CONSTANTE_ML_VASO;

        if(registro.getMililitros() >= mLRecomendados)
            return true;




        return false;
    }

    public boolean aguaRecomendadaMensual (RegistroAgua registro, ArrayList<Integer>meses){

        long vasosRecomendados = (registro.getPeso() / CONSTANTE_DIVISION)*meses.size();
        long mLRecomendados = vasosRecomendados * CONSTANTE_ML_VASO;

        if(registro.getMililitros() >= mLRecomendados)
            return true;




        return false;
    }

    public ArrayList<String> promedioMes (ArrayList<RegistroAgua> registros, int position, ArrayList<Integer>meses){

        ArrayList<String> resultados = new ArrayList<String>();
        long mlTotal = 0;
        long kgTotal = 0;
        long cont = 0;

       if(position >= meses.size()){
           return null;
       }else{
           for(RegistroAgua registro : registros){

               if((registro.getFecha().getMonth())+1 == meses.get(position)){
                   mlTotal = mlTotal + registro.getMililitros();
                   kgTotal = kgTotal + registro.getPeso();
                   cont+=1;
               }
           }
           resultados.add(String.valueOf(meses.get(position)));
           resultados.add(String.valueOf(mlTotal/cont));
           resultados.add(String.valueOf(kgTotal/cont));


       }



        return resultados;

    }

}

