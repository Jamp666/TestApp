package com.example.testapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationPOJO {
        @SerializedName("Key")
        @Expose
        private String Key;

        public String getKey() {
                return Key;
        }

        public void setKey(String key) {
                Key = key;
        }
}