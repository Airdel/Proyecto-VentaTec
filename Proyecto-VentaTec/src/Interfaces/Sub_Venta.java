package Interfaces;

import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

/**
 *
 * @author INOVATEC
 */
public class Sub_Venta extends javax.swing.JFrame {

    /**
     * Creates new form Sub_Venta
     */
    public Sub_Venta() {
        initComponents();
        setLocationRelativeTo(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInformacion = new javax.swing.JPanel();
        lblTP2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTP3 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblUser4 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblUser6 = new javax.swing.JLabel();
        lblFechaV = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        pnlBotonInformacion = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblUser5 = new javax.swing.JLabel();
        lblSobrante = new javax.swing.JLabel();
        lblTP4 = new javax.swing.JLabel();
        lblTP5 = new javax.swing.JLabel();
        lblEfectivo = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TICKET DE VENTA");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icon_Empresa_Transparente.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlInformacion.setBackground(new java.awt.Color(255, 255, 255));
        pnlInformacion.setLayout(null);

        lblTP2.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lblTP2.setText("Total:");
        pnlInformacion.add(lblTP2);
        lblTP2.setBounds(10, 10, 100, 19);

        lblTotal.setFont(new java.awt.Font("Montserrat", 1, 26)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("$0.00");
        pnlInformacion.add(lblTotal);
        lblTotal.setBounds(0, 20, 200, 40);

        lblTP3.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblTP3.setText("Efectivo");
        pnlInformacion.add(lblTP3);
        lblTP3.setBounds(10, 110, 50, 16);

        lblDescuento.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblDescuento.setForeground(new java.awt.Color(102, 102, 102));
        lblDescuento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescuento.setText("0%");
        pnlInformacion.add(lblDescuento);
        lblDescuento.setBounds(80, 200, 120, 20);

        lblUser4.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblUser4.setForeground(new java.awt.Color(102, 102, 102));
        lblUser4.setText("IVA:");
        pnlInformacion.add(lblUser4);
        lblUser4.setBounds(10, 230, 30, 16);

        lblIva.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblIva.setForeground(new java.awt.Color(102, 102, 102));
        lblIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIva.setText("$0.00");
        pnlInformacion.add(lblIva);
        lblIva.setBounds(40, 230, 160, 20);

        lblUser6.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblUser6.setForeground(new java.awt.Color(102, 102, 102));
        lblUser6.setText("Fecha Venta:");
        pnlInformacion.add(lblUser6);
        lblUser6.setBounds(10, 260, 80, 16);

        lblFechaV.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblFechaV.setForeground(new java.awt.Color(102, 102, 102));
        lblFechaV.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaV.setText("15/01/2020");
        pnlInformacion.add(lblFechaV);
        lblFechaV.setBounds(90, 260, 110, 20);

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setDoubleBuffered(true);
        pnlInformacion.add(jSeparator2);
        jSeparator2.setBounds(10, 280, 190, 10);

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator3.setDoubleBuffered(true);
        pnlInformacion.add(jSeparator3);
        jSeparator3.setBounds(10, 220, 190, 10);

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator4.setDoubleBuffered(true);
        pnlInformacion.add(jSeparator4);
        jSeparator4.setBounds(10, 250, 190, 10);

        pnlBotonInformacion.setLayout(null);

        jToolBar3.setRollover(true);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/pago.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnAceptar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fotos/Back.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(btnCancelar);

        pnlBotonInformacion.add(jToolBar3);
        jToolBar3.setBounds(20, 70, 140, 90);

        pnlInformacion.add(pnlBotonInformacion);
        pnlBotonInformacion.setBounds(10, 300, 190, 190);

        lblUser5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblUser5.setForeground(new java.awt.Color(102, 102, 102));
        lblUser5.setText("Promedio Descuento:");
        pnlInformacion.add(lblUser5);
        lblUser5.setBounds(10, 200, 130, 16);

        lblSobrante.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblSobrante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSobrante.setText("$0.00");
        pnlInformacion.add(lblSobrante);
        lblSobrante.setBounds(0, 170, 200, 24);

        lblTP4.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblTP4.setText("Sobrante");
        pnlInformacion.add(lblTP4);
        lblTP4.setBounds(10, 160, 60, 16);

        lblTP5.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        lblTP5.setText("SubTotal");
        pnlInformacion.add(lblTP5);
        lblTP5.setBounds(10, 60, 60, 16);

        lblEfectivo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblEfectivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEfectivo.setText("$0.00");
        pnlInformacion.add(lblEfectivo);
        lblEfectivo.setBounds(0, 130, 200, 24);

        lblSubTotal.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblSubTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubTotal.setText("$0.00");
        pnlInformacion.add(lblSubTotal);
        lblSubTotal.setBounds(0, 80, 200, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         if (showConfirmDialog(rootPane, "¿Desea salir del sistema?",
                "Salir del sistema", YES_NO_OPTION) == YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Sub_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sub_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sub_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sub_Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sub_Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JToolBar jToolBar3;
    public javax.swing.JLabel lblDescuento;
    public javax.swing.JLabel lblEfectivo;
    public javax.swing.JLabel lblFechaV;
    public javax.swing.JLabel lblIva;
    public javax.swing.JLabel lblSobrante;
    public javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTP2;
    private javax.swing.JLabel lblTP3;
    private javax.swing.JLabel lblTP4;
    private javax.swing.JLabel lblTP5;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUser4;
    private javax.swing.JLabel lblUser5;
    private javax.swing.JLabel lblUser6;
    private javax.swing.JPanel pnlBotonInformacion;
    private javax.swing.JPanel pnlInformacion;
    // End of variables declaration//GEN-END:variables
}
