package com.example.demo.base.page;

import java.io.Serializable;

/**
 * @author ansonglin 2018年4月16日 下午6:18:07
 * @Description: 分页查询信息
 * @ClassName: Page
 */
public class Page implements Serializable {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 8589696277823925515L;
    private Integer pageNo;
    private Integer pageSize;

    public Page() {
        // TODO Auto-generated constructor stub
    }

    public Page(Integer pageNo, Integer pageSize) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo == null ? 1 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize == null ? 10 : pageSize;
    }

}
