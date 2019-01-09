package es.deusto.deustoair.server.gateway;

public class LoginGatewayFactory {
	
	public static IAuthGateway createGateway(String type) {
		if(type.equals("google")) {
			return new GoogleLoginHelper();
		}else if(type.equals("facebook")) {
			return new FacebookLoginHelper();
		}else {
			return null;
		}
	}

}
