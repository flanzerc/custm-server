package com.customserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CustomClient {
	
	private int port = 9090;

	public void runclient() throws UnknownHostException, IOException {
		int port = this.port;
		InetAddress address = InetAddress.getByName("localhost");
		Socket socket = new Socket(address, port);
		PrintWriter toserver = new PrintWriter(socket.getOutputStream());
		BufferedReader fromserver = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		toserver.println("Hello from client");
		String line = fromserver.readLine();
		
		System.out.println("Response from server is: " + line);
		
		toserver.close();
		fromserver.close();
		socket.close();
		
	}	
}
