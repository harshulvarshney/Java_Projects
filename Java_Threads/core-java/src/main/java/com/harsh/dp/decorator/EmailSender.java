package com.harsh.dp.decorator;

public class EmailSender {
	
	public void sendEmail(_Email email) {
		
		//check address, if it is external email, add disclaimer and encrypt
		//if() {
			ExternalEmailDecorator decorator = new ExternalEmailDecorator(email);
			decorator.getContent();
			//send.
		//}
		
	}

}
