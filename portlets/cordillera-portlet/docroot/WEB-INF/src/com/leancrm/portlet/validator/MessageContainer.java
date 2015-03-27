package com.leancrm.portlet.validator;

import java.util.ArrayList;
import java.util.List;

public class MessageContainer {

	protected List<String> messageList;
	
	public void addMessage(String message) {
		if (messageList == null) {
			messageList = new ArrayList<String>();
		}
		
		messageList.add(message);
	}
	
	public List<String> getMessageList() {
		return messageList;
	}
}
