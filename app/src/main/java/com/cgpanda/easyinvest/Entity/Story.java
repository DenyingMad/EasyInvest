package com.cgpanda.easyinvest.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Story {
    //TODO Разбить каждую историю на эпизоды
    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("story_name")
    @Expose
    private String title;

    @SerializedName("story_image_url")
    @Expose
    private String imageUrl; //TODO Заменить url на картинку

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
