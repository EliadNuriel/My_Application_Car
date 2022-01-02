package com.example.myapplicationcar;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationcar.databinding.CardetailsActivityBinding;

public class CarDetailsActivity extends AppCompatActivity {
    private CardetailsActivityBinding binding;
    private ImageView carImage;
    private TextView carModelTv,carBrandTv,carPriceTv,carYearTv;
    private Button backButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CardetailsActivityBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        carImage = binding.carImage;
        carModelTv = binding.carModelTv;
        carPriceTv = binding.carPriceTv;
        carYearTv = binding.carYearTv;
        carBrandTv = binding.carBrandTv;
        Intent i = getIntent();
        if(i != null && i.getExtras()!=null) {
            Car car = (Car) i.getExtras().getSerializable("car");
            carImage.setImageResource(car.getPhotoResource());
            carModelTv.setText(car.getModel());
            carPriceTv.setText(car.getPrice() + "$");
            carYearTv.setText(car.getYear());
            carBrandTv.setText(car.getBrand());

        }
        backButton = binding.backDetails;

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
