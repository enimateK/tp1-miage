package com.acme.mailreader.presentation;

public class ClientMail {
	
	public static boolean production;
	
	public static void main(String[] args) {
		production = Boolean.parseBoolean(args[0]);
	}

}
