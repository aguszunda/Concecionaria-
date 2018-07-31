
package concesionaria;


public class Automovil extends Vehiculo
{
    private int cantPuertas;

    public Automovil(int cantPuertas, String marca, int modelo, double precio) {
        super(marca, modelo, precio);
        this.cantPuertas = cantPuertas;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + this.getMarca( )+ ", modelo=" + this.getModelo() + ", precio=" + this.getPrecio() + "Automovil{" + "cantPuertas=" + cantPuertas + '}';
    }
    public void actualizarPrecio()
    {
        double precio = this.getPrecio();
        if(this.getModelo() >= 2005)
        {
            precio = (precio * 1.03) + 400;
            this.setPrecio(precio);
        }
        else
        {
            precio = precio * 1.03;
            this.setPrecio(precio);
        }
    }
    
}
