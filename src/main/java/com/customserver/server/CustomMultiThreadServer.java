package com.customserver.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class CustomMultiThreadServer {
	
	public Consumer<Socket> getConsumer() {
			
		return (clientsocket) -> {
			
			try {
				PrintWriter toclient = new PrintWriter(clientsocket.getOutputStream(), true);
				toclient.println("Hello from server to: " + clientsocket.getInetAddress() + " by " + Thread.currentThread().getName());
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		};
		
		
	}
	
}
