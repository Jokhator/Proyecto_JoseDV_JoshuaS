/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Listas;

import SampleClasses.Empleado;
import SampleClasses.Vuelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import Seguridad.Comprobaciones;

/**
 * @author jdvc, jgsm
 * @time 9:12:05 AM
 * @date Jun 23, 2023
 */
public class ListaVuelo {

    private static ListaVuelo instancia;
    private final ArrayList<Vuelo> listaVuelos;
    Comprobaciones comp = new Comprobaciones();

    private ListaVuelo() {
        listaVuelos = new ArrayList<>();
        cargarVuelosDesdeArchivo();
    }

    public static ListaVuelo getInstancia() {
        if (instancia == null) {
            instancia = new ListaVuelo();
        }
        return instancia;
    }

    public ArrayList<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    private void cargarVuelosDesdeArchivo() {
        String nombreArchivo = "Vuelo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length == 15) { // Asegurar que se tengan los 15 atributos
                    Vuelo vuelo = new Vuelo();
                    if(comp.existeEmpleado(null, partes[1]) && comp.existeEmpleado(null, partes[2])){
                    vuelo.setIdVuelo(partes[0]);
                    // Cargar el piloto desde la lista de empleados por su ID
                    Empleado piloto = comp.devolverEmpleado(null, partes[1]);
                    vuelo.setPiloto(piloto);
                    // Cargar el copiloto desde la lista de empleados por su ID
                    Empleado copiloto = comp.devolverEmpleado(null, partes[2]);
                    vuelo.setCopiloto(copiloto);
                    vuelo.setOrigen(partes[3]);
                    vuelo.setDestino(partes[4]);
                    vuelo.setCodAreopuertoSalida(partes[5]);
                    vuelo.setCodAeropuertoEntrada(partes[6]);
                    vuelo.setFechaSalida(partes[7]);
                    vuelo.setFechaEntrada(partes[8]);
                    vuelo.setHoraSalida(partes[9]);
                    vuelo.setHoraEntrada(partes[10]);
                    vuelo.setIdAvion(partes[11]);
                    vuelo.setCapacidad(Integer.parseInt(partes[12]));
                    vuelo.setCostoPasaje(Double.parseDouble(partes[13]));
                    vuelo.setCostoTotalAerolinea(Double.parseDouble(partes[14]));
                    listaVuelos.add(vuelo);
                    }
                }
            }
            System.out.println("Se han cargado " + listaVuelos.size() + " vuelos desde el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar los vuelos desde el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    public void write() {
        String nombreArchivo = "Vuelo.txt";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreArchivo, false)))) {
            for (Vuelo vuelo : listaVuelos) {
                out.println(vuelo.save());
            }
            System.out.println("Los vuelos se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los vuelos en el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }

    private Empleado obtenerEmpleadoPorId(String id) {
        // Aquí debes implementar la lógica para buscar un empleado por su ID en la lista de empleados
        // y retornar el objeto Empleado correspondiente.
        // Por simplicidad, se asume que ya existe una lista de empleados cargada y accesible.
        // Puedes utilizar un ciclo for o métodos de búsqueda según tu implementación.
        // Este es solo un ejemplo básico:
        for (Empleado empleado : ListaEmpleado.getInstancia().getListaEmpleados()) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null; // Retornar null si no se encuentra el empleado
    }
}

