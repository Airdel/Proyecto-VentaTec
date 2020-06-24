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
public class Modulo_DevolverProducto {
    private String IDProducto;
    private String IDVenta;

    public Modulo_DevolverProducto() {
        this.IDProducto = "";
        this.IDVenta = "";
    }

    public void setIDProducto(String IDProducto) {
        this.IDProducto = IDProducto;
    }

    public void setIDVenta(String IDVenta) {
        this.IDVenta = IDVenta;
    }

    public String getIDProducto() {
        return IDProducto;
    }

    public String getIDVenta() {
        return IDVenta;
    }
    
}
