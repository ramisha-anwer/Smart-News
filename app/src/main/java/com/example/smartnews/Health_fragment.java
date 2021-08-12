package com.example.smartnews;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Health_fragment extends Fragment {
    String api= "8d0770f335424606a3a0be143fd26f08";
    private RecyclerView recyclerViewhealth;
    Adapter adapter;
    ArrayList<newsModel> newsModelArrayList;
    String country="us";
    String category="health";

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.healthfragment,null);
        recyclerViewhealth=view.findViewById(R.id.healthRV);
        newsModelArrayList= new ArrayList<>();
        recyclerViewhealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),newsModelArrayList);
        recyclerViewhealth.setAdapter(adapter);

        findNews();

        return  view;

    }
    private void findNews() {
        ApiUitilities.getInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    newsModelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }



    }

