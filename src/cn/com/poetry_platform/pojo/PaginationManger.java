package cn.com.poetry_platform.pojo;

import java.util.List;

public class PaginationManger {

    /**
     * 总记录数
     */
    private int counts;

    /**
     * 页大小（每页显示多少条）
     */
    private int pageSize;

    /**
     * 页码：第几页。
     */
    private int pageNo;

    /**
     * 总页数。
     */
    private int pages;

    /**
     * 是不是第一页
     */
    private boolean firstPage;

    /**
     * 是不是最后一页。
     */
    private boolean lastPage;

    /**
     * 结果集
     */
    private List<?> result;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "counts=" + counts +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", pages=" + pages +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", result=" + result +
                '}';
    }
}
