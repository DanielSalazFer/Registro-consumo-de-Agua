package examen.cr.ac.una.registroconsumodeagua;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

import examen.cr.ac.una.registroconsumodeagua.model.RegistroAgua;

public class MesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<RegistroAgua> registros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        registros = (ArrayList<RegistroAgua>) getIntent().getSerializableExtra(getResources().getString(R.string.keyMainActivity));
        ArrayList<Integer> meses = new ArrayList<Integer>();


        for(RegistroAgua reg : registros){

            meses.add(reg.getFecha().getMonth()+1);
        }

        // esto me elimina los mese repetidos de la lista
        HashSet<Integer> hashSet = new HashSet<Integer>(meses);
        meses.clear();
        meses.addAll(hashSet);

        ListAdapterMes adapter= new ListAdapterMes(registros,getApplicationContext(),meses);






        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ListView lista = (ListView) findViewById(R.id.listaMes);
        lista.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent salida=new Intent( Intent.ACTION_MAIN); //Llamando a la activity principal
            finish();
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_dias) {
            Intent diasI = new Intent(this, MainActivity.class);
            startActivity(diasI);
        } else if (id == R.id.nav_mes) {
            Intent mesI = new Intent(this, MesActivity.class);
            mesI.putExtra(getResources().getString(R.string.keyMainActivity),registros);
            startActivity(mesI);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
