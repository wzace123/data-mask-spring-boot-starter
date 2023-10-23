package org.wz.datamask.entity;

import java.io.Serializable;
import java.util.List;

public class PageWrapper<T> implements Serializable {

    private List<T> content;

    private int total;

    public PageWrapper(List<T> content, int total) {
        this.content = content;
        this.total = total;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
