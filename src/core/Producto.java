
package core;

public class Producto {
    public int id;
    public String nombre;
    public double precio;
    public int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + precio + "," + stock;
    }
}
