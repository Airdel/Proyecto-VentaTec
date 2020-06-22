/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.*;
import Modulos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author INOVATEC
 */
public class Manejador_Principal {
    //-------Declaracion de variables---------------------------//
    private String TipoUsu;
    //-----Interfaz_x-------------------//
    private Interfaz_Documentacion ID = new Interfaz_Documentacion();
    private Interfaz_InicioSesion IN;
    private Interfaz_Inventario II = new Interfaz_Inventario();
    private Interfaz_Principal IP;
    private Interfaz_Registro IR = new Interfaz_Registro();
    private Interfaz_Venta IV;
    private Interfaz_CerrarCaja ICC = new Interfaz_CerrarCaja();
    private Interfaz_AbrirCaja IAC = new Interfaz_AbrirCaja();
    private Interfaz_AgregaUsu IAU = new Interfaz_AgregaUsu();
    //-----Interfaz_x-------------------//
    //-----Modulo_x-------------------//
    private Modulo_Documentos MD = new Modulo_Documentos();
    private Modulo_Inventario MI = new Modulo_Inventario();
    private Modulo_Principal MP;
    private Modulo_Registro MR = new Modulo_Registro();
    private Modulo_Venta MV;
    private Modulo_CerrarCaja MCC = new Modulo_CerrarCaja();
    private Modulo_AbrirCaja MAC = new Modulo_AbrirCaja();
    private Modulo_Usuario MU = new Modulo_Usuario();
    //-----Modulo_x-------------------//
    //-----Manejador_x-------------------//
    private Manejador_Documentacion MAD = new Manejador_Documentacion(ID, MD);
    private Manejador_Inventario MAI = new Manejador_Inventario(II,MI);
    private Manejador_Principal MAP;
    private Manejador_Registro MAR = new Manejador_Registro(IR, MR);
    private Manejador_Ventas MAV;
    private Manejador_CerrarCaja MACC = new Manejador_CerrarCaja(ICC, MCC);
    private Manejador_AbrirCaja MAAC = new Manejador_AbrirCaja(IAC, MAC);
    private Manejador_NuevoUsu MNU = new Manejador_NuevoUsu(IAU, MU);
    //-----Manejador_x-------------------// 
    //-----Inicio de Ventana Principal-------------------// 
    public Manejador_Principal(Interfaz_Principal IP1, Modulo_Principal MP1,String T) {
        //------------Inicializacion de variables-----------//
        this.TipoUsu = T;
        this.IP = IP1;
        this.MP = MP1;
        ValidaUsu();
        //------Colocando interfaz no editable-------//
        IR.setEnabled(false);
        ID.setEnabled(false);
        II.setEnabled(false);
        ICC.setEnabled(false);
        IAC.setEnabled(false);
        //IAU.setEnabled(false);
        //------Agregando interfaz a desktop---------//
        IP.Ventana_JPanelPrincipal.add(IR);
        IP.Ventana_JPanelPrincipal.add(ID);
        IP.Ventana_JPanelPrincipal.add(II);
        IP.Ventana_JPanelPrincipal.add(IAU);
        IP.Ventana_JPanelPrincipal.add(ICC);
        IP.Ventana_JPanelPrincipal.add(IAC);
        //------------Inicializacion de variables-----------//
        //------Action Listener Performed-----------------------//
        this.IP.btn_CerrarSesion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //----Inicia ventana Inicio de secion---//
                IN = new Interfaz_InicioSesion();
                //----Inicia ventana Inicio de secion---//
                //----Cierra interfaz Principal abre Inicio de secion---//
                IN.setVisible(true);
                IP.dispose();
                //----Cierra interfaz Principal abre Inicio de secion---//
            }
        });
        this.IP.btn_VentanaNuevaVenta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //------Inicializacion de Ventana----------//
                IV = new Interfaz_Venta();
                MV = new Modulo_Venta();
                MAV = new Manejador_Ventas(IV, MV, TipoUsu,IP);
                
                //------Inicializacion de Ventana----------//
                //------Cierre de ventana principal y visualiza Venta----------//
                IP.setVisible(false);
                IV.setVisible(true);
                //------Cierre de ventana principal y visualiza Venta----------//
            }
        });
        this.IP.btn_CrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //----Revisa si esta abierto Crear Usuario---//
                if(IAU.isVisible() == false){
                    IAU.setVisible(true);
                    IAU.setEnabled(true);
                }
                //----Revisa si esta abierto Crear Usuario---//
            }
        });
        this.IP.btn_VentanaDocumentos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //----Revisa si esta abierto Documentos---//
                if(ID.isVisible()==false){
                    ID.setVisible(true);
                    ID.setEnabled(true);
                }
                //----Revisa si esta abierto Documentos---//
            }
        });
        this.IP.btn_VentanaInventario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //----Revisa si esta abierto Inventario---//
                if(II.isVisible()==false){
                    II.setVisible(true);
                    II.setEnabled(true);
                }
                //----Revisa si esta abierto Inventario---// 
            }
        });
        this.IP.btn_VentanaRegistrarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //----Revisa si esta abierto Registro---// 
                if(IR.isVisible() == false){
                    IR.setVisible(true);
                    IR.setEnabled(true);
                }
                //----Revisa si esta abierto Registro---//
            }
        });
        this.IP.btn_CerrarCaja.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
               //----Revisa si esta abierto Cerrar Caja---//
                if(ICC.isVisible()==false){
                    MACC.setMAC(MAC);
                    ICC.setVisible(true);
                    ICC.setEnabled(true);
                }
               //----Revisa si esta abierto Cerrar Caja---//
           } 
        });
        this.IP.btn_AbrirCaja.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
               //----Revisa si esta abierto Abrir Caja---//
                if(IAC.isVisible()==false ){
                    IAC.setVisible(true);
                    IAC.setEnabled(true);
                    IP.btn_CerrarCaja.setEnabled(true);
                    IP.btn_AbrirCaja.setEnabled(false);
                    IP.btn_VentanaNuevaVenta.setEnabled(true);
                }
               //----Revisa si esta abierto Abrir Caja---//
           } 
        });
        //------Action Listener Performed-----------------------//
    }
    //---------------Fin Constructor------------------//
    //---------------Funciones Void------------------//
    public void ValidaUsu(){
        if(TipoUsu.equals("G")){
            IP.btn_VentanaDocumentos.setVisible(true);
            IP.btn_CrearUsuario.setVisible(true);
            IP.btn_VentanaInventario.setVisible(true);
        }else if(TipoUsu.equals("U")){
            IP.btn_VentanaDocumentos.setVisible(false);
            IP.btn_CrearUsuario.setVisible(false);
            IP.btn_VentanaInventario.setVisible(false);
        }else{System.out.println("No encontro Tipo Usuario");}
    }// Fin ValidaUsu
    //---------------Funciones Void------------------//
}
