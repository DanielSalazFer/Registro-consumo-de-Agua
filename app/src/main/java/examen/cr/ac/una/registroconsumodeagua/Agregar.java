package examen.cr.ac.una.registroconsumodeagua;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class Agregar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }

    public void click(View view) {

        final DatePicker date = (DatePicker) findViewById(R.id.date);
        final TextView fecha = (TextView) findViewById(R.id.fecha);



        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        fecha.setText(date.getDayOfMonth() + "/" + date.getMonth() + "/" + date.getYear() );
    }
}
