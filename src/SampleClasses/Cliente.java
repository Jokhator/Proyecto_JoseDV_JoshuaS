/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SampleClasses;

/**
 * @author jdvc, jgsm
 * @time 2:17:06 PM
 * @date Jun 23, 2023
 */
public class Cliente {

    private String pasaporte, nombre, correo, nacionalidad;
    private int telefono, edad, vuelosComprados;

    public Cliente() {
    }

    public Cliente(String pasaporte, String nombre, int telefono, int edad, String correo, String nacionalidad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
        this.vuelosComprados = 0;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getVuelosComprados() {
        return vuelosComprados;
    }

    public void setVuelosComprados(int vuelosComprados) {
        this.vuelosComprados = vuelosComprados;
    }

    @Override
    public String toString() {
        return "Cliente{" + "pasaporte=" + pasaporte + ", nombre=" + nombre + ", correo=" + correo + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", edad=" + edad + ", vuelosComprados=" + vuelosComprados + '}';
    }

    public String save() {
        return pasaporte + "|" + nombre + "|" + telefono + "|" + edad + "|" + correo + "|" + nacionalidad + "|" + vuelosComprados;
    }

}
