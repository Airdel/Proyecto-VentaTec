/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_DevolverProducto;
import Modulos.ConexionBD;
import Modulos.Modulo_DevolverProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISMI
 */
public class Manejador_DevolverProducto {
    private Interfaz_DevolverProducto IDP;
    private Modulo_DevolverProducto MDP;
    private ConexionBD CBD;

    public Manejador_DevolverProducto(Interfaz_DevolverProducto IDP, Modulo_DevolverProducto MDP) {
        this.IDP = IDP;
        this.MDP = MDP;
        this.CBD = new ConexionBD();
        this.IDP.txt_IdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(c >= 48 && c <= 57)) {
                    ke.consume();
                } else if (IDP.txt_IdProducto.getText().length() == 6) {
                    ke.consume();
                }
            }
        });
        this.IDP.txt_IdVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(c >= 48 && c <= 57)) {
                    ke.consume();
                } else if (IDP.txt_IdVenta.getText().length() == 6) {
                    ke.consume();
                }
            }
        });
        this.IDP.btn_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IDP.dispose();
            }
        });
    
        this.IDP.btn_Confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MDP.setIDProducto(Integer.parseInt(IDP.txt_IdProducto.getText()));
                MDP.setIDVenta(Integer.parseInt(IDP.txt_IdVenta.getText()));
                CBD.openConexion();
                if(CBD.devolverProc(MDP.getIDProducto(), MDP.getIDVenta())){
                    JOptionPane.showMessageDialog(IDP, "Producto devuelto exitosamente");
                }else{
                    JOptionPane.showMessageDialog(IDP, "Producto no encontrado en la venta");
                }
                CBD.closeConexion();
            }
        });
        
    }
}
