package com.example.fragmentorientation.api;

import com.example.fragmentorientation.api.model.Avenger;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAvengersApi {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel/")
    Call<List<Avenger>> getAvengersList();
}
