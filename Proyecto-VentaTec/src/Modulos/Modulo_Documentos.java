/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

/**
 *
 * @author LUIS INC
 */
public class Modulo_Documentos {
    //--------Declaracion Variables-------//    
    private int ID_Ticket;
    private int ID_Venta;
    private String Fecha;
    private String Usuario;
    private String ID_Producto;
    private int PrecioProducto;
    private int Cantidad;
    private float Descuento;
    private float Sub_Total;
    private float IVA;
    private float Total;
    private String Descripcion;
    private ConexionBD CBD;
    //--------Declaracion Variables-------//
    //-------- get -------//
    public int getPrecioProducto() {
        return PrecioProducto;
    }
    public int getID_Ticket() {
        return ID_Ticket;
    }
    public int getID_Venta() {
        return ID_Venta;
    }
    public String getFecha() {
        return Fecha;
    }
    public String getID_Producto() {
        return ID_Producto;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public float getDescuento() {
        return Descuento;
    }
    public float getSub_Total() {
        return Sub_Total;
    }
    public float getIVA() {
        return IVA;
    }
    public float getTotal() {
        return Total;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    //-------- get -------//
    //-------- set -------//
    public void setPrecioProducto(int PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }
    public void setID_Ticket(int ID_Ticket) {
        this.ID_Ticket = ID_Ticket;
    }
    public void setID_Venta(int ID_Venta) {
        this.ID_Venta = ID_Venta;
    }
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    public void setID_Producto(String ID_Producto) {
        this.ID_Producto = ID_Producto;
    }
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }
    public void setSub_Total(float Sub_Total) {
        this.Sub_Total = Sub_Total;
    }
    public void setIVA(float IVA) {
        this.IVA = IVA;
    }
    public void setTotal(float Total) {
        this.Total = Total;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    //-------- set -------//
    public void BuscaTicket(){
        CBD.openConexion();
        //consulta para conseguir info del ticket
    }// Fin BuscarTicket
}
