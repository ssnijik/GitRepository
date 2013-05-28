package com.tutoring.action;



import java.io.File;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.tutoring.util.StaticUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.TopicBiz;

public class MakeCommentAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TopicBiz topicBiz;
	String pic_sn = null;
	private String content;
	private int topicid;
	private File picture;
	private String pictureFileName;
	private String pictureContentType;
	
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	
	public String execute() throws Exception{
		System.out.println(topicid);
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String useremail = (String)session.get("email");
		
		if(picture!=null)
		{
			String pictureType = pictureFileName.substring(pictureFileName.indexOf('.'));
			if(pictureType.equals(".jpg")||pictureType.equals(".jpeg")||pictureType.equals(".png")||pictureType.equals(".bmp"))
			{
				String filetype = pictureFileName.substring(pictureFileName.indexOf('.'));
				pic_sn = StaticUtil.generateRandomString(10)+filetype;
				//System.out.println(filetype);
				String storePath = ServletActionContext.getServletContext().getRealPath( "/images" )+"/"+pic_sn;
				File storeFile = new File(storePath);
				StaticUtil.copy(picture,storeFile);
			}
			else
				return ERROR;
		}

		topicBiz.makeComment(useremail, content, topicid,pic_sn);
		return SUCCESS;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTopicid() {
		return topicid;
	}

	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContentType() {
		return pictureContentType;
	}
	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}
	
	
	
	
}
