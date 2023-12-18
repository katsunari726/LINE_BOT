package dto;

import java.util.List;

public class LineRequestBodyDto {
	
	private String destination;

	private List<Event> events;
	
	public List<Event> getEvents() {
		return this.events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public static class Event {
		
	    private String type;
	    
	    private String mode;
	    
	    private Long timestamp;
	    
	    private Source source;
	    
	    private String webhookEventId;
	    
	    private DeliveryContext deliveryContext;
	    
	    private String replyToken;
	    
	    private Message message; 
	    
	    public String getType() {
			return this.type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		public String getMode() {
			return this.mode;
		}
		
		public void setMode(String mode) {
			this.mode = mode;
		}
		
		public Long getTimestamp() {
			return this.timestamp;
		}
		
		public void setTimestamp(Long timestamp) {
			this.timestamp = timestamp;
		}
		
		public Source getSource() {
			return this.source;
		}
		
		public void setSource(Source source) {
			this.source = source;
		}
		
		public String getWebhookEventId() {
			return this.webhookEventId;
		}
		
		public void setWebhookEventId(String webhookEventId) {
			this.webhookEventId = webhookEventId;
		}
		
		public DeliveryContext getDeliveryContext() {
			return this.deliveryContext;
		}
		
		public void setDeliveryContext(DeliveryContext deliveryContext) {
			this.deliveryContext = deliveryContext;
		}
		
		public String getReplyToken() {
			return this.replyToken;
		}
		
		public void setReplyToken(String replyToken) {
			this.replyToken = replyToken;
		}
		
		public Message getMessage() {
			return this.message;
		}
		
		public void setMessage(Message message) {
			this.message = message;
		}
	    
	    public static class Source {
	    	
	    	private String type;
	    	
	    	private String userId;
	    	
	    	private String groupId;
	    	
	    	private String roomId;
	    	
	    	public String getType() {
				return this.type;
			}
			
			public void setType(String type) {
				this.type = type;
			}
			
			public String getUserId() {
				return this.userId;
			}
			
			public void setUserId(String userId) {
				this.userId = userId;
			}
			
			public String getGroupId() {
				return this.groupId;
			}
			
			public void setGroupId(String groupId) {
				this.groupId = groupId;
			}
			
			public String getRoomId() {
				return this.roomId;
			}
			
			public void setRoomId(String roomId) {
				this.roomId = roomId;
			}
	    	
	    }
	    
	    public static class DeliveryContext {
	    	
	    	private Boolean isRedelivery;
	    	
	    	public Boolean getIsRedelivery() {
				return this.isRedelivery;
			}
			
			public void setIsRedelivery(Boolean isRedelivery) {
				this.isRedelivery = isRedelivery;
			}
	    	
	    }
	    
	    public static class Message {
	    	
	    	private String id;
	    	
	    	private String type;
	    	
	    	private String quoteToken;
	    	
	    	private String text;
	    	
	    	private List<Emoji> emojis;
	    	
	    	private Mention mention;
	    	
	    	private String quotedMessageId;
	    	
	    	public String getId() {
				return this.id;
			}
			
			public void setId(String id) {
				this.id = id;
			}
	    	
	    	public String getType() {
				return this.type;
			}
			
			public void setType(String type) {
				this.type = type;
			}
			
			public String getQuoteToken() {
				return this.quoteToken;
			}
			
			public void setQuoteToken(String quoteToken) {
				this.quoteToken = quoteToken;
			}
			
			public String getText() {
				return this.text;
			}
			
			public void setText(String text) {
				this.text = text;
			}
			
			public List<Emoji> getEmojis() {
				return this.emojis;
			}
			
			public void setEmojis(List<Emoji> emojis) {
				this.emojis = emojis;
			}
			
			public Mention getMention() {
				return this.mention;
			}
			
			public void setMention(Mention mention) {
				this.mention = mention;
			}
			
			public String getQuotedMessageId() {
				return this.quotedMessageId;
			}
			
			public void setQuotedMessageId(String quotedMessageId) {
				this.quotedMessageId = quotedMessageId;
			}
	    	
	    	public static class Emoji {
	    		
	    		private Long index;
	    		
	    		private Long length;
	    		
	    		private String productId;
	    		
	    		private String emojiId;
	    		
	    		public Long getIndex() {
					return this.index;
				}
				
				public void setIndex(Long index) {
					this.index = index;
				}
				
				public Long getLength() {
					return this.length;
				}
				
				public void setLength(Long length) {
					this.length = length;
				}
				
				public String getProductId() {
					return this.productId;
				}
				
				public void setProductId(String productId) {
					this.productId = productId;
				}
				
				public String getEmojiId() {
					return this.emojiId;
				}
				
				public void setEmojiId(String emojiId) {
					this.emojiId = emojiId;
				}
	    		
	    	}
	    	
	    	public static class Mention {
    			
    			List<Mentionees> mentionees;
    			
    			public List<Mentionees> getMentionees() {
					return this.mentionees;
				}
				
				public void setMentionees(List<Mentionees> mentionees) {
					this.mentionees = mentionees;
				}
    			
    			public static class Mentionees {
    				
    				private Long index;
    				
    				private Long length;
    				
    				private String type;
    				
    				private String userId;
    				
    				public Long getIndex() {
    					return this.index;
    				}
    				
    				public void setIndex(Long index) {
    					this.index = index;
    				}
    				
    				public Long getLength() {
    					return this.length;
    				}
    				
    				public void setLength(Long length) {
    					this.length = length;
    				}
    				
    				public String getType() {
    					return this.type;
    				}
    				
    				public void setType(String type) {
    					this.type = type;
    				}
    				
    				public String getUserId() {
    					return this.userId;
    				}
    				
    				public void setUserId(String userId) {
    					this.userId = userId;
    				}
    				
    			}
    			
    		}
	    	
	    }
	    
	}
	
}
