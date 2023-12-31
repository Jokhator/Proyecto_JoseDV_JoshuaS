/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Grafos;

/**
 * @author jdvc, jgsm
 * @time 4:20:05 PM
 * @date Jun 28, 2023
 */

public class CaminosMinimos {

    //metodo para derminar xaminos segun el algoritmo de floyd
    public String algoritmoFloyd(double[][] mAdy) {

        int vertices = mAdy.length;
        double matrizAdyacencia[][] = mAdy;
        String caminos[][] = new String[vertices][vertices];
        String caminosAuxiliares[][] = new String[vertices][vertices];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        int i, j, k;
        double temporal1, temporal2, temporal3, temporal4, minimo;
        //inicializar matrices y caminos 
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                caminos[i][j] = "";
                caminosAuxiliares[i][j] = "";
            }
        }

        for (k = 0; k < vertices; k++) {
            for (i = 0; i < vertices; i++) {
                for (j = 0; j < vertices; j++) {

                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    //encontrando al minimo
                    minimo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minimo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliares[1][j] = k + "";
                            caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);

                        }
                    }
                    matrizAdyacencia[i][j] = minimo;
                }
            }
        }
        //agregando el camino a cadeba
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 999999999.0) {
                    cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
                } else {
                    cadena = cadena + "[NH]";
                }
            }
            cadena = cadena + "\n";
        }
        for (i = 0; i < vertices; i++) {
            for (j = 0; j < vertices; j++) {
                if (matrizAdyacencia[i][j] != 999999999.0) {
                    if (i != j) {
                        if (caminos[i][j].equals("")) {
                            caminitos += "de (" + (i + 1) + "---->" + (j + 1) + ") irse por...(" + (i + 1) + ", " + (j + 1) + ")\n";
                        } else {
                            caminitos += "de (" + (i + 1) + "---->" + (j + 1) + ") irse por...(" + (i + 1) + ", " + caminos[i][j] + ", " + (j + 1) + ")\n";
                        }
                    }
                }
            }
        }

        return "LA MATRIZ DE CAMINOS MAS CORTOS ENTRE LOS DIFERENTES VERTICES ES \n" + cadena
                + "\n LOS DIFERENTES CAMINOS MAS CORTOS ENTRE VERTICES SON:\n" + caminitos;
    }

    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
        if (caminosAuxiliares[i][k].equals("")) {
            return "";
        } else {
            caminoRecorrido += caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido) + (Integer.parseInt(caminosAuxiliares[i][k].toString()) + 1) + ", ";
            return caminoRecorrido;
        }
    }

}
