package es.deusto.deustoair.server.gateway;

public class PaymentGatewayFactory {
	
	public static IPaymentGateway createGateway(String type, String arguments) {
		String[] args = arguments.split(";");
		if(type.equals("paypal")) {
			return new PaypalPaymentProcessor(args[0], args[1]);
		}else if(type.equals("credit")) {
			return new CreditPaymentProcessor(args[0], args[1], Integer.parseInt(args[2]));
		}else {
			return null;
		}
	}

}
