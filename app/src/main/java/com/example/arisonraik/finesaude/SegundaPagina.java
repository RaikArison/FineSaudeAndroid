package com.example.arisonraik.finesaude;

import android.os.Bundle;
import com.example.arisonraik.finesaude.BuildConfig;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaPagina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pagina);
            }

    public void btnCalcularOnClick(View v){
        TextView Resultado = (TextView)findViewById(R.id.Resultado);
        EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);

        int peso = Integer.parseInt(txtPeso.getText().toString());
        float altura = Float.parseFloat(txtAltura.getText().toString());

        float resultado = peso /(altura*altura);

        if(resultado < 19){
            Resultado.setText("Abaixo do nível ideal");
        }
        else if(resultado > 32){
            Resultado.setText("Acima do nível Ideal");
        }
        else if(resultado > 40){
            Resultado.setText("Obeso");
        }
        else{
            Resultado.setText("Nivel ideal atingido");
        }

        }

    }


