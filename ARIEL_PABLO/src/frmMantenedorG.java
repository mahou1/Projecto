
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class frmMantenedorG extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public frmMantenedorG() {
        initComponents();
        setGuia();
        desactivarTxt();
    }
    public void desactivarTxt(){
        txtNombre.setEnabled(false);
        txtTelefono.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cmbActivo.setEnabled(false);
       
    }
    public void activarTxt(){
        txtNombre.setEnabled(true);
        txtTelefono.setEnabled(true);
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cmbActivo.setEnabled(true);
    }
  
    public void setGuia(){
        lblTitulo.setText("Guías");
        String[] columnas = {"id","nombre","telefono","Activo"};
        DefaultTableModel model =  new DefaultTableModel(null,columnas);
        Query q = new Query();
        try{
            ResultSet lista= q.select("*","guia","");
            while(lista.next()){
                String activo="";
                if(lista.getString("deleted_at")== null){
                    activo="S";
                }else{
                    activo="N";
                }
                model.addRow(new Object[]{lista.getString("idGuia"),lista.getString("nombre"),lista.getString("telefono"),activo});
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
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblSub = new javax.swing.JLabel();
        cmbActivo = new javax.swing.JComboBox<>();
        lblActivo = new javax.swing.JLabel();

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
        setResizable(false);

        lblTitulo.setText("Mantenedor Guía");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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

        jLabel1.setText("Nombre :");

        jLabel2.setText("Telefono :");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblSub.setText("Detalles");

        cmbActivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "N" }));
        cmbActivo.setSelectedIndex(-1);
        cmbActivo.setEnabled(false);
        cmbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbActivoActionPerformed(evt);
            }
        });

        lblActivo.setText("Activo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSub)
                                        .addGap(57, 57, 57)))
                                .addGap(18, 18, 18)
                                .addComponent(lblActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregar)
                    .addComponent(btnVolver))
                .addGap(15, 15, 15)
                .addComponent(lblSub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblActivo)
                        .addComponent(cmbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        reset();   
        desactivarTxt();
        btnAgregar.setEnabled(true);
        cmbActivo.setSelectedIndex(-1);
        lblSub.setText("Detalles");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nom,telefono,estado="";
        nom = txtNombre.getText();
        telefono = txtTelefono.getText();
        if(nom.equals("") || telefono.equals("")){
            JOptionPane.showMessageDialog(null,"Rellene todos los campos","Error",2);
        }else{
            Query query = new Query();
            if(cmbActivo.getSelectedItem().equals("S")){
                estado = " = NULL";
            }else{
                estado = " = CURRENT_TIMESTAMP";
            }
            if(lblSub.getText().equals("Agregar Guia")){
                try{
                    String valores = "null,'"+nom+"','"+telefono+"',NULL";
                    query.insert("guia",valores);
                    cmbActivo.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null,"Agregacion exitosa","",1); 
                 }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Agregar "+e,"Error",2);
                }
            }else{
                if(lblSub.getText().equals("Modificar Guia")){
                    try{
                        int index =  tbl.getSelectedRow();
                        int indice = Integer.parseInt(tbl.getValueAt(index, 0).toString());
                        String valor = "nombre = '"+ nom+"', telefono = '"+telefono+"', deleted_at"+estado ;
                        String cond = " WHERE idGuia = "+ indice;
                        query.update("guia", valor, cond);
                        cmbActivo.setSelectedIndex(-1);
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa","",1); 
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"No se pudo actualizar "+e,"Error",2);
                }   
            }
                
            }
            query.cerrar();
            reset();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu menu = new frmMenu();
        this.dispose();
        menu.pack();
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        activarTxt();
        txtNombre.setText("");
        txtTelefono.setText("");
        lblSub.setText("Agregar Guia");
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        cmbActivo.setSelectedIndex(0);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
         if(tbl.getSelectedRow()!=-1){
            int index =  tbl.getSelectedRow();
            String id = tbl.getValueAt(index, 0).toString();
            String nombre = tbl.getValueAt(index,1).toString();
            String telefono = tbl.getValueAt(index,2).toString();
            for(int i=0;i<cmbActivo.getItemCount();i++){
                         if(tbl.getValueAt(tbl.getSelectedRow(), 3).equals(cmbActivo.getItemAt(i))){
                             cmbActivo.setSelectedIndex(i);
                         }
                     }
            txtNombre.setText(nombre);
            txtTelefono.setText(telefono);
            if(lblSub.getText().equals("Detalles")){
                btnModificar.setEnabled(true);
                btnEliminar.setEnabled(true);
            }
            
         }
    }//GEN-LAST:event_tblMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(tbl.getSelectedRow()!=-1){
            activarTxt();
            lblSub.setText("Modificar Guia");
            btnAgregar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tbl.getSelectedRow()!=-1){
            String nom = txtNombre.getText();
            int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar "+nom+" ?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opc==0){
                int index =  tbl.getSelectedRow();
                int indice = Integer.parseInt(tbl.getValueAt(index, 0).toString());
                Query query = new Query();
                try{
                    query.delete("guia", "idGuia = "+indice );
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Eliminar","",2);
                }
                reset();
            }
        }
       
                
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void cmbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbActivoActionPerformed
    public void reset(){
        setGuia();
        txtNombre.setText("");
        txtTelefono.setText("");
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
     
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
            java.util.logging.Logger.getLogger(frmMantenedorG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMantenedorG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMantenedorG().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblActivo;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
