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

                if (validaUsu()) {
                    rellenaUSU();
                    if (IU.txtNombreCom.getText().equals("")) {
                        IU.lblnombre.setBackground(Color.red);
                        IU.txtNombreCom.requestFocus();
                        JOptionPane.showMessageDialog(IU, "Campo vacío Nombre Completo");
                        throw new Newuserexcepcion("Campo vacío Nombre Completo");
                    }
                    JOptionPane.showMessageDialog(IU, "Usuario Registrado Exitosamente");
                    IU.lblCosto.setBackground(Color.black);
                    IU.lblTitulo.setBackground(Color.black);
                    IU.lblconfirmar.setBackground(Color.black);
                    IU.lblcontraseña.setBackground(Color.black);
                    IU.lbldomocilio.setBackground(Color.black);
                    IU.lblnombre.setBackground(Color.black);
                    IU.lblnomuser.setBackground(Color.black);
                    IU.lbltelefono.setBackground(Color.black);
                    IU.txtConfirContra.setText("");
                    IU.txtNombreCom.setText("");
                    IU.txtContraseña.setText("");
                    IU.txtDomicilio.setText("");
                    IU.txtNombreUSU.setText("");
                    IU.txtTelefono.setText("");
                    IU.lbltelefono.setText("");

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

    public boolean validacampoUser() {
        boolean b = false;

        if (IU.txtNombreUSU.getText().equals("")) {
            IU.txtNombreUSU.requestFocus();
            IU.lblnomuser.setBackground(Color.red);
            throw new Newuserexcepcion("Campo vacío Usuario");
        }
        if (IU.txtContraseña.getText().equals("")) {
            IU.txtContraseña.requestFocus();
            IU.lblcontraseña.setBackground(Color.red);
            throw new Newuserexcepcion("Campo vacío tu contraseña");
        }
        if (IU.txtConfirContra.getText().equals("")) {
            IU.txtConfirContra.requestFocus();
            IU.lblconfirmar.setBackground(Color.red);
            throw new Newuserexcepcion("Campo vacío confirma tu contraseña");

        }
        if (IU.txtDomicilio.getText().equals("")) {
            IU.txtDomicilio.requestFocus();
            IU.lbldomocilio.setBackground(Color.red);
            throw new Newuserexcepcion("Campo vacío Domicilio");

        }
        if (IU.txtTelefono.getText().equals("")) {
            IU.txtTelefono.requestFocus();
            IU.lbltelefono.setBackground(Color.red);
            throw new Newuserexcepcion("Campo vacío telefono");

        }

        return b = true;

    }
}
