package ec.edu.ups.idao;

import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.Ticket;
import java.util.List;

public interface ITicketDAO {
    public void create(Ticket ticket);
    public Ticket read(int numero);
    public void update(Ticket ticket);
    public void delete(Ticket ticket);   
    public List<Ticket> findAll();
}
