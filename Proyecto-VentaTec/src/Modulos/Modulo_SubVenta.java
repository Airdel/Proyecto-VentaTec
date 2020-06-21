/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import java.util.ArrayList;

/**
 *
 * @author LUISM
 */
public class Modulo_SubVenta {
    //----------Declaracion de variables----------//
    public ArrayList<String> idProduc = new ArrayList<String>();
    public ArrayList<String> Cantidad = new ArrayList<String>();
    public ArrayList<String> precUnitario = new ArrayList<String>();
    public ArrayList<String> importe = new ArrayList<String>();
    public ArrayList<String> descuento = new ArrayList<String>();
    private int tamañoMaximo;
    private double total;
    private double efectivo;
    private double sobrante;
    private double iva;
    private double subtotal;
    private String fecha;
    //----------Declaracion de variables----------//
    
    public Modulo_SubVenta(int row) {
        this.tamañoMaximo = row;
        this.total = 0;
        this.subtotal = 0;
        this.iva = 0;
        this.fecha = "";
        this.efectivo = 0;
        this.sobrante = 0;
    }
    //-----------Fin del Constructor---------------//
    //-------funciones void----------//
    public void agregaProduc(String idproc,String cant,String precUni,String impor,String desc){
        idProduc.add(idproc);
        Cantidad.add(cant);
        precUnitario.add(precUni);
        importe.add(impor);
        descuento.add(desc);
    }
    public void sumaSubTotal(){
        for(int i = 0;i < tamañoMaximo ; i++){
            subtotal = subtotal + (Double.parseDouble(importe.get(i))*Integer.parseInt(Cantidad.get(i)));
        }
        iva = (subtotal * 0.16);
    }
    public void sumaTodo(){
        total = subtotal + iva;
        sobrante = efectivo - total;
    }
    //-------funciones void----------//
    //------- get ----------//
    public double getEfectivo() {
        return efectivo;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getSobrante() {
        return sobrante;
    }
    public double getTotal() {
        return total;
    }
    public double getIva() {
        return (subtotal * 0.16);
    }
    public String getFecha() {
        return fecha;
    }
    public double getPromedioDescuento(){
        double descuentoAcumulado = 0;
        for(int i = 0;i < tamañoMaximo;i++){
            descuentoAcumulado = Double.parseDouble(descuento.get(i));
        }
        return (descuentoAcumulado / tamañoMaximo);
    }
    //------- get ----------//
    //------- set ----------//
    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
    public void setFecha(String dia,String mes,String ano) {
        this.fecha = dia +"/"+ mes +"/"+ ano;
    }
    //------- set ----------//
}
