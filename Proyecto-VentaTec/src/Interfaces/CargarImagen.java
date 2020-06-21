/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * pepe
 * @author user
 */
public class CargarImagen implements DropTargetListener{
    JLabel imageLabel= new JLabel();
    JLabel pathLabel = new JLabel();
    
    public CargarImagen(JLabel image)
    {
        imageLabel=image;

    }
    
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
    
    }
    
    //
    @Override
    public void dropActionChanged(DropTargetDragEvent ev) {
      
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
       
    }

    @Override
    public void drop(DropTargetDropEvent ev) {
     ev.acceptDrop(DnDConstants.ACTION_COPY); 
     
     
     Transferable t=ev.getTransferable();
     
     DataFlavor[] df=t.getTransferDataFlavors();
     
     for(DataFlavor f:df)
     {
         try{
             if(f.isFlavorJavaFileListType())
             {
                List<File> files= (List<File>) t.getTransferData(f);
             
             
                for(File file: files)
                {
                    displayImage(file.getPath());
                }
             }
         }catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null,ex);
         }   
     }
     
    }
    private void displayImage(String path){
        BufferedImage img =null;
        try{
             img=ImageIO.read(new File (path));
            }catch(Exception e) {                
            }

            Image newimg = img.getScaledInstance(300, 300,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon= new ImageIcon(newimg);
            imageLabel.setIcon(icon);
            pathLabel.setText(path);
        }

    
}
