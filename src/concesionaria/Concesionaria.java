
package concesionaria;
import java.util.*;

public class Concesionaria
{
    
    public static void main(String[] args)
    {
        ArrayList<Vehiculo> lista = new  ArrayList<Vehiculo>();
        Scanner in = new Scanner(System.in);
        int opc=0;
        boolean bandera=false;
        do{
            System.out.println("**********************************");
            System.out.println("*  CONCESIONARIO DE AUTOMOTORES  *");
            System.out.println("**********************************");
            System.out.println("1_NUEVO VEHICULO");
            System.out.println("2_MOSTRAR VEHICULOS");
            System.out.println("3_ACTUALIZAR TODOS LOS PRECIOS");
            System.out.println("4_BUSCAR VEHICULO DE CARGA");
            System.out.println("5_MOSTRAR CANT. DE VEHIC. X CLASE");
            System.out.println("6_SALIR");
            System.out.println("INGRESE SU OPCIÓN: ");
            opc=in.nextInt();
            switch(opc)
            {
                case 1:
                    cargarVehiculo(lista);
                    break;
                case 2:
                    System.out.println(lista.toString());
                    break;
                case 3:
                    actualizarPrecioV(lista);
                    break;
                case 4:
                    BuscarVCarga(lista);
                    break;
                case 5:
                    mostrarCantVehiculos(lista);
                    break;
                case 6:
                    bandera=true;
                    break;
                default:
                    System.out.println("Opción incorrecta... intente nuevamente.");
            }
        }while(bandera != true);

    }
    public static void cargarVehiculo(ArrayList<Vehiculo> lista)
    {
        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);
        String marca="";
        int modelo=0, tipo=0;
        boolean error=false;
        double precio=0;
        int cantPuertas=0;
        int capacidad=0;
        System.out.println("Ingrese la Marca de su vehiculo: ");
        marca=in.nextLine();
        System.out.println("Ingrese el modelo(en numeros): ");
        modelo=on.nextInt();
        System.out.println("Ingrese el precio del vehiculo: ");
        precio=on.nextDouble();
        do{
            System.out.println("Ingrese el tipo de vehiculo (1-automovil/ 2-vehiculo de carga)");
            tipo=on.nextInt();
            switch(tipo)
            {
                case 1:
                    System.out.println("Ingrese la cantidad de puertas de su vehiculo:");
                    cantPuertas=on.nextInt();
                    Automovil nuevo = new Automovil(cantPuertas, marca, modelo, precio);
                    lista.add(nuevo);
                    System.out.println("Su vehiculo fue ingresado correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese su capasidad de carga expresada en toneladas:");
                    capacidad=on.nextInt();
                    Carga n = new Carga(capacidad, marca, modelo, precio);
                    lista.add(n);
                    System.out.println("Su vehiculo fue ingresado correctamente.");
                    break;
                default:
                    System.out.println("Opción incorresta... itente nuevamente.");
                    error=true;
            }
            
        }while(error==true);
    }
    public static void actualizarPrecioV(ArrayList<Vehiculo> lista)
    {
        Vehiculo aux=null;
        for(int i=0; i < lista.size(); i++)
        {
            aux=lista.get(i);
            //el metodo instanceof nos permite consultar de que tipo es el vehiculo que tiene el ArrayList
            if(aux instanceof Carga)
            {
                Carga c1=(Carga)aux;
                c1.actualizarPrecio();
                lista.remove(i);
                lista.add(i,c1);
            }
            else
            {
                Automovil a1=(Automovil)aux;
                a1.actualizarPrecio();
                lista.remove(i);
                lista.add(i,a1);
            }
        }
        System.out.println("Lista de precios actualizada.");
        System.out.println(lista.toString());
    }
    public static void BuscarVCarga(ArrayList<Vehiculo> lista)
    {
        Scanner in = new Scanner(System.in);
        int capacidad=0;
        boolean bandera=false;
        System.out.println("Ingrese el peso en toneladas del vehiculo de carga a buscar: ");
        capacidad=in.nextInt();
        Vehiculo aux=null;
        for(int i=0; i < lista.size(); i++)
        {
            aux=lista.get(i);
            if(aux instanceof Carga)
            {
                Carga c1=(Carga)aux;
                if(c1.getCapacidad() > capacidad)
                {
                    System.out.println("Vehiculos con capacidad mayor a " + capacidad + " toneladas:");
                    System.out.println(c1.toString());
                    bandera=true;
                }
            }
            
        }
        if(bandera==false)
        {
            System.out.println("No existe ningun vehiculo registrado que cumpla esta condición.");
        }
    }
    public static void mostrarCantVehiculos(ArrayList<Vehiculo> lista)
    {
        Vehiculo aux=null;
        int carga=0, auto=0;
        for(int i=0; i < lista.size(); i++)
        {
            aux=lista.get(i);
            if(aux instanceof Carga)
            {
                carga++;
            }
            else
            {
                auto++;
            }
        }
        System.out.println("Lista de vehiculos registrados: ");
        System.out.println("Vehiculos de Carga: " + carga);
        System.out.println("Automoviles: " + auto);
    }
}
