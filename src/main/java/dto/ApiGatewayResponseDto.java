package dto;

import java.util.Map;

public class ApiGatewayResponseDto {

	private Boolean isBase64Encoded= null;
	
	private Integer statusCode= null;
	
	private Map<String, String> headers = null;
	
	private String body = null;
	
	public Boolean getIsBase64Encoded() {
		return this.isBase64Encoded;
	}
	
	public void setIsBase64Encoded(Boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}
	
	public Integer getStatusCode() {
		return this.statusCode;
	}
	
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	public Map<String, String> getHeaders() {
		return this.headers;
	}
	
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
}
