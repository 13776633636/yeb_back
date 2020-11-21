package com.xxxx.server.base;

import io.swagger.models.auth.In;

public class BaseQuery {
    //当前页面
    private Integer currentPage = 1;
    //每页大小

    private Integer size = 10;

    public BaseQuery() {
    }

    public BaseQuery(Integer currentPage, Integer size) {
        this.currentPage = currentPage;
        this.size = size;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
