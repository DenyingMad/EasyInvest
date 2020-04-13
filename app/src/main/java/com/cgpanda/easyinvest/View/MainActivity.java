package com.cgpanda.easyinvest.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cgpanda.easyinvest.Adapters.StoriesRecyclerViewAdapter;
import com.cgpanda.easyinvest.Entity.Story;
import com.cgpanda.easyinvest.R;
import com.cgpanda.easyinvest.ViewModel.StoryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView storiesRecyclerView;
    private StoriesRecyclerViewAdapter storiesRecyclerViewAdapter;
    private StoryViewModel storyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storiesRecyclerView = findViewById(R.id.stories_recyclerview);

        storyViewModel = ViewModelProviders.of(this).get(StoryViewModel.class);
        storyViewModel.init();
        storyViewModel.getStories().observe(this, new Observer<List<Story>>() {
            @Override
            public void onChanged(List<Story> stories) {
                storiesRecyclerViewAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        storiesRecyclerViewAdapter = new StoriesRecyclerViewAdapter(this, storyViewModel.getStories().getValue());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        storiesRecyclerView.setLayoutManager(layoutManager);
        storiesRecyclerView.setAdapter(storiesRecyclerViewAdapter);
    }
}
