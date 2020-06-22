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
    
    //----------Declaracion de variables----------//
    public ArrayList<String> idProduc = new ArrayList<String>();
    public ArrayList<String> Cantidad = new ArrayList<String>();
    public ArrayList<String> precUnitario = new ArrayList<String>();
    public ArrayList<String> importe = new ArrayList<String>();
    public ArrayList<String> descuento = new ArrayList<String>();
    public ArrayList<String> renglon = new ArrayList<String>();
    private int NoArticulos;
    private double total;
    private double iva;
    private double subtotal;
    //----------Declaracion de variables----------//
    
    public Modulo_Venta() {
        this.total = 0;
        this.NoArticulos = 0;
        this.subtotal = 0;
        this.iva = 0;
    }
    //-----------Fin del Constructor---------------//
    //-------funciones void----------//
    public void agregaProduc(String reng,String idproc,String cant,String precUni,String impor,String desc){
        renglon.add(reng);
        idProduc.add(idproc);
        Cantidad.add(cant);
        precUnitario.add(precUni);
        importe.add(impor);
        descuento.add(desc);
        NoArticulos++;
    }
    public void eliminaProduc(String reng){
        int ren = 0;
        for(int i = 0; i < renglon.size();i++){
            if(renglon.get(i).equals(reng)){
                ren = Integer.parseInt(renglon.get(i));
            }
        }
        renglon.remove(ren);
        idProduc.remove(ren);
        Cantidad.remove(ren);
        precUnitario.remove(ren);
        importe.remove(ren);
        descuento.remove(ren);
        NoArticulos--;
    }
    public void sumaSubTotal(){
        subtotal = 0;
        for(int i = 0;i < idProduc.size() ; i++){
            subtotal = subtotal + (double)(Double.parseDouble(importe.get(i))*Integer.parseInt(Cantidad.get(i)));
        }
        iva = (subtotal * 0.16);
    }
    public void sumaTodo(){
        total = subtotal + iva;
    }
    //-------funciones void----------//
    //------- get ----------//
    
    public double getSubtotal() {
        return subtotal;
    }
    public double getTotal() {
        return total;
    }
    public double getIva() {
        return (subtotal * 0.16);
    }
    public int getNoArticulos() {
        return NoArticulos;
    }
    public double getPromedioDescuento(){
        double descuentoAcumulado = 0;
        for(int i = 0;i < idProduc.size();i++){
            descuentoAcumulado = Double.parseDouble(descuento.get(i));
        }
        return (descuentoAcumulado / idProduc.size());
    }
    //------- get ----------//
}
