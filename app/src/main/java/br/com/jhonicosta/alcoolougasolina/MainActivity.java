package br.com.jhonicosta.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editAlcool;
    private EditText editGasolina;
    private Button buttonCalcular;
    private TextView resposta;

    private Double valorAlcool;
    private Double valorGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool = findViewById(R.id.editAlcool);
        editGasolina = findViewById(R.id.editGasolina);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        resposta = findViewById(R.id.resposta);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (editGasolina.getText().toString().equals("") || editAlcool.getText().toString().equals("")) {
                    resposta.setText(R.string.erro);
                } else {

                    valorAlcool = Double.valueOf(editAlcool.getText().toString());
                    valorGasolina = Double.valueOf(editGasolina.getText().toString());

                    if (valorAlcool / valorGasolina < 0.7) {
                        resposta.setText(R.string.resultadoAlcool);
                    }
                    if (valorAlcool / valorGasolina > 0.7) {
                        resposta.setText(R.string.resultadoGasolina);
                    }
                    if (valorAlcool / valorGasolina == 0.7) {
                        resposta.setText(R.string.resultadoIgual);
                    }

                }
            }
        });
    }


}
