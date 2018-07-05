package com.example.arisonraik.finesaude;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.lang.reflect.Type;
import java.util.List;

public class UsuarioHttpGson {

    public static final String BASE_URL =
            "http://www.finesaude.com.br/index.php?modulo=Requests&acao=requestUsuarios";

    public static List<Usuario> obterUsuariosDoServidor(){

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

            //  Log.e("UsuarioHttp", "retorno: "+ json);

            Type listType = new TypeToken<List<Usuario>>() {}.getType();

            return gson.fromJson(json, listType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
