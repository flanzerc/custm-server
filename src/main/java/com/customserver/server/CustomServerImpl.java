package com.customserver.server;

import java.io.IOException;

import com.customserver.utils.Helper;

public class CustomServerImpl {

	public static void main(String[] args) {
		CustomServer server = new CustomServer();
		try {
			
			server.runserver();
			
		} catch(IOException e) {
			Helper.print("Exception while running the sever");
			 e.printStackTrace();
		}

	}

}
