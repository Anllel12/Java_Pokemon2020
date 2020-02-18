/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Angel Esquinas
 * 
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1=null;
    BufferedImage buffer2=null;
    
    Image imagen1=null;
    Image imagen2=null;
    
    int contador=0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) imagenPokemon.getGraphics();
        Graphics2D g3=(Graphics2D) fondo.getGraphics();
        
        g3.drawImage(buffer2, 0, 0, fondo.getWidth(), fondo.getHeight(), null);
        g2.drawImage(buffer1, 0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        
        initComponents();
        
       
       
        try {
            imagen1=ImageIO.read(getClass().getResource("/imagenes/black-white.png"));
            } 
        catch (IOException ex) {
           System.out.println("No es capaz de leer la imagen");
        }
        
        try {
            imagen2=ImageIO.read(getClass().getResource("/imagenes/Pokedex.jpg"));
        } 
        catch (IOException ex) {
            System.out.println("No es capaz de leer la imagen");   
        }
        
        buffer1=(BufferedImage) imagenPokemon.createImage(imagenPokemon.getWidth(), imagenPokemon.getHeight());
        buffer2=(BufferedImage) fondo.createImage(fondo.getWidth(), fondo.getHeight());
        
        Graphics2D g2=buffer1.createGraphics();
        
        fondo();
        pintaPokemon(30);      
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.111.133/test", "root", "");
            estado = conexion.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
        
    }
    private void fondo(){
        
        Graphics2D g2=(Graphics2D) buffer2.getGraphics();
      
        g2.drawImage(imagen2, 0, 0, fondo.getWidth(), fondo.getHeight(), null);
        repaint(0,0,1,1);
    }
    
    
    private void pintaPokemon(int pos){
        
        int fila=pos/31;
        int columna=pos%31;
        
        Graphics2D g2=(Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight());//pinta el fondo del jpanel en negro
        g2.drawImage(imagen1, 0, 0, imagenPokemon.getWidth(), imagenPokemon.getHeight(), columna*96, fila*96, columna*96+96, fila*96+96, null);
        
        repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JLayeredPane();
        imagenPokemon = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        nombrePokemon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        anterior.setText("<");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        siguiente.setText(">");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        fondo.setLayer(imagenPokemon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(anterior, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(siguiente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(nombrePokemon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(anterior)
                        .addGap(187, 187, 187)
                        .addComponent(siguiente))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(553, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombrePokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)))
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(anterior)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(siguiente)
                        .addGap(266, 266, 266))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed

        pintaPokemon(contador);

        try {
            resultadoConsulta=estado.executeQuery("select * from pokemon where id=" + (contador+1));
            if (resultadoConsulta.next()) {
                nombrePokemon.setText(resultadoConsulta.getString(2));
            }
            else{
                nombrePokemon.setText("Enhorabuena has conseguido un pokemon nuevo");
            }
        }
        catch (SQLException ex) {
            System.out.println("No responde la Base de Datos");;
        }

        contador++;
        if (contador>=649){
            contador=1;
        }
    }//GEN-LAST:event_siguienteActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        contador--;
        if (contador<=0){
            contador=0;
        }
        pintaPokemon(contador);
    }//GEN-LAST:event_anteriorActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JLayeredPane fondo;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
}
