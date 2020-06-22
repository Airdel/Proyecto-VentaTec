/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_AgregaUsu;
import Modulos.Modulo_Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;


/**
 *
 * @author LUISM
 */
public class Manejador_NuevoUsu  {
    private Interfaz_AgregaUsu IU;
    private Modulo_Usuario MU;

    public Manejador_NuevoUsu(Interfaz_AgregaUsu IU, Modulo_Usuario MU) {
        this.IU = IU;
        this.MU = MU;
        this.IU.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validaUsu()){rellenaUSU();}
            }
        });
        this.IU.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IU.setEnabled(false);
                IU.setVisible(false);
            }
        });
    }
    
    public void rellenaUSU(){
        MU.setNombreReal(IU.txtNombreCom.getText());
        MU.setNombreUsuario(IU.txtNombreUSU.getText());
        MU.setContraseña(IU.txtContraseña.getText());
        MU.setTipo_Usuario(IU.cmbTipoUSU.getSelectedItem() + "");
        MU.setTelefono(IU.txtTelefono.getText());
        MU.setDomicilio(IU.txtDomicilio.getText());
        MU.agregarUsu();
    }
    
    public boolean validaUsu(){
        String contra1 = IU.txtContraseña.getText();
        String contra2 = IU.txtConfirContra.getText();
        if(contra1.equals(contra2)){
            return true;
        }
        JOptionPane.showMessageDialog(IU, "Contraseña mal escrita");
        return false;
    }
}
