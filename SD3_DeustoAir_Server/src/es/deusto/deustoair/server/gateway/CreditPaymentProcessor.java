package es.deusto.deustoair.server.gateway;

import es.deusto.deustoair.server.data.Payment;

public class CreditPaymentProcessor implements IPaymentGateway{

	private String number, expiration;
	private int cvv;
	
	public CreditPaymentProcessor(String number, String expiration, int cvv) {
		this.number = number;
		this.expiration = expiration;
		this.cvv = cvv;
	}
	
	@Override
	public Payment pay(float price) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
