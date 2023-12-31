/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import SampleClasses.Empleado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author jdvc, jgsm
 * @time 7:02:54 PM
 * @date Jun 22, 2023
 */
public class ListaEmpleado {

    private static ListaEmpleado instancia;
    private final ArrayList<Empleado> listaEmpleados;

    private ListaEmpleado() {
        listaEmpleados = new ArrayList<>();
        cargarEmpleadosDesdeArchivo();
    }

    public static ListaEmpleado getInstancia() {
        if (instancia == null) {
            instancia = new ListaEmpleado();
        }
        return instancia;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    private void cargarEmpleadosDesdeArchivo() {
        String nombreArchivo = "Empleado.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 7) { // Asegurar que se tengan los 7 atributos
                    Empleado empleado = new Empleado();
                    empleado.setId(partes[0]);
                    empleado.setNom(partes[1]);
                    empleado.setEdad(Integer.parseInt(partes[2]));
                    empleado.setTelefono(Integer.parseInt(partes[3]));
                    empleado.setDepartamento(partes[4]);
                    empleado.setSalario(Double.parseDouble(partes[5]));
                    empleado.setFecha(partes[6]);
                    listaEmpleados.add(empleado);
                }
            }
            System.out.println("Se han cargado " + listaEmpleados.size() + " empleados desde el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar los empleados desde el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void write() {
        String nombreArchivo = "Empleado.txt";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, false)))) {
            for (Empleado empleado : listaEmpleados) {
                out.println(empleado.save());
            }
            System.out.println("Los empleados se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los empleados en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

}
