package com.samfieldhawb.mvvm.models;

public class NicePlace {
    private String mImageUrl;
    private String mTitle;

    public NicePlace(String imageUrl, String title) {
        mImageUrl = imageUrl;
        mTitle = title;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
