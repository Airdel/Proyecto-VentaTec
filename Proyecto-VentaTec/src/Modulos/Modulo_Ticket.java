/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author LUIS INC
 */
public class Modulo_Ticket {
    //----------Arreglos del ticket-----------//
    static ArrayList<String> CabezaLineas = new ArrayList<String>();
    static ArrayList<String> subCabezaLineas = new ArrayList<String>();
    static ArrayList<String> items = new ArrayList<String>();
    static ArrayList<String> totales = new ArrayList<String>();
    static ArrayList<String> LineasPie = new ArrayList<String>();
    //----------Arreglos del ticket-----------//
    //----------Declaracion de variables----------//
    private ConexionBD CBD;
    //----------Declaracion de variables----------//
    //Agrega lineas de cabeza
    public void AddCabecera(String line) {
        CabezaLineas.add(line);
    }
    //Agrega lineas de subacabeza
    public void AddSubCabecera(String line) {
        subCabezaLineas.add(line);
    }
    //Agrega Productos
    public void AddItem(String cantidad, String item, String precio) {
        items.add(cantidad + '#' + item + '#' + precio);
    }
    //Agrega lineas de total
    public void AddTotal(String nombre, String precio) {
        totales.add(nombre + '#' + precio);
    }
    //Agrega lineas de pie
    public void AddPieLinea(String line) {
        LineasPie.add(line);
    }
    //Dibuja linea
    public String DibujarLinea(int valor) {
        String raya = "";
        for (int x = 0; x < valor; x++) {
            raya += "- ";
        }
        return raya;

    }
    // da espacio
    public String DarEspacio() {
        return "\n";
    }
    //----------ImprimirTicket------------------//
    public void ImprimirTicket() {   
        String cadena = this.toString();

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();//Busca la impresora por default
        DocPrintJob pj = service.createPrintJob(); //Inicia el servicio para imprimir
        byte bytes[] =cadena.getBytes(); //Genera array de bytes del texto del Ticket

        Doc doc = new SimpleDoc(bytes, flavor,null); //Crea el doc para imprimir

        try{

            pj.print(doc,null); //Imprime

        }catch(Exception e){ }

    }// Fin imprimirTicket
    //Funcion para agregar los productos al tiket
    public void TxtProducto(){
        for (int i = 0; i < items.size();i++){
            String A[] = (items.get(i)).split("#");
            this.AddItem(A[0],A[1],A[2]);
            this.AddItem("", "", this.DarEspacio());
        }
    }
    //Funcion para agregar los totales al tiket
    public void TxtTotal(){
        this.AddTotal("", this.DibujarLinea(29));
        for (int i = 0; i < totales.size();i++){
            String A[] = (totales.get(i)).split("#");
            this.AddItem(A[0],A[1],A[2]);
            this.AddItem("", "", this.DarEspacio());
        }
    }
    //Funcion para recopilar toda la info del tiquet
    public void CreaTicket(){
        CBD.openConexion();
        Date date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        //CABECERA
        this.AddCabecera("Minisuper Los Ayala");
        this.AddCabecera(this.DarEspacio());
        this.AddCabecera("EXPEDIDO EN: Monteon");
        this.AddCabecera(this.DarEspacio());
        this.AddCabecera("AV. TAMAULIPAS NO. 5 LOC. 101");
        this.AddCabecera(this.DarEspacio());
        this.AddCabecera(this.DibujarLinea(14));
        this.AddCabecera(this.DarEspacio());
        this.AddCabecera("Mexico, Monteon");
        this.AddCabecera(this.DarEspacio());
        this.AddCabecera("RFC: CSI-020226-MV4");
        this.AddCabecera(this.DarEspacio());
        //SUBCABECERA
        this.AddSubCabecera(this.DarEspacio());
        this.AddSubCabecera("Caja # 1");
        this.AddSubCabecera(this.DarEspacio());
        this.AddSubCabecera("LE ATENDIO: JUAN");
        this.AddSubCabecera(this.DarEspacio());
        this.AddSubCabecera("" + fecha.format(date));
        this.AddSubCabecera(this.DarEspacio());
        this.AddSubCabecera(this.DibujarLinea(14));
        this.AddSubCabecera(this.DarEspacio());
        TxtProducto();
        TxtTotal();
        //PIE DE LINEA
        this.AddPieLinea(this.DibujarLinea(29));
        this.AddPieLinea(this.DarEspacio());
        this.AddPieLinea("TU ERES NUESTRA MOTIVACION");
        this.AddPieLinea(this.DarEspacio());
        this.AddPieLinea("VIVE LA EXPERIENCIA EN LOS AYALA");
        this.AddPieLinea(this.DarEspacio());
        this.AddPieLinea("Gracias por su visita");
        this.AddPieLinea(this.DarEspacio());
    }

    @Override
    public String toString() {
        String cadena="";
        //Agreaga Cabeza
        for(int cabecera=0;cabecera<CabezaLineas.size();cabecera++ ){
            cadena+=CabezaLineas.get(cabecera);
        }
        //Agreaga la Subcabeza
        for(int subcabecera=0;subcabecera<subCabezaLineas.size();subcabecera++){
            cadena+=subCabezaLineas.get(subcabecera);
        }
        //Agreaga los productos
        for(int ITEM=0;ITEM<items.size();ITEM++){
            cadena+=items.get (ITEM);
        }
        //Agreaga los totales
        for(int total=0;total<totales.size();total++){
            cadena+=totales.get(total);
        }
        //Agreaga las lineas de pie
        for(int pie=0;pie<LineasPie.size();pie++){
            cadena+=LineasPie.get(pie);
        }
        return cadena;
    }
}

