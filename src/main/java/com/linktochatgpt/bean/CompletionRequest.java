package com.linktochatgpt.bean;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * 接口实体类
 *
 * https://api.openai.com/v1/completions
 *
 */
@Configuration
@Data
public class CompletionRequest {
	/**
	 * 可选参数。语言模型，这里选择的是text-davinci-003
	 */
	private String model = "text-davinci-003";

	/**
	 * 必选参数。即用户的输入。
	 */
	private String prompt;

	/**
	 * 可选参数，默认值为 16。最大分词数，会影响返回结果的长度。
	 */
	private Integer max_tokens = 256;

	/**
	 * 可选参数，默认值为 1，取值 0-2。该值越大每次返回的结果越随机，即相似度越小。
	 */
	private float temperature = 0.5f;

	/**
	 * 可选参数，与temperature类似。
	 */
	private Integer top_p = 1;

	/**
	 * 可选参数，默认值为 1。表示对每条prompt生成多少条结果。
	 */
	private Integer n = 1;

	/**
	 * 可选参数，默认值为false。表示是否回流部分结果。
	 */
	private Boolean stream = false;

	private Boolean logprobs;

	private String stop;
}
