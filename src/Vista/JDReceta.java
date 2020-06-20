package Vista;

import DAO.DAOException;
import DAO.DAOManager;
import Modelo.Receta;
import javax.swing.JOptionPane;
import DAOMySQL.MySQLDAOManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 * @authors Alanstark & DiegoRoque
 */
public class JDReceta extends javax.swing.JDialog {
    //creamos un objeto del tipo interface IRecetaDAO
        private DAOManager manager = null;
        //private DAOManager manager = null;
   
        //campos para almacenar los datos del formulario
        private int idReceta;
        private String diagnostico;
        private String medicamentos;
        private int idPaciente;
        private int id;
        
    /**
     * Creates new form JDReceta
     */
    public JDReceta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //limpiarFormulario();
        this.manager = new MySQLDAOManager();//propiedad para manejar nuestros DAO
    }
    /**
     * Este método permite limpiar el formulario y ubicar el focus en la caja de texto diagnostico
     */
    private void limpiarFormulario(){
        //asignamos el string -1 a la caja de texto del id.Receta 
        txtIdReceta.setText("-1");
    //limpiamos las otras cajas de texto 
        txtDiagnostico.setText("");
        txtMedicamentos.setText("");
        txtIdPaciente.setText("");
        txtBuscarPorId.setText("");
        //ubicamos el focus en la caja de texto del nombre 
        txtDiagnostico.requestFocusInWindow();
    }//fin del método limpiar formulario
    
    /**
     * Valida los datos de entrada del formulario
     *@return true si todos son validados correctamente, false en caso contrario  
     */
    private boolean validar(){
        boolean validacion = false;
        idReceta = Integer.parseInt(txtIdReceta.getText());
        diagnostico = txtDiagnostico.getText(); 
        medicamentos = txtMedicamentos.getText();
        idPaciente = Integer.parseInt(txtIdPaciente.getText());
        
        if(txtDiagnostico.equals("") ){
            JOptionPane.showMessageDialog(null, "Especifica el diagnostico");
            txtDiagnostico.requestFocusInWindow();
            return (validacion);
        }
        if(txtMedicamentos.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica los medicamentos");
            txtMedicamentos.requestFocusInWindow();
            return (validacion);
        }
        if(txtIdPaciente.equals("")){
            JOptionPane.showMessageDialog(null, "Especifica el id del paciente");
            txtIdPaciente.requestFocusInWindow();
            return (validacion);
        }
        return (true);
    }//fin del método validar

    /**
     * Imprime un mensaje de error personalizado para aquellos errores que son 
     * producidos por el acceso a la base de datos 
     * @param ex objeto de tipo DAOException
     */
    public void imprimirMensajeDeErrorDAO(DAOException ex){
        //si getMessage existe obtenemos su valor 
        String mensajeError;
        try{
            mensajeError = "Mensaje "+ ex.getCause().getMessage();  
        }catch(NullPointerException error){
            mensajeError = "";
        }   
        JOptionPane.showMessageDialog(null, ex.getMessage()+ "\n"+mensajeError,"Error",JOptionPane.ERROR_MESSAGE);
    }//fin del método imprimirMensajeDeErrorDAO
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDiagnostico = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdPaciente = new javax.swing.JTextField();
        txtIdReceta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMedicamentos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarPorId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Llena los campos de la Receta"));

        jLabel5.setText("id. Paciente:");

        txtIdPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPacienteActionPerformed(evt);
            }
        });

        txtIdReceta.setEditable(false);
        txtIdReceta.setText("-1");

        jLabel2.setText("Id. Receta:");

        jLabel6.setText("diagnostico:");

        btnNuevo.setText("Nueva");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setText("medicamentos:");

        txtMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicamentosActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdReceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        jLabel8.setText("Id. Receta:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //llamamos al método limpiarFormulario
        limpiarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //llamamos la método validar para ver si procede guardar la cita
        if(validar()){
            if(idReceta == -1){
                //llamamos al contructor para crear un ojeto de tipo Receta
                Receta miReceta = new Receta(diagnostico, medicamentos, idPaciente);
                try{
                    manager.getRecetaDAO().insertar(miReceta);
                    txtIdReceta.setText(Integer.toString(miReceta.getIdReceta()));
                    JOptionPane.showMessageDialog(null,"Los datos han sido guardados");
                //imprimiendo la receta
                    String path = "src\\Reportes\\Receta.jasper";//agregarle el path donde esta el archivo .jasper
                    Map parametro = new HashMap();
                    id = Integer.parseInt(txtIdPaciente.getText());
                    parametro.put("idPaciente", id);
                    JasperPrint jprint = manager.getPacienteDAO().imprimirReporte(path, parametro);
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
            }else{//si es diferente de -1 quiere decir que se esta realizando una modificación
                //llamamos al contructor para crear un ojeto de tipo Receta
                Receta miReceta = new Receta(idReceta, diagnostico, medicamentos, idPaciente);
                try{
                    manager.getRecetaDAO().insertar(miReceta);
                    txtIdReceta.setText(Integer.toString(miReceta.getIdReceta()));
                    JOptionPane.showMessageDialog(null,"Los datos han sido guardados");
                //imprimiendo la receta
                    String path = "src\\Reportes\\Receta.jasper";//agregarle el path donde esta el archivo .jasper
                    Map parametro = new HashMap();
                    id = Integer.parseInt(txtIdPaciente.getText());
                    parametro.put("idPaciente", id);
                    JasperPrint jprint = manager.getPacienteDAO().imprimirReporte(path, parametro);
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
            }//fin del else
            limpiarFormulario();
        }//fin del if validar
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //sólo se puede eliminar si el id Cita es diferente de -1
        if(!txtIdReceta.getText().equals("-1")){
            int idReceta = Integer.parseInt(txtIdReceta.getText());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar la receta relacionada con el id del Paciente = "+txtIdPaciente.getText()+"?" ,"confirmar",0);
            if(respuesta == 0){
                try{
                    //eliminamos la receta
                    manager.getRecetaDAO().eliminar(idReceta);
                    //si no ocurre una excepción
                    JOptionPane.showMessageDialog(null,"La receta ha sido eliminada");
                }catch(DAOException ex){
                    imprimirMensajeDeErrorDAO(ex);
                }//fin del catch
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(null,"Busca una receta para poder eliminarla");
            }//fin del else
        }//fin del if
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIdPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPacienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            //obtenemos el id de la receta a buscar
            int idBuscar =(Integer) Integer.parseInt(txtBuscarPorId.getText());
            //obtenemos los datos del autor y lo asignamos al objeto miReceta
            Receta miReceta = manager.getRecetaDAO().obtener(idBuscar);
            //mostramos los datos  en la caja de texto
            txtIdReceta.setText(Integer.toString(miReceta.getIdReceta()));
            txtDiagnostico.setText(miReceta.getDiagnostico());
            txtMedicamentos.setText(miReceta.getMedicamentos());
            txtIdPaciente.setText(Integer.toString(miReceta.getIdPaciente()));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Especifica un número entero", "Error", JOptionPane.ERROR_MESSAGE);
            txtBuscarPorId.requestFocusInWindow();
            txtBuscarPorId.selectAll();
        }catch(DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicamentosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    //sólo se puede imprimir si busca una Cita 
        if(!txtIdReceta.getText().equals("-1")){
            int idReceta = Integer.parseInt(txtIdReceta.getText());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas imprimir la receta relacionada con el id del Paciente = "+txtIdPaciente.getText()+"?" ,"confirmar",0);
            if(respuesta == 0){
                try{
                //imprimiendo la receta
                    String path = "src\\Reportes\\Receta.jasper";//agregarle el path donde esta el archivo .jasper
                    Map parametro = new HashMap();
                    id = Integer.parseInt(txtIdPaciente.getText());
                    parametro.put("idPaciente", id);
                    JasperPrint jprint = manager.getPacienteDAO().imprimirReporte(path, parametro);
                    
                    //JasperPrint jprint = manager.getPacienteDAO().imprimirReporte(path);
                    JasperViewer view = new JasperViewer(jprint, false);
                    view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    view.setVisible(true);
                    }catch(DAOException ex){
                        imprimirMensajeDeErrorDAO(ex);
                    }//fin del catch
                    limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(null,"Busca una receta para poder imprimirla");
            }//fin del else
            limpiarFormulario();
        }//fin del if
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JDReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDReceta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDReceta dialog = new JDReceta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBuscarPorId;
    private javax.swing.JTextField txtDiagnostico;
    private javax.swing.JTextField txtIdPaciente;
    private javax.swing.JTextField txtIdReceta;
    private javax.swing.JTextField txtMedicamentos;
    // End of variables declaration//GEN-END:variables
}