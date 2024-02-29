package com.customserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.customserver.utils.Helper;

public class CustomultiThreadServerImpl {
	
	private static int port = 9090;
	private static int timeout = 15000;
	
	
	
	public static void main(String[] args) throws IOException {
		CustomMultiThreadServer server = new CustomMultiThreadServer();
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(port);
			socket.setSoTimeout(timeout);
			Helper.print("Server is listening on port: " + port);
			
			while(true) {
				Socket accpetedSocket = socket.accept();
				
				Thread thread = new Thread(() -> server.getConsumer().accept(accpetedSocket));
				thread.start();
				
				
			}
			
			
			
			
		} catch(IOException e) {
			
		} finally {
			
			socket.close();
		}
	}

}
