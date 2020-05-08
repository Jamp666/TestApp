package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
        private AppModel model;
        private AppView view;
        private AppController controller;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                model = new AppModel();
                view = new AppView(this);
                controller = new AppController(this, model, view);
        }
}

