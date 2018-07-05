package com.example.arisonraik.finesaude;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class HistoricoAlergicoActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = PanelActivity.class.getSimpleName();
    ProgressDialog dialog;
    Observable fetch;

    String alimento;
    String dataOcorrido;
    String dataInsercao;
    String descricao;
    String tipoReacao;

    TextView alimentoView;
    TextView dataOcorridoView;
    TextView dataInsercaoView;
    TextView descricaoView;
    TextView tipoReacaoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_alergico);

        alimentoView = (TextView) findViewById(R.id.alAlimento);
        dataOcorridoView = (TextView) findViewById(R.id.alOcorrido);
        dataInsercaoView = (TextView) findViewById(R.id.alDataInsercao);
        descricaoView = (TextView) findViewById(R.id.alDescricao);
        tipoReacaoView = (TextView) findViewById(R.id.alTipoReacao);

        // click dos botões
        Button salvarMedida = (Button) findViewById(R.id.alSalvar);
        salvarMedida.setOnClickListener(this);
        Button salvarExcluir = (Button) findViewById(R.id.alExcluir);
        salvarMedida.setOnClickListener(this);
        Button editarMedida = (Button) findViewById(R.id.alEditar);
        editarMedida.setOnClickListener(this);
        fazerChamada();

    }
    protected void fazerChamada(){

        dialog = ProgressDialog.show(HistoricoAlergicoActivity.this,"Carregando" ,"Por favor, aguarde...", true);
        fetch = Observable.create(new Observable.OnSubscribe<List<HistoricoAlergico>>() {

            @Override
            public void call(Subscriber<? super List<HistoricoAlergico>> subscriber) {
                try {
                    // CRIA A LISTA DE USUARIOAPI ATRAVES DO JSON QUE VEM DO SERVIDOR
                    List<HistoricoAlergico> resposta = HistoricoAlergicoGson.obterHistAlergicoDoServidor();

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
                .subscribe(new Action1<List<HistoricoAlergico>>() {
                    @Override
                    public void call(List resposta) {

                        dialog.dismiss();

                        if(resposta != null){

                            Iterator<HistoricoAlergico> itr = resposta.iterator();
                            HistoricoAlergico historicoAlergico2 = itr.next();

                            alimento = historicoAlergico2.setFkAlimento(String.valueOf(historicoAlergico2.getFkAlimento()));
                            dataOcorrido = historicoAlergico2.setDtOcorrido(String.valueOf(historicoAlergico2.getDtOcorrido()));
                            dataInsercao = historicoAlergico2.setDtInsercao(String.valueOf(historicoAlergico2.getDtInsercao()));
                            descricao = historicoAlergico2.setDescricao(String.valueOf(historicoAlergico2.getDescricao()));
                            tipoReacao = historicoAlergico2.setTipoReacao(String.valueOf(historicoAlergico2.getTipoReacao()));

                            alimentoView.setText(alimento);
                            dataOcorridoView.setText(dataOcorrido);
                            dataInsercaoView.setText(dataInsercao);
                            descricaoView.setText(descricao);
                            tipoReacaoView.setText(tipoReacao);

                        }
                        else{
                            Toast.makeText(HistoricoAlergicoActivity.this,
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
                break;

            case R.id.mEditar:
                break;

            case R.id.mExcluir:
                break;

        }

    }


}