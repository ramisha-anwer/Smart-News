package com.example.smartnews;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private int totalResults;
    private ArrayList<newsModel> articles;

    public mainNews(String status, int totalResults, ArrayList<newsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<newsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<newsModel> articles) {
        this.articles = articles;
    }
}
