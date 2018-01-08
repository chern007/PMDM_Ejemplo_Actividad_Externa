package com.example.ilm.actividadexterna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {

    public static final int SELECCIONA_PROVINCIA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void pulsado(View v){
        Intent intent = new Intent(this, Selecciona.class);
        startActivityForResult(intent,SELECCIONA_PROVINCIA);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data)
    {
        TextView t=(TextView)findViewById(R.id.textView);

        if (requestCode == SELECCIONA_PROVINCIA) {
            if (resultCode == RESULT_OK) {
                // se seleccionó correctamente la provincia
                t.setText("Se ha seleccionado:\n"+data.getStringExtra("PROVINCIA"));
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
