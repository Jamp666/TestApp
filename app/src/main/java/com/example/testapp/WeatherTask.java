package com.example.testapp;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.view.View;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SuppressLint("StaticFieldLeak")
public class WeatherTask extends AsyncTask<String, Void, String> {
        private MainActivity mainActivity;

        public WeatherTask(MainActivity mainActivity) {
                this.mainActivity = mainActivity;
        }

        @Override
        protected String doInBackground(String... strings) {
                return HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + mainActivity.getLocation() + "&units=metric&appid=" + mainActivity.getAPI());
        }

        @Override
        protected void onPreExecute() {
                super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
                try {
                        JSONObject jsonObj = new JSONObject(s);
                        JSONObject main = jsonObj.getJSONObject("main");
                        JSONObject sys = jsonObj.getJSONObject("sys");
                        JSONObject wind = jsonObj.getJSONObject("wind");
                        JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                        Long updatedAt = jsonObj.getLong("dt");
                        String updatedAtText = "Обновлено: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                        String temp = main.getString("temp") + " °C";
//                        String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
//                        String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
//                        String pressure = main.getString("pressure");
//                        String humidity = main.getString("humidity");
//                        Long sunrise = sys.getLong("sunrise");
//                        Long sunset = sys.getLong("sunset");
//                        String windSpeed = wind.getString("speed");
//                        String weatherDescription = weather.getString("description");
                        String address = jsonObj.getString("name");

                        mainActivity.getTemperature().setText(temp);
                        mainActivity.getAddress().setText(address);
                        mainActivity.getLastUpdate().setText(updatedAtText);
                        mainActivity.getProgressBar().setVisibility(View.INVISIBLE);
                        mainActivity.getTemperature().setVisibility(View.VISIBLE);
                        mainActivity.getAddress().setVisibility(View.VISIBLE);
                        mainActivity.getLastUpdate().setVisibility(View.VISIBLE);

                } catch (JSONException ignored) {
                        System.out.println("lol");
                }
        }
}