
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mahou
 */
public class frmMantenedorS extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public frmMantenedorS() {
        initComponents();
        setSesion();
        lblTitulo.setText("Sesiones");
        
        cmbIdTour.setVisible(false);
        cmbIdGuia.setVisible(false);
        cmbTour.setSelectedIndex(-1);
        cmbGuia.setSelectedIndex(-1);
    }
   
    public void setSesion(){
        String[] columnas = {"nombre","fecha","precio","disponibilad"};
        DefaultTableModel model =  new DefaultTableModel(null,columnas);
        Query q = new Query();
        try{
            ResultSet lista= q.select("*","sesion"," INNER JOIN tour ON sesion.idTour= tour.idTour WHERE sesion.deleted_at is NULL");
            while(lista.next()){
                model.addRow(new Object[]{lista.getString("nombre"),lista.getString("fecha"),lista.getString("precio"),lista.getString("disponibilidad")});
            }
            try{
                lista= q.select("*", "guia", " WHERE deleted_at is null");
                 while(lista.next()){
                    cmbGuia.addItem(lista.getString("nombre"));
                  cmbIdGuia.addItem(lista.getString("idGuia"));
                }
                lista=q.select("idTour,nombre","tour", " WHERE deleted_at is null");
                while(lista.next()){
                    cmbTour.addItem(lista.getString("nombre"));
                    cmbIdTour.addItem(lista.getString("idTour"));
                }
            }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Error "+e,"",2);
            }
            q.cerrar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e,"",2);
        }
        tbl.setModel(model);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblDetalle = new javax.swing.JLabel();
        lblTour = new javax.swing.JLabel();
        cmbTour = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbGuia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblDisponibilidad = new javax.swing.JLabel();
        txtDisponibilidad = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        cmbIdTour = new javax.swing.JComboBox<>();
        cmbIdGuia = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Mantenedor");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl);

        jPanel2.setLayout(null);

        lblDetalle.setText("Detalle Sesion");
        jPanel2.add(lblDetalle);
        lblDetalle.setBounds(196, 11, 97, 14);

        lblTour.setText("Tour:");
        jPanel2.add(lblTour);
        lblTour.setBounds(20, 40, 40, 20);

        cmbTour.setToolTipText("Selecione un Tour");
        cmbTour.setEnabled(false);
        cmbTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTourActionPerformed(evt);
            }
        });
        jPanel2.add(cmbTour);
        cmbTour.setBounds(90, 40, 170, 30);

        jLabel2.setText("Guia:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 140, 40, 20);

        cmbGuia.setEnabled(false);
        cmbGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGuiaActionPerformed(evt);
            }
        });
        jPanel2.add(cmbGuia);
        cmbGuia.setBounds(90, 140, 170, 30);

        jLabel3.setText("Fecha:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 90, 50, 20);

        lblDisponibilidad.setText("Disponibilidad:");
        jPanel2.add(lblDisponibilidad);
        lblDisponibilidad.setBounds(280, 40, 90, 30);

        txtDisponibilidad.setEnabled(false);
        txtDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponibilidadActionPerformed(evt);
            }
        });
        jPanel2.add(txtDisponibilidad);
        txtDisponibilidad.setBounds(380, 40, 40, 30);

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar);
        btnAceptar.setBounds(280, 210, 80, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);
        btnCancelar.setBounds(380, 210, 90, 23);

        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel2.add(txtFecha);
        txtFecha.setBounds(90, 90, 130, 30);

        cmbIdTour.setEnabled(false);
        cmbIdTour.setFocusable(false);
        cmbIdTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdTourActionPerformed(evt);
            }
        });
        jPanel2.add(cmbIdTour);
        cmbIdTour.setBounds(270, 40, 30, 30);

        cmbIdGuia.setEnabled(false);
        jPanel2.add(cmbIdGuia);
        cmbIdGuia.setBounds(270, 140, 30, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu menu = new frmMenu();
        this.dispose();
        menu.pack();
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        controlDetalle(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtDisponibilidad.setText("");
        txtFecha.setText("");
        cmbTour.setSelectedIndex(-1);
        cmbGuia.setSelectedIndex(-1);
        lblDetalle.setText("Agregar Sesion");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGuiaActionPerformed

    private void txtDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponibilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponibilidadActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        Query q = new Query();
        String tour,fecha,disponibilidad,guia;
        tour = cmbIdTour.getItemAt(cmbTour.getSelectedIndex());
        guia = cmbIdGuia.getItemAt(cmbGuia.getSelectedIndex());
        fecha = txtFecha.getText();
        disponibilidad = txtDisponibilidad.getText();
        if(lblDetalle.getText().equals("Agregar Sesion")){
           try{     
                q.insert("sesion(`idTour`, `fecha`, `disponibilidad`, `idGuia`)",tour+",'"+fecha+"',"+disponibilidad+","+guia);
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"No se pudo actualizar"+e,"",2);
           }    
        }else{
            if(lblDetalle.getText().equals("Modificar sesion")){
                int index = tbl.getSelectedRow();
                String consultFecha = tbl.getValueAt(index,1).toString();    
                try{
                    String valores = "idTour='"+tour+"',fecha='"+fecha+"',disponibilidad='"+disponibilidad+"',idGuia='"+guia+"'";
                    q.update("sesion",valores," WHERE idTour = "+ tour+" AND fecha ='"+consultFecha+"'");
                }
                catch(Exception e){
                    
                }
            }
        }
        q.cerrar();
        frmMantenedorS sesion = new frmMantenedorS();
        this.dispose();
        sesion.pack();
        sesion.setVisible(true);
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbIdTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIdTourActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int index,idTour=0;
        index= tbl.getSelectedRow();
        String tour="",fecha="" ,guia="",disponibilidad="";
        tour = tbl.getValueAt(index,0).toString();
        fecha = tbl.getValueAt(index, 1).toString();
        disponibilidad =tbl.getValueAt(index, 3).toString();
        Query q = new Query();
        ResultSet lista;
        for(int i = 0 ; i< cmbTour.getItemCount();i++){
            if(cmbTour.getItemAt(i).equals(tour)){
                idTour = Integer.parseInt(cmbIdTour.getItemAt(i));
            }
        }
        try{
            lista = q.select("*", "sesion", " INNER JOIN guia ON sesion.idGuia=guia.idGuia WHERE fecha='"+fecha+"' AND idTour="+idTour);
            if(lista.next()){
                guia = lista.getString("nombre");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "", 2);
        }   
        for(int i = 0 ; i< cmbTour.getItemCount();i++){
            if(cmbTour.getItemAt(i).equals(tour)){
                cmbTour.setSelectedIndex(i);
            }
        }
        for(int i = 0 ; i< cmbGuia.getItemCount();i++){
            if(cmbGuia.getItemAt(i).equals(guia)){
                cmbGuia.setSelectedIndex(i);
            }
        }
        txtFecha.setText(fecha);
        txtDisponibilidad.setText(disponibilidad);
      
    }//GEN-LAST:event_tblMouseClicked
    
    public void controlDetalle(boolean a){
        btnAceptar.setEnabled(a);
        btnCancelar.setEnabled(a);
        cmbGuia.setEnabled(a);
        cmbTour.setEnabled(a);
        txtFecha.setEnabled(a);
        txtDisponibilidad.setEnabled(a);
    }
    public void reset(){
       frmMantenedorS mantenedor = new frmMantenedorS();
       this.dispose();
       mantenedor.pack();
       mantenedor.setVisible(true);
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tbl.getSelectedRow()!=-1){
            controlDetalle(true);
            lblDetalle.setText("Modificar sesion");
            btnAgregar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       reset();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void cmbTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTourActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tbl.getSelectedRow() != -1){   
            int index= tbl.getSelectedRow();
            String nombre = tbl.getValueAt(index,0).toString();
            String id = cmbIdTour.getItemAt(cmbTour.getSelectedIndex());
            String fecha = txtFecha.getText();
            int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar "+nombre+" con fecha "+fecha+"?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opc == 0){
                Query query = new Query();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String time = (timestamp).toString();
                time = time.substring(0,19);
                String valor = "deleted_at = '"+time+"'";
                    
                String cond = " WHERE idTour = '"+ id+"' AND fecha = '"+fecha+"' ";
                query.update("sesion", valor, cond);
                reset();
            }
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(frmMantenedorS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenedorS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbGuia;
    private javax.swing.JComboBox<String> cmbIdGuia;
    private javax.swing.JComboBox<String> cmbIdTour;
    private javax.swing.JComboBox<String> cmbTour;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTour;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtDisponibilidad;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
