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
private String nombreUsuario;
private String Tipo_Usuario;
private String contraseña;
private ConexionBD con;
//------------Declaracion de variables-------------//    
    //-----------------------Constructor Modulo usuario------------------------------------------------------------
    public Modulo_Usuario(String nombreUsuario,String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        con = new ConexionBD();
    }//Fin del constructor 
  
    //-----------------------Devuelve Falso o verdadero si el contraseña y usuario existen-------------------------------
    public boolean validateUser(){
        con.openConexion();
        if(con.consulta("USUARIOS","[NOMBRE USUARIO]", this.nombreUsuario) &&
           con.consulta("USUARIOS","CONTRASEÑA", this.contraseña) ){
           this.Tipo_Usuario = con.consultaT(this.nombreUsuario, this.contraseña); 
           con.closeConexion();
           return true;
        }
        con.closeConexion();
       return false;
    }//fin de iniciar seseion


//----------------------------------------Metodos get y Set-------------------------------------------------------------------------
    public String getNombreUsuario() {
        return nombreUsuario;
        
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
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
