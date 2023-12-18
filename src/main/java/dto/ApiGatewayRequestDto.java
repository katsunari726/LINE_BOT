package dto;

import java.util.HashMap;

public class ApiGatewayRequestDto {

	private String body;
	
	private HashMap<String, String> headers;
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	
	public void setHeaders(HashMap<String, String> headers) {
		this.headers = headers;
	}
	
}
