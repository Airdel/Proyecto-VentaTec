package Manejadores;

import Interfaces.Interfaz_Principal;
import Interfaces.Interfaz_Venta;
import Interfaces.SubInterfaz_Venta_BuscarProducto;
import Interfaces.Sub_Venta;
import MailyOtros.ventaException;
import Modulos.ConexionBD;
import Modulos.Modulo_Venta;
import Modulos.Modulo_SubVenta;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS INC
 */
public class Manejador_Ventas {

    //---Declaracion de Variables-----------//
    private Interfaz_Venta IV;
    private SubInterfaz_Venta_BuscarProducto IV_BP;
    private Modulo_Venta MV;
    private ConexionBD CBD;
    private DefaultTableModel DTM;
    private TextAutoCompleter TAC;
    private SubInterfaz_Venta_BuscarProducto SIVBP;
    private ListSelectionModel SM;
    private Interfaces.Sub_Venta SUV;
    private Modulo_SubVenta MSUV;
    private Manejador_SubVenta MASUV;
    private Interfaz_Principal IP;

    //---Declaracion de Variables-----------//
    //------Inicio de Interfaz Venta-----------//
    public Manejador_Ventas(Interfaz_Venta IV1, Modulo_Venta MV1, Interfaz_Principal IP2) {
        //--------Inicializacion de variables------------//
        this.IV = IV1;
        this.MV = MV1;
        IV.lbl_UsuarioValor.setText(MV.getNameUsu());
        CBD = new ConexionBD();
        DTM = (DefaultTableModel) IV.dgv_Productos.getModel();
        SM = IV.dgv_Productos.getSelectionModel();
        TAC = new TextAutoCompleter(IV1.txt_BuscarProducto);
        this.IP = IP2;
        //--------Inicializacion de variables------------//
        //--------Listener Key Listener------------//
        this.IV.txt_BuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                busquedarapida();
            }
            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!(IV.txt_Cantidad.getText().equals(""))) {
                        CBD.openConexion();
                        String A = CBD.searchProduct2("[NOMBRE PRODUCTO]", IV.txt_BuscarProducto.getText());
                        Object B[] = new Object[6];
                        B = A.split(",");
                        IV.txt_Codigo.setText(B[0]+"");
                        if(!(validaProducto())){
                            try {
                                if(!(A.equals(""))){
                                    B[2] = IV.txt_Cantidad.getText();
                                    B[4] = (Double.parseDouble(B[2]+"")*(Double.parseDouble(B[3]+"")*(1 - Double.parseDouble(B[5]+""))))+"";
                                    DTM.addRow(B);
                                    
                                    int row = DTM.getRowCount();
                                    Float impUnit = Float.parseFloat(B[3] + "") - (Float.parseFloat(B[3] + "") * Float.parseFloat(B[5] + ""));
                                    MV.agregaProduc((row - 1) + "",B[0] + "", B[2] + "", B[3] + "",impUnit + "",  B[5]+ "");
                                    MV.sumaSubTotal();
                                    MV.sumaTodo();
                                    IV.txt_Codigo.setText(B[0] + "");
                                }else{
                                    JOptionPane.showMessageDialog(IV, "Producto no encontrado");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        CBD.closeConexion();
                    } else {
                        showMessageDialog(IV, "El campo cantidad esta vacia: no se puede generar la venta");
                        IV.dgv_Productos.requestFocus();
                    }

                }
                if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
                IV.txt_BuscarProducto.setText("");
                }

            }
        });
        this.IV.txt_Codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(c >= 48 && c <= 57)) {
                    ke.consume();
                } else if (IV.txt_Codigo.getText().length() == 13) {
                    ke.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!(IV.txt_Cantidad.getText().equals("") || IV.txt_Codigo.getText().equals(""))) {
                        CBD.openConexion();
                        String A = CBD.searchProduct2("[ID PRODUCTO]", IV.txt_Codigo.getText());
                        Object B[] = new Object[6];
                        if(!(validaProducto())){
                            try {
                                if(!(A.equals(""))){
                                    B = A.split(",");
                                    B[2] = IV.txt_Cantidad.getText();
                                    B[4] = (Double.parseDouble(B[2]+"")*(Double.parseDouble(B[3]+"")*(1 - Double.parseDouble(B[5]+""))))+"";
                                    DTM.addRow(B);

                                    int row = DTM.getRowCount();
                                    Float impUnit = Float.parseFloat(B[3] + "") - (Float.parseFloat(B[3] + "") * Float.parseFloat(B[5] + ""));
                                    MV.agregaProduc((row - 1) + "",B[0] + "", B[2] + "", B[3] + "",impUnit + "",  B[5]+ "");
                                    MV.sumaSubTotal();
                                    MV.sumaTodo();
                                    actualizalbl();     
                                }else{
                                    JOptionPane.showMessageDialog(IV,"Producto no encontrado");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        CBD.closeConexion();
                    } else {
                        showMessageDialog(IV, "Algunos campos estan vacios Error: no se puede generar la venta");
                        IV.dgv_Productos.requestFocus();
                    }

                }
            }
        }
        );
        
        

        this.IV.txt_Cantidad.addKeyListener(
                new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke
            ) {
                char c = ke.getKeyChar();
                if (!(c >= 48 && c <= 57)) {
                    ke.consume();
                } else if (IV.txt_Cantidad.getText().length() == 4) {
                    ke.consume();
                }
            }

            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (!(IV.txt_Cantidad.getText().equals("") || IV.txt_Codigo.getText().equals(""))) {
                        CBD.openConexion();
                        String A = CBD.searchProduct2("[ID PRODUCTO]", IV.txt_Codigo.getText());
                        Object B[] = new Object[6];

                        
                        if(!(validaProducto())){
                            try {
                                if(!(A.equals(""))){
                                    B = A.split(",");
                                    B[2] = IV.txt_Cantidad.getText();
                                    B[4] = (Double.parseDouble(B[2]+"")*(Double.parseDouble(B[3]+"")*(1 - Double.parseDouble(B[5]+""))))+"";
                                    DTM.addRow(B);
                                    
                                    int row = DTM.getRowCount();
                                    Float impUnit = Float.parseFloat(B[3] + "") - (Float.parseFloat(B[3] + "") * Float.parseFloat(B[5] + ""));
                                    MV.agregaProduc((row - 1) + "",B[0] + "", B[2] + "", B[3] + "",impUnit + "",  B[5]+ "");
                                    MV.sumaSubTotal();
                                    MV.sumaTodo();
                                    actualizalbl(); 
                                }else{
                                    JOptionPane.showMessageDialog(IV, "Producto no encontrado");
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        CBD.closeConexion();
                    } else {
                        showMessageDialog(IV, "Algunos campos estan vacios Error: no se puede generar la venta");
                        IV.dgv_Productos.requestFocus();
                    }
                    IV.txt_Cantidad.setText("1");

                }
            }

        });
        //--------Listener Key Listener------------//
        //--------Action Listener Performed------------//
        this.IV.btn_AplicarDescuento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (IV.dgv_Productos.getSelectedRow() >= 0) {
                    float x = 0;
                    String cad = "";
                    try {
                        cad = JOptionPane.showInputDialog(IV, "Coloca el descuento del producto");
                        x = Float.parseFloat(cad);
                    } catch (Exception e) {
                        showMessageDialog(IV, "Solo numeros");
                        IV.dgv_Productos.requestFocus();
                    }
                    if (x > -1) {
                        Integer.parseInt(cad);
                        int row[] = IV.dgv_Productos.getSelectedRows();
                        int cant = 0;
                        float PU = 0,descu = 0;
                        for(int i = 0; i < row.length;i++){
                            DTM.setValueAt("0." + cad, row[i], 5);
                            descu = Float.parseFloat(DTM.getValueAt(row[i], 5) + "");
                            PU = Float.parseFloat(DTM.getValueAt(row[i], 3) + "");
                            cant = Integer.parseInt(DTM.getValueAt(row[i], 2) + "");
                            float importe = cant * (PU - (PU * descu));
                            DTM.setValueAt(importe, row[i], 4);
                            String imporUnitario = (PU - (PU * descu)) + "";
                            String desc = DTM.getValueAt(row[i], 5) + "";
                            String cantidad = cant +"";
                            MV.modificarProducto(row[i] + "", imporUnitario, desc,cantidad);
                        }
                        MV.sumaSubTotal();
                        MV.sumaTodo();
                        actualizalbl();
                    } else {
                        showMessageDialog(IV, "Ingresa un valor valido");
                    }
                } else {
                    showMessageDialog(IV, "Es necesario seleccionar un registro");
                }

            }
        }
        );

        this.IV.btn_BuscarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                IniciaSub();
            }
        });
        this.IV.btn_Cobrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (IV.dgv_Productos.getRowCount() > 0) {                    
                    MSUV = new Modulo_SubVenta(IV.dgv_Productos.getRowCount(),MV.getId_usu());
                    SUV = new Sub_Venta();
                    MASUV = new Manejador_SubVenta(SUV, MSUV, IV, MV);                    
                    String cad = JOptionPane.showInputDialog(IV, "Coloque el Efectivo");
                    if (MASUV.validaInput(cad)) {
                        MSUV.setEfectivo(Double.parseDouble(cad));
                        if (MASUV.venta()) {
                            MASUV.rellenaSub();
                            SUV.setVisible(true);
                        } else {
                          
                            JOptionPane.showMessageDialog(IV, "Efectivo no suficiente");
                            SUV.dispose();
                        }
                    }
                } else {
                    showMessageDialog(IV, "Es necesario ingresar productos registro");
                    IV.dgv_Productos.requestFocus();
                }
            }

        });

        this.IV.btn_Quitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (IV.dgv_Productos.getSelectedRow() >= 0) {
                    eliminaTabla();
                    MV.sumaSubTotal();
                    MV.sumaTodo();
                    actualizalbl();
                } else {
                    showMessageDialog(IV, "Es necesario seleccionar un registro");
                }
            }
        });
        this.IV.btn_regresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (showConfirmDialog(IV, "¿Desea salir de la venta?",
                        "Salir del sistema", YES_NO_OPTION) == YES_OPTION) {

                    IV.dispose();
                    IP.setVisible(true);
                }

            }
        });
        //--------Action Listener Performed------------//
    }

    //-------------Fin del Constructor---------------//
    //--------Funciones Void-----------------//
    public void actualizalbl(){
        int row = DTM.getRowCount();
        if(DTM.getRowCount() != 0){
            IV.lbl_NumeroDeArticulosValor.setText(MV.getNoArticulos() + "");
            String nombrePro = (DTM.getValueAt(row - 1, 1) + "");
            IV.lbl_NombreProducto.setText(nombrePro);
            IV.lbl_TotalValor.setText((MV.getSubtotal() + MV.getIva()) + "");
        }else{
            IV.lbl_NumeroDeArticulosValor.setText(MV.getNoArticulos() + "");
            IV.lbl_TotalValor.setText("0.0");
        }
    }
    public void eliminaTabla() {
        //----Selecciona en numero de renglon de las seleccines es tabla----//
        int sel[] = IV.dgv_Productos.getSelectedRows();
        //----Elimina los renglones de las tablas-----/
        if (sel.length == 0) {
            JOptionPane.showMessageDialog(IV, "Selecciona una columna a eliminar");
            return;
        }
        for (int i = (sel.length - 1); i >= 0 ; i--) {
            MV.eliminaProduc(sel[i] + "");
            DTM.removeRow(sel[i]);
        }
    }// Fin elimina Tabla

    public void busquedarapida() {
        CBD.openConexion();
        //-----Busca el coincidente que inicia con nombreProducto-----//
        String nombreProducto = IV.txt_BuscarProducto.getText();
        String A[] = CBD.searchInTable("[NOMBRE PRODUCTO]", nombreProducto);
        //-----Busca el coincidente que inicia con nombreProducto-----//
        //-----Agrega la lista de coincidencias a la variable autocompletar----//
        TAC.removeAllItems();
        try {
            TAC.addItems(A);
        } catch (Exception e) {
        }
        //-----Agrega la lista de coincidencias a la variable autocompletar----//
        CBD.closeConexion();
    }// Fin busqueda rapida

    //----Inicializa interfaz Sub Venta----//
    public void IniciaSub() {
        //----Inicializa variables-----//
        SIVBP = new SubInterfaz_Venta_BuscarProducto();
        DefaultTableModel ddd = (DefaultTableModel) SIVBP.dgv_Productos.getModel();
        //----Inicializa variables-----//
        //----Action Listener Performed----//
        SIVBP.btnCan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SIVBP.dispose();
            }
        });
        SIVBP.btnAna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int row[] = SIVBP.dgv_Productos.getSelectedRows();
                Object B[] = new Object[6];
                for(int j = 0; j < row.length; j++){
                    B[0] = ddd.getValueAt(row[j], 0);
                    B[1] = ddd.getValueAt(row[j], 1);
                    B[2] = ddd.getValueAt(row[j], 2);
                    B[3] = ddd.getValueAt(row[j], 3);
                    B[4] = ddd.getValueAt(row[j], 4);
                    B[5] = "0.0";
                    int CANTIDAD = 0;
                    float PRECIOU = 0;
                    float precioUimporte = 0;
                    float imp = 0;
                    boolean encontro = false;
                    for(int i = 0;i<DTM.getRowCount();i++){
                        if(DTM.getValueAt(i,0).toString().equals(B[0])){
                            CANTIDAD = Integer.parseInt(DTM.getValueAt(i,2).toString()) + Integer.parseInt(B[2] + "");
                            PRECIOU =  Float.parseFloat(DTM.getValueAt(i,3).toString());
                            imp = CANTIDAD*PRECIOU *(1 - Float.parseFloat(DTM.getValueAt(i,5).toString()));
                            precioUimporte = PRECIOU *(1 - Float.parseFloat(DTM.getValueAt(i,5).toString()));
                            DTM.setValueAt(CANTIDAD,i, 2);
                            DTM.setValueAt(imp,i, 4);
                            MV.modificarProducto(i + "",precioUimporte + "",DTM.getValueAt(i,5).toString(),CANTIDAD+"");
                            MV.sumaSubTotal();
                            MV.sumaTodo();
                            actualizalbl();
                            encontro = true;
                        }
                    }
                    if(!encontro){
                        DTM.addRow(B);
                        int rows = DTM.getRowCount();
                        MV.agregaProduc((rows - 1) + "",B[0] + "", B[2] + "", B[3] + "", B[4]+ "", B[5]+ "");
                        MV.sumaSubTotal();
                        MV.sumaTodo();
                        actualizalbl();
                    }
                }
            }
        });
        //----Action Listener Performed----//
        //----Listener Key Listener----//
        SIVBP.txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            //------Agrega a la tabla el registro con el TXTCode----//
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    ddd.setRowCount(0); //---Elimina tabla---//
                    CBD.openConexion();
                    //----Busca producto segun id ------//
                    String A[] = CBD.searchProduct("[ID PRODUCTO]", SIVBP.txtCode.getText());
                    Object B[] = new Object[6];
                    try {
                        //-------Agrega a tabla SubVentaBuscarProducto------//
                        for (int i = 0; i < A.length; i++) {
                            B = A[i].split(",");
                            B[2] = 1 + "";
                            ddd.addRow(B);
                        }
                        //-------Agrega a tabla SubVentaBuscarProducto------//
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    CBD.closeConexion();
                }
            }
        });
        //----Listener Key Listener----//
        SIVBP.setVisible(true);
    }// Fin Inicio Sub

    public boolean validaProducto(){
        int CANTIDAD = 0;
        float PRECIOU = 0;
        float precioUimporte = 0;
        float imp = 0;
        int stock = Integer.parseInt(CBD.getInventario(IV.txt_Codigo.getText()));
        if(stock == 0){
            IV.lblHora.requestFocus();
            showMessageDialog(null,"No se encuentra este producto en inventario. Cantidad de producto = 0");
            return true;
        }
        for(int i = 0;i<DTM.getRowCount();i++){
            if((DTM.getValueAt(i,0) + "").equals(IV.txt_Codigo.getText())){
                
                CANTIDAD = Integer.parseInt(DTM.getValueAt(i,2).toString()) + Integer.parseInt(IV.txt_Cantidad.getText());
                if(stock>=CANTIDAD){
                    PRECIOU =  Float.parseFloat(DTM.getValueAt(i,3).toString());
                    imp = CANTIDAD*(PRECIOU *(1 - Float.parseFloat(DTM.getValueAt(i,5).toString())));
                    precioUimporte = PRECIOU -(PRECIOU * Float.parseFloat(DTM.getValueAt(i,5).toString()));

                    DTM.setValueAt(CANTIDAD,i, 2);
                    DTM.setValueAt(imp,i, 4);
                    MV.modificarProducto(i + "",precioUimporte + "",DTM.getValueAt(i,5).toString(),CANTIDAD+"");
                    MV.sumaSubTotal();
                    MV.sumaTodo();
                    actualizalbl();
                    return true;
                }else{
                    IV.lblHora.requestFocus();
                    showMessageDialog(null,"DEJA DE ESTAR JUGANDO, NO PUEDES VENDER MAS DEL PRODUCTO QUE TIENES EN INVENTARIO. PRODUCTO MAX:" + stock);
                    return true;
                }                
            }
        }
        return false;
    }

    public void validartxtCaracteresBG() throws ventaException {
        //valida los txt para que no tengan caracteres invalidos y 
        //que no tengan espacios excepto el nombre por que se separan en dos nombres por eso para el nombre tiene la de invalidonom donde no agrego el espacio

        String invalido = "¬~`^!#$%&/()=¡*¨[]:@;*|°|$!!'*¨**]{.-¨¨><''**;:_-¡¡?=~`^~^^¬";
        String invalidonom = "¬~`^!#$%&/()=¡*¨[]:@;*|°|$!!*¨**]{.-¨¨><''''**;:_-'¡¡?=~`^~^^";
        String numeros = "0123456789";
        String letras = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLLÑZXCVBNM";
        String cad = IV.txt_BuscarProducto.getText();
        String cad2 = IV.txt_Cantidad.getText();
        String cad3 = IV.txt_Codigo.getText();
        for (int i = 0; i < cad.length(); i++) {
            if (invalidonom.indexOf(cad.substring(i, i + 1)) != -1) {
                IV.txt_BuscarProducto.requestFocus();
                throw new ventaException("Campo Buscar Producto contiene carácteres inválidos");
            }
        }
        for (int i = 0; i < cad.length(); i++) {
            if (numeros.indexOf(cad.substring(i, i + 1)) != -1) {
                IV.txt_BuscarProducto.requestFocus();
                throw new ventaException("Campo Buscar Producto contiene números");
            }
        }
        for (int o = 0; o < cad2.length(); o++) {
            if (invalido.indexOf(cad2.substring(o, o + 1)) != -1) {
                IV.txt_Cantidad.requestFocus();
                throw new ventaException("Campo Cantidad contiene carácteres inválidos");
            }
        }
        for (int o = 0; o < cad2.length(); o++) {
            if (letras.indexOf(cad2.substring(o, o + 1)) != -1) {
                IV.txt_Cantidad.requestFocus();
                throw new ventaException("Campo Cantidad contiene letras");
            }
        }
        for (int o = 0; o < cad3.length(); o++) {
            if (invalido.indexOf(cad3.substring(o, o + 1)) != -1) {
                IV.txt_Codigo.requestFocus();
                throw new ventaException("Campo Codigo contiene carácteres inválidos");
            }
        }
        for (int o = 0; o < cad3.length(); o++) {
            if (letras.indexOf(cad3.substring(o, o + 1)) != -1) {
                IV.txt_Codigo.requestFocus();
                throw new ventaException("Campo Codigo contiene letras");
            }
        }
    }// Fin Validar Txt Brayan
    //--------Funciones Void-----------------//    
}
