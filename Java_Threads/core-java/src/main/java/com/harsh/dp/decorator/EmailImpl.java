package com.harsh.dp.decorator;

/**
 * This is our original class whose functioality needs to be extended.
 * 
 * @author harshul.varshney
 */
public class EmailImpl implements _Email {
	
	private String content;
	
	public EmailImpl(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}

}
