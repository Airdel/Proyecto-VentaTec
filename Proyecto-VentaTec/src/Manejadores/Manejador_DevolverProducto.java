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
import javax.swing.JOptionPane;

/**
 *
 * @author LUISM
 */
public class Manejador_DevolverProducto {
    private Interfaz_DevolverProducto IDP;
    private Modulo_DevolverProducto MDP;
    private ConexionBD CBD;

    public Manejador_DevolverProducto(Interfaz_DevolverProducto IDP, Modulo_DevolverProducto MDP) {
        this.IDP = IDP;
        this.MDP = MDP;
        this.CBD = new ConexionBD();
        this.IDP.btn_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IDP.dispose();
            }
        });
        this.IDP.btn_Confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MDP.setIDProducto(IDP.txt_IdProducto.getText());
                MDP.setIDVenta(IDP.txt_IdVenta.getText());
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
