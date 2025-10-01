package com.example.ecommerceapp.model;

public class VideoModel {
    private String videoUrl;
    private String username;
    private String description;
    private String profileImage; // optional

    public VideoModel(String videoUrl, String username, String description, String profileImage) {
        this.videoUrl = videoUrl;
        this.username = username;
        this.description = description;
        this.profileImage = profileImage;
    }

    public String getVideoUrl() { return videoUrl; }
    public String getUsername() { return username; }
    public String getDescription() { return description; }
    public String getProfileImage() { return profileImage; }
}

