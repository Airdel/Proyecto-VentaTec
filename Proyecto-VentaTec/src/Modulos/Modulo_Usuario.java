/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;


/**
 *
 * @author LUIS INC
 */
public class Modulo_Usuario {
    
//------------Declaracion de variables-------------//
private int idUsuario;
private String nombreUsuario;
private String nombreReal;
private String Tipo_Usuario;
private String contraseña;
private String telefono;
private String domicilio;
private ConexionBD con;
//------------Declaracion de variables-------------//    
    //-----------------------Constructor Modulo usuario------------------------------------------------------------
    public Modulo_Usuario(){
        this.nombreUsuario = "";
        this.contraseña = "";
        this.nombreReal = "";
        this.telefono = "";
        this.Tipo_Usuario = "";
        this.telefono = "";
        this.idUsuario = 0;
        con = new ConexionBD();
    }//Fin del constructor 
  
    //-----------------------Devuelve Falso o verdadero si el contraseña y usuario existen-------------------------------
    public boolean validateUser(){
        con.openConexion();
        if(con.consulta("USUARIOS","[NOMBRE USUARIO]", this.nombreUsuario) &&
           con.consulta("USUARIOS","CONTRASEÑA", this.contraseña) ){
           this.Tipo_Usuario = con.consultaT("[TIPO USUARIO]",this.nombreUsuario, this.contraseña); 
           this.nombreReal = con.consultaT("[NOMBRE]",this.nombreUsuario, this.contraseña); 
           this.idUsuario = Integer.parseInt(con.consultaT("[ID USUARIO]",this.nombreUsuario, this.contraseña) + "");
           con.closeConexion();
           return true;
        }
        con.closeConexion();
       return false;
    }//fin de iniciar seseion
    
    public void agregarUsu(){
        con.openConexion();
        con.agregaUsuario(nombreReal,nombreUsuario,contraseña,Tipo_Usuario,telefono,domicilio);
        con.closeConexion();
    }

//----------------------------------------Metodos get y Set-------------------------------------------------------------------------
    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
        
    }
    public String getNombreReal() {
        return nombreReal;
    }
    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDomicilio(String domicilio) {    
        this.domicilio = domicilio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ConexionBD getConexion() {
        return con;
    }

    public void setConexion(ConexionBD conexion) {
        this.con = conexion;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    @Override
    public String toString() {
        return "Modulo_Usuario{" + "nombreUsuario=" + nombreUsuario + ", Tipo_Usuario=" + Tipo_Usuario + ", contrase\u00f1a=" + contraseña ;
    }
    
}//Fin Class
