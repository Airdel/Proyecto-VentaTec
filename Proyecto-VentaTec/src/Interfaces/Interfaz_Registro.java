package Interfaces;

/**
 *
 * @author INOVATEC
 */

public class Interfaz_Registro extends javax.swing.JInternalFrame {
    /**
     * Creates new form Interfaz_Registro
     */
    public Interfaz_Registro() {
        initComponents();
        this.setTitle("Registro");
        this.setLocation(200,50);
       //this.setLocationRelativeTo(null);
    }
    public void ini(){
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubT = new javax.swing.JLabel();
        jspTitulo = new javax.swing.JSeparator();
        lblSubT1 = new javax.swing.JLabel();
        lblID_Pro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jspNombre = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jspDescripcion = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        jspPrecio = new javax.swing.JSeparator();
        txtCosto = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        jspCosto = new javax.swing.JSeparator();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jspStock = new javax.swing.JSeparator();
        lblPresentacion = new javax.swing.JLabel();
        cmbPresentacion = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        cmbProvedor = new javax.swing.JComboBox();
        lblNombre1 = new javax.swing.JLabel();
        lblProvedor = new javax.swing.JLabel();
        txtID_Producto = new javax.swing.JTextField();
        jspID_Prod = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_Empresa_Transparente.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(66, 65, 70));
        lblTitulo.setText("Campos Obligatorios *");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(50, 400, 210, 30);

        lblSubT.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        lblSubT.setForeground(new java.awt.Color(66, 65, 70));
        lblSubT.setText("Registrar Nuevo Producto");
        jPanel1.add(lblSubT);
        lblSubT.setBounds(20, 10, 320, 30);

        jspTitulo.setBackground(new java.awt.Color(99, 99, 101));
        jspTitulo.setForeground(new java.awt.Color(99, 99, 101));
        jspTitulo.setDoubleBuffered(true);
        jspTitulo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jspTitulo.setMinimumSize(new java.awt.Dimension(650, 5));
        jspTitulo.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel1.add(jspTitulo);
        jspTitulo.setBounds(0, 40, 620, 10);

        lblSubT1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblSubT1.setForeground(new java.awt.Color(66, 65, 70));
        lblSubT1.setText("Información del Producto:");
        jPanel1.add(lblSubT1);
        lblSubT1.setBounds(20, 50, 220, 30);

        lblID_Pro.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblID_Pro.setForeground(new java.awt.Color(66, 65, 70));
        lblID_Pro.setText("Codigo Barra: *");
        jPanel1.add(lblID_Pro);
        lblID_Pro.setBounds(50, 80, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_Venta/icon_Empresa.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(410, 50, 210, 160);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_InterfazPrincipal/icon_RegistrarProducto.png"))); // NOI18N
        btnGuardar.setText("Guardar Producto");
        btnGuardar.setToolTipText("");
        btnGuardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGuardar.setContentAreaFilled(false);
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(340, 430, 210, 80);

        jspNombre.setBackground(new java.awt.Color(99, 99, 101));
        jspNombre.setForeground(new java.awt.Color(99, 99, 101));
        jspNombre.setDoubleBuffered(true);
        jPanel1.add(jspNombre);
        jspNombre.setBounds(190, 170, 120, 20);

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setBorder(null);
        txtNombre.setOpaque(false);
        txtNombre.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtNombre);
        txtNombre.setBounds(190, 150, 120, 22);

        txtDescripcion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(102, 102, 102));
        txtDescripcion.setBorder(null);
        txtDescripcion.setOpaque(false);
        txtDescripcion.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtDescripcion);
        txtDescripcion.setBounds(150, 180, 240, 22);

        lblDescripcion.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(66, 65, 70));
        lblDescripcion.setText("Descripción:");
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(50, 180, 110, 30);

        jspDescripcion.setBackground(new java.awt.Color(99, 99, 101));
        jspDescripcion.setForeground(new java.awt.Color(99, 99, 101));
        jspDescripcion.setDoubleBuffered(true);
        jPanel1.add(jspDescripcion);
        jspDescripcion.setBounds(150, 200, 240, 20);

        txtPrecio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(102, 102, 102));
        txtPrecio.setBorder(null);
        txtPrecio.setOpaque(false);
        txtPrecio.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(160, 220, 80, 22);

        lblPrecio.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(66, 65, 70));
        lblPrecio.setText("*Precio:          $");
        jPanel1.add(lblPrecio);
        lblPrecio.setBounds(50, 220, 110, 30);

        jspPrecio.setBackground(new java.awt.Color(99, 99, 101));
        jspPrecio.setForeground(new java.awt.Color(99, 99, 101));
        jspPrecio.setDoubleBuffered(true);
        jPanel1.add(jspPrecio);
        jspPrecio.setBounds(160, 240, 80, 20);

        txtCosto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(102, 102, 102));
        txtCosto.setBorder(null);
        txtCosto.setOpaque(false);
        txtCosto.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtCosto);
        txtCosto.setBounds(160, 250, 220, 22);

        lblCosto.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(66, 65, 70));
        lblCosto.setText("*Costo:           $");
        jPanel1.add(lblCosto);
        lblCosto.setBounds(50, 250, 110, 30);

        jspCosto.setBackground(new java.awt.Color(99, 99, 101));
        jspCosto.setForeground(new java.awt.Color(99, 99, 101));
        jspCosto.setDoubleBuffered(true);
        jPanel1.add(jspCosto);
        jspCosto.setBounds(160, 270, 80, 20);

        lblCategoria.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(66, 65, 70));
        lblCategoria.setText("*Categoria del Producto: ");
        jPanel1.add(lblCategoria);
        lblCategoria.setBounds(50, 280, 180, 40);

        cmbCategoria.setOpaque(false);
        jPanel1.add(cmbCategoria);
        cmbCategoria.setBounds(230, 290, 150, 22);

        lblStock.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblStock.setForeground(new java.awt.Color(66, 65, 70));
        lblStock.setText("*Cantidad:");
        jPanel1.add(lblStock);
        lblStock.setBounds(50, 320, 80, 30);

        txtStock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtStock.setForeground(new java.awt.Color(102, 102, 102));
        txtStock.setBorder(null);
        txtStock.setOpaque(false);
        txtStock.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtStock);
        txtStock.setBounds(130, 320, 120, 22);

        jspStock.setBackground(new java.awt.Color(99, 99, 101));
        jspStock.setForeground(new java.awt.Color(99, 99, 101));
        jspStock.setDoubleBuffered(true);
        jPanel1.add(jspStock);
        jspStock.setBounds(130, 340, 120, 20);

        lblPresentacion.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblPresentacion.setForeground(new java.awt.Color(66, 65, 70));
        lblPresentacion.setText("*Presentación: ");
        jPanel1.add(lblPresentacion);
        lblPresentacion.setBounds(50, 360, 180, 40);

        cmbPresentacion.setOpaque(false);
        jPanel1.add(cmbPresentacion);
        cmbPresentacion.setBounds(170, 370, 210, 22);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Iconos_InterfazPrincipal/icon_Salir.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setAlignmentX(0.5F);
        btnRegresar.setBorder(null);
        btnRegresar.setContentAreaFilled(false);
        jPanel1.add(btnRegresar);
        btnRegresar.setBounds(80, 440, 190, 80);

        jPanel1.add(cmbProvedor);
        cmbProvedor.setBounds(160, 130, 120, 22);

        lblNombre1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(66, 65, 70));
        lblNombre1.setText("*Nombre Producto: ");
        jPanel1.add(lblNombre1);
        lblNombre1.setBounds(50, 150, 150, 30);

        lblProvedor.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblProvedor.setForeground(new java.awt.Color(66, 65, 70));
        lblProvedor.setText("*Proveedor: *");
        jPanel1.add(lblProvedor);
        lblProvedor.setBounds(50, 120, 100, 30);

        txtID_Producto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtID_Producto.setForeground(new java.awt.Color(102, 102, 102));
        txtID_Producto.setBorder(null);
        txtID_Producto.setOpaque(false);
        txtID_Producto.setSelectedTextColor(new java.awt.Color(66, 65, 70));
        jPanel1.add(txtID_Producto);
        txtID_Producto.setBounds(160, 80, 120, 22);

        jspID_Prod.setBackground(new java.awt.Color(99, 99, 101));
        jspID_Prod.setForeground(new java.awt.Color(99, 99, 101));
        jspID_Prod.setDoubleBuffered(true);
        jPanel1.add(jspID_Prod);
        jspID_Prod.setBounds(160, 100, 120, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Registro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbPresentacion;
    public javax.swing.JComboBox cmbProvedor;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jspCosto;
    private javax.swing.JSeparator jspDescripcion;
    private javax.swing.JSeparator jspID_Prod;
    private javax.swing.JSeparator jspNombre;
    private javax.swing.JSeparator jspPrecio;
    private javax.swing.JSeparator jspStock;
    private javax.swing.JSeparator jspTitulo;
    public javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblCosto;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblID_Pro;
    public javax.swing.JLabel lblNombre1;
    public javax.swing.JLabel lblPrecio;
    public javax.swing.JLabel lblPresentacion;
    public javax.swing.JLabel lblProvedor;
    public javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblSubT;
    private javax.swing.JLabel lblSubT1;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JTextField txtCosto;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtID_Producto;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
