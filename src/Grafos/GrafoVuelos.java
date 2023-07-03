/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

/**
 * @author Jose Daniel Vargas C
 * @time 4:20:51 PM
 * @date Jun 28, 2023
 */
import Listas.ListaVuelo;
import SampleClasses.Vuelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Seguridad.Comprobaciones;
import java.util.Collections;
import java.util.LinkedHashSet;

public class GrafoVuelos {
    
    static ArrayList<String> aeropuertos = new ArrayList<>();
    
    public void grafo(String origen, String destino, int espacios) {
        Comprobaciones comprobaciones = new Comprobaciones();
        ArrayList<Double> precios = new ArrayList<>();
        double matrizA[][];
        
        matrix(origen, destino);
        matrizA = new double[aeropuertos.size()][aeropuertos.size()];
        System.out.println(aeropuertos.size());
        for (int i = 0; i < aeropuertos.size(); i++) {
            System.out.println(aeropuertos.get(i));
        }
        
        
        for (int i = 0; i < matrizA.length; i++) {
            boolean exVuelo = false;
            for (int j = 0; j < matrizA[i].length; j++) {
                if (i != j) {
                    String aer1 = aeropuertos.get(j);
                    String aer2 = aeropuertos.get(i);
                    //recorrer lista vuelos, buscando un vuelo que tenga los 2 aeropuertos que coincidad y si lo hacen, se le ponde un precio
                    if (comprobaciones.existenAeropuertos(aer1, aer2)) {
                        if(comprobaciones.devolverVueloAeropuertos(aer1, aer2).getCapacidad() > espacios){
                        matrizA[i][j] = comprobaciones.devolverVueloAeropuertos(aer1, aer2).getCostoPasaje();
                        }
                    } else {
                        matrizA[i][j] = 999999999.0;
                    }
                }else matrizA[i][j] = 0.0;
            }
        }
        CaminosMinimos ruta = new CaminosMinimos();
        //ordenarListas(matrizA);
        String aeropst = "\n\nNumeros que representan los aeropuertos: \n";
        for (int i = 0; i < aeropuertos.size(); i++) {
            aeropst += (i + 1) + ") " + aeropuertos.get(i) + "\n";
            
        }
        JOptionPane.showMessageDialog(null, ruta.algoritmoFloyd(matrizA) + aeropst);
    }
    
    public int convertirAEntero(String cadena) {
        if (esNumero(cadena)) {
            return Integer.parseInt(cadena);
        } else {
            System.out.println("El string no contiene solo números.");
            return -1;
        }
    }
    
    public boolean esNumero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public void matrix(String ori, String dest) {
    ListaVuelo listaVuelos = ListaVuelo.getInstancia();
    for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
        boolean existe = false;
        Vuelo vuelo = listaVuelos.getListaVuelos().get(i);
        for (int j = 0; j < aeropuertos.size(); j++) {
            if (aeropuertos.get(j).equals(listaVuelos.getListaVuelos().get(i).getOrigen())) {
                existe = true;
                break; // Salir del bucle una vez que se encuentra el aeropuerto
            }
        }
        if (!existe && listaVuelos.getListaVuelos().get(i).getOrigen().contains(ori)) {
            System.out.println("ELPEPE");
            aeropuertos.add(listaVuelos.getListaVuelos().get(i).getOrigen());
        }
    }

    for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
        boolean existe = false;
        Vuelo vuelo = listaVuelos.getListaVuelos().get(i);
        for (int j = 0; j < aeropuertos.size(); j++) {
            if (aeropuertos.get(j).equals(listaVuelos.getListaVuelos().get(i).getDestino())) {
                existe = true;
                break; // Salir del bucle una vez que se encuentra el aeropuerto
            }
        }
        if (!existe  && listaVuelos.getListaVuelos().get(i).getDestino().contains(dest)) {
            aeropuertos.add(listaVuelos.getListaVuelos().get(i).getDestino());
            System.out.println("ETESECH");
        }
    }
        System.out.println(ori + ", " + dest);
}

    public void ordenarListas(ArrayList<Double>[][] matriz) {
    int filas = matriz.length;
    int columnas = matriz[0].length;

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            // Obtener la lista en la posición actual
            ArrayList<Double> lista = matriz[i][j];
            
            // Ordenar la lista de menor a mayor
            Collections.sort(lista);
            
            // Eliminar elementos duplicados utilizando un LinkedHashSet
            LinkedHashSet<Double> conjuntoSinDuplicados = new LinkedHashSet<>(lista);
            
            // Limpiar la lista y agregar los elementos únicos nuevamente
            lista.clear();
            lista.addAll(conjuntoSinDuplicados);
        }
    }
}

    
    public ArrayList<Double>[][] crearMatriz(int filas, int columnas) {
        ArrayList<Double>[][] matriz = new ArrayList[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = new ArrayList<>();
            }
        }

        return matriz;
    }
    
}
