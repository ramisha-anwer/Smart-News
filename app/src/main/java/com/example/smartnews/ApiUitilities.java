package com.example.smartnews;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUitilities {
    private static Retrofit retrofit=null;

    public static ApiInterface getInterface(){

        if (retrofit==null){
        retrofit=new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
  return retrofit.create(ApiInterface.class);
    }
}
