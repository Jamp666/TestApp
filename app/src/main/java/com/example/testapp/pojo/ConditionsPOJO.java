package com.example.testapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConditionsPOJO {
        @SerializedName("Temperature")
        @Expose
        private Temperature temperature;

        public Temperature getTemperature() {
                return temperature;
        }

        public void setTemperature(Temperature temperature) {
                this.temperature = temperature;
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
