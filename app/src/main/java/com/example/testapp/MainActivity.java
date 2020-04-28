package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testapp.pojo.ConditionsPOJO;
import com.example.testapp.pojo.LocationPOJO;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private String Location;
        private String API = "7aevoUmbcEUAWdpGBZTdiNl8AaBA9aGR";
        private TextView temperature, address, lastUpdate;
        private ProgressBar loadingCircle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                initButtons();
                temperature = findViewById(R.id.temperature);
                address = findViewById(R.id.address);
                lastUpdate = findViewById(R.id.lastU);
        }

        private void initButtons() {
                loadingCircle = findViewById(R.id.progressBar);
                loadingCircle.setVisibility(View.INVISIBLE);

                List<Button> buttons = new LinkedList<>();
                buttons.add((Button) findViewById(R.id.abiy));
                buttons.add((Button) findViewById(R.id.oymyakon));
                buttons.add((Button) findViewById(R.id.yakutsk));
                buttons.add((Button) findViewById(R.id.aldan));
                buttons.add((Button) findViewById(R.id.allayiha));
                buttons.add((Button) findViewById(R.id.anabar));
                buttons.add((Button) findViewById(R.id.bulun));
                buttons.add((Button) findViewById(R.id.uoheHalima));
                buttons.add((Button) findViewById(R.id.uoheJaani));
                buttons.add((Button) findViewById(R.id.buluu));
                buttons.add((Button) findViewById(R.id.uoheeBuluu));
                buttons.add((Button) findViewById(R.id.ejigeen));
                buttons.add((Button) findViewById(R.id.kebeei));
                buttons.add((Button) findViewById(R.id.lenskei));
                buttons.add((Button) findViewById(R.id.meneKanalas));
                buttons.add((Button) findViewById(R.id.mirney));
                buttons.add((Button) findViewById(R.id.muoma));
                for (Button b : buttons) {
                        b.setOnClickListener(this);
                        b.setBackgroundColor(Color.TRANSPARENT);
                }
        }

        @Override
        public void onClick(View v) {
                switch (v.getId()) {
                        case R.id.abiy :
                                Location = "belaya gora";
                                break;
                        case R.id.oymyakon :
                                Location = "oymyakon";
                                break;
                        case R.id.yakutsk :
                                Location = "yakutsk";
                                break;
                        case R.id.aldan:
                                Location = "aldan";
                                break;
                        case R.id.allayiha :
                                Location = "chokurdakh";
                                break;
                        case R.id.anabar :
                                Location = "saskylakh";
                                break;
                        case R.id.bulun :
                                Location = "tiksi";
                                break;
                        case R.id.uoheHalima :
                                Location = "zyryanka";
                                break;
                        case R.id.uoheJaani:
                                Location = "batagay";
                                break;
                        case R.id.buluu :
                                Location = "vilyuysk";
                                break;
                        case R.id.uoheeBuluu :
                                Location = "verkhnevilyuysk";
                                break;
                        case R.id.ejigeen :
                                Location = "zhigansk";
                                break;
                        case R.id.kebeei :
                                Location = "sangar";
                                break;
                        case R.id.lenskei :
                                Location = "lensk";
                                break;
                        case R.id.meneKanalas :
                                Location = "nizhniy bestyakh";
                                break;
                        case R.id.mirney :
                                Location = "mirnyy";
                                break;
                        case R.id.muoma :
                                Location = "khonuu";
                                break;
                }
                temperature.setVisibility(View.INVISIBLE);
                address.setVisibility(View.INVISIBLE);
                lastUpdate.setVisibility(View.INVISIBLE);
                loadingCircle.setVisibility(View.VISIBLE);

                NetworkService.getInstance()
                        .getLocationApi()
                        .getKey(API, Location)
                        .enqueue(new Callback<List<LocationPOJO>>() {
                                @Override
                                public void onResponse(@NonNull Call<List<LocationPOJO>> call, @NonNull Response<List<LocationPOJO>> response) {
                                        assert response.body() != null;
                                        NetworkService.getInstance()
                                                .getConditionsApi()
                                                .getConditions(response.body().get(0).getKey(), API)
                                                .enqueue(new Callback<List<ConditionsPOJO>>() {
                                                        @Override
                                                        public void onResponse(@NonNull Call<List<ConditionsPOJO>> call, @NonNull Response<List<ConditionsPOJO>> response) {
                                                                temperature.setVisibility(View.VISIBLE);
                                                                loadingCircle.setVisibility(View.INVISIBLE);
                                                                assert response.body() != null;
                                                                temperature.setText(String.valueOf(response.body().get(0).getTemperature().getMetric().getValue()));
                                                        }

                                                        @Override
                                                        public void onFailure(@NonNull Call<List<ConditionsPOJO>> call, @NonNull Throwable t) {
                                                                System.out.println(t.toString());
                                                        }
                                                });
                                }

                                @Override
                                public void onFailure(@NonNull Call<List<LocationPOJO>> call, @NonNull Throwable t) {
                                        System.out.println(t.toString());
                                }
                        });
        }
}

