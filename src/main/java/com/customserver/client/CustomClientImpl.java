package com.customserver.client;

import java.io.IOException;

public class CustomClientImpl {
	
	public static void main(String[] args) {
		try {
			CustomClient client = new CustomClient();
			client.runclient();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
