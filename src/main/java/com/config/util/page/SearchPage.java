package com.config.util.page;

import com.config.util.global.GlobalConst;

/**
 * Created by LiNan on 2018-04-09.
 * Description: 所有需要实现分页功能需要继承此类
 */
public class SearchPage {
    private int total = 0;//总数
    private int page = 1; //当前页面
    private int limit = GlobalConst.pageSize;//页面容量
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
