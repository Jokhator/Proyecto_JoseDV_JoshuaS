/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Registros;

/**
 * @author Jose Daniel Vargas C
 * @time 9:20:27 PM
 * @date Jun 20, 2023
 */
public class Empleado {
//Identificación, Nombre y Apellidos, Edad, Teléfono, Departamento de la empresa en la que labora (Ventas, Atención al cliente, Mostrador, 
    //Sobrecargo, Piloto, Administrativo), Salario y Fecha de ingreso a la empresa.
    String id;
    String nom;
    int edad;
    int telefono;
    String departamento;
    double salario;
    String fecha;

    public Empleado() {
    }

    public Empleado(String id, String nom, int edad, int telefono, String departamento, double salario, String fecha) {
        this.id = id;
        this.nom = nom;
        this.edad = edad;
        this.telefono = telefono;
        this.departamento = departamento;
        this.salario = salario;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nom=" + nom + ", edad=" + edad + ", telefono=" + telefono + ", departamento=" + departamento + ", salario=" + salario + ", fecha=" + fecha + '}';
    }
    
    public String save() {
        return id + "|" + nom + "|" + edad + "|" + telefono + "|" + departamento + "|" + salario + "|" + fecha;
    }
    
}
