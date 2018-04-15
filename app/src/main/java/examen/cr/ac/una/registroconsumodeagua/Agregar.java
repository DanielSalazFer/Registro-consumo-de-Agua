package examen.cr.ac.una.registroconsumodeagua;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import examen.cr.ac.una.registroconsumodeagua.model.RegistroAgua;

public class Agregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);


        ImageButton guardar = (ImageButton) findViewById(R.id.guardarBoton);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<RegistroAgua> registros = (ArrayList<RegistroAgua>) getIntent().getSerializableExtra("registrosActuales");

                EditText peso = (EditText) findViewById(R.id.peso);
                EditText mililitros = (EditText) findViewById(R.id.mililitros);
                DatePicker date = (DatePicker) findViewById(R.id.date);
                Date fecha = new Date(date.getYear(), date.getMonth(), date.getDayOfMonth());

                RegistroAgua nuevoRegistro = new RegistroAgua(fecha, Long.parseLong(mililitros.getText().toString()), Long.parseLong(peso.getText().toString()));
                registros.add(nuevoRegistro);



                Intent i = new Intent(Agregar.this, MainActivity.class);
                i.putExtra("nuevoRegistro", registros);
                finish();
                startActivity(i);


            }
        });

    }











}
