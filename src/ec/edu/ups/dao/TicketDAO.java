package ec.edu.ups.dao;

import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.modelo.Ticket;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TicketDAO implements ITicketDAO{
    
    private TreeSet<Ticket> tickets;
    
    public TicketDAO(){
	tickets = new TreeSet<>();
    }

    @Override
    public void create(Ticket ticket) {
	tickets.add(ticket);
    }

    @Override
    public Ticket read(int numero) {
	Ticket ticket = new Ticket(numero, null, null, 0, null);
	if(tickets.contains(ticket)){
	    return tickets.ceiling(ticket);
	}
	return null;
    }

    @Override
    public void update(Ticket ticket) {
	if(tickets.contains(ticket)){
	    ticket.setVehiculo(tickets.ceiling(ticket).getVehiculo());
	    tickets.remove(ticket);
	    tickets.add(ticket);
	}
    }

    @Override
    public void delete(Ticket ticket) {
	if(tickets.contains(ticket)){
	    tickets.remove(ticket);
	}
    }

    @Override
    public List<Ticket> findAll() {
	return new ArrayList<Ticket>(tickets);
    }
    
}
