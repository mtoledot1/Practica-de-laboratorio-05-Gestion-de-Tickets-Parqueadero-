package ec.edu.ups.modelo;
public class Vehiculo implements Comparable<Vehiculo>{
    
    private String placa;
    private String marca;
    private String modelo;
    private Cliente propietario;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, Cliente propietario) {
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
	this.propietario = propietario;
    }

    public String getPlaca() {
	return placa;
    }

    public void setPlaca(String placa) {
	this.placa = placa;
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public String getModelo() {
	return modelo;
    }

    public void setModelo(String modelo) {
	this.modelo = modelo;
    }

    public Cliente getPropietario() {
	return propietario;
    }

    public void setPropietario(Cliente propietario) {
	this.propietario = propietario;
    }

    @Override
    public String toString() {
	return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", propietario=" + propietario + '}';
    }

    @Override
    public int compareTo(Vehiculo o) {
	if(this.placa.equalsIgnoreCase(o.getPlaca()))
	    return 0;
	return 1;
    }
    
}
