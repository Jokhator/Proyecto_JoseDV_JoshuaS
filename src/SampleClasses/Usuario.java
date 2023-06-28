/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package SampleClasses;

/**
 * @author jdvc, jgsm
 * @time 11:33:16 PM
 * @date Jun 24, 2023
 */
public class Usuario {
    private String user, contrasenia;
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String user, String contrasenia, Empleado empleado) {
        this.user = user;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", contrasenia=" + contrasenia + ", empleado=" + empleado + '}';
    }
    
    public String save() {
        return user + "|" + contrasenia + "|" + empleado.getId();
    }
    
}
