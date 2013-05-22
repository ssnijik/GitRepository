package com.onlinetutoring.utility.page;

import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * 与分页相关的导航Tag. 用于显示上一�?下一�?跳转
 * 
 * 
 * @since 1.0
 */
public class NavigationTag extends TagSupport {
    static final long serialVersionUID = 2372405317744358833L;
//  private static final Log LOGGER = LogFactory.getLog(NavigationTag.class);
    
    /**
     * request 中用于保存Page<E> 对象的变量名,默认为�?page�?
     */
    private String bean = "page";
    
    /**
     * 分页跳转的url地址,此属性必�?
     */
    private String url = null;
    
    /**
     * 是否显示跳转
     */
    private boolean showJump = true;
    
    /**
     * 是否优化分页
     */
    private boolean optimize;
    
    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        Page<?> onePage = (Page<?>)pageContext.getRequest().getAttribute(bean); 
        if (onePage == null) 
            return SKIP_BODY;
        
        url = resolveUrl(url, pageContext);
        Object firstModel = null;
        Object lastModel = null;
        if(onePage.getItems() != null && onePage.getItems().size() > 0) {
            firstModel = onePage.getItems().get(0);
            lastModel = onePage.getItems().get(onePage.getItems().size() - 1);
        }
        try {
            if (onePage.isHasPre()) {
                String preUrl = append(url, "pn", onePage.getIndex() - 1);
                if(optimize && firstModel != null) {
                    preUrl = append(preUrl, PageUtil.getIdName(firstModel), PageUtil.getIdValue(firstModel));
                    preUrl = append(preUrl, "pre", "true");
                }
                writer.print("<a href=\"" + preUrl + "\">上一�?/a>&nbsp;");
            }
            if (onePage.isHasNext()) {
                String nextUrl  = append(url, "pn", onePage.getIndex() + 1);
                if(optimize && lastModel != null) {
                    nextUrl = append(nextUrl, PageUtil.getIdName(lastModel), PageUtil.getIdValue(lastModel));
                }
                writer.print("<a href=\"" + nextUrl + "\">下一�?/a><br/>");
                if(showJump) {
                    writer.print(makeNext(onePage, url));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }
    
    /**
     * 为url 添加上下文环�?如果是登陆用户则还要添加uid参数
     * 
     * @param url
     * @param pageContext
     * @return
     * @throws javax.servlet.jsp.JspException
     */
    private String resolveUrl(String url, javax.servlet.jsp.PageContext pageContext) throws JspException{
        url = UrlSupport.resolveUrl(url, null, pageContext);
        url = url.replaceAll("&pn=\\d*", "").replaceAll("&pre=true", "").replaceAll("&id=\\d*", "");
        return url;
    }
    
    
    private String append(String url, String key, int value) {
        return append(url, key, String.valueOf(value));
    }
    
    /**
     * 为url 参加参数对儿
     * 
     * @param url
     * @param key
     * @param value
     * @return
     */
    private String append(String url, String key, String value) {
        if (url == null || url.trim().length() == 0) {
            return "";
        }
        
        if (url.indexOf("?") == -1) {
            url = url + "?" + key + "=" + value;
        } else {
            url = url + "&amp;" + key + "=" + value;
        }
        
        return url;
    }
    
    
    private String makeNext(Page<?> page, String url) {
        StringBuffer sb = new StringBuffer("");
        sb.append("<input type=\"text\" name=\"pn\" size=\"3\" value=\"1\" format=\"*N\"/>")
            .append(page.getIndex()).append("/").append(page.getContext().getPageCount())
            .append("�?anchor>跳转<go href=\"").append(url).append("\" method=\"get\" accept-charset=\"utf-8\">")
            .append("<postfield name=\"pn\" value=\"$pn\"/></go></anchor><br/>");
        
        return sb.toString();
    }

    /**
     * @return the bean
     */
    public String getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public void setBean(String bean) {
        this.bean = bean;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public void setShowJump(boolean showJump) {
        this.showJump = showJump;
    }

    public void setOptimize(boolean optimize) {
        this.optimize = optimize;
    }
    
}
