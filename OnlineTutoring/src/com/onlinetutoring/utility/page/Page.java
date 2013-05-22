package com.onlinetutoring.utility.page;

import java.util.Collections;
import java.util.List;


/**
 * 表示分页中的�?���?
 * 
 * @author  Zhang Kaitao
 */
public class Page<E> {
    private boolean hasPre;//是否首页
    private boolean hasNext;//是否尾页
    private List<E> items;//当前页包含的记录列表
    private int index;//当前页页�?起始�?)
    private IPageContext<E> context;
    
    public IPageContext<E> getContext() {
        return this.context;
    }

    public void setContext(IPageContext<E> context) {
        this.context = context;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isHasPre() {
        return this.hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<E> getItems() {
        return this.items == null ? Collections.<E>emptyList() : this.items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
    
}
