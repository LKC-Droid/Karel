package com.example.basiccrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basiccrud.dal.SerieDAL;
import com.example.basiccrud.dto.Serie;

public class MainActivity extends AppCompatActivity {
    private SerieDAL serieDAL;
    private Button BtnEnviar;
    private EditText Titulo;
    private EditText categoria;
    private EditText capitulos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.serieDAL = new SerieDAL(getApplicationContext(), new Serie());
        this.BtnEnviar = (Button) findViewById(R.id.btnEnviar);
        this.Titulo = (EditText) findViewById(R.id.formNombre);
        this.categoria = (EditText) findViewById(R.id.formCategoria);
        this.capitulos = (EditText) findViewById(R.id.formCapitulos);

        BtnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Serie s = new Serie(Titulo.getText().toString(),categoria.getText().toString(),Integer.parseInt(capitulos.getText().toString()));
                serieDAL = new SerieDAL(getApplicationContext(),s);
                boolean r = serieDAL.insertar();

                if (r){
                    Toast.makeText(getApplicationContext(),"Se ha insertado la serie", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No se ha ingresado la serie", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
