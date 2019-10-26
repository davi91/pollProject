package com.example.pollproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * En este activity usamos el RelativeLayout, que nos permite alinear
 * unos componentes respecto a otros, usando la propiedad Margin para ajustar
 * las distancias.
 *
 * Más información en:
 * https://developer.android.com/guide/topics/ui/layout/relative
 */
public class ResultadoActivity extends AppCompatActivity {

    private String sexText;
    private boolean comidas[];

    private Button resultsBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Ahora obtenemos los datos que nos envió el otro activity
        Bundle bundle = getIntent().getExtras();
        sexText = bundle.getString("SEXO");
        comidas = bundle.getBooleanArray("COMIDAS");

        resultsBt = (Button)findViewById(R.id.resultsBt);
        resultsBt.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView sexText = findViewById(R.id.sexValue);
                ImageView carne = findViewById(R.id.carneValue);
                ImageView verduras = findViewById(R.id.verdurasValue);
                ImageView pescado = findViewById(R.id.pescadoValue);

                sexText.setText(ResultadoActivity.this.sexText);
                carne.setImageDrawable(iconDraw(comidas[0]));
                verduras.setImageDrawable(iconDraw(comidas[1]));
                pescado.setImageDrawable(iconDraw(comidas[2]));

                // Desactivamos el botón
                v.setEnabled(false);
            }
        });
    }

    private Drawable iconDraw( boolean checked) {
        return getResources().getDrawable((!checked) ? R.drawable.ic_error : R.drawable.ic_success);
    }


}
