package com.csto.pruebaparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner spinner_lugares;
    Button btn_siguiente;
    ArrayList<String> array_lugares= new ArrayList<>();
    String Lugares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_lugares= (Spinner) findViewById(R.id.spinner_lugares);
        btn_siguiente= (Button) findViewById(R.id.btn_siguiente);

        array_lugares.add("");
        array_lugares.add("Estadio Santa Cruz");
        array_lugares.add("Puerto montt");
        array_lugares.add("Calama");

        ArrayAdapter<String> adaptar =new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,array_lugares);
        spinner_lugares.setAdapter(adaptar);

        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinner_lugares.getSelectedItem()==""){
                    Toast.makeText(getApplicationContext(),"Tiene que seleccionar un lugar.",Toast.LENGTH_SHORT).show();
                    Intent E = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(E);
                }
                String Lugar=spinner_lugares.getSelectedItem().toString();
                Intent I= new Intent(getApplicationContext(), MainActivity2.class);
                I.putExtra("spinner_lugar",Lugar);
                startActivity(I);


            }
        });
    }
}