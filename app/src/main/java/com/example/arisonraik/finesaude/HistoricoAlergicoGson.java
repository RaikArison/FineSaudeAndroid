package com.example.arisonraik.finesaude;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HistoricoAlergicoGson {

    public static final String BASE_URL =
            "http://www.finesaude.com.br/index.php?modulo=Requests&acao=requestHistAlergia";

    public static List<HistoricoAlergico> obterHistAlergicoDoServidor(){

        OkHttpClient client = new OkHttpClient();
        client.readTimeoutMillis();
        client.connectTimeoutMillis();
        Request request = new Request.Builder()
                .url(BASE_URL)
                .build();

        try{
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Gson gson = new Gson();

            Type listType = new TypeToken<List<HistoricoAlergico>>() {}.getType();

            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}