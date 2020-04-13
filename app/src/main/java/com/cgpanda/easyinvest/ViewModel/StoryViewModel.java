package com.cgpanda.easyinvest.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cgpanda.easyinvest.Entity.Story;
import com.cgpanda.easyinvest.Repositories.StoriesRepository;

import java.util.List;

public class StoryViewModel extends ViewModel {
    private MutableLiveData<List<Story>> stories;
    private StoriesRepository storiesRepository;

    public void init(){
        if (stories != null)
            return;
        storiesRepository = StoriesRepository.getInstance();
        stories = storiesRepository.getStories();
    }
    public LiveData<List<Story>> getStories(){
        return stories;
    }
}
