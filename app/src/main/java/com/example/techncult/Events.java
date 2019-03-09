package com.example.techncult;

import com.google.firebase.Timestamp;

public class Events {
    String title,photo,info,venue;
    Timestamp time;

    public Events() {
    }

    public Events(String title, String photo, String info, String venue, Timestamp time) {
        this.title = title;
        this.photo = photo;
        this.info = info;
        this.venue = venue;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
