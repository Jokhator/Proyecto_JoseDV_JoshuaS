/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Mantenimiento;

import SampleClasses.Empleado;
import Listas.ListaVuelo;
import SampleClasses.Vuelo;
import Seguridad.Comprobaciones;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jdvc, jgsm
 */
public class RegistroVuelo extends javax.swing.JFrame {

    /**
     * Creates new form AgregarEmpleados
     */
    ListaVuelo listaVuelos = ListaVuelo.getInstancia();
    Comprobaciones comporbaciones = new Comprobaciones();

    public RegistroVuelo() {
        initComponents();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                confirmarCierreVentana();
            }
        });
    }

    public void limpiarTxt() {
        txt_idPiloto.setText("");
        txt_idVuelo.setText("");
        txt_idCopiloto.setText("");
        txt_origen.setText("");
        txt_destino.setText("");
        txt_aeropuertoSalida.setText("");
        txt_aeropuertoEntrada.setText("");
        txt_idAvion.setText("");
        txt_capacidad.setText("");
        txt_costoBoleto.setText("");
        txt_costoTotal.setText("");
    }

    private void confirmarCierreVentana() {
        // Aquí puedes mostrar un mensaje de confirmación y realizar acciones adicionales antes de cerrar la ventana
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas cerrar la ventana?", "Confirmar cierre", javax.swing.JOptionPane.YES_NO_OPTION);
        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            listaVuelos.write();
            dispose(); // Cerrar la ventana
        }
    }

    // Método para obtener la fecha actual
    private static String obtenerFechaActual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Método para sumar 2 meses a una fecha
    private static String sumarDias(String fecha) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date fechaDate = dateFormat.parse(fecha);
            calendar.setTime(fechaDate);

            // Sumar aleatoriamente entre 1 y 2 días
            int diasAleatorios = (int) (Math.random() * 1) + 1;
            calendar.add(Calendar.DAY_OF_MONTH, diasAleatorios);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    private static String sumarMeses(String fecha) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(fecha));

            // Sumar aleatoriamente entre 1 y 11 meses
            int mesesAleatorios = (int) (Math.random() * 12) + 1;
            calendar.add(Calendar.MONTH, mesesAleatorios);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateFormat.format(calendar.getTime());
    }

    // Método para generar una hora aleatoria
    private static String generarHoraAleatoria() {
        Random random = new Random();
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        return String.format("%02d:%02d", hour, minute);
    }

    // Método para generar la hora de llegada basada en la hora de salida
    private static String generarHoraLlegada(String horaSalida, String fechaSalida, String fechaEntrada) {
        Random random = new Random();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Calendar calendarSalida = Calendar.getInstance();
        Calendar calendarLlegada = Calendar.getInstance();
        try {
            calendarSalida.setTime(timeFormat.parse(horaSalida));
            calendarLlegada.setTime(timeFormat.parse(horaSalida));

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaSalidaDate = dateFormat.parse(fechaSalida);
            Date fechaEntradaDate = dateFormat.parse(fechaEntrada);

            if (fechaEntradaDate.after(fechaSalidaDate)) {
                // Si la fecha de entrada es posterior a la fecha de salida, la hora de llegada puede ser cualquier hora
                // después de la hora de salida en el mismo día.
                int minHoraLlegada = calendarSalida.get(Calendar.HOUR_OF_DAY) + 2; // Hora de salida + 2 horas
                int maxHoraLlegada = 23; // Última hora del día
                int diferenciaHoras = maxHoraLlegada - minHoraLlegada + 1; // +1 para incluir la última hora
                int horasAleatorias = random.nextInt(diferenciaHoras) + minHoraLlegada;
                calendarLlegada.set(Calendar.HOUR_OF_DAY, horasAleatorias);
            } else {
                // Si la fecha de entrada es el mismo día que la fecha de salida, la hora de llegada debe ser posterior
                // a la hora de salida y tener al menos 2 horas de diferencia.
                int minHoraLlegada = calendarSalida.get(Calendar.HOUR_OF_DAY) + 2; // Hora de salida + 2 horas
                int maxHoraLlegada = 23; // Última hora del día
                int diferenciaHoras = maxHoraLlegada - minHoraLlegada + 1; // +1 para incluir la última hora
                int horasAleatorias = random.nextInt(diferenciaHoras) + minHoraLlegada;
                calendarLlegada.set(Calendar.HOUR_OF_DAY, horasAleatorias);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return timeFormat.format(calendarLlegada.getTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idVuelo = new javax.swing.JTextField();
        txt_idPiloto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_origen = new javax.swing.JTextField();
        txt_capacidad = new javax.swing.JTextField();
        btn_Agregar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_BuscarID = new javax.swing.JButton();
        btn_BuscarN = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Mostrar = new javax.swing.JButton();
        txt_destino = new javax.swing.JTextField();
        txt_idCopiloto = new javax.swing.JTextField();
        txt_idAvion = new javax.swing.JTextField();
        txt_aeropuertoSalida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_costoBoleto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_aeropuertoEntrada = new javax.swing.JTextField();
        txt_costoTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vuelos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel1.setText("Id Piloto:");

        txt_idPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idPilotoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel3.setText("Id Copiloto");

        jLabel4.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel4.setText("País Salida:");

        jLabel5.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel5.setText("Id Vuelo:");

        jLabel6.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel6.setText("País Llegada:");

        jLabel7.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel7.setText("Id avión:");

        txt_origen.setToolTipText("");
        txt_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_origenActionPerformed(evt);
            }
        });

        txt_capacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_capacidadActionPerformed(evt);
            }
        });

        btn_Agregar.setText("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Modificar.setText("Modificar");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });

        btn_BuscarID.setText("Buscar ID");
        btn_BuscarID.setToolTipText("");
        btn_BuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarIDActionPerformed(evt);
            }
        });

        btn_BuscarN.setText("Buscar Nombre");
        btn_BuscarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarNActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Mostrar.setText("Mostrar");
        btn_Mostrar.setToolTipText("");
        btn_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MostrarActionPerformed(evt);
            }
        });

        txt_destino.setToolTipText("");
        txt_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_destinoActionPerformed(evt);
            }
        });

        txt_idCopiloto.setToolTipText("");
        txt_idCopiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCopilotoActionPerformed(evt);
            }
        });

        txt_idAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idAvionActionPerformed(evt);
            }
        });

        txt_aeropuertoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aeropuertoSalidaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel8.setText("Codigo Aeropuerto Salida:");

        jLabel9.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel9.setText("Capacidad del avión:");

        jLabel10.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel10.setText("Codigo Aeropuerto Llegada:");

        txt_costoBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoBoletoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel11.setText("Costo boleto:");

        jLabel12.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel12.setText("Costo del vuelo:");

        txt_aeropuertoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aeropuertoEntradaActionPerformed(evt);
            }
        });

        txt_costoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costoTotalActionPerformed(evt);
            }
        });

        tbl_vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_vuelos.setEnabled(false);
        jScrollPane1.setViewportView(tbl_vuelos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(3, 3, 3)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_idVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_destino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_origen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_idCopiloto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_idPiloto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_idAvion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_aeropuertoSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_costoBoleto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_capacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_aeropuertoEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_costoTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGap(184, 184, 184)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_BuscarN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_BuscarID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jLabel9))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(373, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_idVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idPiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btn_BuscarID)
                    .addComponent(txt_idCopiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(btn_BuscarN))
                    .addComponent(txt_origen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btn_Eliminar)
                    .addComponent(txt_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Mostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(txt_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_aeropuertoSalida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_aeropuertoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_costoBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_costoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_costoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoTotalActionPerformed

    private void txt_aeropuertoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aeropuertoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aeropuertoEntradaActionPerformed

    private void txt_costoBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costoBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costoBoletoActionPerformed

    private void txt_aeropuertoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aeropuertoSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aeropuertoSalidaActionPerformed

    private void txt_idAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idAvionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idAvionActionPerformed

    private void txt_idCopilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCopilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCopilotoActionPerformed

    private void txt_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_destinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_destinoActionPerformed

    private void btn_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MostrarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Vuelo");
        modeloTabla.addColumn("Piloto (ID)");
        modeloTabla.addColumn("Copiloto (ID)");
        modeloTabla.addColumn("Origen");
        modeloTabla.addColumn("Destino");
        modeloTabla.addColumn("Código Aeropuerto Salida");
        modeloTabla.addColumn("Código Aeropuerto Entrada");
        modeloTabla.addColumn("Fecha Salida");
        modeloTabla.addColumn("Fecha Entrada");
        modeloTabla.addColumn("Hora Salida");
        modeloTabla.addColumn("Hora Entrada");
        modeloTabla.addColumn("ID Avión");
        modeloTabla.addColumn("Capacidad");
        modeloTabla.addColumn("Costo Pasaje");
        modeloTabla.addColumn("Costo Total Aerolínea");

        for (Vuelo vuelo : listaVuelos.getListaVuelos()) {
            Object[] fila = new Object[15]; // Crea un arreglo para almacenar los datos de cada vuelo

            fila[0] = vuelo.getIdVuelo();
            fila[1] = vuelo.getPiloto().getId();
            fila[2] = vuelo.getCopiloto().getId();
            fila[3] = vuelo.getOrigen();
            fila[4] = vuelo.getDestino();
            fila[5] = vuelo.getCodAreopuertoSalida();
            fila[6] = vuelo.getCodAeropuertoEntrada();
            fila[7] = vuelo.getFechaSalida();
            fila[8] = vuelo.getFechaEntrada();
            fila[9] = vuelo.getHoraSalida();
            fila[10] = vuelo.getHoraEntrada();
            fila[11] = vuelo.getIdAvion();
            fila[12] = vuelo.getCapacidad();
            fila[13] = vuelo.getCostoPasaje();
            fila[14] = vuelo.getCostoTotalAerolinea();

            modeloTabla.addRow(fila); // Agrega la fila al modelo de tabla
        }

        tbl_vuelos.setModel(modeloTabla);
        modeloTabla.fireTableDataChanged();
        listaVuelos.write();
        //listaEmps.write();
    }//GEN-LAST:event_btn_MostrarActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
            if (listaVuelos.getListaVuelos().get(i).getIdVuelo().equals(txt_idVuelo.getText())) {
                listaVuelos.getListaVuelos().remove(i);
                JOptionPane.showMessageDialog(this, "Vuelo eliminado correctamente!");
                btn_MostrarActionPerformed(evt);
                limpiarTxt();
            }
        }
        limpiarTxt();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_BuscarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarNActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
            if (String.valueOf(listaVuelos.getListaVuelos().get(i).getCostoTotalAerolinea()).equals(txt_costoTotal.getText())) {
                JOptionPane.showMessageDialog(this, listaVuelos.getListaVuelos().get(i).toString());
                limpiarTxt();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró el nombre");
        limpiarTxt();
    }//GEN-LAST:event_btn_BuscarNActionPerformed

    private void btn_BuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarIDActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listaVuelos.getListaVuelos().size(); i++) {
            if (listaVuelos.getListaVuelos().get(i).getIdVuelo().equals(txt_idVuelo.getText())) {
                JOptionPane.showMessageDialog(this, listaVuelos.getListaVuelos().get(i).toString());
                limpiarTxt();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No se encontró la ID");
        limpiarTxt();
    }//GEN-LAST:event_btn_BuscarIDActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        // TODO add your handling code here:
        btn_Eliminar.doClick();
        btn_Agregar.doClick();
        limpiarTxt();
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        // TODO add your handling code here:
        // Obtener los valores de los campos de texto
        String idVuelo = txt_idVuelo.getText();
        String idPiloto = txt_idPiloto.getText();
        String idCopiloto = txt_idCopiloto.getText();
        String origen = txt_origen.getText();
        String destino = txt_destino.getText();
        String codAreopuertoSalida = txt_aeropuertoSalida.getText();
        String codAeropuertoEntrada = txt_aeropuertoEntrada.getText();
        String fechaSalida = sumarMeses(obtenerFechaActual());
        String fechaEntrada = sumarDias(fechaSalida);
        String horaSalida = generarHoraAleatoria();
        String horaEntrada = generarHoraLlegada(horaSalida, fechaSalida, fechaEntrada);
        String idAvion = txt_idAvion.getText();

        int capacidad = comporbaciones.esInt(txt_capacidad.getText());
        double costoPasaje = comporbaciones.esDouble(txt_costoBoleto.getText());
        double costoTotalAerolinea = comporbaciones.esDouble(txt_costoTotal.getText());
        // Crear objeto Vuelo con los valores obtenidos
        Empleado piloto;
        Empleado copiloto;
        if (comporbaciones.existeEmpleado(this, idPiloto) && comporbaciones.existeEmpleado(this, idCopiloto) && capacidad > 0 && costoPasaje > 0 && costoTotalAerolinea > 0) {
            piloto = comporbaciones.devolverEmpleado(this, idPiloto);
            copiloto = comporbaciones.devolverEmpleado(this, idCopiloto);
            Vuelo vuelo;
            if (piloto.getDepartamento().equals("Piloto") && copiloto.getDepartamento().equals("Copiloto")) {
                vuelo = new Vuelo(idVuelo, piloto, copiloto, origen, destino, codAreopuertoSalida,
                        codAeropuertoEntrada, fechaSalida, fechaEntrada, horaSalida, horaEntrada,
                        idAvion, capacidad, costoPasaje, costoTotalAerolinea);
                listaVuelos.getListaVuelos().add(vuelo);
            } else {
                JOptionPane.showMessageDialog(this, "El piloto o copiloto no se encuentran en el departamento respectivo.");
            }
        }
        btn_Mostrar.doClick();
        limpiarTxt();
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void txt_capacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_capacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_capacidadActionPerformed

    private void txt_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_origenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_origenActionPerformed

    private void txt_idPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idPilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idPilotoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVuelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_BuscarID;
    private javax.swing.JButton btn_BuscarN;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_vuelos;
    private javax.swing.JTextField txt_aeropuertoEntrada;
    private javax.swing.JTextField txt_aeropuertoSalida;
    private javax.swing.JTextField txt_capacidad;
    private javax.swing.JTextField txt_costoBoleto;
    private javax.swing.JTextField txt_costoTotal;
    private javax.swing.JTextField txt_destino;
    private javax.swing.JTextField txt_idAvion;
    private javax.swing.JTextField txt_idCopiloto;
    private javax.swing.JTextField txt_idPiloto;
    private javax.swing.JTextField txt_idVuelo;
    private javax.swing.JTextField txt_origen;
    // End of variables declaration//GEN-END:variables
}
