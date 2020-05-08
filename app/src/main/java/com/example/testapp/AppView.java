package com.example.testapp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.testapp.pojo.ConditionsPOJO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Response;

class AppView {
        private MainActivity mainActivity;
        private TextView temperature, location, lastUpdate, weather;
        private ProgressBar loadingCircle;

        AppView(MainActivity MainActivity) {
                this.mainActivity = MainActivity;
                temperature = mainActivity.findViewById(R.id.temperature);
                location = mainActivity.findViewById(R.id.location);
                lastUpdate = mainActivity.findViewById(R.id.lastU);
                weather = mainActivity.findViewById(R.id.weather);
                loadingCircle = mainActivity.findViewById(R.id.progressBar);
                setLoadingVisibility(false);
        }

        void showInfo(boolean show) {
                setTemperatureVisibility(show);
                setLocationVisibility(show);
                setLastUpdateVisibility(show);
                setWeatherTextVisibility(show);
                setLoadingVisibility(!show);
        }

        @SuppressLint("SetTextI18n")
        void setTemperature(Response<List<ConditionsPOJO>> response) {
                assert response.body() != null;
                float temp = response.body().get(0).getTemperature().getMetric().getValue();
                temperature.setText(temp + "℃");
        }

        @SuppressLint("SetTextI18n")
        void setLastUpdate(Response<List<ConditionsPOJO>> response) {
                assert response.body() != null;
                long epoch = response.body().get(0).getEpochTime();
                Date date = new Date(TimeUnit.SECONDS.toMillis(epoch));
                @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String formatted = format.format(date);
                lastUpdate.setText("Обновлено " + formatted);
        }

        void setLocation(String adrs) {
                location.setText(adrs);
        }

        void setWeather(Response<List<ConditionsPOJO>> response) {
                assert response.body() != null;
                String text = response.body().get(0).getWeatherText();
                weather.setText(text);
        }

        private void setLoadingVisibility(boolean visible) {
                if (visible) {
                        loadingCircle.setVisibility(android.view.View.VISIBLE);
                } else {
                        loadingCircle.setVisibility(android.view.View.INVISIBLE);
                }
        }

        private void setWeatherTextVisibility(boolean visible) {
                if (visible) {
                        weather.setVisibility(View.VISIBLE);
                } else {
                        weather.setVisibility(View.INVISIBLE);
                }
        }

        private void setTemperatureVisibility(boolean visible) {
                if (visible) {
                        temperature.setVisibility(View.VISIBLE);
                } else {
                        temperature.setVisibility(View.INVISIBLE);
                }
        }

        private void setLocationVisibility(boolean visible) {
                if (visible) {
                        location.setVisibility(View.VISIBLE);
                } else {
                        location.setVisibility(View.INVISIBLE);
                }
        }

        private void setLastUpdateVisibility(boolean visible) {
                if (visible) {
                        lastUpdate.setVisibility(View.VISIBLE);
                } else {
                        lastUpdate.setVisibility(View.INVISIBLE);
                }
        }
}
