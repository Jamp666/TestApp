package com.example.testapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConditionsPOJO {
        @SerializedName("Temperature")
        @Expose
        private Temperature temperature;

        @SerializedName("EpochTime")
        @Expose
        private long epochTime;

        @SerializedName("WeatherText")
        @Expose
        private String weatherText;

        public Temperature getTemperature() {
                return temperature;
        }

        public void setTemperature(Temperature temperature) {
                this.temperature = temperature;
        }

        public long getEpochTime() {
                return epochTime;
        }

        public void setEpochTime(long epochTime) {
                this.epochTime = epochTime;
        }

        public String getWeatherText() {
                return weatherText;
        }

        public void setWeatherText(String weatherText) {
                this.weatherText = weatherText;
        }

        public static class Temperature {
                @SerializedName("Metric")
                @Expose
                private Metric metric;

                public Metric getMetric() {
                        return metric;
                }

                public void setMetric(Metric metric) {
                        this.metric = metric;
                }

                public static class Metric {
                        @SerializedName("Value")
                        @Expose
                        private float Value;

                        public float getValue() {
                                return Value;
                        }

                        public void setValue(float value) {
                                Value = value;
                        }
                }
        }
}
