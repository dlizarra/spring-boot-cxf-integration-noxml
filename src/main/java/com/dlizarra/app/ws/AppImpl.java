package com.dlizarra.app.ws;

import com.dlizarra.app.App;
import com.dlizarra.app.in.SayHiRequest;
import com.dlizarra.app.out.SayHiResponse;

public class AppImpl implements App{

	@Override
	public SayHiResponse sayHi(SayHiRequest sayHiRequest) {
		String message = "Hi " + sayHiRequest.getYourName() + "!";
		SayHiResponse response = new SayHiResponse();
		response.setMessage(message);
		return response;
	}


}
