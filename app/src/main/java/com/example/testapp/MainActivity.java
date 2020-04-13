package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
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
        private Button buttonAldan;
        private Button buttonYakutsk, buttonAbiy, buttonOymakon ;
        private ProgressBar progressBar;

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
                buttonYakutsk = findViewById(R.id.yakutsk);
                buttonYakutsk.setBackgroundColor(Color.TRANSPARENT);
                buttonAbiy = findViewById(R.id.abiy);
                buttonAbiy.setBackgroundColor(Color.TRANSPARENT);
                buttonOymakon = findViewById(R.id.oymyakon);
                buttonOymakon.setBackgroundColor(Color.TRANSPARENT);
                buttonAldan = findViewById(R.id.aldan_button);
//                buttonAldan.setBackgroundColor(Color.TRANSPARENT);
                Log.e("ALDAN", String.valueOf(buttonAldan == null));
                progressBar = findViewById(R.id.progressBar);
                progressBar.getIndeterminateDrawable().setColorFilter(0xFF782D1E, PorterDuff.Mode.MULTIPLY);
                progressBar.setVisibility(View.INVISIBLE);
                List<Button> buttons = new LinkedList<>();
                buttons.add(buttonAbiy);
                buttons.add(buttonOymakon);
                buttons.add(buttonYakutsk);
//                buttons.add(buttonAldan);
                for (Button b : buttons) {
                        b.setOnClickListener(this);
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
                        case R.id.aldan_button:
                                Location = "aldan";
                                break;
                }
                new WeatherTask(this).execute();
                progressBar.setVisibility(View.VISIBLE);
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
                return progressBar;
        }
}

