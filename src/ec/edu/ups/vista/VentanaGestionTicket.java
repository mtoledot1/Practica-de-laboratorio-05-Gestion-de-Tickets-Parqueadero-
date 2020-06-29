/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.modelo.Ticket;
import ec.edu.ups.modelo.Vehiculo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tano
 */
public class VentanaGestionTicket extends javax.swing.JInternalFrame {
    
    private ControladorTicket controladorTicket;
    private ControladorVehiculo controladorVehiculo;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaGestionVehiculo gestionVehiculo;
    private DefaultTableModel tabla;
    private int codigo;
    private ResourceBundle mensajes;
    
    public VentanaGestionTicket(ControladorTicket controladorTicket, ControladorVehiculo controladorVehiculo) {
	initComponents();
	this.controladorTicket = controladorTicket;
	this.controladorVehiculo = controladorVehiculo;
	controladorVehiculo.verVehiculos((DefaultTableModel) tablaVehiculos.getModel());
    }
    
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal){
	this.ventanaPrincipal = ventanaPrincipal;
	gestionVehiculo = ventanaPrincipal.getGestionVehiculo();
    }

    public void setTabla(DefaultTableModel tabla) {
	this.tabla = tabla;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVehiculos = new javax.swing.JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e){
                return false;
            }
        };
        lblCodigo = new javax.swing.JLabel();
        lblFechaEnt = new javax.swing.JLabel();
        lblFechaSal = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtFechaEnt = new javax.swing.JTextField();
        txtFechaSal = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtPlaca = new javax.swing.JFormattedTextField();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tablaVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVehiculos);

        lblCodigo.setText("Codigo");

        lblFechaEnt.setText("Fecha Entrada");

        lblFechaSal.setText("Fecha Salida");

        lblCedula.setText("Cédula");

        lblNombre.setText("Nombre");

        lblDireccion.setText("Dirección");

        lblTelefono.setText("Teléfono");

        lblPlaca.setText("Placa");

        lblMarca.setText("Marca");

        lblModelo.setText("Modelo");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);

        txtFechaEnt.setEditable(false);

        txtFechaSal.setEditable(false);

        txtCedula.setEditable(false);

        txtNombre.setEditable(false);

        txtDireccion.setEditable(false);

        txtMarca.setEditable(false);

        txtModelo.setEditable(false);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+593)-#-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblFechaEnt)
                            .addComponent(lblFechaSal)
                            .addComponent(lblCedula)
                            .addComponent(lblNombre)
                            .addComponent(lblDireccion)
                            .addComponent(lblTelefono)
                            .addComponent(lblPlaca)
                            .addComponent(lblMarca)
                            .addComponent(lblModelo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(txtFechaEnt)
                            .addComponent(txtFechaSal)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtDireccion)
                            .addComponent(txtMarca)
                            .addComponent(txtModelo)
                            .addComponent(txtPlaca)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(130, 130, 130))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addGap(61, 61, 61)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaEnt)
                    .addComponent(txtFechaEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaSal)
                    .addComponent(txtFechaSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnBorrar))
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
	Ticket t = controladorTicket.verTicket(codigo);
	String placa = txtPlaca.getText();
	controladorTicket.actualizar(codigo, t.getFechaIngreso(), t.getFechaSalida(), placa);
	String titulo = mensajes.getString("mensajeDatosActualizados");
	String mensaje = "Ticket" + mensajes.getString("mensajeActualizado");
	JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	controladorTicket.verTickets(tabla);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
	dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
	controladorTicket.verTickets(tabla);
    }//GEN-LAST:event_formInternalFrameClosed

    private void tablaVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVehiculosMouseClicked
        String placa = (String)tablaVehiculos.getValueAt(tablaVehiculos.getSelectedRow(), 0);
	if(evt.getClickCount() == 1 && !evt.isConsumed()){
	    evt.consume();
	    Vehiculo vehiculo = controladorVehiculo.verVehiculo(placa);
	    txtPlaca.setText(vehiculo.getPlaca());
	    txtMarca.setText(vehiculo.getMarca());
	    txtModelo.setText(vehiculo.getModelo());
	    txtCedula.setText(vehiculo.getPropietario().getCedula());
	    txtNombre.setText(vehiculo.getPropietario().getNombre());
	    txtDireccion.setText(vehiculo.getPropietario().getDireccion());
	    txtTelefono.setValue(vehiculo.getPropietario().getTelefono());
	}else if(evt.getClickCount() == 2 && !evt.isConsumed()){
	    evt.consume();
	    ventanaPrincipal.getDesktopPane().remove(gestionVehiculo);
	    ventanaPrincipal.getDesktopPane().add(gestionVehiculo);
	    gestionVehiculo.setTabla((DefaultTableModel) tablaVehiculos.getModel());
	    gestionVehiculo.datos(placa);
	    gestionVehiculo.setVisible(true);
	}
    }//GEN-LAST:event_tablaVehiculosMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
	controladorTicket.eliminar(codigo);
	String titulo = mensajes.getString("mensajeDatosEliminados");
	String mensaje = "Ticket" + mensajes.getString("mensajeEliminado");
	JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	controladorTicket.verTickets(tabla);
	dispose();
    }//GEN-LAST:event_btnBorrarActionPerformed
    
    public void datos(int num){
	codigo = num;
	Ticket t = controladorTicket.verTicket(num);
	txtCodigo.setText(num+"");
	txtFechaEnt.setText(t.getFechaIngreso().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	if(t.getFechaSalida() == null)
	    txtFechaSal.setText("");
	else
	    txtFechaSal.setText(t.getFechaSalida().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	txtPlaca.setText(t.getVehiculo().getPlaca());
	txtMarca.setText(t.getVehiculo().getMarca());
	txtModelo.setText(t.getVehiculo().getModelo());
	txtCedula.setText(t.getVehiculo().getPropietario().getCedula());
	txtNombre.setText(t.getVehiculo().getPropietario().getNombre());
	txtDireccion.setText(t.getVehiculo().getPropietario().getDireccion());
	txtTelefono.setValue(t.getVehiculo().getPropietario().getTelefono());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaEnt;
    private javax.swing.JLabel lblFechaSal;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tablaVehiculos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaEnt;
    private javax.swing.JTextField txtFechaSal;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPlaca;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    void cambiarIdioma(Locale localizacion, ResourceBundle mensajes) {
	this.mensajes = mensajes;
	lblCedula.setText(mensajes.getString("lblCedula"));
	lblCodigo.setText(mensajes.getString("lblCodigo"));
	lblDireccion.setText(mensajes.getString("lblDireccion"));
	lblFechaEnt.setText(mensajes.getString("lblIngreso"));
	lblFechaSal.setText(mensajes.getString("lblSalida"));
	lblMarca.setText(mensajes.getString("lblMarca"));
	lblModelo.setText(mensajes.getString("lblModelo"));
	lblNombre.setText(mensajes.getString("lblNombre"));
	lblPlaca.setText(mensajes.getString("lblPlaca"));
	lblTelefono.setText(mensajes.getString("lblTelefono"));
	tablaVehiculos.getColumnModel().getColumn(0).setHeaderValue(mensajes.getString("vehiculosPlaca"));
	tablaVehiculos.getColumnModel().getColumn(1).setHeaderValue(mensajes.getString("vehiculosMarca"));
	tablaVehiculos.getColumnModel().getColumn(2).setHeaderValue(mensajes.getString("vehiculosModelo"));
	btnCancelar.setText(mensajes.getString("btnCancelar"));
	btnActualizar.setText(mensajes.getString("btnActualizar"));
	btnBorrar.setText(mensajes.getString("btnBorrar"));
	setTitle(mensajes.getString("tituloTicket"));
    }
}