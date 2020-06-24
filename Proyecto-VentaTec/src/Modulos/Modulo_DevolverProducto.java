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
    private int IDProducto;
    private int IDVenta;

    public Modulo_DevolverProducto() {
        this.IDProducto = 0;
        this.IDVenta = 0;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public int getIDVenta() {
        return IDVenta;
    }
    
}
