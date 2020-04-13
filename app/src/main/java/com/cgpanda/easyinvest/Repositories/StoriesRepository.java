package com.cgpanda.easyinvest.Repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cgpanda.easyinvest.Entity.Story;
import com.cgpanda.easyinvest.WebServices.StoriesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StoriesRepository {
    private static StoriesRepository instance;
    private ArrayList<Story> dataSet = new ArrayList<>();
    private StoriesApi storiesApi;
    private static final String TAG = "StoriesRepository";

    public StoriesRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.storiesApi = retrofit.create(StoriesApi.class);
    }

    public static StoriesRepository getInstance(){
        if(instance == null)
            instance = new StoriesRepository();
        return instance;
    }

    public MutableLiveData<List<Story>> getStories(){
        final MutableLiveData<List<Story>> data = new MutableLiveData<>();
        Call<List<Story>> stories = storiesApi.getAllStories();
        stories.enqueue(new Callback<List<Story>>() {
            @Override
            public void onResponse(Call<List<Story>> call, Response<List<Story>> response) {
                if(response.isSuccessful() && response.body() != null) {
                    dataSet.addAll(response.body());
                    data.setValue(dataSet);
                    Log.d(TAG, "onResponse: Success");
                }
            }

            @Override
            public void onFailure(Call<List<Story>> call, Throwable t) {
                Log.d(TAG, "onFailure: Fail");
            }
        });
        return data;
    }
}
