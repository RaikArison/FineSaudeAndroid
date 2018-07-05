package com.example.arisonraik.finesaude;

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

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MedidasActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = PanelActivity.class.getSimpleName();
    TextView tMessage;
    ProgressDialog dialog;
    Observable fetch;

    String nome;
    String peso;
    String altura;
    String circuferencia;
    String data;

    TextView nomeView;
    TextView pesoView;
    TextView alturaView;
    TextView circunferenciaView;
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas);

        nomeView = (TextView) findViewById(R.id.mNome);
        pesoView = (TextView) findViewById(R.id.mPeso);
        alturaView = (TextView) findViewById(R.id.mAltura);
        circunferenciaView = (TextView) findViewById(R.id.mCircunferencia);
        dataView = (TextView) findViewById(R.id.mData);

        // click dos botões
        Button salvarMedida = (Button) findViewById(R.id.mSalvar);
        salvarMedida.setOnClickListener(this);
        Button salvarExcluir = (Button) findViewById(R.id.mExcluir);
        salvarMedida.setOnClickListener(this);
        Button editarMedida = (Button) findViewById(R.id.mEditar);
        editarMedida.setOnClickListener(this);
        fazerChamada();

    }

    protected void fazerChamada(){

        dialog = ProgressDialog.show(MedidasActivity.this,"Carregando" ,"Por favor, aguarde...", true);
        fetch = Observable.create(new Observable.OnSubscribe<List<Medidas>>() {

            @Override
            public void call(Subscriber<? super List<Medidas>> subscriber) {
                try {
                    // CRIA A LISTA DE USUARIOAPI ATRAVES DO JSON QUE VEM DO SERVIDOR
                    List<Medidas> resposta = MedidasGson.obterMedidasDoUsuarioServidor();

                    // CRIA A LISTA DE USUARIOAPI ATRAVES DO JSON QUE VEM DO SERVIDOR
                    List<Usuario> pegaUsuario = UsuarioHttpGson.obterUsuariosDoServidor();

                    subscriber.onNext(resposta); // Emit the contents of the URL
                    subscriber.onCompleted(); // Nothing more to emit
                }catch(Exception e){
                    subscriber.onError(e); // In case there are network errors
                }
            }
        });

        fetch
                .subscribeOn(Schedulers.newThread()) // Create a new Thread
                .observeOn(AndroidSchedulers.mainThread()) // Use the UI thread
                .subscribe(new Action1<List<Medidas>>() {
                    @Override
                    public void call(List resposta) {

                        dialog.dismiss();

                        if(resposta != null){

                            Iterator<Medidas> itr = resposta.iterator();
                            Medidas medida2 = itr.next();
                            peso = medida2.setPeso(String.valueOf(medida2.getPeso()));
                            altura = medida2.setAltura(String.valueOf(medida2.getAltura()));
                            circuferencia = medida2.setCircunferencia(String.valueOf(medida2.getCircunferencia()));
                            data = medida2.setData(String.valueOf(medida2.getData()));


                            //nome = pessoa2.setNome(String.valueOf(pessoa2.getNome()));


                            // nomeView.setText(nome);
                            nomeView.setText(nome);
                            pesoView.setText(peso);
                            alturaView.setText(altura);
                            circunferenciaView.setText(circuferencia);
                            dataView.setText(data);

                            Usuario pessoa2 = new Usuario();
                            Log.d("PUXAR", pessoa2.setNome(String.valueOf(pessoa2.getNome())));


                        }
                        else{
                            Toast.makeText(MedidasActivity.this,
                                    "Não foi possivel carregar dados",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                });

        fetch.unsubscribeOn(AndroidSchedulers.mainThread());
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.mSalvar:
/*
                    Usuario painelAdmin = new Usuario();
                    // primeiro set na classe USUARIO
                    //cadastrar.setSenha(edtSenha.getText().toString());
                    painelAdmin.setNome(edtNome.getText().toString());
                    Intent itPanel = new Intent(MainActivity.this, PainelActivity.class);
                    itPanel.putExtra("listarausuario", painelAdmin);
                    startActivity(itPanel);
*/
                break;

            case R.id.mEditar:
                /*
                Usuario cadastrar = new Usuario();
                // primeiro set na classe USUARIO
                //cadastrar.setSenha(edtSenha.getText().toString());
                cadastrar.setNome(edtNome.getText().toString());
                Intent it = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
                it.putExtra("cadastrar", cadastrar);
                startActivity(it);
                */
                break;

            case R.id.mExcluir:
                /*
                Usuario cadastrar = new Usuario();
                // primeiro set na classe USUARIO
                //cadastrar.setSenha(edtSenha.getText().toString());
                cadastrar.setNome(edtNome.getText().toString());
                Intent it = new Intent(MainActivity.this, CadastrarUsuarioActivity.class);
                it.putExtra("cadastrar", cadastrar);
                startActivity(it);
                */
                break;

        }

    }


}