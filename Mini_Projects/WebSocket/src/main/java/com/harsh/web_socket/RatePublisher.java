package com.harsh.web_socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.util.CollectionUtils;

/**
 * Restfull end point to publish rates to all active websocket connections.
 * 
 * @author harshul.varshney
 *
 */
@ServerEndpoint(value = "/rates")
public class RatePublisher {
	
	private static Queue<Session> sessionQueue = new ConcurrentLinkedQueue<Session>();
	private static Thread rateThread ; //rate publisher thread

	@OnMessage
	public void onMessage(Session session, String msg) {
		// although client will not send any message in this application: just added for demo.
		try {
			System.out.println("received msg " + msg + " from " + session.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		sessionQueue.add(session);
		if(rateThread == null || !rateThread.isAlive())
			publish();//starting rates generation thread only once.
		
		System.out.println("New session opened: " + session.getId());
	}

	@OnError
	public void onError(Session session, Throwable t) {
		sessionQueue.remove(session);
		System.err.println("Error on session " + session.getId());
	}
	
	@OnClose
	public void closedConnection(Session session) {
		sessionQueue.remove(session);
		System.out.println("session closed: " + session.getId());
	}
	
	/**
	 * Start the rate generator at first connection.
	 */
	private void publish() {
		Queue<Double> queue = new LinkedBlockingQueue<>();
		RateGenerator rateGenerator = new RateGenerator();
		rateGenerator.setQueue(queue);
		
		rateThread = new Thread(rateGenerator);
		rateThread.start();
		
		try {
			startPublishingMessages(queue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * publish rates to web-socket connections.
	 * 
	 * @param ratesQueue
	 * @throws IOException
	 */
	private void startPublishingMessages(Queue<Double> ratesQueue) throws IOException {
		while (!CollectionUtils.isEmpty(sessionQueue)) {
			
			ArrayList<Session> closedSessions = new ArrayList<>();
			double newRate = ratesQueue.peek() != null ? ratesQueue.poll() : 0d;
			for (Session session : sessionQueue) {
				if (!session.isOpen()) {
					System.err.println("Closed session: " + session.getId());
					closedSessions.add(session);
				} else if(newRate > 0d){
					session.getBasicRemote().sendText(Double.toString(newRate));
				}
			}
			sessionQueue.removeAll(closedSessions);
		}
		rateThread.interrupt();//stopping the thread
	}

}
