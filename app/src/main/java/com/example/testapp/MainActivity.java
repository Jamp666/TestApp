package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private String Location;
        private String API = "e90a73a8a229cb20d0e51447fb2b3b7a";
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
                                Location = "khonuu";//Api no workee
                                break;
                }
                new WeatherTask(this).execute();
                temperature.setVisibility(View.INVISIBLE);
                address.setVisibility(View.INVISIBLE);
                lastUpdate.setVisibility(View.INVISIBLE);
                loadingCircle.setVisibility(View.VISIBLE);
        }

        public String getLocation() {
                return Location;
        }

        public String getAPI() {
                return API;
        }

        public TextView getTemperature() {
                return temperature;
        }

        public TextView getAddress() {
                return address;
        }

        public TextView getLastUpdate() {
                return lastUpdate;
        }

        public ProgressBar getProgressBar() {
                return loadingCircle;
        }
}

