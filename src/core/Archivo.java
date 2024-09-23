
package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {
    public String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public ArrayList<Producto> leerArchivo(){
        ArrayList<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int stock = Integer.parseInt(partes[3]);
                productos.add(new Producto(id, nombre, precio, stock));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la lista o el archivo no existe.");
        }
        return productos;
    }
    
    public String mostrarArchivo() {
        String res = "";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double precio = Double.parseDouble(partes[2]);
                int stock = Integer.parseInt(partes[3]);
                res = res + "ID: " + id + ", NOMBRE: " + nombre + ", PRECIO: " + precio + ", STOCK: " + stock + "\n";
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return res;
    }
    
    public void escribirArchivo(ArrayList<Producto> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Producto producto : productos) {
                bw.write(producto.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }
    
   
}
