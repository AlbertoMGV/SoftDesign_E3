package es.deusto.deustoair.server.gateway;

public interface IAuthGateway {
	public boolean login(String email, String password);
}
