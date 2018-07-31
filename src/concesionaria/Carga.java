
package concesionaria;


public class Carga extends Vehiculo
{
    private int capacidad;

    public Carga(int capacidad, String marca, int modelo, double precio) {
        super(marca, modelo, precio);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + this.getMarca( )+ ", modelo=" + this.getModelo() + ", precio=" + this.getPrecio() + "Carga{" + "capacidad=" + capacidad + "}\n";
    }
    public void actualizarPrecio()
    {
        double pre=this.getPrecio() * 1.05;
        this.setPrecio(pre);
    }
    
}
