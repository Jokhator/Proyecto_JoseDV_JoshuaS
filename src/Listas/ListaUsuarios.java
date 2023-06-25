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
import SampleClasses.Usuario;
import Seguridad.Comprobaciones;
import SampleClasses.Empleado;

/**
 * @author jdvc, jgsm
 * @time 2:17:16 PM
 * @date Jun 23, 2023
 */

public class ListaUsuarios {
    private static ListaUsuarios instancia;
    private ArrayList<Usuario> listaUsuarios;
    Comprobaciones comprobaciones = new Comprobaciones();
    
    private ListaUsuarios() {
        listaUsuarios = new ArrayList<>();
        cargarUsuariosDesdeArchivo();
    }

    public static ListaUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ListaUsuarios();
        }
        return instancia;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    private void cargarUsuariosDesdeArchivo() {
        String nombreArchivo = "Usuarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 3) { // Ensure all attributes are present
                    Usuario usuario = new Usuario();
                    usuario.setUser(partes[0]);
                    usuario.setContrasenia(partes[1]);
                    // Assuming Usuario class exists with necessary attributes and constructor
                    Empleado empleado = comprobaciones.devolverEmpleado(null, partes[2]);
                    // Set other Usuario attributes if available
                    usuario.setEmpleado(empleado);
                    listaUsuarios.add(usuario);
                }
            }
            System.out.println("Se han cargado " + listaUsuarios.size() + " usuarios desde el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar los usuarios desde el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void write() {
        String nombreArchivo = "Usuarios.txt";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, false)))) {
            for (Usuario usuario : listaUsuarios) {
                out.println(usuario.save()); // Assuming Usuario class has a "save" method to convert to string format
            }
            System.out.println("Los usuarios se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}


