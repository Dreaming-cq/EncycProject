package com.threadnew.pojo;

import java.util.List;

public class EncycResult {
    private long count;
    private List<EncycSolr> list;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<EncycSolr> getList() {
        return list;
    }

    public void setList(List<EncycSolr> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "EncycResult{" +
                "count=" + count +
                ", list=" + list +
                '}';
    }
}
