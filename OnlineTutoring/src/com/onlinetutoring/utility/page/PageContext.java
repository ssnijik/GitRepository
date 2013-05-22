package com.onlinetutoring.utility.page;

import java.util.ArrayList;
import java.util.List;


/**
 * 查询返回�?��记录的分页实�?
 * 
 * @version 1.0, 2010-4-3
 */
public class PageContext<E> implements IPageContext<E>{

    private int pageSize;//每页包含的记录数
    private List<E> items;
    
    public PageContext(List<E> items) {
        this(items, DEFAULT_PAGE_SIZE);
    }
    
    public PageContext(List<E> items, int pageSize) {
        if (items == null) {
            throw new IllegalArgumentException("Items should not be null!");
        }
        this.items = items;
        this.pageSize = pageSize;
    }
    
    public Page<E> getPage(int index) {
        Page<E> page = new Page<E>();
        List<E> pageItems = new ArrayList<E>();
        page.setContext(this);
        page.setHasNext(index < getPageCount());
        page.setHasPre(index > 1);
        page.setIndex(index);
        
        List<E> items = getItems();
        int total = items.size();
        int start = (index - 1) * getPageSize();
        if (start > total - 1) {
            start = 0;
            page.setHasPre(false);
            page.setIndex(1);
        }
        int toIndex = start + getPageSize();
        if (toIndex > total) {
            toIndex = total;
        }
        
        pageItems = items.subList(start, toIndex);
        page.setItems(pageItems);
        return page;
    }

    /**
     * 计算总页�?
     * 
     * @return
     */
    public int getPageCount() {
        int size = getItems().size();
        int div = size / getPageSize();
        int result = (size % getPageSize() == 0) ? div : div + 1;
        
        return result;
    }

    public int getPageSize() {
        if (this.pageSize <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<E> getItems() {
        return this.items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
    
    public int getTotal() {
        return getItems().size();
    }
    
}
