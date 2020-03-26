package com.example.searchviewws.services;

import com.example.searchviewws.entities.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CountryService {

    @GET("countries/{keyword}")
    Call<List<Countries>> search(@Path("keyword") String keyword);
}
