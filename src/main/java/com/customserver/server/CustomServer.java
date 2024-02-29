package com.customserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.customserver.utils.Helper;

public class CustomServer {
	
	private int sotimeout = 10000;
	private int port = 9090;
	
	public CustomServer() {
		
	}
	
	public CustomServer(int port) {
		this.port = port;
	}
	
	public void runserver() throws IOException {
		ServerSocket socket = new ServerSocket(this.port);
		socket.setSoTimeout(this.sotimeout);
		
		while(true) {
			Helper.print("Server socket listening on port " + port);
			Socket acceptConn = socket.accept();
			Helper.print("Connection accepted from: " + acceptConn.getRemoteSocketAddress());
			PrintWriter toclient = new PrintWriter(acceptConn.getOutputStream());
			BufferedReader frmClient = new BufferedReader(new InputStreamReader(acceptConn.getInputStream()));
			toclient.println("Hello from the server");
			
			toclient.close();
			frmClient.close();
			acceptConn.close();
			
		}
		
		
	}

}
