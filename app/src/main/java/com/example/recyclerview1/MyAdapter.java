package com.example.recyclerview1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyRow> {
    private ArrayList<String> car_name_list;
    private ArrayList<String> car_max_speed_list;

    public MyAdapter(ArrayList<String> car_name_list, ArrayList<String> car_max_speed_list) {
        this.car_max_speed_list = car_max_speed_list;
        this.car_name_list = car_name_list;
    }

    @NonNull
    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        holder.car_name_view.setText(car_name_list.get(position));
        holder.car_max_speed_view.setText(car_max_speed_list.get(position));

    }

    @Override
    public int getItemCount() {
        return car_name_list.size();
    }

    class MyRow extends RecyclerView.ViewHolder {
        TextView car_name_view;
        TextView car_max_speed_view;

        public MyRow(@NonNull View itemView) {
            super(itemView);
            car_name_view = itemView.findViewById(R.id.nameView);
            car_max_speed_view = itemView.findViewById(R.id.maxSpeedView);
        }
    }
}
