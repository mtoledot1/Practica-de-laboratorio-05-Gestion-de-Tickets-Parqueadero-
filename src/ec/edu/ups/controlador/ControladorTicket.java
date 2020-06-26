package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JTextField;
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
    
    public void registrarEntrada(int numero, LocalDateTime ingreso, String placa){
        ticket = new Ticket(numero, ingreso, null, 0, null);
	ticket.setVehiculo(controladorVehiculo.verVehiculo(placa));
        ticketDAO.create(ticket);
    }
    
    public void actualizar(int numero, LocalDateTime ingreso, LocalDateTime salida, String placa){
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
    
    public void verTicketsVehiculo(DefaultTableModel tabla){
        List<Ticket> tickets;
        tickets = ticketDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < tickets.size(); i++){
	    tabla.addRow(new Object[]{
		tickets.get(i).getNumero(),
		tickets.get(i).getVehiculo().getPlaca(),
		tickets.get(i).getVehiculo().getMarca(),
		tickets.get(i).getVehiculo().getModelo(),
		tickets.get(i).getVehiculo().getPropietario().getNombre(),
	    });
	}
    }
    
    public void verTicketsIngresos(DefaultTableModel tabla){
        List<Ticket> tickets;
        tickets = ticketDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < tickets.size(); i++){
	    if(tickets.get(i).getFechaSalida() == null){
		tabla.addRow(new Object[]{
		    tickets.get(i).getNumero(),
		    tickets.get(i).getFechaIngreso(),
		    tickets.get(i).getFechaSalida(),
		    tickets.get(i).getTotal(),
		});
	    }
	}
    }
    
    public void listarTickets(DefaultTableModel tabla){
        List<Ticket> tickets;
        tickets = ticketDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < tickets.size(); i++){
	    tabla.addRow(new Object[]{
		tickets.get(i).getNumero(),
		tickets.get(i).getFechaIngreso(),
		tickets.get(i).getFechaSalida(),
		tickets.get(i).getTotal(),
		tickets.get(i).getVehiculo().getPropietario().getCedula(),
		tickets.get(i).getVehiculo().getPropietario().getNombre(),
		tickets.get(i).getVehiculo().getPropietario().getDireccion(),
		tickets.get(i).getVehiculo().getPropietario().getTelefono(),
		tickets.get(i).getVehiculo().getPlaca(),
		tickets.get(i).getVehiculo().getMarca(),
		tickets.get(i).getVehiculo().getModelo(),
	    });
	}
    }
    
    public List<Ticket> listarTickets(){
	return ticketDAO.findAll();
    }
    
    public void calcularTotal(int codigo, JTextField txtTotal, JTextField txtFracciones, LocalDateTime tiempo){
	ticket = verTicket(codigo);
	ticket.setFechaSalida(tiempo);
	Duration diff = Duration.between(ticket.getFechaIngreso(), tiempo);
	long diffMin = diff.toMinutes();
	diffMin /= 10;
	double total = 0.25 * diffMin;
	ticket.setTotal(total);
	txtTotal.setText(total + "");
	txtFracciones.setText(diffMin + "");
    }

}
