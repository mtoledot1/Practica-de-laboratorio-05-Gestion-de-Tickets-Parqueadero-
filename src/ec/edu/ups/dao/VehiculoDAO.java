package ec.edu.ups.dao;

import ec.edu.ups.idao.IVehiculoDAO;
import ec.edu.ups.modelo.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class VehiculoDAO implements IVehiculoDAO{
    
    private TreeSet<Vehiculo> vehiculos;
    
    public VehiculoDAO(){
	vehiculos = new TreeSet<>();
    }

    @Override
    public void create(Vehiculo vehiculo) {
	vehiculos.add(vehiculo);
    }

    @Override
    public Vehiculo read(String placa) {
	Vehiculo vehiculo = new Vehiculo(placa, null, null, null);
	if(vehiculos.contains(vehiculo)){
	    return vehiculos.ceiling(vehiculo);
	}
	return null;
    }

    @Override
    public void update(Vehiculo vehiculo) {
	if(vehiculos.contains(vehiculo)){
	    vehiculo.setPropietario(vehiculos.ceiling(vehiculo).getPropietario());
	    vehiculos.remove(vehiculo);
	    vehiculos.add(vehiculo);
	}
    }

    @Override
    public void delete(Vehiculo vehiculo) {
	if(vehiculos.contains(vehiculo)){
	    vehiculos.remove(vehiculo);
	}
    }

    @Override
    public List<Vehiculo> findAll() {
	return new ArrayList<Vehiculo>(vehiculos);
    }
    
}
