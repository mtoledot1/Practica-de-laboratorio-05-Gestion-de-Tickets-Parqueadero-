package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Comparable<Cliente>{
    
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private List<Vehiculo> vehiculos;

    public Cliente() {
	vehiculos = new ArrayList<>();
    }

    public Cliente(String cedula, String nombre, String direccion, String telefono) {
	this.cedula = cedula;
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	vehiculos = new ArrayList<>();
    }

    public String getCedula() {
	return cedula;
    }

    public void setCedula(String cedula) {
	this.cedula = cedula;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getDireccion() {
	return direccion;
    }

    public void setDireccion(String direccion) {
	this.direccion = direccion;
    }

    public String getTelefono() {
	return telefono;
    }

    public void setTelefono(String telefono) {
	this.telefono = telefono;
    }
    
    public List<Vehiculo> getVehiculos(){
	return vehiculos;
    }
    
    public void setVehiculos(List<Vehiculo> vehiculos) {
	this.vehiculos = vehiculos;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo){
	vehiculos.add(vehiculo);
    }
    
    public void eliminarVehiculo(Vehiculo vehiculo){
	vehiculos.remove(vehiculo);
    }
    
    public void actualizarVehiculo(Vehiculo vehiculo){
	vehiculos.remove(vehiculo);
	vehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
	return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", vehiculos=" + vehiculos + '}';
    }

    @Override
    public int compareTo(Cliente o) {
	if(Integer.parseInt(cedula) == Integer.parseInt(o.getCedula()))
	    return 0;
	else if(Integer.parseInt(cedula) > Integer.parseInt(o.getCedula()))
	    return 1;
	else 
	    return -1;
    }
    
    
}
