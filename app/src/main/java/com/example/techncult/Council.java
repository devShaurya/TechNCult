package com.example.techncult;

public class Council {
    String title,club,email,facebook,img,info,secName,secPhoto,web,youtube;
    public Council(){

    }
    public Council(String title, String club, String email, String facebook, String img,
                   String info, String secName, String secPhoto, String web, String youtube) {
        this.title = title;
        this.club = club;
        this.email = email;
        this.facebook = facebook;
        this.img = img;
        this.info = info;
        this.secName = secName;
        this.secPhoto = secPhoto;
        this.web = web;
        this.youtube = youtube;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public String getSecPhoto() {
        return secPhoto;
    }

    public void setSecPhoto(String secPhoto) {
        this.secPhoto = secPhoto;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
