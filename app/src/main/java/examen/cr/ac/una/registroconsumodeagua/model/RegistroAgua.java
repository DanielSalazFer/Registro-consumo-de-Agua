package examen.cr.ac.una.registroconsumodeagua.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daniel on 15/04/2018.
 */

public class RegistroAgua implements Serializable{

    Date fecha;
    long mililitros;
    long peso;

    public RegistroAgua() {
    }

    public RegistroAgua(Date fecha, long mililitros, long peso) {
        this.fecha = fecha;
        this.mililitros = mililitros;
        this.peso = peso;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getMililitros() {
        return mililitros;
    }

    public void setMililitros(long mililitros) {
        this.mililitros = mililitros;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return this.fecha + "" + this.mililitros + "" + this.peso;
    }
}
