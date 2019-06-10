package com.harsh.dp.decorator;

public class ExternalEmailDecorator  extends EmailDecorator {
	private String content;
	
	public ExternalEmailDecorator(_Email email) {
		originalEmail = email;
	}

	@Override
	public String getContent() {
		content = addDisclaimer(originalEmail.getContent());
		return content;
	}
	
	/**
	 * Adding disclaimer to original email through decorator.
	 * @param message
	 * @return
	 */
	private String addDisclaimer(String message) {
		return message + "Disclaimer: ... ";
	}
	
}
