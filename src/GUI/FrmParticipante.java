
package GUI;

import Classes.Oferta;
import Classes.Cuenta;
import Classes.Usuario;
import DAO.AdministradorDAO;
import DAO.OfertaDAO;
import DAO.CuentaDAO;
import DAO.SesionDAO;
import DAO.UsuarioDAO;
import Factory.DAOFactory;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class FrmParticipante extends javax.swing.JFrame {
    
    public static String id = "";
    
    public FrmParticipante() {
        initComponents();
        setLocationRelativeTo(null);
        loadInitialData();
    }
    
    public void loadInitialData(){
        List<String> nombre = seleccionarNombre(Integer.parseInt(id));
        lblAutenticado.setText("Usted se ha autenticado como " + nombre.get(0) + 
                " " + nombre.get(1) + " " + nombre.get(2) + ".");
    }
    
    public List<String> seleccionarNombre(int pId){
        List <String> nombre = new ArrayList<>();
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
        UsuarioDAO usuarioDAO = sqlserverFactory.getUsuarioDAO();
        nombre = usuarioDAO.obtenerNombre(pId);        
        return nombre;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensaje = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblAutenticado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pizarra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tbxMonto = new javax.swing.JTextField();
        tbxTipoCambio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbTipoOferta = new javax.swing.JComboBox();
        btnCrearOferta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblMensaje.setText("Bievenido Participante");

        lblAutenticado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAutenticado.setText("Usted se ha autenticado como: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("(Salir)");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        pizarra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(pizarra);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(81, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Listar Pizarra", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Útimas Negociaciones", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Buscar Ofertas", jPanel4);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Monto:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tipo Cambio:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de Oferta:");

        cmbTipoOferta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "compra", "venta" }));
        cmbTipoOferta.setSelectedIndex(-1);

        btnCrearOferta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCrearOferta.setText("Confirmar");
        btnCrearOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearOfertaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tbxMonto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxTipoCambio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoOferta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrearOferta)
                .addGap(164, 164, 164))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(tbxTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(cmbTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnCrearOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Crear Oferta", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMensaje)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblAutenticado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutenticado)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        dispose();
        new FrmMainWindow().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnCrearOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearOfertaActionPerformed

        if(tbxMonto.getText().trim().length() != 0 && tbxTipoCambio.getText().trim().length() != 0
           && cmbTipoOferta.getSelectedItem() != null)
        {
            try 
            {
                DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
                OfertaDAO ofertaDAO = sqlserverFactory.getOfertaDAO();

                // Obtener valores
                boolean isCompra = false;          
                if (cmbTipoOferta.getSelectedIndex() == 0)
                    isCompra = true;         

                BigDecimal monto = BigDecimal.valueOf(Float.parseFloat(tbxMonto.getText()));
                BigDecimal tipoCambio = BigDecimal.valueOf(Float.parseFloat(tbxTipoCambio.getText()));
                
                // Sesion actual
                SesionDAO sesionDAO = sqlserverFactory.getSesionDAO();
                List<Integer> resultSesion = sesionDAO.obtenerSesionActual();// id , comision
                
                // Verificar que la cuenta tiene suficientes fondos
                CuentaDAO cuentaDAO = sqlserverFactory.getCuentaDAO();
                Cuenta cuenta;
                boolean aprobada = false;
                BigDecimal aCongelar = monto;
                
                BigDecimal comision = BigDecimal.valueOf((double)resultSesion.get(1) / 100);
                comision = comision.multiply(monto);
                
                System.out.println("COMISION: " + comision);
                
                if (isCompra) // monto*tipoCambio+(monto*tipoCambio*comision/100)
                {
                    cuenta = cuentaDAO.obtenerCuenta(Integer.parseInt(id), false);    
                    comision = comision.multiply(tipoCambio);
                    aCongelar = aCongelar.multiply(tipoCambio);
                    aCongelar = aCongelar.add(comision);
                }
                
                else // monto+(monto*comision/100)
                {
                    cuenta = cuentaDAO.obtenerCuenta(Integer.parseInt(id), true);
                   aCongelar = aCongelar.add(comision);
                }
                
                if (cuenta.getSaldo().compareTo(aCongelar) != -1)            
                    aprobada = true;                  
  
                int result = 0;
                if (aprobada)
                {
                    // Congelar Monto
                    int resultCong = cuentaDAO.congelarMonto(cuenta.getId(), aCongelar);
                    
                    // Crear Oferta       
                    Oferta oferta;
                    oferta = new Oferta(isCompra, monto, tipoCambio, true, 
                                        Integer.parseInt(id), resultSesion.get(0));               
                    result = ofertaDAO.crearOferta(oferta);
                }
                
                if(result > 0)
                    JOptionPane.showMessageDialog(null, "Oferta creada correctamente."); 

                else
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear la oferta "
                                        + "o no hay suficientes fondos, favor intente de nuevo."); 
            }
            
            catch(HeadlessException e)
            {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }
            
        }
        
        
    }//GEN-LAST:event_btnCrearOfertaActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
        DAOFactory sqlserverFactory = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
            AdministradorDAO adminDAO = sqlserverFactory.getAdministradorDAO();
            int result = adminDAO.mostrarPizarra("ID", pizarra);
            if(result < 0)
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error."); 
    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
            java.util.logging.Logger.getLogger(FrmParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmParticipante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        id = args[0];
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmParticipante().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearOferta;
    private javax.swing.JComboBox cmbTipoOferta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAutenticado;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable pizarra;
    private javax.swing.JTextField tbxMonto;
    private javax.swing.JTextField tbxTipoCambio;
    // End of variables declaration//GEN-END:variables

}
