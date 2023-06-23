/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Registros;

/**
 * @author Jose Daniel Vargas C
 * @time 2:17:06 PM
 * @date Jun 23, 2023
 */
public class Cliente {
    String pasaporte, nombre;
    int telefono, edad;
    String correo, nacionalidad;

    public Cliente() {
    }

    public Cliente(String pasaporte, String nombre, int telefono, int edad, String correo, String nacionalidad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
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

    @Override
    public String toString() {
        return "Cliente{" + "pasaporte=" + pasaporte + ", nombre=" + nombre + ", telefono=" + telefono + ", edad=" + edad + ", correo=" + correo + ", nacionalidad=" + nacionalidad + '}';
    }
    
    public String save() {
        return pasaporte + "|" + nombre + "|" + telefono + "|" + edad + "|" + correo + "|" + nacionalidad;
    }
    
    
}
