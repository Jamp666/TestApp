package com.example.testapp;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.example.testapp.pojo.ConditionsPOJO;
import com.example.testapp.pojo.LocationPOJO;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class AppController implements View.OnClickListener{
        private MainActivity mainActivity;
        private AppView view;
        private AppModel model;

        AppController(MainActivity MainActivity, AppModel model, AppView view) {
                this.mainActivity = MainActivity;
                this.model = model;
                this.view = view;
                initButtons();
        }

        private void initButtons() {
                List<Button> buttons = new LinkedList<>();
                buttons.add((Button) mainActivity.findViewById(R.id.abiy));
                buttons.add((Button) mainActivity.findViewById(R.id.aldan));
                buttons.add((Button) mainActivity.findViewById(R.id.allayiha));
                buttons.add((Button) mainActivity.findViewById(R.id.amma));
                buttons.add((Button) mainActivity.findViewById(R.id.anabar));
                buttons.add((Button) mainActivity.findViewById(R.id.bulun));
                buttons.add((Button) mainActivity.findViewById(R.id.uoheeBuluu));
                buttons.add((Button) mainActivity.findViewById(R.id.uoheHalima));
                buttons.add((Button) mainActivity.findViewById(R.id.uoheJaani));
                buttons.add((Button) mainActivity.findViewById(R.id.buluu));
                buttons.add((Button) mainActivity.findViewById(R.id.gornay));
                buttons.add((Button) mainActivity.findViewById(R.id.ejigeen));
                buttons.add((Button) mainActivity.findViewById(R.id.kebeei));
                buttons.add((Button) mainActivity.findViewById(R.id.lenskei));
                buttons.add((Button) mainActivity.findViewById(R.id.meneKanalas));
                buttons.add((Button) mainActivity.findViewById(R.id.mirney));
                buttons.add((Button) mainActivity.findViewById(R.id.muoma));
                buttons.add((Button) mainActivity.findViewById(R.id.nam));
                buttons.add((Button) mainActivity.findViewById(R.id.nuorungru));
                buttons.add((Button) mainActivity.findViewById(R.id.allaraHalima));
                buttons.add((Button) mainActivity.findViewById(R.id.nyurba));
                buttons.add((Button) mainActivity.findViewById(R.id.oymyakon));
                buttons.add((Button) mainActivity.findViewById(R.id.oloon));
                buttons.add((Button) mainActivity.findViewById(R.id.oluohume));
                buttons.add((Button) mainActivity.findViewById(R.id.ortohalima));
                buttons.add((Button) mainActivity.findViewById(R.id.suntaar));
                buttons.add((Button) mainActivity.findViewById(R.id.taatta));
                buttons.add((Button) mainActivity.findViewById(R.id.tompo));
                buttons.add((Button) mainActivity.findViewById(R.id.uusAldan));
                buttons.add((Button) mainActivity.findViewById(R.id.uusMaya));
                buttons.add((Button) mainActivity.findViewById(R.id.usuyaana));
                buttons.add((Button) mainActivity.findViewById(R.id.hanalas));
                buttons.add((Button) mainActivity.findViewById(R.id.churapchi));
                buttons.add((Button) mainActivity.findViewById(R.id.ebeenBytantai));
                buttons.add((Button) mainActivity.findViewById(R.id.yakutsk));
                for (Button b : buttons) {
                        b.setOnClickListener(this);
                        b.setBackgroundColor(Color.TRANSPARENT);
                }
        }

        @Override
        public void onClick(View v) {
                switch (v.getId()) {
                        case R.id.abiy :
                                model.setLocation("belaya gora");
                                model.setLocationText("Абыйский улус");
                                break;
                        case R.id.aldan :
                                model.setLocation("aldan");
                                model.setLocationText("Алданский район");
                                break;
                        case R.id.allayiha :
                                model.setLocation("chokurdakh");
                                model.setLocationText("Аллаиховский улус");
                                break;
                        case R.id.amma :
                                model.setLocation("amga");
                                model.setLocationText("Амгинский улус");
                                break;
                        case R.id.anabar :
                                model.setLocation("saskylakh");
                                model.setLocationText("Анабарский национальный улус");
                                break;
                        case R.id.bulun :
                                model.setLocation("tiksi");
                                model.setLocationText("Булунский улус");
                                break;
                        case R.id.uoheeBuluu :
                                model.setLocation("verkhnevilyuysk");
                                model.setLocationText("Верхневилюйский улус");
                                break;
                        case R.id.uoheHalima :
                                model.setLocation("zyryanka");
                                model.setLocationText("Верхнеколымский улус");
                                break;
                        case R.id.uoheJaani:
                                model.setLocation("batagay");
                                model.setLocationText("Верхоянский улус");
                                break;
                        case R.id.buluu :
                                model.setLocation("vilyuysk");
                                model.setLocationText("Вилюйский улус");
                                break;
                        case R.id.gornay :
                                model.setLocation("berdigestyakh");
                                model.setLocationText("Горный улус");
                                break;
                        case R.id.ejigeen :
                                model.setLocation("zhigansk");
                                model.setLocationText("Жиганский национальный эвенкийский улус");
                                break;
                        case R.id.kebeei :
                                model.setLocation("sangar");
                                model.setLocationText("Кобяйский улус");
                                break;
                        case R.id.lenskei :
                                model.setLocation("lensk");
                                model.setLocationText("Ленский район");
                                break;
                        case R.id.meneKanalas :
                                model.setLocation("nizhniy bestyakh");
                                model.setLocationText("Мегино-Кангаласский улус");
                                break;
                        case R.id.mirney :
                                model.setLocation("mirnyy");
                                model.setLocationText("Мирнинский район");
                                break;
                        case R.id.muoma :
                                model.setLocation("khonuu");
                                model.setLocationText("Момский район");
                                break;
                        case R.id.nam :
                                model.setLocation("namtsy");
                                model.setLocationText("Намский улус");
                                break;
                        case R.id.nuorungru :
                                model.setLocation("neryungri");
                                model.setLocationText("Нерюнгринский район");
                                break;
                        case R.id.allaraHalima :
                                model.setLocation("chersky");
                                model.setLocationText("Нижнеколымский улус");
                                break;
                        case R.id.nyurba :
                                model.setLocation("nyurba");
                                model.setLocationText("Нюрбинский улус");
                                break;
                        case R.id.oymyakon :
                                model.setLocation("ust'-nyera");
                                model.setLocationText("Оймяконский улус");
                                break;
                        case R.id.oloon :
                                model.setLocation("olyenyek");
                                model.setLocationText("Оленёкский национальный эвенкийский улус");
                                break;
                        case R.id.oluohume :
                                model.setLocation("olekminsk");
                                model.setLocationText("Олёкминский улус");
                                break;
                        case R.id.ortohalima :
                                model.setLocation("srednekolymsk");
                                model.setLocationText("Среднеколымский улус");
                                break;
                        case R.id.suntaar :
                                model.setLocation("suntar");
                                model.setLocationText("Сунтарский улус");
                                break;
                        case R.id.taatta :
                                model.setLocation("ytyk-kyuyel'");
                                model.setLocationText("Таттинский улус");
                                break;
                        case R.id.tompo :
                                model.setLocation("khandyga");
                                model.setLocationText("Томпонский район");
                                break;
                        case R.id.uusAldan :
                                model.setLocation("borogontsy");
                                model.setLocationText("Усть-Алданский улус");
                                break;
                        case R.id.uusMaya :
                                model.setLocation("ust'-maya");
                                model.setLocationText("Усть-Майский улус");
                                break;
                        case R.id.usuyaana :
                                model.setLocation("deputatskiy");
                                model.setLocationText("Усть-Янский улус");
                                break;
                        case R.id.hanalas :
                                model.setLocation("pokrovsk");
                                model.setLocationText("Хангаласский улус");
                                break;
                        case R.id.churapchi :
                                model.setLocation("churapcha");
                                model.setLocationText("Чурапчинский улус");
                                break;
                        case R.id.ebeenBytantai :
                                model.setLocation("batagay-alyta");
                                model.setLocationText("Эвено-Бытантайский национальный улус");
                                break;
                        case R.id.yakutsk :
                                model.setLocation("yakutsk");
                                model.setLocationText("Якутск");
                                break;
                }
                view.showInfo(false);

                NetworkService.getInstance()
                        .getLocationApi()
                        .getKey(model.getAPIkey(), model.getLocation())
                        .enqueue(new Callback<List<LocationPOJO>>() {
                                @Override
                                public void onResponse(@NonNull Call<List<LocationPOJO>> call, @NonNull Response<List<LocationPOJO>> response) {
                                        if (response.body() != null) {
                                                for (LocationPOJO locationPOJO : response.body()) {
                                                        if (locationPOJO.getAdministrativeArea().getEnglishName().equals("Sakha")) {
                                                                model.setLocationKey(locationPOJO.getKey());
                                                                NetworkService.getInstance()
                                                                        .getConditionsApi()
                                                                        .getConditions(model.getLocationKey(), model.getAPIkey(), "ru")
                                                                        .enqueue(new Callback<List<ConditionsPOJO>>() {
                                                                                @Override
                                                                                public void onResponse(@NonNull Call<List<ConditionsPOJO>> call, @NonNull Response<List<ConditionsPOJO>> response) {
                                                                                        view.showInfo(true);
                                                                                        view.setTemperature(response);
                                                                                        view.setWeather(response);
                                                                                        view.setLastUpdate(response);
                                                                                        view.setLocation(model.getLocationText());
                                                                                }

                                                                                @Override
                                                                                public void onFailure(@NonNull Call<List<ConditionsPOJO>> call, @NonNull Throwable t) {
                                                                                        System.out.println(t.toString());
                                                                                }
                                                                        });
                                                                break;
                                                        }
                                                }
                                        } else {
                                                view.showInfo(true);
                                                view.setLocation("Oops api limit is ded, try again tomorrow");
                                        }
                                }

                                @Override
                                public void onFailure(@NonNull Call<List<LocationPOJO>> call, @NonNull Throwable t) {
                                        System.out.println(t.toString());
                                }
                        });
        }
}
