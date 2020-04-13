package com.cgpanda.easyinvest.WebServices;

import com.cgpanda.easyinvest.Entity.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StoriesApi {
    @GET("")
    Call<List<Story>> getAllStories();
}
