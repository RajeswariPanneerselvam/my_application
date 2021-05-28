package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ItemClick;
import com.example.myapplication.R;

public class NewDesignAdapter extends RecyclerView.Adapter<NewDesignAdapter.ViewHolder> {
    ItemClick mItemClick;
    public NewDesignAdapter(ItemClick itemClick) {
        this.mItemClick = itemClick;

    }
    @Override
    public NewDesignAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( NewDesignAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {




        TextView android_tutorial;
        public ViewHolder(View itemView) {
            super(itemView);

            android_tutorial=itemView.findViewById(R.id.text_tutorial);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClick.onClicked();
                }
            });
        }

    }
}
