/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;
import Interfaces.*;
import Modulos.Modulo_Principal;
import Modulos.Modulo_Usuario;

import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author Inovatec
 */
public class Manejador_InicioSesion{
    //------------Declaracion Variables----------------------//
    private Modulo_Usuario MU;
    private Interfaz_Principal IP;
    private Modulo_Principal MP;
    private Manejador_Principal MAP;
    //------------Declaracion Variables----------------------//
    
    //---------------------Inicia La interfaz Principal---------------------------//
    public Manejador_InicioSesion(String nombreUsuario,String contraseña,Interfaz_InicioSesion II) {
        //------------Inicializa las variables----------------------//
        MU = new Modulo_Usuario();
        MU.setNombreUsuario(nombreUsuario);
        MU.setContraseña(contraseña);
        //------------Inicializa las variables----------------------//
        //-------------Verificar Usuarios---------------------------//
            if(MU.validateUser()){
               II.dispose(); //---Cerrar ventana Inicio de secion
               //---Crear la interfaz bienvenida
               Interfaz_Bienvenida IB = new Interfaz_Bienvenida(MU.getTipo_Usuario(),MU.getNombreReal());
               IB.setVisible(true);
            }//Fin if
            else{
                showMessageDialog(null,"Usuario o Contraseña incorrectas");
            }//Fin else
        //-------------Verificar Usuarios---------------------------//
    }
    //---------------Fin del Constructor---------------//
    
    //---------- Get --------------//
    public boolean Estatus(){
        return MU.validateUser();
    }
    //---------- Get --------------// 
}//fin de la clase
