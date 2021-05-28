package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.ViewHolder> {
    public TutorialAdapter(Context context) {
    }

    @NonNull
    @NotNull
    @Override
    public TutorialAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.tutorial_adapter_layout, parent, false);
        TutorialAdapter.ViewHolder viewHolder = new TutorialAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TutorialAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

 public class ViewHolder extends RecyclerView.ViewHolder{


     public ViewHolder( View itemView) {
         super(itemView);


     }
 }
 }

