package com.example.arisonraik.finesaude;

import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class PanelActivity extends AppCompatActivity  implements View.OnClickListener {

    private final String TAG = PanelActivity.class.getSimpleName();
    List<UsuarioAPI> mUsuario;
    ListView mListView;
    TextView tMessage;
    ProgressBar mProgressBar;
    ArrayAdapter<UsuarioAPI> mAdapter;
    ProgressDialog dialog;
    Observable fetch;
    String nome;
    String idade;
    String peso;
    String altura;
    TextView nomeView;
    TextView idadeView;
    TextView alturaView;
    TextView pesoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        // click dos botões
        Button butonMedidas = (Button) findViewById(R.id.buttonMedidas);
        butonMedidas.setOnClickListener(this);
        Button buttonDieta = (Button) findViewById(R.id.buttondieta);
        buttonDieta.setOnClickListener(this);
        Button butonAlergia = (Button) findViewById(R.id.buttonalergia);
        butonAlergia.setOnClickListener(this);
        Button buttonIMC = (Button) findViewById(R.id.buttonIMC);
        butonMedidas.setOnClickListener(this);

        //fazerChamada();
    }





    @Override
    public void onClick(View v) {



        // Log.d(TAG, "Clicou no botao logar");

        switch (v.getId()) {

            // verifica qual botão clicado

            case R.id.buttonMedidas:

                //if(alerta != null){

                    Intent it = new Intent(PanelActivity.this, MedidasActivity.class);
                    //it.putExtra("medidas", alerta);
                    startActivity(it);
                    /*break;

                } else {
                    Toast.makeText(PanelActivity.this,"Dados Nulos", Toast.LENGTH_LONG).show();
                    break;
                }*/

            case R.id.buttonalergia:

                //if(alerta != null){

                    Intent its = new Intent(PanelActivity.this, HistoricoAlergicoActivity.class);
                    //its.putExtra("alergias", alerta);
                    startActivity(its);
                    /*break;

                } else {
                    Toast.makeText(PanelActivity.this,"Dados Nulos", Toast.LENGTH_LONG).show();
                    break;
                }*/

            case R.id.buttondieta:
                //if(alerta != null){

                    //Toast.makeText(PanelActivity.this,"Ainda não implementado", Toast.LENGTH_LONG).show();
                    /*break;

                } else {
                    Toast.makeText(PanelActivity.this,"Dados Nulos", Toast.LENGTH_LONG).show();
                    break;
                }*/

            case R.id.buttonIMC:
                startActivity(new Intent(PanelActivity.this, SegundaPagina.class));
        }
    }
}
