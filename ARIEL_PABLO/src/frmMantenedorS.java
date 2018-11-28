
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
        cmbGuia.removeAllItems();
        cmbTour.removeAllItems();
        cmbIdTour.removeAllItems();
        cmbIdGuia.removeAllItems();
        try{
            ResultSet lista= q.select("*","tour"," INNER JOIN sesion ON sesion.idTour= tour.idTour INNER JOIN guia ON guia.idGuia = sesion.idGuia"
                    + " WHERE sesion.deleted_at is Null  AND tour.deleted_at is NULL AND guia.deleted_at is NULL");
            while(lista.next()){
                model.addRow(new Object[]{lista.getString("tour.nombre"),lista.getString("fecha"),lista.getString("precio"),lista.getString("disponibilidad")});
            }
            try{
                lista= q.select("*", "guia", " WHERE guia.deleted_at is Null");
                 while(lista.next()){
                  cmbGuia.addItem(lista.getString("nombre"));
                  cmbIdGuia.addItem(lista.getString("idGuia"));
                }
                lista=q.select("idTour,nombre","tour", " WHERE tour.deleted_at is Null");
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
        tbl.setDefaultEditor(Object.class, null);
        cmbGuia.setSelectedIndex(-1);
        cmbIdGuia.setSelectedIndex(-1);
        cmbTour.setSelectedIndex(-1);
        cmbIdTour.setSelectedIndex(-1);
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
        lblTitulo = new javax.swing.JLabel();

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

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        lblDetalle.setText("Detalle Sesion");

        lblTour.setText("Tour:");

        cmbTour.setToolTipText("Selecione un Tour");
        cmbTour.setEnabled(false);
        cmbTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTourActionPerformed(evt);
            }
        });

        jLabel2.setText("Guia:");

        cmbGuia.setEnabled(false);
        cmbGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGuiaActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        lblDisponibilidad.setText("Disponibilidad:");

        txtDisponibilidad.setEnabled(false);
        txtDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisponibilidadActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtFecha.setEnabled(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        cmbIdTour.setEnabled(false);
        cmbIdTour.setFocusable(false);
        cmbIdTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdTourActionPerformed(evt);
            }
        });

        cmbIdGuia.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDetalle)
                .addGap(235, 235, 235))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(lblTour))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTour, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblDisponibilidad)
                        .addGap(19, 19, 19)
                        .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbIdGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbIdTour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblDetalle)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTour)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbIdTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIdGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibilidad)
                    .addComponent(txtDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setText("Sesiones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(39, 39, 39)
                                .addComponent(btnModificar)
                                .addGap(49, 49, 49)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu menu = new frmMenu();
        this.dispose();
        menu.pack();
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnAceptar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cmbGuia.setEnabled(true);
        cmbTour.setEnabled(true);
        txtFecha.setEnabled(true);
        txtDisponibilidad.setEnabled(true);
        limpiar();
        lblDetalle.setText("Agregar Sesion");
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnAgregar.setEnabled(false);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbGuiaActionPerformed

    private void txtDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisponibilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisponibilidadActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       if(cmbTour.getSelectedIndex()==-1 || cmbGuia.getSelectedIndex()==-1 || txtFecha.getText().equals("") || txtDisponibilidad.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Rellene todos los campos","Error",2);
       }else{
           Query q = new Query();
            String antiguoTour ="",nuevoTour,nuevaFecha,antiguaFecha="",disponibilidad,guia;
            nuevoTour = cmbIdTour.getItemAt(cmbTour.getSelectedIndex());
            guia = cmbIdGuia.getItemAt(cmbGuia.getSelectedIndex());
            nuevaFecha = txtFecha.getText();
            disponibilidad = txtDisponibilidad.getText();
            if(tbl.getSelectedRow()!=-1){
                antiguaFecha = tbl.getValueAt(tbl.getSelectedRow(),1).toString();
                for(int i = 0 ; i< cmbTour.getItemCount();i++){
                    if(cmbTour.getItemAt(i).equals(tbl.getValueAt(tbl.getSelectedRow(), 0))){
                        antiguoTour = cmbIdTour.getItemAt(i);
                    }
                }
            }
            if(lblDetalle.getText().equals("Agregar Sesion")){
                try{
                    q.insert("sesion(`idTour`, `fecha`, `disponibilidad`, `idGuia`)",nuevoTour+",'"+nuevaFecha+"',"+disponibilidad+","+guia);
                    JOptionPane.showMessageDialog(null,"Agregacion exitosa","",1);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Agregar "+e,"Error",2);
                }
            }else{
                if(lblDetalle.getText().equals("Modificar Tour")){
                    try{
                        String valores = "idTour="+nuevoTour+",idGuia="+guia+",fecha='"+nuevaFecha+"',disponibilidad="+disponibilidad;
                        q.update("sesion",valores," WHERE idTour="+antiguoTour+" AND fecha='"+antiguaFecha+"'");
                        JOptionPane.showMessageDialog(null,"Actualizacion exitosa","",1);
                    }catch(Exception e){
                      JOptionPane.showMessageDialog(null,"No se pudo actualizar"+e,"",2);
                    }
                }
            }
            q.cerrar();
            limpiar();
            setSesion();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed
    public void limpiar(){
        cmbIdGuia.setSelectedIndex(-1);
        cmbIdTour.setSelectedIndex(-1);
        cmbGuia.setSelectedIndex(-1);
        txtDisponibilidad.setText("");
        txtFecha.setText("");
        cmbTour.setSelectedIndex(-1);
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setSesion();
        limpiar();
        btnAgregar.setEnabled(true);
        lblDetalle.setText("Detalle Sesion");
        txtDesactivar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void cmbTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTourActionPerformed

    private void cmbIdTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIdTourActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        if(tbl.getSelectedRow()!=-1 && !lblDetalle.getText().equals("Agregar Sesion")){
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
                    cmbIdTour.setSelectedIndex(i);
                }
            }
            for(int i = 0 ; i< cmbGuia.getItemCount();i++){
                if(cmbGuia.getItemAt(i).equals(guia)){
                    cmbGuia.setSelectedIndex(i);
                    cmbIdGuia.setSelectedIndex(i);
                }
            }
            txtFecha.setText(fecha);
            txtDisponibilidad.setText(disponibilidad);
            if(lblDetalle.getText().equals("Detalle Sesion")){
                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tblMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int e = tbl.getSelectedRow();

        if(e!=-1){
            String fecha,idTour;
            String ventas= "0";
            fecha=txtFecha.getText();
            idTour=cmbIdTour.getSelectedItem().toString();
            Query query = new  Query();
            ResultSet resul = query.select("COUNT(venta.idVenta)","sesion"," INNER JOIN venta ON venta.idTour=sesion.idTour  AND venta.fechaSesion=sesion.fecha WHERE sesion.idTour="+idTour
            +" AND sesion.fecha='"+fecha+"'");
            try{
                if(resul.next()){
                     ventas = resul.getString(1);
                }
            }catch(SQLException ee){
                JOptionPane.showMessageDialog(null,ee,"",2);
            }

            if(ventas.equals("0")){
                lblDetalle.setText("Modificar Tour");
                btnCancelar.setEnabled(true);
                btnAceptar.setEnabled(true);
                cmbTour.setEnabled(true);
                cmbGuia.setEnabled(true);
                txtFecha.setEnabled(true);
                txtDisponibilidad.setEnabled(true);
                btnAgregar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnModificar.setEnabled(false);
            }else{

                JOptionPane.showMessageDialog(null,"No se puede Modificar Sesiones vendidas ","",2);
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int e = tbl.getSelectedRow();
        if(e!=-1){
            String nom = cmbTour.getSelectedItem().toString();
            String fecha= txtFecha.getText();
            int idTour=Integer.parseInt(cmbIdTour.getItemAt(cmbIdTour.getSelectedIndex()));
            Query query = new Query();
            int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar "+nom+" "+fecha+" ?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opc==0){

                try{
                    query.delete("sesion", " idTour="+idTour+" AND fecha='"+fecha+"'");
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar","",2);
                }
            }
            setSesion();
            limpiar();
            txtDesactivar();
            btnEliminar.setEnabled(false);
            btnModificar.setEnabled(false);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    public void txtDesactivar(){
        txtDisponibilidad.setEnabled(false);
        txtFecha.setEnabled(false);
        cmbTour.setEnabled(false);
        cmbGuia.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnCancelar.setEnabled(false);
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
