package com.example.testapp;

class AppModel {
        private String APIkey = "7aevoUmbcEUAWdpGBZTdiNl8AaBA9aGR";
        private String LocationKey;
        private String Location;
        private String LocationText;

        String getAPIkey() {
                return APIkey;
        }

        String getLocationKey() {
                return LocationKey;
        }

        void setLocationKey(String locationKey) {
                LocationKey = locationKey;
        }

        String getLocation() {
                return Location;
        }

        void setLocation(String location) {
                Location = location;
        }

        String getLocationText() {
                return LocationText;
        }

        void setLocationText(String locationText) {
                LocationText = locationText;
        }
}
