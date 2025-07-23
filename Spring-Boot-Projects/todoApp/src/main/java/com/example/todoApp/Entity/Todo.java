package com.example.todoApp.Entity;

public class Todo {

    private int id;

    private String title;
    private String desc;

    public Todo(String desc, String title, int id) {
        this.desc = desc;
        this.title = title;
        this.id = id;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
