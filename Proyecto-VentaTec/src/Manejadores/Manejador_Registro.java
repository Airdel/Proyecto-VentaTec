/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_Registro;
import Modulos.ConexionBD;
import Modulos.Modulo_Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LUIS INC
 */
public class Manejador_Registro {
    //------Declaracion de Variables----//
    private Interfaz_Registro IR;
    private Modulo_Registro MR;
    private ConexionBD CBD;
    //------Declaracion de Variables----//
    //---------------Inicia la ventana Registro--------------//
    public Manejador_Registro(Interfaz_Registro IR1, Modulo_Registro MR1) {
        //-------Inicializacion de variables----//
        this.IR = IR1;
        this.MR = MR1;
        CBD = new ConexionBD();
        llenarCombo();
        //-------Inicializacion de variables----//  
        //--------Action Listener Performet-------------------//
        this.IR.btnGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    //--------Agrega caracteristicas a Modulo Registro---------//
                    MR.setCantidad(Integer.parseInt(IR.txtStock.getText()));
                    MR.setCategoria(IR.cmbCategoria.getSelectedIndex());
                    MR.setCosto(Integer.parseInt(IR.txtCosto.getText()));
                    MR.setDescripcion(IR.txtDescripcion.getText());
                    MR.setNombre(IR.txtNombre.getText());
                    MR.setPrecio(Integer.parseInt(IR.txtPrecio.getText()));
                    MR.setPresentacion(IR.cmbPresentacion.getSelectedIndex());
                    MR.setID_Producto(IR.txtID_Producto.getText());
                    MR.setID_Proveedor(IR.cmbProvedor.getSelectedIndex());
                    //--------Agrega caracteristicas a Modulo Registro---------//
                    MR.Inserta();//--------Insencion-------//
                    //--------Limipia todos los TXT---------//
                    IR.txtStock.setText("");
                    IR.cmbCategoria.setSelectedIndex(0);
                    IR.txtCosto.setText("");
                    IR.txtDescripcion.setText("");
                    IR.txtNombre.setText("");
                    IR.txtPrecio.setText("");
                    IR.cmbPresentacion.setSelectedIndex(0);
                    IR.txtID_Producto.setText("");
                    IR.cmbProvedor.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(IR, "Producto añadido!");
                    //--------Limipia todos los TXT---------//
                }catch(Exception error) {
                    JOptionPane.showMessageDialog(IR, "Ha ocurrido un error, contacta el administrador del sistema!\n"+error);
                }
            }
        });
        this.IR.btnRegresar.addActionListener(new ActionListener(){
            //--------Oculta la Interfaz Registro en Interfaz Principal-------//
            public void actionPerformed(ActionEvent e){
                IR.setVisible(false);
                IR.setEnabled(false);
            }
            //--------Oculta la Interfaz Registro en Interfaz Principal-------//
        });
        //--------Action Listener Performet-------------------//
        //--------Action Listener KeyListener-------------------//
        this.IR.txtID_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(!((c >= 48 && c <= 57))){
                    ke.consume();
                }else if(IR.txtID_Producto.getText().length() == 25){//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros------------//
        });
        
        this.IR.txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Letras------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(!((c >= 65 && c <= 90)||(c >= 97 && c <= 122)||(c == KeyEvent.VK_ESCAPE)||(c == 130)||(c == 181)||(c == 144)||(c == 214)||(c == 224)||(c == 233)||(c >= 160 && c <= 163))){
                    ke.consume();
                }else if(IR.txtNombre.getText().length() == 20){//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Letras------------//
        });
       
        this.IR.txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros y Punto------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(!((c >= 48 && c <= 57)||(c == 46))){
                    ke.consume();
                }else if(IR.txtPrecio.getText().length() == 25){//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros y Punto------------//
        });
        
       this.IR.txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros y Punto------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(!((c >= 48 && c <= 57)||(c == 46))){
                    ke.consume();
                }else if(IR.txtCosto.getText().length() == 25){//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros y Punto------------//
        });
        this.IR.txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if(!((c >= 48 && c <= 57))){
                    ke.consume();
                }else if(IR.txtStock.getText().length() == 25){//----Tamaño----//
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros------------//
        });
        //--------Action Listener KeyListener-------------------//
    }
    //---------------Fin Constructor------------------//
    public void validaTxt(){
        //---Valida si Precio esta bien---//
        String textP = IR.txtPrecio.getText();
        String S[] = textP.split(".");
        if(S.length > 2){
            JOptionPane.showMessageDialog(IR, "Precio mal escrito");
            return;
        }
        //---Valida si Precio esta bien---//
        //---Valida si Costo esta bien---//
        String textC = IR.txtCosto.getText();
        String S1[] = textC.split(".");
        if(S1.length > 2){
            JOptionPane.showMessageDialog(IR, "Costo mal escrito");
            return;
        }
        //---Valida si Costo esta bien---//
        //---Valida si Cantidad esta bien---//
        String textCan = IR.txtStock.getText();
        if(textCan.equals("")){
            JOptionPane.showMessageDialog(IR, "Cantidad esta vacia");
            return;
        }
        //---Valida si Cantidad esta bien---//
        //---Valida si Nombre esta bien---//
        String textName = IR.txtNombre.getText();
        if(textName.equals("")){
            JOptionPane.showMessageDialog(IR, "Nombre del producto esta vacio");
            return;
        }
        //---Valida si Nombre esta bien---//
        //---Valida si Descripcion esta bien---//
        String textDes = IR.txtDescripcion.getText();
        if(textDes.equals("")){
            JOptionPane.showMessageDialog(IR, "Descripcion del producto esta vacio");
            return;
        }
        //---Valida si Descripcion esta bien---//
        //---Valida si Combo Categoria esta bien---//
        Object cmbCat = IR.cmbCategoria.getSelectedItem();
        if(cmbCat == null){
            JOptionPane.showMessageDialog(IR, "Categoria del producto esta vacia");
            return;
        }
        //---Valida si Combo Categoria esta bien---//
        //---Valida si Combo Presentacion esta bien---//
        Object cmbPre = IR.cmbPresentacion.getSelectedItem();
        if(cmbPre == null){
            JOptionPane.showMessageDialog(IR, "Presentacion del producto esta vacio");
            return;
        }
        //---Valida si Combo Presentacion esta bien---//
    }// Fin validaTxt
    
    public void llenarCombo(){
        CBD.openConexion();
        //---Variables Auxiliares---//
        String A[] = CBD.allCat();
        String B[] = CBD.allPre();
        String C[] = CBD.allProvedor();
        //---Variables Auxiliares---//
        //---Llena Combo Categoria---//
        for (int i = 0;i<A.length;i++) {
            IR.cmbCategoria.addItem(A[i]);
        }
        //---Llena Combo Categoria---//
        //---Llena Combo Presentacion---//
        for (String B1 : B) {
            IR.cmbPresentacion.addItem(B1);
        }
        //---Llena Combo Presentacion---//
        //---Llena Combo Provedor---//
        for (String C1 : C) {
            IR.cmbProvedor.addItem(C1);
        }
        //---Llena Combo Provedor---//
        CBD.closeConexion();     
    }// Fin llenarCombo
}//Fin llenarCombo
