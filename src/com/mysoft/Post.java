package com.mysoft;

public class Post {
    int id;
    String txt;

    public Post(int id, String txt) {
        this.id = id;
        this.txt = txt;
    }

    public int getId() {
        return id;
    }

    public String getTxt() {
        return txt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "" + "id=" + id + ", txt = " + txt + "";
    }
}
