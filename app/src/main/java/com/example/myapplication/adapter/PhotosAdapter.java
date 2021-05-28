package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ItemClick;
import com.example.myapplication.R;
import com.example.myapplication.model.GetPhotosListModel;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {


    List<GetPhotosListModel> photos;
    Context context;
        ItemClick click;


public PhotosAdapter(List<GetPhotosListModel>photos, Context context){

  this.photos=photos;
  this.context=context;
}


    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_adapter_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder( PhotosAdapter.ViewHolder holder, int position) {
    holder.text_photo.setText(photos.get(position).getTitle());



       Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(photos.get(position).getThumbnailUrl())

                .into(holder.image_photo);


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{


    TextView text_photo;
    ImageView image_photo;
        public ViewHolder( View itemView) {
            super(itemView);
           text_photo=itemView.findViewById(R.id.text_photo) ;
           image_photo=itemView.findViewById(R.id.photo_image);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   click.onClicked();
               }
           });
        }
    }
}
