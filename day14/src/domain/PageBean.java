package domain;

import java.util.List;

/**
 * Created by lwd on 2017/8/30.
 */
public class PageBean<T> {
    private List<T> list;//当前页面内容
    private int currPage;//当前页码
    private int pageSize;//每页显示的条数
    private int totalCount;//总条数
    private int totalPage;//总页数

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    //获取总页数
    public int getTotalPage() {
        return (int) Math.ceil(totalCount*1.0/pageSize);
    }
    public PageBean(){}

    public PageBean(List<T> list, int currPage, int pageSize, int totalCount) {
        this.list = list;
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }
}
