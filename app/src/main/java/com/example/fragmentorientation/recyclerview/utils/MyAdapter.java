package com.example.fragmentorientation.recyclerview.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentorientation.R;
import com.example.fragmentorientation.api.data.AvengersList;
import com.example.fragmentorientation.api.model.Avenger;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private List<Avenger> avengers;

    public MyAdapter(Context context) {
        this.context = context;
        this.avengers = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(avengers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return avengers.size();
    }

    public void update() {
        this.avengers.clear();
        this.avengers = AvengersList.getAvengers();
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.my_row_text);
        }
    }
}
