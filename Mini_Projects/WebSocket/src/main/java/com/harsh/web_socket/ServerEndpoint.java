package com.harsh.web_socket;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;

/**
 * 
 * @author harshul.varshney
 *
 */
@javax.websocket.server.ServerEndpoint("/web_socket/test")
public class ServerEndpoint {
	
	@OnOpen
	public void onOpen() {
		System.out.println("Opening connection...");
	}
	@OnClose
	public void onClose() {
		System.out.println("Closing connection...");
	}
	@OnMessage
	public String onMessage(String message) {
		System.out.println("Message from client : " + message);
		String resp = "Acknowledged : " + message;
		for(int i =0; i < 10; i++) {
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Random r = new Random();
			r.nextInt(100);
			resp = resp + "New Rate : " + r;
		}
		return resp;
	}
	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}

}
