package com.example.quizapp.entity;

public class Subject {
    private String id;
    private String name;
    private int iconResId; // icon cho môn học

    public Subject(String id, String name, int iconResId) {
        this.id = id;
        this.name = name;
        this.iconResId = iconResId;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public int getIconResId() { return iconResId; }
}