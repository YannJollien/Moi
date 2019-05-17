package com.example.moi.database.entity;

public class Mood {

    private String mood;
    private String date;
    private String text;

    public Mood(){

    }

    public Mood(String mood, String date, String text) {
        this.mood = mood;
        this.date = date;
        this.text = text;
    }

    public String getMood() {
        return mood;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
