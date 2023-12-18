package dto;

import java.util.List;

import dto.LineRequestBodyDto.Event.Message;

public class LineResponseBodyDto {

	private String replyToken;
	
	private List<Message> messages;
	
	public String getReplyToken() {
		return this.replyToken;
	}
	
	public void setReplyToken(String replyToken) {
		this.replyToken = replyToken;
	}
	
	public List<Message> getMessages() {
		return this.messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
}
