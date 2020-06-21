/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadores;


import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Interfaces.Interfaz_Documentacion;
import Interfaces.Interfaz_Principal;
import Modulos.ConexionBD;
import MailyOtros.MailException;
import Modulos.Modulo_Documentos;
import Modulos.Modulo_Principal;
import Modulos.Modulo_Ticket;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LUIS INC
 */
public class Manejador_Documentacion{
    //-----------Declaracion de Variables--------------//
    private Interfaz_Documentacion ID;
    private Interfaz_Principal IP;
    private Modulo_Documentos MD;
    private Modulo_Ticket MT;
    private ConexionBD CBD;
    private DefaultTableModel DTM;
    private ListSelectionModel SM;
    //-----------Declaracion de Variables--------------//
    //--------Iniciar Interfaz Documentos-----------//
    public Manejador_Documentacion(Interfaz_Documentacion ID1, Modulo_Documentos MD1) {
        //----------INICIALIZACION Variables----------------//
        this.ID = ID1;
        this.MD = MD1;
        DTM = (DefaultTableModel) ID.tblDocumento.getModel();
        SM = ID.tblDocumento.getSelectionModel();
        CBD = new ConexionBD();
        rellenaTabla();
        //----------INICIALIZACION Variables----------------//
        //----------Action Listener Performed---------------//
        this.ID.btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                BuscarTicket();
            }
        });
        this.ID.btnImpTicket.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImpTicket();
            }
        });
        this.ID.btnInfoAdicional.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImpTicket();
            }
        });
        this.ID.btnPDF.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                HacerPDF();
            }
        });
        this.ID.btnEnviarM.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EnviarMail();
            }
        });
        this.ID.btnRegresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ID.setVisible(false);
                ID.setEnabled(false);
            }
        });
        //----------Action Listener Performed---------------//
    }
    //-------------Fin de constructor-----------//
    //-------------------------Funciones void---------------//
    public void rellenaTabla(){
        CBD.openConexion();
        String S[] = CBD.getTicket(); //Llamada a get Ticket
        String S2[] = new String[8];
        try{
            //------Rellena la tabla Documentacion----------//
            for (int i = 0;i < S.length;i++){
                S2 = S[i].split(",");
                DTM.addRow(S2);
            }
            //------Rellena la tabla Documentacion----------//
        }
        catch(Exception e){}
        CBD.closeConexion();
    }// Fin RellenaTabla
    
    public void ImpTicket(){
        CBD.openConexion();
        //--------Inicializacion variables----------//
        MT = new Modulo_Ticket();
        int ROW = ID.tblDocumento.getSelectedRow();
        int TICKET = Integer.parseInt(DTM.getValueAt(ROW, 0) + "");
        String S[] = CBD.getTicketID(TICKET);
        //--------Inicializacion variables----------//
        //-----------Rellena Ticket------------//
        for(int i=0;i < S.length; i++){
            MT.AddItem(S[4] + "", S[3] + "", S[6] + "");
        }
        MT.AddTotal("", MT.DibujarLinea(29));
        MT.AddTotal("", MT.DarEspacio());
        MT.AddTotal("SUBTOTAL", ID.lblSubTotal.getText());
        MT.AddTotal("IVA", ID.lblIva.getText());
        MT.AddTotal("TOTAL", ID.lblTotal.getText());
        MT.AddTotal("FECHA", ID.lblFechaV.getText());
        MT.AddTotal("", MT.DarEspacio());
        //-----------Rellena Ticket------------//
        //-----------Imprime Ticket------------//
        MT.ImprimirTicket();
        CBD.closeConexion();
    }// Fin impTicket
    
    private void HacerPDF() {
        String nombredearchivo2,archivo2;
        FileDialog fd = new FileDialog(IP, "Guardar", FileDialog.SAVE);
        fd.setVisible(true);
        nombredearchivo2 = fd.getDirectory() + fd.getFile() + ".pdf";
        if(nombredearchivo2!=""){
            archivo2 = fd.getFile() + ".pdf";
            File file = new File(nombredearchivo2);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    //Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < ID.tblDocumento.getRowCount(); i++) {
                    for (int j = 0; j < ID.tblDocumento.getColumnCount(); j++) {
                        bw.write(ID.tblDocumento.getValueAt(i, j).toString() + "/");
                    }
                    bw.newLine();
                }
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(ID, "El archivo ha sido guardado correctamente con el nombre de " + archivo2);
                DTM.setColumnCount(4);
                DefaultTableModel model = (DefaultTableModel) ID.tblDocumento.getModel();
                model.setRowCount(0);
            } catch (IOException ex) {
                //Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            return;
        }
    }// Fin Hacer PDF
    //-------------------------Funciones void---------------//
    //-------------------------Funciones Return---------------//
    public int BuscarTicket(){
        CBD.openConexion();
        //-------Inicializa variables---------//
        String G[] = new String[DTM.getRowCount()];
        String B = ID.txtBuscar.getText();
        //-------Inicializa variables---------//
        //-------Busca ticket a ticket en la tabla---------//
        for (int i = 0;i < DTM.getRowCount();i++){
            if(B.equals(DTM.getValueAt(i,0) + "")){
                SM.setSelectionInterval(i, i + 1);
                CBD.closeConexion();
                return 0;
            }
        }
        //-------Busca ticket a ticket en la tabla---------//
        JOptionPane.showMessageDialog(ID, "Ticket no encontrado","Busca Ticket",JOptionPane.INFORMATION_MESSAGE);
        CBD.closeConexion();
        return 1;
    }// Fin BuscarTicket
    
    public boolean EnviarMail(){
        try{
            if(DTM.getRowCount()==0){
                throw new MailException("No existen registros");
            }else{
                
                String To = JOptionPane.showInputDialog("Coloca tu correo");
              // String To="briangr99@gmail.com"; 
               String me = "";
                   /*for(int i=0;i < ID.tblDocumento.getRowCount();i++){
                       for(int j=0;j < ID.tblDocumento.getColumnCount();j++){
                       me = me + ID.tblDocumento.getValueAt(i, j).toString()+" ";    
                   }
                       me=me+"\n";
                   }
                   */me="Buenas tarde Maestra";

                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");

                    Session session;
                    session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                @Override
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication("ultramarinosayala2020@gmail.com", "losayalaultra");
                                }
                            });

                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("ultramarinosayala2020@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(To));
                        message.setSubject("Lista de archivos");

                        message.setText(me);

                        Transport.send(message);
                        JOptionPane.showMessageDialog(ID, "Los registros han sido enviados a "+To);

                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
        catch(MailException e){
            System.out.println(e.getMessage());
        }
        return true;
    }// Fin EnviarMail
    //-------------------------Funciones Return---------------//
}
