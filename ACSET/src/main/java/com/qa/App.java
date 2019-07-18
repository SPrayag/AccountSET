package com.qa;

import com.qa.domain.Account;

import util.JSONUtil;

public class App {
	
	public static void main(String[] args) {
		JSONUtil json = new JSONUtil();
		Account test = new Account("654POI", "Perry", "Como");
		System.out.println(json.getJSONForObject(test));
	}

}
