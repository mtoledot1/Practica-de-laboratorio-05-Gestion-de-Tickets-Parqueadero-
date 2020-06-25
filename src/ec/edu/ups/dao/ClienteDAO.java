package ec.edu.ups.dao;

import ec.edu.ups.idao.IClienteDAO;
import ec.edu.ups.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ClienteDAO implements IClienteDAO{
    
    private TreeSet<Cliente> clientes;
    
    public ClienteDAO(){
	clientes = new TreeSet<>();
    }

    @Override
    public void create(Cliente cliente) {
	clientes.add(cliente);
    }

    @Override
    public Cliente read(String cedula) {
	Cliente cliente = new Cliente(cedula, null, null, null);
	if(clientes.contains(cliente)){
	    return clientes.ceiling(cliente);
	}
	return null;
    }

    @Override
    public void update(Cliente cliente) {
	if(clientes.contains(cliente)){
	    cliente.setVehiculos(clientes.ceiling(cliente).getVehiculos());
	    clientes.remove(cliente);
	    clientes.add(cliente);
	}
    }

    @Override
    public void delete(Cliente cliente) {
	if(clientes.contains(cliente)){
	    clientes.remove(cliente);
	}
    }

    @Override
    public List<Cliente> findAll() {
	return new ArrayList<Cliente>(clientes);
    }
    
}
