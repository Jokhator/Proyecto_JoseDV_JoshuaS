/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Registros;

/**
 * @author Jose Daniel Vargas C
 * @time 9:30:51 PM
 * @date Jun 22, 2023
 */
public class Vuelo {
    String idVuelo;
    Empleado piloto;
    Empleado copiloto;
    String origen;
    String destino;
    String codAreopuertoSalida;
    String codAeropuertoEntrada;
    String fechaSalida;
    String fechaEntrada;
    String horaSalida;
    String horaEntrada;
    String idAvion;
    int capacidad;
    double costoPasaje;
    double costoTotalAerolinea;

    public Vuelo() {
    }

    public Vuelo(String idVuelo, Empleado piloto, Empleado copiloto, String origen, String destino, String codAreopuertoSalida, String codAeropuertoEntrada, String fechaSalida, String fechaEntrada, String horaSalida, String horaEntrada, String idAvion, int capacidad, double costoPasaje, double costoTotalAerolinea) {
        this.idVuelo = idVuelo;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.origen = origen;
        this.destino = destino;
        this.codAreopuertoSalida = codAreopuertoSalida;
        this.codAeropuertoEntrada = codAeropuertoEntrada;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
        this.idAvion = idAvion;
        this.capacidad = capacidad;
        this.costoPasaje = costoPasaje;
        this.costoTotalAerolinea = costoTotalAerolinea;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Empleado getPiloto() {
        return piloto;
    }

    public void setPiloto(Empleado piloto) {
        this.piloto = piloto;
    }

    public Empleado getCopiloto() {
        return copiloto;
    }

    public void setCopiloto(Empleado copiloto) {
        this.copiloto = copiloto;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCodAreopuertoSalida() {
        return codAreopuertoSalida;
    }

    public void setCodAreopuertoSalida(String codAreopuertoSalida) {
        this.codAreopuertoSalida = codAreopuertoSalida;
    }

    public String getCodAeropuertoEntrada() {
        return codAeropuertoEntrada;
    }

    public void setCodAeropuertoEntrada(String codAeropuertoEntrada) {
        this.codAeropuertoEntrada = codAeropuertoEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(String idAvion) {
        this.idAvion = idAvion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCostoPasaje() {
        return costoPasaje;
    }

    public void setCostoPasaje(double costoPasaje) {
        this.costoPasaje = costoPasaje;
    }

    public double getCostoTotalAerolinea() {
        return costoTotalAerolinea;
    }

    public void setCostoTotalAerolinea(double costoTotalAerolinea) {
        this.costoTotalAerolinea = costoTotalAerolinea;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idVuelo=" + idVuelo + ", piloto=" + piloto.getId() + ", copiloto=" + copiloto.getId() + ", origen=" + origen + ", destino=" + destino + ", codAreopuertoSalida=" + codAreopuertoSalida + ", codAeropuertoEntrada=" + codAeropuertoEntrada + ", fechaSalida=" + fechaSalida + ", fechaEntrada=" + fechaEntrada + ", horaSalida=" + horaSalida + ", horaEntrada=" + horaEntrada + ", idAvion=" + idAvion + ", capacidad=" + capacidad + ", costoPasaje=" + costoPasaje + ", costoTotalAerolinea=" + costoTotalAerolinea + '}';
    }
    
    public String save() {
        return idVuelo + "|" + piloto.getId() + "|" + copiloto.getId() + "|" + origen + "|" + destino + "|" + codAreopuertoSalida + "|" + codAeropuertoEntrada + "|" + fechaSalida 
                + "|" + fechaEntrada + "|" + horaSalida + "|" + horaEntrada + "|" + idAvion + "|" + capacidad + "|" + costoPasaje + "|" + costoTotalAerolinea;
    }
}
