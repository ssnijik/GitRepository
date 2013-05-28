package com.test.pushlet;

import java.io.Serializable;
import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class TestPushlet extends EventPullSource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected long getSleepTime() {
		// TODO Auto-generated method stub
		
		return 1000;
	}

	@Override
	protected Event pullEvent() {
		// TODO Auto-generated method stub
		Event event = Event.createDataEvent("/test2/he");
		event.setField("he", "hello");
		return event;
	}

}
