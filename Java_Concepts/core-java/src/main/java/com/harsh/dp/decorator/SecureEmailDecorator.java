package com.harsh.dp.decorator;

public class SecureEmailDecorator extends EmailDecorator {
	
	private String content;
	
	public SecureEmailDecorator(_Email email) {
		originalEmail = email;
	}

	@Override
	public String getContent() {
		content = encrypt(originalEmail.getContent());
		return content;
	}
	
	/**
	 * Adding encryption to original email through decorator.
	 * 
	 * @param originalContent
	 * @return
	 */
	private String encrypt(String originalContent) {
		//encrypt the message
		String encryptedMessage = null;
		//do processing
		
		return encryptedMessage;
	}

}
