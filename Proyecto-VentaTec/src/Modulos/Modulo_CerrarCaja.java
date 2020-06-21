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
public class Modulo_CerrarCaja {
    //--------Declaracion Variables-------//
    private double total;
    private double cajafondo;
    private double ganancias;
    private int s500,s50,s5,s200,s20,s2,s100,s10,s1;
    //--------Declaracion Variables-------//
    
    public Modulo_CerrarCaja() {
        this.total = 0;
        this.cajafondo = 0;
        this.ganancias = 0;
        this.s500 = 0;
        this.s50 = 0;
        this.s5 = 0;
        this.s200 = 0;
        this.s20 = 0;
        this.s2 = 0;
        this.s100 = 0;
        this.s10 = 0;
        this.s1 = 0;
    }
    //---------Fin COnstructor-----------//
    
    //----------Suma el cada spiner-----------//
    public void sumTotal(){
        total = (s500 * 500) + (s50 * 50) + (s5 * 5) + (s200 * 200) + (s20 * 20) + (s2 * 2) + (s100 * 100) + (s10 * 10) + (s1 * 1);
        if(total-cajafondo < 0){
        ganancias = 0;
        }else{ganancias = total - cajafondo;}
    }// Fin sumTotal

    //-------- get -------//
    public double getTotal() {
        return total;
    }
    public double getCajafondo() {
        return cajafondo;
    }
    public double getGanancias() {
        return ganancias;
    }    
    //-------- get -------//
    //-------- set -------//
    public void setCajafondo(double cajafondo) {
        this.cajafondo = cajafondo;
    }
    public void setS500(int s500) {
        this.s500 = s500;
    }
    public void setS50(int s50) {
        this.s50 = s50;
    }
    public void setS5(int s5) {
        this.s5 = s5;
    }
    public void setS200(int s200) {
        this.s200 = s200;
    }
    public void setS20(int s20) {
        this.s20 = s20;
    }
    public void setS2(int s2) {
        this.s2 = s2;
    }
    public void setS100(int s100) {
        this.s100 = s100;
    }
    public void setS10(int s10) {
        this.s10 = s10;
    }
    public void setS1(int s1) {
        this.s1 = s1;
    }
    //-------- set -------//
}
