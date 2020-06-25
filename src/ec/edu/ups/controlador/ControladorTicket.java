package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.Vehiculo;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorTicket {
    
    private ITicketDAO ticketDAO;
    private ControladorVehiculo controladorVehiculo;
    private Ticket ticket;

    public ControladorTicket() {
    }

    public ControladorTicket(ITicketDAO ticketDAO, ControladorVehiculo controladorVehiculo) {
	this.ticketDAO = ticketDAO;
	this.controladorVehiculo = controladorVehiculo;
    }
    
    public void registrarEntrada(int numero, Calendar ingreso, String placa){
        ticket = new Ticket(numero, ingreso, null, 0, null);
	ticket.setVehiculo(controladorVehiculo.verVehiculo(placa));
        ticketDAO.create(ticket);
    }
    
    public void registrarSalida(int numero, Calendar salida){
        ticket = ticketDAO.read(numero);
	ticket.setFechaSalida(salida);
	ticket.calcularTotal();
        ticketDAO.update(ticket);
    }
    
    public void actualizar(int numero, Calendar ingreso, Calendar salida, String placa){
	ticket = new Ticket(numero, ingreso, salida, 0, null);
	ticket.setVehiculo(controladorVehiculo.verVehiculo(placa));
        ticketDAO.update(ticket);
    }
    
    public void eliminar(int numero){
        ticket = ticketDAO.read(numero);
        ticketDAO.delete(ticket);
    }
    
    public Ticket verTicket(int numero){
        ticket = ticketDAO.read(numero);
        return ticket;
    }
    
    public void verTickets(DefaultTableModel tabla){
        List<Ticket> tickets;
        tickets = ticketDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < tickets.size(); i++){
	    tabla.addRow(new Object[]{
		tickets.get(i).getNumero(),
		tickets.get(i).getFechaIngreso(),
		tickets.get(i).getFechaSalida(),
		tickets.get(i).getTotal(),
	    });
	}
    }
    
}
