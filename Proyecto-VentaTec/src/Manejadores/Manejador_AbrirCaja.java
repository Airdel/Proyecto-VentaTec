/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_AbrirCaja;
//TEst comit github
import Modulos.Modulo_AbrirCaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISM & Darienaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */
public class Manejador_AbrirCaja {
    //-----------Declaracion Variables-----------//
    private Interfaz_AbrirCaja IAC;
    private Modulo_AbrirCaja MAC;
    //-----------Declaracion Variables-----------//
    //-----Iniciar Interfaz Abrir Caja-----------//
    public Manejador_AbrirCaja(Interfaz_AbrirCaja IAC1, Modulo_AbrirCaja MAC1) {
        //-----------Inicializacion --------------------//
        this.IAC = IAC1;
        this.MAC = MAC1;
        //-----------Inicializacion --------------------//
        //-----------ACTION LISTENER PERFORMED--------------------//
        this.IAC.btn_AbrirCaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    //------Agrega el Fondo de caja-------//
                    double i = Double.parseDouble(JOptionPane.showInputDialog(IAC, "Agregar caja fondo"));
                    if(i < 0){
                        JOptionPane.showMessageDialog(IAC, "Solo Numeros positivos");
                    }
                    //------Agrega el Fondo de Caja a Modulo Abrir Caja-------//
                    MAC.setCajafondo(i);
                    //------Agrega el Fondo de Caja a Modulo Abrir Caja-------//
                    showMessageDialog("Fondo añadido!");
                    IAC.setEnabled(false);
                    IAC.setVisible(false);
                }catch(Exception e){JOptionPane.showMessageDialog(IAC, "Solo Numeros");}
            }

            private void showMessageDialog(String fondo_añadido) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.IAC.btnCerrar.addActionListener(new ActionListener() {
            //--------Oculta la Interfaz Abrir Caja-----------//
            public void actionPerformed(ActionEvent ae) {
                IAC.setEnabled(false);
                IAC.setVisible(false);
            }
            //--------Oculta la Interfaz Abrir Caja-----------//
        });
        //-----------ACTION LISTENER PERFORMED--------------------//
    }
    //--------Fin de Constructor------------//
}
