package com.example.myapplicationcar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplicationcar.databinding.AddcarActivityBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationcar.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView carRv;
    private CarRvAdapter carRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        carRv = binding.carRv;

        carRv.setLayoutManager(new LinearLayoutManager(this));
        carRvAdapter = new CarRvAdapter(CarsPersistantHelper.loadData(this));
        carRv.setAdapter(carRvAdapter);
        ItemTouchHelper callback = new ItemTouchHelper(new SwipeToDeleteCallback(carRvAdapter));
        callback.attachToRecyclerView(carRv);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),AddCarActivity.class);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                binding.fab,
                                "bg"
                        );
                startActivityForResult(i,1,options.toBundle());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1) {
            if(data ==null)
                return;
            Bundle b = data.getExtras();
            Car car = (Car) b.getSerializable("car");
            carRvAdapter.addCar(this,car);
        }
    }
}