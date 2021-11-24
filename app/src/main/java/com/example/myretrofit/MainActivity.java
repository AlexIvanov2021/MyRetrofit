package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.ApiInterface;
import retrofit.ApiRetrofit;
import retrofit.OpenWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.temp);
        textView2 = findViewById(R.id.temp_min);

       ApiInterface apiInterface = ApiRetrofit.getRetrofit().create(ApiInterface.class);
       Call<OpenWeather>call = apiInterface.getOpenWeather();

       call.enqueue(new Callback<OpenWeather>() {
           @Override
           public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
               textView1.setText(response.body().getMain().getTemp());
               textView2.setText(response.body().getMain().getTemp_min());
           }

           @Override
           public void onFailure(Call<OpenWeather> call, Throwable t) {
               Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });

    }
}