package com.example.ilm.actividadexterna;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Selecciona extends ListActivity implements ListView.OnItemClickListener{


    public void onItemClick(AdapterView<?> a, View view, int position, long id){
        //creamos un intent para pasar los datos al otro activity
        Intent i=new Intent();
        i.putExtra("PROVINCIA",a.getItemAtPosition(position).toString());
        setResult(RESULT_OK,i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String [] elementos={"Toledo","Ciudad Real","Cuenca","Guadalajara","Albacete"};
        //declaramos el adaptor
        ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona);

        //iniciamos un "adaptor" y metemos todas las ciudades que estan en el array que hemos guardado anteriormente
        ListView l=(ListView)findViewById(android.R.id.list);
        adaptador=new ArrayAdapter<String>(this,R.layout.fila,elementos);
        setListAdapter(adaptador);
        l.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.selecciona, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
