
package concesionaria;


public abstract class Vehiculo
{
    private String marca;
    private int modelo;
    private double precio;

    public Vehiculo(String marca, int modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
//este metodo nos permite actualizar nuestro precio
    public abstract void actualizarPrecio();

    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "}\n";
    }
    
}
