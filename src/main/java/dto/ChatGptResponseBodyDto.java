package dto;

import java.util.List;

public class ChatGptResponseBodyDto {

	private String id;
	
	private String object;
	
	private Long created;
	
	private String model;
	
	private String system_fingerprint;
	
	private Usage usage;
	
	private List<Choices> choices;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getObject() {
		return this.object;
	}
	
	public void setObject(String object) {
		this.object = object;
	}
	
	public Long getCreated() {
		return this.created;
	}
	
	public void setCreated(Long created) {
		this.created = created;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSystem_fingerprint() {
		return this.system_fingerprint;
	}
	
	public void setSystem_fingerprint(String system_fingerprint) {
		this.system_fingerprint = system_fingerprint;
	}
	
	public Usage getUsage() {
		return this.usage;
	}
	
	public void setUsage(Usage usage) {
		this.usage = usage;
	}
	
	public List<Choices> getChoices() {
		return this.choices;
	}
	
	public void setChoices(List<Choices> choices) {
		this.choices = choices;
	}
	
	public static class Usage {
		
		private Long prompt_tokens;
		
		private Long completion_tokens;
		
		private Long total_tokens;
		
		public Long getPrompt_tokens() {
			return this.prompt_tokens;
		}
		
		public void setPrompt_tokens(Long prompt_tokens) {
			this.prompt_tokens = prompt_tokens;
		}
		
		public Long getCompletion_tokens() {
			return this.completion_tokens;
		}
		
		public void setCompletion_tokens(Long completion_tokens) {
			this.completion_tokens = completion_tokens;
		}
		
		public Long getTotal_tokens() {
			return this.total_tokens;
		}
		
		public void setTotal_tokens(Long total_tokens) {
			this.total_tokens = total_tokens;
		}
		
	}
	
	public static class Choices {
		
		private Long index;
		
		private Message message;
		
		private String logprobs;
		
		private String finish_reason;
		
		public Long getIndex() {
			return this.index;
		}
		
		public void setIndex(Long index) {
			this.index = index;
		}
		
		public Message getMessage() {
			return this.message;
		}
		
		public void setMessage(Message message) {
			this.message = message;
		}
		
		public String getLogprobs() {
			return this.logprobs;
		}
		
		public void setLogprobs(String logprobs) {
			this.logprobs = logprobs;
		}
		
		public String getFinish_reason() {
			return this.finish_reason;
		}
		
		public void setFinish_reason(String finish_reason) {
			this.finish_reason = finish_reason;
		}
		
		public static class Message {
			
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
	
}
