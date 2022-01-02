package com.example.myapplicationcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationcar.databinding.AddcarActivityBinding;

public class AddCarActivity extends AppCompatActivity {

    private AddcarActivityBinding binding;
    private EditText carBrandEt,carModelEt,carYearEt,carPriceEt,carPhotoIdEt;
    private Button addCarButton,backButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AddcarActivityBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        carBrandEt = binding.carBrandEt;
        carModelEt = binding.carModelEt;
        carYearEt = binding.carYearEt;
        carPriceEt = binding.carPriceEt;
        carPhotoIdEt = binding.carPhotoEt;

        addCarButton = binding.addCarButton;
        backButton = binding.backAddcar;

        addCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car car = new Car(R.drawable.bmw,
                        carBrandEt.getText().toString(),
                        carModelEt.getText().toString(),
                        carYearEt.getText().toString(),
                        carPriceEt.getText().toString());
                Intent i = new Intent();
                i.putExtra("car",car);
                setResult(1,i);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
