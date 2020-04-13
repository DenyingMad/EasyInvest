package com.cgpanda.easyinvest.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cgpanda.easyinvest.Entity.Story;
import com.cgpanda.easyinvest.R;

import java.util.ArrayList;
import java.util.List;

public class StoriesRecyclerViewAdapter extends RecyclerView.Adapter<StoriesRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Story> storyList = new ArrayList<>();

    public StoriesRecyclerViewAdapter(Context context, List<Story> storyList) {
        this.context = context;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(storyList.get(position).getTitle());
        RequestOptions defaultOptions = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(context)
                .setDefaultRequestOptions(defaultOptions)
                .load(storyList.get(position).getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.story_title);
            image = itemView.findViewById(R.id.story_image);
        }
    }
}
