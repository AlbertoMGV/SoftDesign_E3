package es.deusto.deustoair.server.gateway;

public class LoginGatewayFactory {
	
	public static IAuthGateway createGateway(String email, String password, String type) {
		if(type.equals("google")) {
			return new GoogleLoginHelper(email, password);
		}else if(type.equals("facebook")) {
			return new FacebookLoginHelper();
		}else {
			return null;
		}
	}

}
