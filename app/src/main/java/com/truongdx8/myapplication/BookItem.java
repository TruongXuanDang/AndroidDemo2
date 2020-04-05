package com.truongdx8.myapplication;

public class BookItem {
    public int cover;
    public String name;

    public BookItem(int cover, String name) {
        this.cover = cover;
        this.name = name;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
