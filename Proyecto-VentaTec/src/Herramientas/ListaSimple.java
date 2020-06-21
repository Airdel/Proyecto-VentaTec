package Herramientas;

import static javax.swing.JOptionPane.*;

public class ListaSimple {

    private NodoInt ini, fin;

    public ListaSimple() {
        ini = fin = null;
    }

    public void push(int m) {
        if (ini == null) {
            ini = fin = new NodoInt(m);
        } else {
            fin.setSig(new NodoInt(m));
            fin = fin.getSig();
        }
    }

    public boolean pop(int m) {
        if (ini.getInfo() == m) {
            ini = ini.getSig();
            return true;
        } else {
            for (NodoInt i = ini; i != null; i = i.getSig()) {
                if (i.getSig().getInfo() == m) {
                    if (i.getSig() == fin) {
                        fin = i;
                    }
                    i.setSig(i.getSig().getSig());
                    return true;
                }
            }
        }
        return false;
    }

    public void verLista() {
        String cad = "";
        for (NodoInt i = ini; i != null; i = i.getSig()) {
            cad = cad + i;
        }
        showMessageDialog(null, cad);
    }

    public boolean buscar(int m) {
        for (NodoInt i = ini; i != null; i = i.getSig()) {
            if (m == i.getInfo()) {
                return true;
            }
        }
        return false;
    }

    public NodoInt getIni() {
        return ini;
    }

    public void setIni(NodoInt ini) {
        this.ini = ini;
    }

    public NodoInt getFin() {
        return fin;
    }

    public void setFin(NodoInt fin) {
        this.fin = fin;
    }
    
    

    public static void main(String[] args) {
        ListaSimple l = new ListaSimple();
        l.push(1);
        l.push(3);
        l.push(5);
        l.verLista();
        showMessageDialog(null, l.buscar(3));
        l.pop(5);
        l.verLista();
        showMessageDialog(null, l.buscar(3));
        l.push(8);
        l.verLista();
    }

}
