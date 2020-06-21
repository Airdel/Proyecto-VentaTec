package Herramientas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Medina
 */
public class NodoInt {
    private int info;
    private NodoInt sig;

    public NodoInt(int info) {
        this.info = info; sig = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NodoInt getSig() {
        return sig;
    }

    public void setSig(NodoInt sig) {
        this.sig = sig;
    }

    @Override
    public String toString() {
        return "{" + info + "}--->" ;
    }
    
}
