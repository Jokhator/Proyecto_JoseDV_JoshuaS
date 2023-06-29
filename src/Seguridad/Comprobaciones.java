/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import SampleClasses.Empleado;
import Listas.ListaClientes;
import javax.swing.JOptionPane;
import Listas.ListaEmpleados;
import Listas.ListaUsuarios;
import Listas.ListaVuelos;
import SampleClasses.Usuario;
import SampleClasses.Vuelo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jdvc, jgsm
 * @time 10:41:00 AM
 * @date Jun 23, 2023
 */
public class Comprobaciones {

    public double esDouble(String text) {
        if (!text.matches("\\d+(\\.\\d+)?")) {
            // No contiene solo números o el formato decimal es incorrecto, mostrar un mensaje de error o realizar alguna acción apropiada
            // Aquí puedes mostrar un mensaje de error en una etiqueta o lanzar una excepción, por ejemplo
            JOptionPane.showMessageDialog(null, "El campo debe contener solo números en formato decimal (por ejemplo, 1000 o 1000.50).");
            return -1; // Salir del método o realizar alguna acción adicional según sea necesario
        } else {
            return Double.parseDouble(text);
        }
    }

    public int esInt(String text) {
        if (!text.matches("\\d+")) {
            // No contiene solo números, mostrar un mensaje de error o realizar alguna acción apropiada
            // Aquí puedes mostrar un mensaje de error en una etiqueta o lanzar una excepción, por ejemplo
            JOptionPane.showMessageDialog(null, "El campo debe contener solo números sin decimal (por ejemplo, 500 o 1000).");
            return -1; // Salir del método o realizar alguna acción adicional según sea necesario
        } else {
            return Integer.parseInt(text);
        }
    }

    public boolean existeEmpleado(javax.swing.JFrame form, String id) {
        if (ListaEmpleados.getInstancia().getListaEmpleados().isEmpty()) {
            return false;
        } else {
            int cont = 0;
            for (int i = 0; i < ListaEmpleados.getInstancia().getListaEmpleados().size(); i++) {
                if (!ListaEmpleados.getInstancia().getListaEmpleados().get(i).getId().equals(id)) {
                    cont++;
                }
            }
            if (cont == ListaEmpleados.getInstancia().getListaEmpleados().size()) {
                return false;
            } else {
                //JOptionPane.showMessageDialog(form, "No robe indentidades");
                return true;
            }
        }
    }

    public Empleado devolverEmpleado(javax.swing.JFrame form, String id) {
        if (ListaEmpleados.getInstancia().getListaEmpleados().isEmpty()) {
            return null;
        } else {
            for (Empleado empleado : ListaEmpleados.getInstancia().getListaEmpleados()) {
                if (empleado.getId().equals(id)) {
                    return empleado; // Devuelve el empleado si se encuentra la ID
                }
            }
            JOptionPane.showMessageDialog(form, "No se encontró ningún empleado con la ID especificada.");
            return null; // Retorna null si no se encuentra el empleado
        }
    }

    public boolean existeCliente(javax.swing.JFrame form, String pasaporte) {
        if (ListaClientes.getInstancia().getListaClientes().isEmpty()) {
            return false;
        } else {
            int cont = 0;
            for (int i = 0; i < ListaClientes.getInstancia().getListaClientes().size(); i++) {
                if (!ListaClientes.getInstancia().getListaClientes().get(i).getPasaporte().equals(pasaporte)) {
                    cont++;
                }
            }
            if (cont == ListaClientes.getInstancia().getListaClientes().size()) {
                return false;
            } else {
                JOptionPane.showMessageDialog(form, "Cliente encontrado.");
                return true;
            }
        }
    }

    public boolean existeUsuario(javax.swing.JFrame form, String username) {
        if (ListaUsuarios.getInstancia().getListaUsuarios().isEmpty()) {
            return false;
        } else {
            for (Usuario usuario : ListaUsuarios.getInstancia().getListaUsuarios()) {
                if (usuario.getUser().equals(username)) {
                    JOptionPane.showMessageDialog(form, "Usuario encontrado.");
                    return true;
                }
            }
            return false;
        }
    }

    public boolean existenAeropuertos(String idAeropEntrada, String idAeropSalida) {
        if (ListaVuelos.getInstancia().getListaVuelos().isEmpty()) {
            return false;
        } else {
            for (Vuelo vuelo : ListaVuelos.getInstancia().getListaVuelos()) {
                if (vuelo.getCodAeropuertoEntrada().equals(idAeropEntrada) && vuelo.getCodAreopuertoSalida().equals(idAeropSalida)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Vuelo devolverVueloAeropuertos(String idAeropEntrada, String idAeropSalida) {
        List<Vuelo> vuelosCoincidentes = new ArrayList<>();

        for (Vuelo vuelo : ListaVuelos.getInstancia().getListaVuelos()) {
            if (vuelo.getCodAeropuertoEntrada().equals(idAeropEntrada) && vuelo.getCodAreopuertoSalida().equals(idAeropSalida)) {
                vuelosCoincidentes.add(vuelo);
            }
        }

        if (vuelosCoincidentes.isEmpty()) {
            return null;
        } else {
            Vuelo vueloMasBarato = vuelosCoincidentes.get(0);

            for (Vuelo vuelo : vuelosCoincidentes) {
                if (vuelo.getCostoPasaje() < vueloMasBarato.getCostoPasaje() && vuelo.getCapacidad() > 0) {
                    vueloMasBarato = vuelo;
                }
            }

            return vueloMasBarato;
        }
    }

}
