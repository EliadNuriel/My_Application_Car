package com.example.myapplicationcar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarRvAdapter extends RecyclerView.Adapter<CarRvAdapter.ViewHolder> {
    private List<Car> carList;

    public CarRvAdapter(List<Car> carList) {
        this.carList = carList;
    }

    public void addCar(Context context, Car car)
    {
        carList.add(car);
        notifyDataSetChanged();
        CarsPersistantHelper.storeData(context,carList);
    }

    public void deleteCar(Context context,int position)
    {
        carList.remove(position);
        notifyDataSetChanged();
        CarsPersistantHelper.storeData(context,carList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item,parent,false);
        return new ViewHolder(v);
     }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = carList.get(position);
        holder.carImageView.setImageResource(car.getPhotoResource());
        holder.carNameTv.setText(car.getBrand());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),CarDetailsActivity.class);
                i.putExtra("car",car);
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) v.getContext(),
                                holder.carImageView,
                                "avatarTrasnition"
                        );
                v.getContext().startActivity(i,options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView carNameTv;
        private ImageView carImageView;
        private CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carNameTv = itemView.findViewById(R.id.car_item_name);
            carImageView = itemView.findViewById(R.id.car_item_image);
            cardView = itemView.findViewById(R.id.car_card);
        }
    }

}
