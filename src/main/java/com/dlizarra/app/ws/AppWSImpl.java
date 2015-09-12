package com.dlizarra.app.ws;

import com.dlizarra.app.AppWS;
import com.dlizarra.app.in.SayHiRequest;
import com.dlizarra.app.out.SayHiResponse;

public class AppWSImpl implements AppWS{

	@Override
	public SayHiResponse sayHi(SayHiRequest sayHiRequest) {
		String message = "Hi " + sayHiRequest.getYourName() + "!";
		System.out.println(message);		
		SayHiResponse response = new SayHiResponse();
		response.setMessage(message);
		return response;
	}


}
