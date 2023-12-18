package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ChatGptRequestBodyDto;
import dto.ChatGptResponseBodyDto;
import dto.LineRequestBodyDto;
import dto.ApiGatewayResponseDto;
import dto.LineResponseBodyDto;
import dto.ApiGatewayRequestDto;
import dto.ChatGptRequestBodyDto.Messages;
import dto.LineRequestBodyDto.Event;
import dto.LineRequestBodyDto.Event.Message;

public class App implements RequestHandler<ApiGatewayRequestDto, ApiGatewayResponseDto> {

	@Override
	public ApiGatewayResponseDto handleRequest(ApiGatewayRequestDto request, Context context) {

		// ログ出力用のLoggerを取得
		LambdaLogger logger = context.getLogger();
		
		// リクエスト内容を署名検証
		String sig = Sign(request.getBody());
		HashMap<String, String> headers = request.getHeaders();
		
		ApiGatewayResponseDto response = new ApiGatewayResponseDto();
		
		// ダイジェスト値をBase64エンコードした値と、リクエストヘッダーのx-line-signatureに含まれる署名が一致することを確認します。
		if (!sig.equals(headers.get("x-line-signature"))) {
			logger.log("Not a request sent from LINE.");
			response.setIsBase64Encoded(false);
			response.setStatusCode(500);
			response.setHeaders(new HashMap<String, String>());
			response.setBody(null);
			
		} else { 
		
			logger.log(request.getBody());
			
			logic(request.getBody(), logger);
			
			response.setIsBase64Encoded(false);
			response.setStatusCode(200);
			response.setHeaders(new HashMap<String, String>());
			response.setBody(null);
			
		}
		
		return response;
	}
	
	private void logic(String requestBody, LambdaLogger logger) {

		ObjectMapper mapper = new ObjectMapper();
		LineRequestBodyDto lineRequestBody = null;
		try {
			lineRequestBody = mapper.readValue(requestBody, LineRequestBodyDto.class);
			for(Event e : lineRequestBody.getEvents()) {
				if(e.getType().equals("message")){
					if(e.getMessage().getType().equals("text")) {
						
						if(e.getSource() != null) {
							
							String uri = "https://api.line.me/v2/bot/message/reply";
							String replyToken = e.getReplyToken();
							
							String text = e.getMessage().getText();						
							logger.log("[REQUEST_BODY]: " + text);
							
							// ChatGPTへリクエストを実行
							String ans = executeChatGPT(text, logger);
							
							LineResponseBodyDto responseBody = new LineResponseBodyDto();
							ArrayList<Message> messages = new ArrayList<Message>();
							Message message = new Message();
							message.setType("text");
							message.setText(ans);
							messages.add(message);
							responseBody.setReplyToken(replyToken);
							responseBody.setMessages(messages);
							
							String reply = mapper.writeValueAsString(responseBody);
							
							// LINEのユーザに対して返信する
							HttpClient client = HttpClient.newHttpClient();
							HttpRequest request = HttpRequest.newBuilder()
									.uri(URI.create(uri))
									.headers("Authorization", ("Bearer " + System.getenv("CHANNEL_ACCESS_TOKEN")))
									.headers("Content-Type","application/json")
									.POST(HttpRequest.BodyPublishers.ofString(reply))
									.build();
							try {
								HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
								logger.log("[RESPONSE_BODY]: " + response.body());
							} catch (IOException | InterruptedException e1) {
								// TODO 自動生成された catch ブロック
								e1.printStackTrace();
							}
							
						}
					}
				}
			}
		} catch (JsonProcessingException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
	}
	
	private String Sign(String plaintext) {
		
		// チャネルシークレットを秘密鍵として、HMAC-SHA256アルゴリズムを使用してリクエストボディのダイジェスト値を取得します。
		String sig = null;
		
		String algo = "HmacSHA256";
		
        String secret = System.getenv("CHANNEL_SECRETS");
        
        SecretKeySpec sk = new SecretKeySpec(secret.getBytes(), algo);
        Mac mac;
		try {
			mac = Mac.getInstance(algo);
			mac.init(sk);
			byte[] mac_bytes = mac.doFinal(plaintext.getBytes());
		    sig = Base64.getEncoder().encodeToString(mac_bytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return sig;

	}
	
	private String executeChatGPT(String text, LambdaLogger logger) {
		
		String uri = "https://api.openai.com/v1/chat/completions";
		
		ObjectMapper mapper = new ObjectMapper();
		
		ChatGptRequestBodyDto requestBody = new ChatGptRequestBodyDto();
		requestBody.setModel("gpt-3.5-turbo-1106");
		
		ArrayList<Messages> messages = new ArrayList<Messages>();
		Messages message = new Messages();
		message.setRole("user");
		message.setContent(text);
		messages.add(message);
		requestBody.setMessages(messages);
		
		String ans = "";
		
		try {
			String body = mapper.writeValueAsString(requestBody);
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(uri))
					.headers("Authorization", ("Bearer " + System.getenv("OPENAI_API_KEY")))
					.headers("Content-Type","application/json")
					.POST(HttpRequest.BodyPublishers.ofString(body))
					.build();
			
			try {
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				logger.log(response.body());
				ChatGptResponseBodyDto responseBody = mapper.readValue(response.body(), ChatGptResponseBodyDto.class);
				ans = responseBody.getChoices().get(0).getMessage().getContent();
			} catch (IOException | InterruptedException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}

		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return ans;
				
	}
	
}
