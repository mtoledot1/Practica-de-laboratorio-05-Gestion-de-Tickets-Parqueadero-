package ec.edu.ups.modelo;

import java.util.Calendar;
import java.util.Calendar;

public class Ticket implements Comparable<Ticket>{
    
    private int numero;
    private Calendar fechaIngreso;
    private Calendar fechaSalida;
    private double total;
    private Vehiculo vehiculo;

    public Ticket() {
    }

    public Ticket(int numero, Calendar fechaIngreso, Calendar fechaSalida, double total, Vehiculo vehiculo) {
	this.numero = numero;
	this.fechaIngreso = fechaIngreso;
	this.fechaSalida = fechaSalida;
	this.total = total;
	this.vehiculo = vehiculo;
    }

    public int getNumero() {
	return numero;
    }

    public void setNumero(int numero) {
	this.numero = numero;
    }

    public Calendar getFechaIngreso() {
	return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
    }

    public Calendar getFechaSalida() {
	return fechaSalida;
    }

    public void setFechaSalida(Calendar fechaSalida) {
	this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
	return total;
    }

    public void setTotal(double total) {
	this.total = total;
    }

    public Vehiculo getVehiculo() {
	return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
	return "Ticket{" + "numero=" + numero + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", total=" + total + ", vehiculo=" + vehiculo + '}';
    }
    
    public void calcularTotal(){
	double minutos = fechaSalida.get(Calendar.MINUTE)-fechaIngreso.get(Calendar.MINUTE);
	minutos += (fechaSalida.get(Calendar.SECOND)-fechaIngreso.get(Calendar.SECOND))/60;
	minutos += (fechaSalida.get(Calendar.HOUR)-fechaIngreso.get(Calendar.HOUR))*60;
	minutos /= 10;
	total = minutos*0.25;
    }

    @Override
    public int compareTo(Ticket o) {
	if(this.numero == o.getNumero())
	    return 0;
	else if(this.numero > o.getNumero())
	    return 1;
	else
	    return -1;
    }
    
}
