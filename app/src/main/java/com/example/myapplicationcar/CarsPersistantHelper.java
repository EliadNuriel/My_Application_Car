package com.example.myapplicationcar;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.security.CryptoPrimitive;
import java.util.ArrayList;
import java.util.List;

public class CarsPersistantHelper {
    public static final String CARS_SHARED_PREFERENCES = "CARS";
    public static final String CARS_LIST_REF = "CARS_LIST";
    public static void storeData(Context context, List<Car> carList) {
        SharedPreferences sp = context.getSharedPreferences(CARS_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        String json = new Gson().toJson(carList);
        sp.edit()
                .putString(CARS_LIST_REF,json)
                .apply();
    }
    public static List<Car> loadData(Context context) {
        SharedPreferences sp = context.getSharedPreferences(CARS_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        String carListJson = sp.getString(CARS_LIST_REF,null);
        List<Car> cars;
        if(carListJson!=null) {
            Type type = new TypeToken<List<Car>>(){}.getType();
            cars = new Gson().fromJson(carListJson,type);
            if(!cars.isEmpty()) {
                return cars;
            }
        }
            cars = new ArrayList<>();
            // DEFAULT CARS
            Car c1 = new Car(R.drawable.fiat, "Fiat", "S45", "1999", "2000");
            Car c2 = new Car(R.drawable.audi, "Audi", "A1", "2012", "130000");
            Car c3 = new Car(R.drawable.bmw, "BMW", "I8", "2022", "365000");
            Car c4 = new Car(R.drawable.tesla, "Tesla", "X", "2021", "250000");
            Car c5 = new Car(R.drawable.toyota, "Toyota", "CHR", "2001", "10000");
            Car c6 = new Car(R.drawable.mini, "Mini-Cooper", "Model 1", "2020", "50000");
            Car c7 = new Car(R.drawable.kia, "Kia", "Picanto", "2019", "77000");
            Car c8 = new Car(R.drawable.mercedes, "Mercedes", "A", "2021", "135000");

            cars.add(c1);
            cars.add(c2);
            cars.add(c3);
            cars.add(c4);
            cars.add(c5);
            cars.add(c6);
            cars.add(c7);
            cars.add(c8);
            return cars;
    }

}
