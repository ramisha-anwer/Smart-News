package com.example.smartnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<newsModel> newsModelArrayList;

    public Adapter(Context context, ArrayList<newsModel> newsModelArrayList) {
        this.context = context;
        this.newsModelArrayList = newsModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,webView.class);
                intent.putExtra("url",newsModelArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mPublishedat.setText("Published At: "+newsModelArrayList.get(position).getPublishedAt());
        holder.mAuthor.setText("By "+newsModelArrayList.get(position).getAuthor());
        holder.mContent.setText(newsModelArrayList.get(position).getDescription());
        holder.mHeading.setText(newsModelArrayList.get(position).getTitle());
        Glide.with(context).load(newsModelArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading,mAuthor,mContent,mPublishedat,mCategory;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading= itemView.findViewById(R.id.mainHeading);
            mAuthor= itemView.findViewById(R.id.author);
            mPublishedat= itemView.findViewById(R.id.time);
            mContent= itemView.findViewById(R.id.content);
            imageView=itemView.findViewById(R.id.imageView);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
