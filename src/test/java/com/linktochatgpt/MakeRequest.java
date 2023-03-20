package com.linktochatgpt;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class MakeRequest {

	@Value("${openai.api-key}")
	private String apiKey;

	@Test
	public void makingRequest() {
		String json = "{\n" +
				"    \"model\": \"gpt-3.5-turbo\",\n" +
				"    \"messages\": [\n" +
				"        {\n" +
				"            \"role\": \"user\",\n" +
				"            \"content\": \"Hello!\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";
		String url = "https://api.openai.com/v1/chat/completions";
//		String result = HttpRequest.post(url)
//				.header("Authorization")
//				.body(json)
//				.execute().body();
		String result2 = HttpRequest.post(url)
				.header("Content-Type", "application/json")
				.header(Header.AUTHORIZATION, "Bearer " + apiKey)//头信息，多个头信息多次调用此方法即可
				.body(json)//表单内容
//				.timeout(20000)//超时，毫秒
				.execute().body();
		System.out.println(result2);
	}


	@Test
	public void test() throws IOException {
		String message = "Hello!";
		String url = "https://api.openai.com/v1/engines/davinci-codex/completions";
		OkHttpClient client = new OkHttpClient();
		String json = "{\"prompt\": \"" + message.replace("\"", "\\\"") + "\", \"temperature\": 0.7, \"max_tokens\": 100}";
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
		Request request = new Request.Builder()
				.addHeader("Authorization", "Bearer " + apiKey)
				.addHeader("Content-Type", "application/json")
				.url(url)
				.post(body)
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());

	}



}
