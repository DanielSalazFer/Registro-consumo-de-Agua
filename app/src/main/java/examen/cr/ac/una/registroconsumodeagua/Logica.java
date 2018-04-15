package examen.cr.ac.una.registroconsumodeagua;

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

}

