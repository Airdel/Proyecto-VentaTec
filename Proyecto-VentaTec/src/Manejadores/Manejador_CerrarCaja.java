/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_CerrarCaja;
import Modulos.Modulo_AbrirCaja;
import Modulos.Modulo_CerrarCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISM----------------------------------------------------------------
 */
public class Manejador_CerrarCaja {
    //---Declaracion de variables-----------//
    private Interfaz_CerrarCaja ICC;
    private Modulo_CerrarCaja MCC;
    private Modulo_AbrirCaja MAC;
    //---Declaracion de variables-----------//
    //------Inicia Interfaz Cerrar Caja----------//
    public Manejador_CerrarCaja(Interfaz_CerrarCaja ICC1,Modulo_CerrarCaja MCC1) {
        //---Inicializacion variables-----------//
        this.ICC = ICC1;
        this.MCC = MCC1;
        //---Inicializacion variables-----------//
        //------------ACTION LISTENER PERFORMED-----------//
        ICC.btn_Cancelar.addActionListener(new ActionListener() {
            //-----Oculta Interfaz Cerrar Caja--------//
            public void actionPerformed(ActionEvent ae) {
                ICC.setVisible(false);
                ICC.setEnabled(false);
            }
            //-----Oculta Interfaz Cerrar Caja--------//
        });
        ICC.btn_CorteCaja.addActionListener(new ActionListener() {
            //-----Inicializa Modulo Cerrar Caja--------//
            public void actionPerformed(ActionEvent ae) {
                try{
                MCC.setS1(Integer.parseInt(ICC.spin_1.getValue() + ""));
                MCC.setS10(Integer.parseInt(ICC.spin_10.getValue() + ""));
                MCC.setS100(Integer.parseInt(ICC.spin_100.getValue() + ""));
                MCC.setS2(Integer.parseInt(ICC.spin_2.getValue() + ""));
                MCC.setS20(Integer.parseInt(ICC.spin_20.getValue() + ""));
                MCC.setS200(Integer.parseInt(ICC.spin_200.getValue() + ""));
                MCC.setS5(Integer.parseInt(ICC.spin_5.getValue() + ""));
                MCC.setS50(Integer.parseInt(ICC.spin_50.getValue() + ""));
                MCC.setS500(Integer.parseInt(ICC.spin_500.getValue() + ""));
                //-----Coloca el Fondo de caja de Modulo Abrir caja--------//
                MCC.setCajafondo(MAC.getCajafondo());
                //-----Coloca el Fondo de caja de Modulo Abrir caja--------//
                //------Suma todos los valores------//
                MCC.sumTotal();
                //------Suma todos los valores------//
                //-----Actualiza los label de Interfaz Cerrar Caja--------//
                ICC.lblTotal.setText("$"+MCC.getTotal());
                ICC.lblCajaFondo.setText(MAC.getCajafondo() + "");
                ICC.lblGanancias.setText(MCC.getGanancias() + "");
                JOptionPane.showMessageDialog(ICC, "Corte realizado");
                ICC.btn_CorteCaja.setEnabled(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(ICC,e.getMessage());
                }
                
                //-----Actualiza los label de Interfaz Cerrar Caja--------//
            }
        });
        //------------ACTION LISTENER PERFORMED-----------//
        //------------ACTION LISTENER ChangeListener-----------//
        this.ICC.spin_1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_1.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_1.setValue("0");
                }
            }
        });
        this.ICC.spin_10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_10.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_10.setValue("0");
                }
            }
        });
        this.ICC.spin_100.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_100.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_100.setValue("0");
                }
            }
        });
        this.ICC.spin_2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_2.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_2.setValue("0");
                }
            }
        });
        this.ICC.spin_20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_20.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_20.setValue("0");
                }
            }
        });
        this.ICC.spin_200.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_200.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_200.setValue("0");
                }
            }
        });
        this.ICC.spin_5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_5.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_5.setValue("0");
                }
            }
        });
        this.ICC.spin_50.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_50.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_50.setValue("0");
                }
            }
        });
        this.ICC.spin_500.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                int i = Integer.parseInt(ICC.spin_500.getValue() + "");
                //------Valida si el spiner es menor a 0----------//
                if(i < 0){
                    ICC.spin_500.setValue("0");
                }
            }
        });
        //------------ACTION LISTENER ChangeListener-----------//
    }
    //-----Fin de Contructor-------------//
    
    //------ Set ----------//
    public void setMAC(Modulo_AbrirCaja MAC) {
        this.MAC = MAC;
    }
    //------ Set ----------//
}
