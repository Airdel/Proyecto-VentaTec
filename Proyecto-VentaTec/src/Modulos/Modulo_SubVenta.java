/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

/**
 *
 * @author LUISM
 */
public class Modulo_SubVenta {
    //----------Declaracion de variables----------//
    private double total;
    private double efectivo;
    private double sobrante;
    private double iva;
    private double subtotal;
    private String fecha;
    private double descuento;
    //----------Declaracion de variables----------//
    
    public Modulo_SubVenta() {
        this.total = 0;
        this.iva = 0;
        this.subtotal = 0;
        this.fecha = "";
        this.descuento = 0;
        this.efectivo = 0;
        this.sobrante = 0;
    }
    //-----------Fin del Constructor---------------//
    //-------funciones void----------//
    public void sumaSub(double sum,double desc,int cant){
        subtotal = subtotal + ((sum - (sum * desc))*cant);
        iva = (subtotal * 0.16);
    }
    //-------funciones void----------//
    //-------funciones return----------//
    public boolean sumaTodo(){
        total = subtotal + iva;
        sobrante = total - efectivo;
        if(sobrante > 0){
            return false;
        }
        return true;
    }
    //-------funciones return----------//
    //------- get ----------//
    public double getEfectivo() {
        return efectivo;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getSobrante() {
        return sobrante * -1;
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
    public double getDescuento() {
        return descuento;
    }
    //------- get ----------//
    //------- set ----------//
    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
    public void setFecha(String dia,String mes,String ano) {
        this.fecha = dia +"/"+ mes +"/"+ ano;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    //------- set ----------//
}
