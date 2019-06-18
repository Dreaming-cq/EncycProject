package com.threadnew.pojo;


import java.io.Serializable;

/*
     此pojo 只服务于solr
 */


public class EncycSolr implements Serializable {
    private int id;
    private String title;
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EncycSolr{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
