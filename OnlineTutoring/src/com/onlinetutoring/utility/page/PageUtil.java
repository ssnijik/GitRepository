package com.onlinetutoring.utility.page;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.onlinetutoring.utility.KeySynchronizer;


/**
 * @author  Zhang Kaitao
 * @version 1.0, Sep 17, 2010
 * @since 1.0
 */
public class PageUtil {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PageUtil.class);
    /**
     * 获取主键时缓�?
     */
    private static Map<Class<?>, Field> classPKMap = new WeakHashMap<Class<?>, Field>();
    
    /**
     * 不关心�?记录�?
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public static int getPageStart(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }
    
    /**
     * 计算分页获取数据时游标的起始位置
     * 
     * @param totalCount �?��记录总和
     * @param pageNumber 页码,�?�?��
     * @return
     */
    public static int getPageStart(int totalCount, int pageNumber, int pageSize) {
        int start = (pageNumber - 1) * pageSize;
        if (start >= totalCount) {
            start = 0;
        }

        return start;
    }

    /**
     * 构�?分页对象
     * 
     * @param totalCount 满足条件的所有记录�?�?
     * @param pageNumber 本次分页的页�?
     * @param items
     * @return
     */
    public static <E> Page<E> getPage(int totalCount, int pageNumber, List<E> items, int pageSize) {
        IPageContext<E> pageContext = new QuickPageContext<E>(totalCount, pageSize, items);
        return pageContext.getPage(pageNumber);
    }
    
    public static Field getPkField(Class<?> cls) {
        Field pkField = classPKMap.get(cls);
        if(pkField == null) {
            synchronized (KeySynchronizer.acquire(cls)) {
                Field[] fields = cls.getDeclaredFields();
                for(Field field : fields) {
                    if(field.isAnnotationPresent(Id.class)) {
                        pkField = field;
                        pkField.setAccessible(true);
                        classPKMap.put(cls, pkField);
                    }
                }
            }
        }
        if(pkField == null) {
            LOGGER.error("page error,{} : pk null", cls);
        }
        return pkField;
    }
    
    public static <T> String getIdValue(T obj) {
        if(obj == null) {
            return "";
        }
        String retVal = "";
        Field pkField = getPkField(obj.getClass());
        try {
            retVal = pkField.get(obj).toString();
        } catch (Exception e) {
            LOGGER.error("page error,{} : get id value", obj);
        }
        return retVal;
    }
    public static <T> String getIdName(T obj) {
        if(obj == null) {
            return "";
        }
        String retVal = "";
        Field pkField = getPkField(obj.getClass());
        try {
            retVal = pkField.getName();
        } catch (Exception e) {
            LOGGER.error("page error,{} : get id name", obj);
        }
        return retVal;
    }
}
