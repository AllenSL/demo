package com.example.demo.base.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author ansonglin  2018年4月16日 下午6:15:47
 * @Description: 返回分页结果
 * @ClassName: PageDTO
 */
public class PageDTO<T> implements Serializable {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 5250634210833032715L;
    private List<T> list;
    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageDTO() {
        // TODO Auto-generated constructor stub
    }

    public PageDTO(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }
}
