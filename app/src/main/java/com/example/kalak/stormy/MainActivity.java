package com.example.kalak.stormy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String apiKey = "62b83215b0ffdea911ac5441afaf9993";
        double latitude = 37.8267;
        double longitude = -122.423;

        String forecastUrl="https://api.forecast.io/forecast/" +
                apiKey + "/" +
                latitude + "," +
                longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                                    .url(forecastUrl)
                                    .build();

        com.squareup.okhttp.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

                try {
                    if (response.isSuccessful()) {
                        Log.v(TAG, response.body().string());
                    }

                } catch (IOException e) {
                    //e.printStackTrace();
                    Log.e(TAG, "Exception caught: ", e);
                }

            }
        });

    }

}
