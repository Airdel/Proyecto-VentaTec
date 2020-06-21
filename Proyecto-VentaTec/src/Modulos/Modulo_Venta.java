/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS INC
 */
public class Modulo_Venta {
    
    public ArrayList<String> Cantidad = new ArrayList<String>();
    public ArrayList<String> precUnitario = new ArrayList<String>();
    public ArrayList<String> importe = new ArrayList<String>();
    public ArrayList<String> descuento = new ArrayList<String>();
    private String nombreUsuario;
    private String FolioAnterior;
    private String FolioVenta;
    private String nombreProducto;
    private DefaultTableModel DTM;
    
    public Modulo_Venta(DefaultTableModel DTM1) {
        this.DTM = DTM1;
    }
  
    
    
}
