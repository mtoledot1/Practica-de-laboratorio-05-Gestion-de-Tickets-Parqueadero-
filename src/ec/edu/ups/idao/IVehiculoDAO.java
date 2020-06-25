package ec.edu.ups.idao;

import ec.edu.ups.modelo.Vehiculo;
import java.util.List;

public interface IVehiculoDAO {
    public void create(Vehiculo vehiculo);
    public Vehiculo read(String cedula);
    public void update(Vehiculo vehiculo);
    public void delete(Vehiculo vehiculo);   
    public List<Vehiculo> findAll();
}
