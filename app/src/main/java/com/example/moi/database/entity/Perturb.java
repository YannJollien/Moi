package com.example.moi.database.entity;

public class Perturb {

    private String title;
    private String date;
    private String text;

    public Perturb(String title, String date, String text){
        this.title=title;
        this.date=date;
        this.text=text;
    }

    public Perturb(){

    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
