package es.deusto.deustoair.server.data.dto;

import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.Payment;
import es.deusto.deustoair.server.data.Reservation;

public class DataObjectAssembler {
	
	public AirportDTO assemble(Airport a) {
		return new AirportDTO(a.getCode(), a.getName(), a.getCity(), a.getCountry());
	}	
	public FlightDTO assemble(Flight f) {
		return new FlightDTO(f.getAirlineCode(), f.getFltNumber(), f.getDuration(),f.getTotalSeats(), f.getOrigin().getCode(), f.getDestination().getCode(), f.getDepartureDateTime().getTime(), f.getPrice());
	}
	public PaymentDTO assemble(Payment p) {
		return new PaymentDTO(p.getId(), p.getDate().getTime(), p.getPaidReservation().getId());
	}


}
