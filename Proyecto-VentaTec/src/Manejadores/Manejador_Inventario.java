/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;

import Modulos.ConexionBD;
import Modulos.Modulo_Inventario;
import Interfaces.Interfaz_Inventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Inovatec-Darien Rafael Márquez Vázquez
 */
public class Manejador_Inventario {
    //----------Declaracion de Variables--------//
    private Interfaz_Inventario II;
    private Modulo_Inventario MI;
    private ConexionBD CBD;
    private DefaultTableModel DTM;
    //----------Declaracion de Variables--------//

    //--------------Inicia Interfaz INVENTARIO-------------------//
    public Manejador_Inventario(Interfaz_Inventario II, Modulo_Inventario MI) {
        //-------Inicializacion de variables--------------//
        this.II = II;
        this.MI = MI;
        CBD = new ConexionBD();
        DTM = (DefaultTableModel) II.dgvProductos.getModel();
        llenartabla();
        llenarCombo();
        //-------Inicializacion de variables--------------//
        //-------Mouse Listener Key Listener---------------------------//
        this.II.dgvProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            //-----------Actualiza todos los TXT con info de la tabla----------//
            public void mouseReleased(MouseEvent me) {
                int row = II.dgvProductos.getSelectedRow();
                II.txtNombreProducto.setText(DTM.getValueAt(row, 0) + "");
                II.txtDescripcion.setText(DTM.getValueAt(row, 1) + "");
                II.txtPrecio.setText(DTM.getValueAt(row, 2) + "");
                II.txtCosto.setText(DTM.getValueAt(row, 3) + "");
                II.cmbCategoria.setSelectedItem(DTM.getValueAt(row, 4) + "");
                II.txtCantidad.setText(DTM.getValueAt(row, 5) + "");
                II.cmbPresentacion.setSelectedItem(DTM.getValueAt(row, 6) + "");
                II.lblid.setText(DTM.getValueAt(row, 7) + "");
            }
            //-----------Actualiza todos los TXT con info de la tabla----------//
        });
        this.II.txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 48 && c <= 57))) {
                    ke.consume();
                } else if (II.txtCantidad.getText().length() == 20) {
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros------------//
        });

        this.II.txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Numeros y Punto------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 48 && c <= 57) || (c == 46))) {
                    ke.consume();
                } else if (II.txtCosto.getText().length() == 20) {
                    ke.consume();
                }
            }
            //---------Valida Solo Numeros y Punto------------//
        });

        this.II.txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Solo Letras------------//
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == KeyEvent.VK_ESCAPE) || (c == 130) || (c == 181) || (c == 144) || (c == 214) || (c == 224) || (c == 233) || (c >= 160 && c <= 163))) {
                    ke.consume();
                } else if (II.txtNombreProducto.getText().length() == 13) {
                    ke.consume();
                }
            }
            //---------Valida Solo Letras------------//
        });
        this.II.txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            //---------Valida Numeros y Punto------------//
            public void keyPressed(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= 48 && c <= 57) || (c == 46))) {
                    ke.consume();
                } else if (II.txtPrecio.getText().length() == 20) {
                    ke.consume();
                }
            }
            //---------Valida Numeros y Punto------------//
        });
        //-------Mouse Listener Key Listener---------------------------//
        //-------Action Listener Performed---------------//
        this.II.btnEliminarProducto.addActionListener(new ActionListener() {
            //---------Confirmacion de eliminar dato------------//
            public void actionPerformed(ActionEvent ae) {
                int i = JOptionPane.showConfirmDialog(II, "¿Seguro quiere eliminar esta cantidad de productos?");
                if (i == 0) {
                    eliminaBD();
                }
            }
            //---------Confirmacion de eliminar dato------------//
        });
        this.II.btnModificarProducto.addActionListener(new ActionListener() {
            //---------Confirmacion de modificar dato------------//
            public void actionPerformed(ActionEvent ae) {
                //----Valida txt de Intentario---//
                validaTxt();
                modificaDato();
                //----Valida txt de Intentario---//
                int i = JOptionPane.showConfirmDialog(II, "¿Seguro quiere modificar este producto?");
                if (i == 0) {
                    modificaDato();
                    DTM.setRowCount(0);
                    llenartabla();
                }
            }
            //---------Confirmacion de modificar dato------------//
        });
        this.II.btnRegresar.addActionListener(new ActionListener() {
            //-----------Ocupta la Interfaz Inventario-----------//
            public void actionPerformed(ActionEvent ae) {
                II.setVisible(false);
                II.setEnabled(false);
            }
            //-----------Ocupta la Interfaz Inventario-----------//
        });
        //-------Action Listener Performed---------------//
        
        
        //--------------------Codigo que hace que nuestra etiqueta Icono de empresa en ventana inventarios actualice la tabla.
        /*   this.II.lbl_IconoEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DTM.setRowCount(0);
                llenartabla();
            
            }
        });*/
        
        
        
        //----------------Listener Mouse Listener-------------//   
        this.II.btnUpdate.addMouseMotionListener(new java.awt.event.MouseAdapter(){
           public void mouseReleased(java.awt.event.MouseEvent evt) {
                DTM.fireTableDataChanged();
                DTM.setRowCount(0);
                llenartabla();            
            }
        });
        //----------------Listener Mouse Listener-------------//   
    }
    //-----------------Fin de Constructor---------------//

    //---------------Funciones Void------------------//
    public void eliminaBD() {
        CBD.openConexion();
        //------Reune los datos de producto con id--------------//
        String A[] = CBD.getInveID(II.lblid.getText());
        //------Reune los datos de producto con id--------------//
        //------Verifica si la cantidad es 0--------------//
        if (Integer.parseInt(A[5]) == 0) {
            //------Elimina--------------//
            CBD.deleteDBProd("[ID PRODUCTO]", A[7]);
            //------Elimina--------------//
        } else {
            JOptionPane.showMessageDialog(II, "No puedes eliminar un producto si su existencia es mayor a 0");
        }
        CBD.closeConexion();
    }// Fin eliminaBD

    public void llenarCombo() {
        CBD.openConexion();
        //------Busca todas las Categorias y Presentaciones--------------//
        String A[] = CBD.allCat();
        String B[] = CBD.allPre();
        //------Busca todas las Categorias y Presentaciones--------------//
        //------Rellena el Combo Categoria--------------//
        for (int i = 0; i < A.length; i++) {
            II.cmbCategoria.addItem(A[i]);
        }
        //------Rellena el Combo Categoria--------------//
        //------Rellena el Combo Presentacion--------------//
        for (String B1 : B) {
            II.cmbPresentacion.addItem(B1);
        }
        //------Rellena el Combo Presentacion--------------//
        CBD.closeConexion();
    }//Fin llenarCombo

    public void validaTxt() {
        try{
            //---Valida si Precio es numero---//
            String textP = II.txtPrecio.getText();
            Float.parseFloat(textP);
            //---Valida si Precio es numero---//
            //---Valida si Costo es numero---//
            String textC = II.txtCosto.getText();
            Float.parseFloat(textC);
            //---Valida si Costo es numero---//
            //---Valida si Cantidad esta vacio---//
            String textCan = II.txtCantidad.getText();
            if (textCan.equals("")) {
                JOptionPane.showMessageDialog(II, "Cantidad esta vacia");
                return;
            }
            //---Valida si Cantidad esta vacio---//
            //---Valida si Nombre Producto esa vacio---//
            String textName = II.txtNombreProducto.getText();
            if (textName.equals("")) {
                JOptionPane.showMessageDialog(II, "Nombre del producto esta vacio");
                return;
            }
            //---Valida si Nombre Producto esa vacio---//
            //---Valida si Descripcion esa vacio---//
            String textDes = II.txtDescripcion.getText();
            if (textDes.equals("")) {
                JOptionPane.showMessageDialog(II, "Descripcion del producto esta vacio");
                return;
            }
            //---Valida si Descripcion esa vacio---//
            //---Valida si Categoria esa vacio---//
            Object cmbCat = II.cmbCategoria.getSelectedItem();
            if (cmbCat == null) {
                JOptionPane.showMessageDialog(II, "Categoria del producto esta vacia");
                return;
            }
            //---Valida si Categoria esa vacio---//
            //---Valida si Presentacion esa vacio---//
            Object cmbPre = II.cmbPresentacion.getSelectedItem();
            if (cmbPre == null) {
                JOptionPane.showMessageDialog(II, "Presentacion del producto esta vacio");
                return;
            }
            //---Valida si Presentacion esa vacio---//
        }catch(Exception e){JOptionPane.showMessageDialog(II, "Casillas mas escritas");}
    }// Fin valida Txt

    public void modificaDato() {
        CBD.openConexion();
        //(@NOMBRE VARCHAR,org = cmbOrden.getSelectedIndex()@DESCRIPCION VARCHAR,@PREV MONEY,@PREC MONEY,@IDCATE TINYINT,@IDPRESENTACION TINYINT,@ID INT)
        CBD.UpdateInventario(
                II.txtNombreProducto.getText(),//NOMBRE
                II.txtDescripcion.getText(),//DESCRIPCION
                Float.parseFloat(II.txtPrecio.getText()),//PRECIO VENTA
                Float.parseFloat(II.txtCosto.getText()),//PRECIO COSTO
                II.cmbCategoria.getSelectedIndex()+1,//CATEGORIA CMB int 
                II.cmbPresentacion.getSelectedIndex()+1,//PRESENTACIONN CMB int
                II.lblid.getText()//ID
        );
        CBD.closeConexion();
    }// Fin modifica Dato

    public void llenartabla() {
        CBD.openConexion();
        //---Consulta todo el Inventario---//
        String A[] = CBD.getInve();
        Object B[] = new Object[8];
        //---Agrega cada renglon a la tabla Inventario---//
        try {
            for (int i = 0; i < A.length; i++) {
                B = A[i].split(",");
                DTM.addRow(B);
            }
        } catch (Exception e) {
        }
        //---Agrega cada renglon a la tabla Inventario---//
        CBD.closeConexion();
    }//Fin llenar Tabla
    //---------------Funciones Void------------------//
}
