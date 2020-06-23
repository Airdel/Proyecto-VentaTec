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
public class Modulo_Principal {
    private String tipoUSU;
    private String nameUsu;
    private int id_usu;

    public Modulo_Principal(String tipoUSU, String nameUsu,int id_usu) {
        this.tipoUSU = tipoUSU;
        this.nameUsu = nameUsu;
        this.id_usu = id_usu;
    }

    public String getTipoUSU() {
        return tipoUSU;
    }

    public void setTipoUSU(String tipoUSU) {
        this.tipoUSU = tipoUSU;
    }

    public String getNameUsu() {
        return nameUsu;
    }

    public void setNameUsu(String nameUsu) {
        this.nameUsu = nameUsu;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }
    
}