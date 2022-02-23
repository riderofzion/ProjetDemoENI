package com.quentinrouet.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.quentinrouet.swapi.bo.Planet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private final OkHttpClient client = new OkHttpClient();
    private ArrayList<Planet> alPlanet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Request request = new Request.Builder()
                .url("https://swapi.dev/api/planets")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    JSONObject requestJsonObj = new JSONObject(responseBody.string());
                    JSONArray arrayResults = requestJsonObj.getJSONArray("results");

                    for (int i = 0; i < arrayResults.length(); i++) {
                        JSONObject planet = arrayResults.getJSONObject(i);
                        String name = planet.getString("name");
                        String diameter = planet.getString("diameter");
                        String population = planet.getString("population");
                        String climate = planet.getString("climate");
                        alPlanet.add(new Planet(name,diameter,population,climate));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        });
    }
}