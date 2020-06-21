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
public class Modulo_Registro {
    
    //----------Declaracion de variables----------//
    private String ID_Producto;
    private int ID_Proveedor;
    private String Nombre;
    private String Descripcion;
    private float Precio;
    private float Costo;
    private int Categoria;
    private int Cantidad;
    private int Presentacion;
    private ConexionBD CBD;
    //----------Declaracion de variables----------//
    
    //--------- get -----------//
    public String getNombre() {
        return Nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public float getPrecio() {
        return Precio;
    }
    public float getCosto() {
        return Costo;
    }
    public int getCategoria() {
        return Categoria;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public int getPresentacion() {
        return Presentacion;
    }
    public String getID_Producto() {
        return ID_Producto;
    }
    public int getID_Proveedor() {
        return ID_Proveedor;
    }
    //--------- get -----------//
    //--------- set -----------//
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    public void setPresentacion(int Presentacion) {
        this.Presentacion = Presentacion;
    }
    public void setID_Producto(String ID_Producto) {
        this.ID_Producto = ID_Producto;
    }
    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }
    //--------- set -----------//
    
    
    //-----------Funcion para validar si existe producto o no----------/
    public void Inserta() {
        CBD = new ConexionBD();
        CBD.openConexion();
        if (CBD.consulta("PRODUCTOS", "[ID PRODUCTO]", this.ID_Producto)) {//Valida si existe producto o no
            CBD.insertInOut(ID_Producto,'E',Cantidad);            
            CBD.closeConexion();
        } else {
            //Inserta nuevo producto a PRODUCTOS
            CBD.insertProduct(ID_Producto,1, 1, 1, Nombre, Descripcion, Precio, Costo);
            CBD.insertInOut(ID_Producto,'E',Cantidad);
            CBD.closeConexion();
        }
    }
}



