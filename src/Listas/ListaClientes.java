/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import SampleClasses.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author jdvc, jgsm
 * @time 2:17:16 PM
 * @date Jun 23, 2023
 */
public class ListaClientes {

    private static ListaClientes instancia;
    private ArrayList<Cliente> listaClientes;

    private ListaClientes() {
        listaClientes = new ArrayList<>();
        cargarClientesDesdeArchivo();
    }

    public static ListaClientes getInstancia() {
        if (instancia == null) {
            instancia = new ListaClientes();
        }
        return instancia;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    private void cargarClientesDesdeArchivo() {
        String nombreArchivo = "Cliente.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 6) { // Asegurar que se tengan los 7 atributos
                    Cliente cliente = new Cliente();
                    cliente.setPasaporte(partes[0]);
                    cliente.setNombre(partes[1]);
                    cliente.setEdad(Integer.parseInt(partes[2]));
                    cliente.setTelefono(Integer.parseInt(partes[3]));
                    cliente.setCorreo(partes[4]);
                    cliente.setNacionalidad(partes[5]);
                    listaClientes.add(cliente);
                }
            }
            System.out.println("Se han cargado " + listaClientes.size() + " clientes desde el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar los clientes desde el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void write() {
        String nombreArchivo = "Cliente.txt";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, false)))) {
            for (Cliente cliente : listaClientes) {
                out.println(cliente.save());
            }
            System.out.println("Los clientes se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los clientes en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    } 
}
