
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo
 */
public class frmVenta extends javax.swing.JFrame {

    /**
     * Creates new form frmVenta
     */
    public frmVenta() {
        initComponents();
        setTblSesiones("");
        cmbIdTour.setVisible(false);
        setCmb("tour","tour.nombre",cmbTour);
        setCmb("sesion","fecha",cmbFecha);
        setCmb("tour","ubicacion",cmbUbicacion);
        cmbTour.setSelectedIndex(0);
        cmbUbicacion.setSelectedIndex(0);
        cmbFecha.setSelectedIndex(0);
    }

    public void setCmb(String tabla,String col,JComboBox a){
         Query query = new Query();
         ResultSet lista;
         lista = query.select("DISTINCT "+col,"tour"," INNER JOIN sesion ON sesion.idTour= tour.idTour INNER JOIN guia ON guia.idGuia = sesion.idGuia"
                    + " WHERE sesion.deleted_at is Null  AND tour.deleted_at is NULL AND guia.deleted_at is NULL");
         try{
             a.addItem("Sin seleccion");
             while(lista.next()){
                 a.addItem(lista.getString(col));
             }
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "", 2);
         }
    }
    public void setTblSesiones(String condicion){
        Query query = new Query();
        String[] columnas = {"Tour","fecha","precio","disponibilad","Ubicacion","Guia"};
        DefaultTableModel model =  new DefaultTableModel(null,columnas);
        try{
            ResultSet lista= query.select("*","tour"," INNER JOIN sesion ON sesion.idTour= tour.idTour INNER JOIN guia ON guia.idGuia = sesion.idGuia"
                    + " WHERE sesion.deleted_at is Null  AND tour.deleted_at is NULL AND guia.deleted_at is NULL"+condicion);

            while(lista.next()){
                model.addRow(new Object[]{lista.getString("tour.nombre"),lista.getString("fecha"),lista.getString("precio"),lista.getString("disponibilidad"),lista.getString("ubicacion"),lista.getString("guia.nombre")});
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "", 2);
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lblTitulo3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTitulo4 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        lblTitulo5 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        spnEntradas = new javax.swing.JSpinner();
        lblTitulo7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        txtNombreTour = new javax.swing.JTextField();
        lblNombreTour = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreGuia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelefonoGuia = new javax.swing.JTextField();
        lblTitulo8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        cmbIdTour = new javax.swing.JComboBox<>();
        cmbUbicacion = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        cmbTour = new javax.swing.JComboBox<>();
        cmbFecha = new javax.swing.JComboBox<>();
        btnFiltro = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        lblTitulo2.setText("Datos Cliente");
        jPanel1.add(lblTitulo2);
        lblTitulo2.setBounds(60, 310, 89, 23);
        jPanel1.add(txtNombreCliente);
        txtNombreCliente.setBounds(130, 350, 287, 31);

        lblTitulo3.setText("Telefono :");
        jPanel1.add(lblTitulo3);
        lblTitulo3.setBounds(50, 380, 74, 23);
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(130, 380, 134, 31);

        lblTitulo4.setText("Rut :");
        jPanel1.add(lblTitulo4);
        lblTitulo4.setBounds(50, 420, 74, 23);
        jPanel1.add(txtRut);
        txtRut.setBounds(130, 410, 134, 31);

        lblTitulo5.setText("Datos Sesion");
        jPanel1.add(lblTitulo5);
        lblTitulo5.setBounds(550, 310, 110, 23);

        lblTitulo6.setText("Nombre :");
        jPanel1.add(lblTitulo6);
        lblTitulo6.setBounds(50, 350, 74, 23);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver);
        btnVolver.setBounds(220, 620, 63, 23);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(110, 620, 71, 23);

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(925, 331, 200, 74);

        spnEntradas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                spnEntradasMouseMoved(evt);
            }
        });
        spnEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnEntradasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                spnEntradasMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                spnEntradasMousePressed(evt);
            }
        });
        spnEntradas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                spnEntradasInputMethodTextChanged(evt);
            }
        });
        jPanel1.add(spnEntradas);
        spnEntradas.setBounds(130, 450, 61, 31);

        lblTitulo7.setText("Entradas :");
        jPanel1.add(lblTitulo7);
        lblTitulo7.setBounds(50, 460, 74, 23);

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

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(40, 70, 806, 170);

        txtNombreTour.setEditable(false);
        jPanel1.add(txtNombreTour);
        txtNombreTour.setBounds(570, 390, 290, 30);

        lblNombreTour.setText("Nombre :");
        jPanel1.add(lblNombreTour);
        lblNombreTour.setBounds(480, 390, 60, 20);

        lblNombre1.setText("Precio :");
        jPanel1.add(lblNombre1);
        lblNombre1.setBounds(480, 430, 70, 20);

        txtPrecio.setEditable(false);
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(570, 430, 220, 30);

        txtDuracion.setEditable(false);
        jPanel1.add(txtDuracion);
        txtDuracion.setBounds(570, 510, 130, 30);

        lblNombre2.setText("Duración :");
        jPanel1.add(lblNombre2);
        lblNombre2.setBounds(480, 520, 70, 20);

        lblNombre3.setText("Ubicación :");
        jPanel1.add(lblNombre3);
        lblNombre3.setBounds(480, 470, 70, 20);

        txtUbicacion.setEditable(false);
        jPanel1.add(txtUbicacion);
        txtUbicacion.setBounds(570, 470, 230, 30);

        txtFecha.setEditable(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha);
        txtFecha.setBounds(570, 340, 190, 30);

        jLabel3.setText("Fecha:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(480, 350, 60, 20);

        jLabel1.setText("Nombre :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(480, 590, 70, 20);

        txtNombreGuia.setEditable(false);
        jPanel1.add(txtNombreGuia);
        txtNombreGuia.setBounds(570, 590, 220, 30);

        jLabel2.setText("Telefono :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 630, 80, 30);

        txtTelefonoGuia.setEditable(false);
        txtTelefonoGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoGuiaActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonoGuia);
        txtTelefonoGuia.setBounds(570, 630, 230, 30);

        lblTitulo8.setText("Datos Guia");
        jPanel1.add(lblTitulo8);
        lblTitulo8.setBounds(560, 560, 74, 23);

        lblTotal.setText("Total :");
        jPanel1.add(lblTotal);
        lblTotal.setBounds(50, 510, 50, 20);

        txtTotal.setEditable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotal);
        txtTotal.setBounds(130, 510, 220, 30);

        cmbIdTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIdTourActionPerformed(evt);
            }
        });
        jPanel1.add(cmbIdTour);
        cmbIdTour.setBounds(790, 340, 28, 20);

        jPanel1.add(cmbUbicacion);
        cmbUbicacion.setBounds(110, 260, 140, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 290, 930, 10);

        jPanel1.add(cmbTour);
        cmbTour.setBounds(330, 260, 160, 20);

        jPanel1.add(cmbFecha);
        cmbFecha.setBounds(560, 260, 120, 20);

        btnFiltro.setText("Filtro");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });
        jPanel1.add(btnFiltro);
        btnFiltro.setBounds(790, 260, 57, 23);

        jLabel5.setText("Ubicacion:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 260, 60, 14);

        jLabel6.setText("Tour: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 260, 50, 20);

        jLabel7.setText("Fecha:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(500, 260, 41, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Venta");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(380, 30, 171, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        setTblSesiones(tblCondicion());
        limpiar();
    }//GEN-LAST:event_btnFiltroActionPerformed

    private void cmbIdTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIdTourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIdTourActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTelefonoGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoGuiaActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        if(tbl.getSelectedRow()!=-1){
            String nomTour ="" ,fecha="",idTour="";
            fecha = tbl.getValueAt(tbl.getSelectedRow(), 1).toString();
            nomTour = tbl.getValueAt(tbl.getSelectedRow(), 0).toString();
            int disp = Integer.parseInt(tbl.getValueAt(tbl.getSelectedRow(),3).toString());
            Query q = new Query();
            ResultSet lista;
            try{

                lista = q.select("*","tour"," INNER JOIN sesion ON sesion.idTour= tour.idTour INNER JOIN guia ON guia.idGuia = sesion.idGuia"
                    + " WHERE sesion.deleted_at is Null  AND tour.deleted_at is NULL AND guia.deleted_at is NULL AND tour.nombre='"+nomTour+"' AND sesion.fecha='"+fecha+"'");
                txtNombreTour.setText(nomTour);
                txtFecha.setText(fecha);
                if(lista.next()){
                    txtDuracion.setText(lista.getString("tour.duracion"));
                    txtNombreGuia.setText(lista.getString("guia.nombre"));
                    txtUbicacion.setText(lista.getString("ubicacion"));
                    txtTelefonoGuia.setText(lista.getString("telefono"));
                    txtPrecio.setText(lista.getString("precio"));
                    idTour = lista.getString("tour.idTour");
                    cmbIdTour.removeAllItems();
                    cmbIdTour.addItem(idTour);
                    cmbIdTour.setSelectedIndex(0);
                }
                SpinnerNumberModel model= new SpinnerNumberModel(0,0,disp,1);
                spnEntradas.setModel(model);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e, "", 2);
            }
        }
    }//GEN-LAST:event_tblMouseClicked

    private void spnEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnEntradasMouseEntered

    }//GEN-LAST:event_spnEntradasMouseEntered

    private void spnEntradasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnEntradasMouseMoved

    }//GEN-LAST:event_spnEntradasMouseMoved

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved

    }//GEN-LAST:event_jPanel2MouseMoved

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        boolean completo = true;
        if(txtNombreCliente.getText().equals("") || txtTelefono.getText().equals("") || txtRut.getText().equals("") || spnEntradas.getValue().toString().equals("0")){
            completo = false;
        }
        if(tbl.getSelectedRow()!=-1 && completo){
            String nombre = txtNombreCliente.getText();
            String telefono = txtTelefono.getText();
            String rut = txtRut.getText();
            String idTour = cmbIdTour.getItemAt(cmbIdTour.getSelectedIndex());
            String fechaSesion = txtFecha.getText();
            String cantidad = spnEntradas.getValue().toString();
            Query query = new Query();
            try{
                query.insert("venta", "null ,CURRENT_TIMESTAMP,'"+nombre+"','"+telefono+"','"+rut+"',"+idTour+", '"+fechaSesion+"',"+cantidad+" ");
                byte cant = (byte)((Byte.parseByte(tbl.getValueAt(tbl.getSelectedRow(), 3).toString()))-Byte.parseByte(spnEntradas.getValue().toString()));
                query.update("sesion", "disponibilidad ="+cant, " WHERE idTour="+idTour+" AND fecha= '"+fechaSesion+"'");
                 JOptionPane.showMessageDialog(null,"Venta Exitosa","",1);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e,"",2);
            }
            setTblSesiones(tblCondicion());
            limpiar();
        }else{
             JOptionPane.showMessageDialog(null,"Rellene todos los campos","",2);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        frmMenu menu = new frmMenu();
        this.dispose();
        menu.pack();
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

  

    private void spnEntradasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_spnEntradasInputMethodTextChanged

    }//GEN-LAST:event_spnEntradasInputMethodTextChanged

    private void spnEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnEntradasMouseClicked

    }//GEN-LAST:event_spnEntradasMouseClicked

    private void spnEntradasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnEntradasMousePressed

    }//GEN-LAST:event_spnEntradasMousePressed

    public void limpiar(){
       txtNombreCliente.setText("");
       txtNombreGuia.setText("");
       txtNombreTour.setText("");
       txtFecha.setText("");
       txtRut.setText("");
       txtTelefonoGuia.setText("");
       txtTelefono.setText("");
       txtUbicacion.setText("");
       txtRut.setText("");
       txtPrecio.setText("");
       txtDuracion.setText("");
       spnEntradas.setValue(0);
    }

    public String tblCondicion(){
       String condicion = "";
        if(!(cmbTour.getSelectedItem().toString().equals("Sin seleccion"))){
           condicion += " AND tour.nombre='"+cmbTour.getSelectedItem().toString()+"'";
        }
        if(!(cmbUbicacion.getSelectedItem().toString().equals("Sin seleccion"))){
           condicion += " AND tour.ubicacion='"+cmbUbicacion.getSelectedItem().toString()+"'";
        }
        if(!(cmbFecha.getSelectedItem().toString().equals("Sin seleccion"))){
           condicion += " AND sesion.fecha='"+cmbFecha.getSelectedItem().toString()+"'";
        }
        return condicion;
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
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnFiltro;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbFecha;
    private javax.swing.JComboBox<String> cmbIdTour;
    private javax.swing.JComboBox<String> cmbTour;
    private javax.swing.JComboBox<String> cmbUbicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombreTour;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JSpinner spnEntradas;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreGuia;
    private javax.swing.JTextField txtNombreTour;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoGuia;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
