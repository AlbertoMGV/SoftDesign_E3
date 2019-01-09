package es.deusto.deustoair.server.data.dto;

import java.util.Date;

import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.Payment;
import es.deusto.deustoair.server.data.Reservation;
import es.deusto.deustoair.server.data.User;

public class DataObjectAssembler {
	
	public Airport disassemble(AirportDTO a) {
		return new Airport(a.getCode(), a.getName(), a.getCity(), a.getCountry());
	}
	public Reservation disassemble(ReservationDTO r) {
		return new Reservation(r.getId(), new Date(r.getDate()), 0, null, null, r.getPrice());
	}
	public Flight disassemble(FlightDTO f) {
		return new Flight(f.getAirlineCode(), f.getFltNumber(), f.getDuration(), f.getTotalSeats(), new Date(f.getDepartureDateTime()), 0, new Airport(f.getOriginCode()), new Airport(f.getDestinationCode()), f.getPrice());
	}
	public User disassemble(UserDTO u) {
		return new User(u.getId(), null, null);
	}
	public ReservationDTO assemble(Reservation r) {
		return new ReservationDTO(r.getId(), r.getDate().getTime(), r.getPrice());
	}
	public FlightDTO assemble(Flight f) {
		return new FlightDTO(f.getAirlineCode(), f.getFltNumber(), f.getDuration(),f.getTotalSeats(), f.getOrigin().getCode(), f.getDestination().getCode(), f.getDepartureDateTime().getTime(), f.getPrice());
	}
	public PaymentDTO assemble(Payment p) {
		return new PaymentDTO(p.getId(), p.getDate().getTime(), p.getPaidReservation().getId());
	}
	
	public FlightDTO[] assemble(Flight[] flts) {
		FlightDTO[] res = new FlightDTO[flts.length];
		for(int i = 0; i < flts.length; i++) {
			res[i] = new FlightDTO(flts[i].getAirlineCode(), flts[i].getFltNumber(), flts[i].getDuration(),flts[i].getTotalSeats(), flts[i].getOrigin().getCode(), flts[i].getDestination().getCode(), flts[i].getDepartureDateTime().getTime(), flts[i].getPrice());
		}
		return res[i];
	}


}
