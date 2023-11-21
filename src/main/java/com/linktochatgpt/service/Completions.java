package com.linktochatgpt.service;

import com.linktochatgpt.bean.CompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Completions {

	@Autowired
	private CompletionRequest request;

	public void completions() {
		request.setPrompt("默认测试");
	}
}
