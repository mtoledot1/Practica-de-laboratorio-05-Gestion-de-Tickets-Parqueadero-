package ec.edu.ups.idao;

import ec.edu.ups.modelo.Cliente;
import java.util.List;

public interface IClienteDAO {
    public void create(Cliente cliente);
    public Cliente read(String cedula);
    public void update(Cliente cliente);
    public void delete(Cliente cliente);   
    public List<Cliente> findAll();
}
