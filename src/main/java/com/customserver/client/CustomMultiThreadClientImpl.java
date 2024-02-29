package com.customserver.client;

import com.customserver.utils.Helper;

public class CustomMultiThreadClientImpl {

	public static void main(String[] args) {
		CustomMultiThreadClient client = new CustomMultiThreadClient();
		for(int i = 0; i < 100; i++) {
			try {
				Thread t = new Thread(client.getRunnable());
				t.start();
				
			} catch(Exception e) {
				Helper.print("Exception while running multi threaded client impl");
				e.printStackTrace();
				return;
			}
		}

	}

}
