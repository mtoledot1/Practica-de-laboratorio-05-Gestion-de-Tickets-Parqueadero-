package ec.edu.ups.controlador;

import ec.edu.ups.idao.IVehiculoDAO;
import ec.edu.ups.modelo.Vehiculo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorVehiculo {
    
    private IVehiculoDAO vehiculoDAO;
    private Vehiculo vehiculo;
    private ControladorCliente controladorCliente;

    public ControladorVehiculo() {
	
    }

    public ControladorVehiculo(IVehiculoDAO vehiculoDAO, ControladorCliente controladorCliente) {
	this.vehiculoDAO = vehiculoDAO;
	this.controladorCliente = controladorCliente;
    }
    
    public void registrar(String placa, String marca, String modelo, String cedula){
        vehiculo = new Vehiculo(placa, marca, modelo, null);
	vehiculo.setPropietario(controladorCliente.verCliente(cedula));
        vehiculoDAO.create(vehiculo);
    }
    
    public void actualizar(String placa, String marca, String modelo, String cedula){
	vehiculo = new Vehiculo(placa, marca, modelo, null);
	vehiculo.setPropietario(controladorCliente.verCliente(cedula));
        vehiculoDAO.update(vehiculo);
    }
    
    public void eliminar(String placa, String marca, String modelo){
        vehiculo = new Vehiculo(placa, marca, modelo, null);
        vehiculoDAO.delete(vehiculo);
    }
    
    public Vehiculo verVehiculo(String placa){
        vehiculo = vehiculoDAO.read(placa);
        return vehiculo;
    }
    
    public void verVehiculos(DefaultTableModel tabla){
        List<Vehiculo> vehiculos;
        vehiculos = vehiculoDAO.findAll();
        tabla.setRowCount(0);
	    for(int i = 0; i < vehiculos.size(); i++){
		tabla.addRow(new Object[]{
		    vehiculos.get(i).getPlaca(),
		    vehiculos.get(i).getMarca(),
		    vehiculos.get(i).getModelo(),
		});
	    }
    }
    
    public List<Vehiculo> listar(){
	return vehiculoDAO.findAll();
    }
    
}
