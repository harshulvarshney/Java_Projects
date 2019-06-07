package com.harsh.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * How to implement own server.
 * 
 * @author harshul.varshney
 *
 */
public class MyServer implements Runnable {

	private boolean 		stopped 		= false;
	private int 			port 			= 9000;
	private ServerSocket 	serverSocket 	= null;
	private Thread 			currentThread 	= null;
	
	public MyServer(int port) {
		this.port = port;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.currentThread = Thread.currentThread();
		}
		
		openServerSocket();
		
		while(!isStopped()) {
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
			} catch(IOException ioe) {
				if(isStopped()) {
					System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException("Error accepting client connection", ioe);
			}
			
			try {
				processClientRequest(clientSocket);
            } catch (IOException e) {
                //log exception and go on to next request.
            }
		}
		
		System.out.println("Server Stopped.");
	}

	private void processClientRequest(Socket clientSocket) throws IOException {
		InputStream  input  = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        long time = System.currentTimeMillis();

        output.write(("HTTP/1.1 200 OK\n\n<html><body>" +
                "My Server: Hi Harshul " +
                time +
                "</body></html>").getBytes());
        output.close();
        input.close();
        System.out.println("Request processed: " + time);
	}

	private synchronized boolean isStopped() {
		return stopped;
	}

	private void openServerSocket() {
		try {
			serverSocket = new ServerSocket(port);
		} catch(IOException e) {
			throw new RuntimeException("Cannot open port: " + port, e);
		}
	}
	
}
