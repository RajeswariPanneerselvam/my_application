package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.adapter.NewDesignAdapter;
import com.example.myapplication.adapter.PhotosAdapter;
import com.example.myapplication.model.GetPhotosListModel;
import com.example.myapplication.service.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPhotosActivity extends AppCompatActivity implements ItemClick {


    RecyclerView recyclerView;
    List<GetPhotosListModel>photos;
    PhotosAdapter adapter;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    boolean loading = true;
    LinearLayoutManager linearLayoutManager;
    int count = 0;

    private ProgressBar loadingPB;
    private NestedScrollView nestedSV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_photos);

        recyclerView=findViewById(R.id.recyclerView);
        nestedSV=findViewById(R.id.nested_view);
        loadingPB=findViewById(R.id.progressBar);

       linearLayoutManager= new LinearLayoutManager(getApplicationContext());

       recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        getPhotos();
      //  adapter=new  PhotosAdapter(photos,GetPhotosActivity.this);
       // recyclerView.setAdapter(adapter);
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // on scroll change we are checking when users scroll as bottom.
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    // in this method we are incrementing page number,
                    // making progress bar visible and calling get data method.
                    count++;
                    // on below line we are making our progress bar visible.
                    loadingPB.setVisibility(View.VISIBLE);
                    if (count < 20) {
                        // on below line we are again calling
                        // a method to load data in our array list.
                        getPhotos();
                    }
                }
            }
        });


    }

    private void getPhotos() {



    ProgressDialog progressDoalog = new ProgressDialog(GetPhotosActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface service = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<GetPhotosListModel>> call = service.getPhotosList();
        call.enqueue(new Callback<List<GetPhotosListModel>>() {
            @Override
            public void onResponse(Call<List<GetPhotosListModel>> call, Response<List<GetPhotosListModel>> response) {
                progressDoalog.dismiss();

                photos=response.body();
                adapter=new  PhotosAdapter(photos,GetPhotosActivity.this);
                recyclerView.setAdapter(adapter);
                //adapter.notifyDataSetChanged();
               // loading=true;

            }

            @Override
            public void onFailure(Call<List<GetPhotosListModel>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(GetPhotosActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClicked() {

    }
}
