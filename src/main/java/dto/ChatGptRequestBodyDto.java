package dto;

import java.util.List;

public class ChatGptRequestBodyDto {

	private String model;
	
	private List<Messages> messages;
	
	private Double temperature;
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public List<Messages> getMessages() {
		return this.messages;
	}
	
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	
	public Double getTemperature() {
		return this.temperature;
	}
	
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	public static class Messages {
		
		private String role;
		
		private String content;
		
		public String getRole() {
			return this.role;
		}
		
		public void setRole(String role) {
			this.role = role;
		}
		
		public String getContent() {
			return this.content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}
		
	}
	
}
