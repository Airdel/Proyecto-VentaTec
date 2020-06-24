/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_AbrirCaja;
import Interfaces.Interfaz_Principal;
import Modulos.Modulo_AbrirCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISM & DarienR
 */
public class Manejador_AbrirCaja {
    //-----------Declaracion Variables-----------//
    private Interfaz_AbrirCaja IAC;
    private Modulo_AbrirCaja MAC;
    private Manejador_Principal MP;
    private Interfaz_Principal IP;
    //-----------Declaracion Variables-----------//
    //-----Iniciar Interfaz Abrir Caja-----------//
    public Manejador_AbrirCaja(Interfaz_AbrirCaja IAC1, Modulo_AbrirCaja MAC1,Interfaz_Principal ip) {
        //-----------Inicializacion --------------------//
        this.IAC = IAC1;
        this.MAC = MAC1;
        this.IP = ip;
        //-----------Inicializacion --------------------//
        //-----------ACTION LISTENER PERFORMED--------------------//
        this.IAC.btn_AbrirCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    //------Agrega el Fondo de caja-------//
                    double i = Double.parseDouble(JOptionPane.showInputDialog(IAC, "Agregar caja fondo"));
                    if(i < 0){
                        JOptionPane.showMessageDialog(IAC, "Solo Numeros positivos!");
                        System.out.println("i="+i);
                    }else if(i>0){
                    //------Agrega el Fondo de Caja a Modulo Abrir Caja-------//
                    MAC.setCajafondo(i);
                    JOptionPane.showMessageDialog(IAC, "Fondo establecido: "+MAC.getCajafondo());
                    //------Agrega el Fondo de Caja a Modulo Abrir Caja-------//
                    
                    IAC.setVisible(false); //Cierre de la interfaz de abrir caja
                    IP.btn_CerrarSesion.setEnabled(false);
                    
                    }
                }catch(Exception e){JOptionPane.showMessageDialog(IAC, "Solo Numeros");}
            }

        });
//        this.IAC.btnCerrar.addActionListener(new ActionListener() {
//            //--------Oculta la Interfaz Abrir Caja-----------//
//            public void actionPerformed(ActionEvent ae) {
//                IAC.setEnabled(false);
//                IAC.setVisible(false);
//                
//            }
//            //--------Oculta la Interfaz Abrir Caja-----------//
//        });
        //-----------ACTION LISTENER PERFORMED--------------------//
    }
    //--------Fin de Constructor------------//
}
