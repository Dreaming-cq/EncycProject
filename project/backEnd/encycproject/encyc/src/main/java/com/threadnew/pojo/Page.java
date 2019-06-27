package com.threadnew.pojo;

public class Page {
    private String title;
    private int start;
    private int col;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Page{" +
                "title='" + title + '\'' +
                ", start=" + start +
                ", col=" + col +
                '}';
    }
}
