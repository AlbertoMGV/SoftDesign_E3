package es.deusto.deustoair.server.gateway;

import es.deusto.deustoair.server.data.Payment;

public class PaypalPaymentProcessor implements IPaymentGateway{
	
	private String email, password;
	
	public PaypalPaymentProcessor(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	@Override
	public Payment pay(float price) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
