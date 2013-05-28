package com.tutoring.action;

import com.tutoring.biz.TopicBiz;

public class DeleteTopicAction{
	
	
	
	TopicBiz topicBiz;
	
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}


	public String deleteTopicById(int topicid)
	{
		topicBiz.deleteTopic(topicid);
		return "ok";
	}
}
