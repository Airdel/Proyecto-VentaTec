/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_AgregaUsu;
import Modulos.Modulo_Usuario;
import MailyOtros.Newuserexcepcion;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.JOptionPane;

/**
 *
 * @author LUISM
 */
public class Manejador_NuevoUsu {

    private Interfaz_AgregaUsu IU;
    private Modulo_Usuario MU;

    public Manejador_NuevoUsu(Interfaz_AgregaUsu IU, Modulo_Usuario MU) {
        this.IU = IU;
        this.MU = MU;
        this.IU.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                
                    if (IU.txtNombreCom.getText().equals("")) {
                        IU.lblnombre.setForeground(Color.red);
                        IU.txtNombreCom.requestFocus();
                        JOptionPane.showMessageDialog(IU, "Campo vacío Nombre Completo");
                        throw new Newuserexcepcion("Campo vacío Nombre Completo");
                    }
                    if (IU.txtNombreUSU.getText().equals("")) {
                        IU.txtNombreUSU.requestFocus();
                        IU.lblnomuser.setForeground(Color.red);
                        JOptionPane.showMessageDialog(IU, "Campo vacío Usuario");
                        throw new Newuserexcepcion("Campo vacío Usuario");
                    }
                    if (IU.txtContraseña.getText().equals("")) {
                        IU.txtContraseña.requestFocus();
                        IU.lblcontraseña.setForeground(Color.red);
                        JOptionPane.showMessageDialog(IU, "Campo vacío tu contraseña");
                        throw new Newuserexcepcion("Campo vacío tu contraseña");
                    }
                    if (IU.txtConfirContra.getText().equals("")) {                        
                        IU.txtConfirContra.requestFocus();
                        IU.lblconfirmar.setForeground(Color.red);
                        JOptionPane.showMessageDialog(IU, "Campo vacío confirma tu contraseña");
                        throw new Newuserexcepcion("Campo vacío confirma tu contraseña");

                    }
                    if (IU.txtTelefono.getText().equals("")) {
                        IU.txtTelefono.requestFocus();
                        IU.lbltelefono.setForeground(Color.red);
                        JOptionPane.showMessageDialog(IU,"Campo vacío telefono");
                        throw new Newuserexcepcion("Campo vacío telefono");

                    }
                    if (IU.txtDomicilio.getText().equals("")) {
                        IU.txtDomicilio.requestFocus();
                        IU.lbldomocilio.setForeground(Color.red);
                        JOptionPane.showMessageDialog(IU, "Campo vacío Domicilio");
                        throw new Newuserexcepcion("Campo vacío Domicilio");

                    }
                    
                    if (validaUsu()) {
                    rellenaUSU();
                    JOptionPane.showMessageDialog(IU, "Usuario Registrado Exitosamente");
                    IU.lblCosto.setForeground(Color.black);
                    IU.lblTitulo.setForeground(Color.black);
                    IU.lblconfirmar.setForeground(Color.black);
                    IU.lblcontraseña.setForeground(Color.black);
                    IU.lbldomocilio.setForeground(Color.black);
                    IU.lblnombre.setForeground(Color.black);
                    IU.lblnomuser.setForeground(Color.black);
                    IU.lbltelefono.setForeground(Color.black);
                    IU.txtConfirContra.setText("");
                    IU.txtNombreCom.setText("");
                    IU.txtContraseña.setText("");
                    IU.txtDomicilio.setText("");
                    IU.txtNombreUSU.setText("");
                    IU.txtTelefono.setText("");
                    

                }

            }
        });
        this.IU.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                IU.setEnabled(false);
                IU.setVisible(false);
            }
        });
        
         this.IU.txtNombreCom.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Letras------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == KeyEvent.VK_ESCAPE) || (c == 130) || (c == 181) || (c == 144) || (c == 214) || (c == 224) || (c == 233) || (c >= 160 && c <= 163))) {
                    ke.consume();
                } else if (IU.txtNombreCom.getText().length() == 40) {//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Letras------------//
        });
         
         this.IU.txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros y Punto------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 48 && c <= 57) )) {
                    ke.consume();
                } else if (IU.txtTelefono.getText().length() == 10) {//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros y Punto------------//
        });
         
        this.IU.txtNombreUSU.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Letras------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == KeyEvent.VK_ESCAPE) || (c == 130) || (c == 181) || (c == 144) || (c == 214) || (c == 224) || (c == 233) || (c >= 160 && c <= 163))) {
                    ke.consume();
                } else if (IU.txtNombreUSU.getText().length() == 20) {//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Letras------------//
        });
         
        
    }

    public void rellenaUSU() {
        MU.setNombreReal(IU.txtNombreCom.getText());
        MU.setNombreUsuario(IU.txtNombreUSU.getText());
        MU.setContraseña(IU.txtContraseña.getText());
        MU.setTipo_Usuario(IU.cmbTipoUSU.getSelectedItem() + "");
        MU.setTelefono(IU.txtTelefono.getText());
        MU.setDomicilio(IU.txtDomicilio.getText());
        MU.agregarUsu();
    }

    public boolean validaUsu() {
        String contra1 = IU.txtContraseña.getText();
        String contra2 = IU.txtConfirContra.getText();
        if (contra1.equals(contra2)) {
            return true;
        }
        JOptionPane.showMessageDialog(IU, "Contraseña mal escrita");
        return false;
    }

}
