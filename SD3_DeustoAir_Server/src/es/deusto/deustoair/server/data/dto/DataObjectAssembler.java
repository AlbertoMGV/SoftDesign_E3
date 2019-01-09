package es.deusto.deustoair.server.data.dto;

import java.util.Date;

import es.deusto.deustoair.db.DeustoAirDatabase;
import es.deusto.deustoair.server.data.Airport;
import es.deusto.deustoair.server.data.Flight;
import es.deusto.deustoair.server.data.Payment;
import es.deusto.deustoair.server.data.Reservation;
import es.deusto.deustoair.server.data.User;

public class DataObjectAssembler {
	
	public static Airport disassemble(AirportDTO a) {
		return DeustoAirDatabase.getAirport(a.getCode());
	}
	public static Reservation disassemble(ReservationDTO r) {
		return DeustoAirDatabase.getReservation(r.getId());
	}
	public static Flight disassemble(FlightDTO f) {
		return DeustoAirDatabase.getFlight(f.getAirlineCode() + f.getFltNumber());
	}
	public User disassemble(UserDTO u) {
		return DeustoAirDatabase.getUser(u.getEmail());
	}
	public static ReservationDTO assemble(Reservation r) {
		return new ReservationDTO(r.getId(), r.getDate().getTime(), r.getPrice());
	}
	public static FlightDTO assemble(Flight f) {
		return new FlightDTO(f.getAirlineCode(), f.getFltNumber(), f.getDuration(),f.getTotalSeats(), f.getOrigin().getCode(), f.getDestination().getCode(), f.getDepartureDateTime().getTime(), f.getPrice());
	}
	public static PaymentDTO assemble(Payment p) {
		return new PaymentDTO(p.getId(), p.getDate().getTime(), p.getPaidReservation().getId());
	}
	
	public FlightDTO[] assemble(Flight[] flts) {
		FlightDTO[] res = new FlightDTO[flts.length];
		for(int i = 0; i < flts.length; i++) {
			res[i] = new FlightDTO(flts[i].getAirlineCode(), flts[i].getFltNumber(), flts[i].getDuration(),flts[i].getTotalSeats(), flts[i].getOrigin().getCode(), flts[i].getDestination().getCode(), flts[i].getDepartureDateTime().getTime(), flts[i].getPrice());
		}
		return res;
	}


}
