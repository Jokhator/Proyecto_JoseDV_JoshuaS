/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;

import SampleClasses.Empleado;
import Listas.ListaCliente;
import javax.swing.JOptionPane;
import Listas.ListaEmpleado;
import Listas.ListaUsuario;
import Listas.ListaVuelo;
import SampleClasses.Cliente;
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
        if (ListaEmpleado.getInstancia().getListaEmpleados().isEmpty()) {
            return false;
        } else {
            int cont = 0;
            for (int i = 0; i < ListaEmpleado.getInstancia().getListaEmpleados().size(); i++) {
                if (!ListaEmpleado.getInstancia().getListaEmpleados().get(i).getId().equals(id)) {
                    cont++;
                }
            }
            if (cont == ListaEmpleado.getInstancia().getListaEmpleados().size()) {
                return false;
            } else {
                //JOptionPane.showMessageDialog(form, "No robe indentidades");
                return true;
            }
        }
    }

    public Empleado devolverEmpleado(javax.swing.JFrame form, String id) {
        if (ListaEmpleado.getInstancia().getListaEmpleados().isEmpty()) {
            return null;
        } else {
            for (Empleado empleado : ListaEmpleado.getInstancia().getListaEmpleados()) {
                if (empleado.getId().equals(id)) {
                    return empleado; // Devuelve el empleado si se encuentra la ID
                }
            }
            JOptionPane.showMessageDialog(form, "No se encontró ningún empleado con la ID especificada.");
            return null; // Retorna null si no se encuentra el empleado
        }
    }

    public boolean existeCliente(javax.swing.JFrame form, String pasaporte) {
        if (ListaCliente.getInstancia().getListaClientes().isEmpty()) {
            return false;
        } else {
            int cont = 0;
            for (int i = 0; i < ListaCliente.getInstancia().getListaClientes().size(); i++) {
                if (!ListaCliente.getInstancia().getListaClientes().get(i).getPasaporte().equals(pasaporte)) {
                    cont++;
                }
            }
            if (cont == ListaCliente.getInstancia().getListaClientes().size()) {
                return false;
            } else {
                JOptionPane.showMessageDialog(form, "Cliente encontrado.");
                return true;
            }
        }
    }
    
    public Cliente devolverCliente(javax.swing.JFrame form, String pasaporte) {
        Cliente cliente = null;
        if (ListaCliente.getInstancia().getListaClientes().isEmpty()) {
            return null;
        } else {
            int cont = 0;
            for (int i = 0; i < ListaCliente.getInstancia().getListaClientes().size(); i++) {
                if (!ListaCliente.getInstancia().getListaClientes().get(i).getPasaporte().equals(pasaporte)) {
                    
                    cont++;
                }else {
                    cliente = ListaCliente.getInstancia().getListaClientes().get(i);
                }
            }
            if (cont == ListaCliente.getInstancia().getListaClientes().size()) {
                return null;
            } else {
                JOptionPane.showMessageDialog(form, "Cliente encontrado.");
                return cliente;
            }
        }
    }

    public boolean existeUsuario(javax.swing.JFrame form, String username) {
        if (ListaUsuario.getInstancia().getListaUsuarios().isEmpty()) {
            return false;
        } else {
            for (Usuario usuario : ListaUsuario.getInstancia().getListaUsuarios()) {
                if (usuario.getUser().equals(username)) {
                    JOptionPane.showMessageDialog(form, "Usuario encontrado.");
                    return true;
                }
            }
            return false;
        }
    }

    public boolean existenAeropuertos(String origen, String destino) {
        if (ListaVuelo.getInstancia().getListaVuelos().isEmpty()) {
            return false;
        } else {
            for (Vuelo vuelo : ListaVuelo.getInstancia().getListaVuelos()) {
                if (vuelo.getDestino().equals(origen) && vuelo.getOrigen().equals(destino)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Vuelo devolverVueloAeropuertos(String destino, String origen) {
        List<Vuelo> vuelosCoincidentes = new ArrayList<>();

        for (Vuelo vuelo : ListaVuelo.getInstancia().getListaVuelos()) {
            if (vuelo.getDestino().contains(destino) && vuelo.getOrigen().contains(origen)) {
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
