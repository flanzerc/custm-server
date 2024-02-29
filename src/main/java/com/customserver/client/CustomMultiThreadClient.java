package com.customserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.customserver.utils.Helper;

public class CustomMultiThreadClient {
	
	int port = 9090;
	
	public Runnable getRunnable() {
		
		return new Runnable() {
			
			@Override
			public void run(){
				try {
					InetAddress address = InetAddress.getByName("localhost");
					Socket socket = new Socket(address, port);
					PrintWriter toserver = new PrintWriter(socket.getOutputStream());
					BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					toserver.println("Hello from client: " + socket.getLocalSocketAddress());
					// receive from the server
					String line = fromServer.readLine();
					Helper.print("Response from server: " + line);
					
				} catch(UnknownHostException e) {
					Helper.print("UnknownHostException from Multi Threaded Client" );
					e.printStackTrace();
					
				} catch (IOException ioe) {
					Helper.print("IOException from Multi Threaded Client");
					ioe.printStackTrace();
					
				}
				
			}
		};
	}

}
