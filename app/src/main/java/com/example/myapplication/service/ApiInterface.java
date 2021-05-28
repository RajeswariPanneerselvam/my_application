package com.example.myapplication.service;

import com.example.myapplication.DataModel;
import com.example.myapplication.model.GetPhotosListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/photos")
    Call<List<GetPhotosListModel>> getPhotosList();

    @POST("users")
    Call<DataModel> createPost(@Body DataModel dataModel);
}
