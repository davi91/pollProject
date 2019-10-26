package com.example.pollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

/**
    Los linear layout te permiten distribuir de forma equitativa
    los elementos atendiendo al 'weight' de cada elemento con respecto
    a la suma de todos.

    También se pueden distribuir de forma no equitativa de manera que si
    no ponemos el 'weight' cada elemento ocupará lo que tenga que ocupar.
    En este ejemplo hemos utilizado las dos orientaciones de layout con
    una variación de lo mencionado anteriormente.

    Para más información;
    https://developer.android.com/guide/topics/ui/layout/linear
 */

public class MainActivity extends AppCompatActivity {

    private boolean esMujer = false;

    // Vamos a hacerlo de una manera sencilla.
    private boolean comidas[] = {
            false, // carne
            false, // verduras
            false // pescado
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activamos hombre por defecto
        ((RadioButton)findViewById(R.id.hombreBtton)).toggle();
    }

    public void onSexClick(View view) {

        int id = view.getId();

        // Aquí sólo podemos seleccionar uno
        if( id == R.id.mujerBt) {
            esMujer = true;
        } else {
            esMujer = false;
        }
    }

    public void onFoodClick(View view) {

        int id = view.getId();

        // Aquí si tenemos que comprobar si está 'on' o 'off'
        boolean checked = ((CheckBox)view).isChecked();

        if( R.id.carneCh == id ) {
            comidas[0] = checked;
        } else if( R.id.pesacdoCh == id) {
            comidas[1] = checked;
        } else {
            comidas[2] = checked;
        }
    }

    public void onNextPage(View view) {

        // Vamos a la siguiente 'página' y le enviamos los datos
        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("SEXO", (esMujer) ? "Mujer" : "Hombre");
        intent.putExtra("COMIDAS", comidas); // También nos permite pasar arrays completos

        startActivity(intent);
    }
}
