package com.example.testapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationPOJO {
        @SerializedName("Key")
        @Expose
        private String Key;

        @SerializedName("AdministrativeArea")
        @Expose
        private AdministrativeArea  administrativeArea;

        public String getKey() {
                return Key;
        }

        public void setKey(String key) {
                Key = key;
        }

        public AdministrativeArea getAdministrativeArea() {
                return administrativeArea;
        }

        public void setAdministrativeArea(AdministrativeArea administrativeArea) {
                this.administrativeArea = administrativeArea;
        }

        public static class AdministrativeArea {
                @SerializedName("EnglishName")
                @Expose
                private String englishName;

                public String getEnglishName() {
                        return englishName;
                }

                public void setEnglishName(String englishName) {
                        this.englishName = englishName;
                }
        }
}