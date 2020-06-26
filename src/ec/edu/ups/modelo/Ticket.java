package ec.edu.ups.modelo;

import java.time.LocalDateTime;

public class Ticket implements Comparable<Ticket>{
    
    private int numero;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private double total;
    private Vehiculo vehiculo;

    public Ticket() {
    }

    public Ticket(int numero, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, double total, Vehiculo vehiculo) {
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

    public LocalDateTime getFechaIngreso() {
	return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
	return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
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
