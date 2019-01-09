package es.deusto.deustoair.server.gateway;

import es.deusto.deustoair.server.data.Payment;

public interface IPaymentGateway {
	public Payment pay(float price);
}
