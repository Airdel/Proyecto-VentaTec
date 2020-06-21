/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Interfaces.Interfaz_Venta;
import Interfaces.Sub_Venta;
import Modulos.ConexionBD;
import Modulos.Modulo_SubVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUISM
 */
public class Manejador_SubVenta {
    //-----Declaracion Variables-----//
    private Sub_Venta SUV;
    private Modulo_SubVenta MSUV;
    private Interfaz_Venta IV;
    private DefaultTableModel DTM;
    private ConexionBD CBD;
    //-----Declaracion Variables-----//
    //---------Inicia Interfaz Sub Venta-----------//
    public Manejador_SubVenta(Sub_Venta SUV1, Modulo_SubVenta MSUV1, Interfaz_Venta IV1) {
        //----Inicializacion de variables---------//
        this.SUV = SUV1;
        this.MSUV = MSUV1;
        this.IV = IV1;
        this.DTM = (DefaultTableModel) IV.dgv_Productos.getModel();
        this.CBD = new ConexionBD();
        //----Inicializacion de variables---------//
        //------Action Listener Performed---------//
        this.SUV.btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ConfirmaVenta();
            }
        });
        this.SUV.btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CancelaVenta();
            }
        });
        //------Action Listener Performed---------//
    }
    //-----------------------Fin de Constructor------------------------//
    
    //-----------Funciones Void-----------//
    public void ConfirmaVenta(){
        CBD.openConexion();
        //------Agrega todos los Renglones de Tabla Productos  E y S---------// 
        for(int i = 0;i < MSUV.tamañoMaximo;i++){
            String CodigoProducto = MSUV.idProduc.get(i);
            int Cantidad = Integer.parseInt(MSUV.Cantidad.get(i));
            CBD.insertInOut(CodigoProducto,'S',Cantidad);
        }
        //------Agrega todos los Renglones de Tabla Productos---------//
        CBD.closeConexion();
        //------Elimina todos los Renglones de Tabla Productos---------//
        JOptionPane.showMessageDialog(SUV,"Productos Vendidos");
        DTM.setRowCount(0);
        SUV.dispose();
    }// Fin ConfirmaVenta
    public void rellenaSub(){
        //------Inicializa los label con valores del Modulo Sub----//
        SUV.lblTotal.setText("$" + MSUV.getTotal());
        SUV.lblSubTotal.setText("$" + MSUV.getSubtotal());
        SUV.lblFechaV.setText(MSUV.getFecha());
        SUV.lblSobrante.setText("$" + MSUV.getSobrante());
        SUV.lblEfectivo.setText("$" + MSUV.getEfectivo());
        SUV.lblIva.setText("$" + MSUV.getIva());
        SUV.lblDescuento.setText(MSUV.getPromedioDescuento() + "%");
        //------Inicializa los label con valores del Modulo Sub----//
    }// Fin rellenaSub
    public void CancelaVenta(){
        SUV.dispose();
    }// Fin CancelaVenta
    //-----------Funciones Void-----------//
    //-----------Funciones Retornables-----//
    public boolean validaInput(String cad){
        //---Valida si cadena es numero---//
        try{
            float num = Float.parseFloat(cad);
            if(num < 0){
                JOptionPane.showMessageDialog(SUV, "Solo efectivo positivo");
                return false;
            }
        }catch(Exception e){JOptionPane.showMessageDialog(SUV, "Efectivo mal escrito");return false;}
        return true;
        //---Valida si cadena es numero---//
    }// Fin validarInput
    public boolean venta(){
        //----Agrega fecha a Modulo Sub----//
        java.util.Date fecha = new Date();
        MSUV.setFecha(fecha.getDay() + "", fecha.getMonth() + "", fecha.getYear()+1900 + "");
        //----Agrega fecha a Modulo Sub----//
        int row = IV.dgv_Productos.getRowCount();
        //----Suma el precio de cada producto----//
        for(int i = 0;i < row;i++){
            String idproc = DTM.getValueAt(i, 0) +"";
            String cant = DTM.getValueAt(i, 2) +"";
            String precUni = DTM.getValueAt(i, 3) +"";
            String impor = DTM.getValueAt(i, 4) +"";
            String desc = DTM.getValueAt(i, 5) +"";
            MSUV.agregaProduc(idproc, cant, precUni, impor, desc);
        }
        MSUV.sumaSubTotal();
        MSUV.sumaTodo();
        //----Suma el precio de cada producto----//
        //----Retorna la suma total----//
        double SOBRANTE = MSUV.getSobrante();
        if(SOBRANTE > 0){
            return true;
        }
        return false;
        //----Retorna la suma total----//
    }// Fin venta
    //-----------Funciones Retornables-----//
    
    public static void main(String arg[]){
        Interfaz_Venta IV = new Interfaz_Venta();
        Sub_Venta SV = new Sub_Venta();
        Modulo_SubVenta MS = new Modulo_SubVenta(10);
        Manejador_SubVenta MAS = new Manejador_SubVenta(SV, MS, IV);
        System.out.println(MAS.validaInput("a"));
    }
}
