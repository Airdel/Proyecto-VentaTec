/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import java.util.ArrayList;

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
    private String nameUsu;
    private String tipoUsu;
    private int id_usu;
    private int NoArticulos;
    private double total;
    private double iva;
    private double subtotal;
    //----------Declaracion de variables----------//
    
    public Modulo_Venta(String nameUsu,String tipoUsu,int id_usu) {
        this.nameUsu = nameUsu;
        this.tipoUsu = tipoUsu;
        this.id_usu = id_usu;
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
    public void modificarProducto(String reng,String impor,String desc,String cant){
        int ren = Integer.parseInt(reng);
        Cantidad.set(ren,cant);
        importe.set(ren,impor);
        descuento.set(ren,desc);
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
    
    public void eliminaTodo(){
        for(int i = (idProduc.size() - 1); i >=0 ; i--){
            renglon.remove(i);
            idProduc.remove(i);
            Cantidad.remove(i);
            precUnitario.remove(i);
            importe.remove(i);
            descuento.remove(i);
        }
        this.total = 0;
        this.NoArticulos = 0;
        this.subtotal = 0;
        this.iva = 0;
    }
    public void redondeaTodo(){
        this.total = redondearDecimales(total, 2);
        this.subtotal = redondearDecimales(subtotal, 2);
        this.iva = redondearDecimales(iva, 2);
    }
    //-------funciones void----------//
    //-------funciones retornables----------//
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    //-------funciones retornables----------//
    //------- get ----------//

    public String getNameUsu() {
        return nameUsu;
    }
    public int getId_usu() {
        return id_usu;
    }
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
    public String toString(){
        String cad = "";
        for(int i = 0;i<idProduc.size();i++ ){
            cad = cad + idProduc.get(i) + " idProduc ";
            cad = cad + Cantidad.get(i) + " Cantidad ";
            cad = cad + precUnitario.get(i) + " precUnitario ";
            cad = cad + importe.get(i) + " importe ";
            cad = cad + descuento.get(i) + " descuento ";
            cad = cad + renglon.get(i) + " renglon "+ "\n";
        }
        cad = cad + NoArticulos + " NoArticulos " + iva + " iva " + subtotal + " subtotal " + total + " total ";
        return cad;
    }
}
