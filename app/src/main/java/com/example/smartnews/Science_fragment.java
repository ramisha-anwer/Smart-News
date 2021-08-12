package com.example.smartnews;

import android.os.Bundle;
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

public class Science_fragment extends Fragment {
    String api= "8d0770f335424606a3a0be143fd26f08";
    private RecyclerView recyclerViewscience;
    Adapter adapter;
    ArrayList<newsModel> newsModelArrayList;
    String country="us";
    String category="science";

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.sciencefragment,null);
        recyclerViewscience=view.findViewById(R.id.scienceRV);
        newsModelArrayList= new ArrayList<>();
        recyclerViewscience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),newsModelArrayList);
        recyclerViewscience.setAdapter(adapter);

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
