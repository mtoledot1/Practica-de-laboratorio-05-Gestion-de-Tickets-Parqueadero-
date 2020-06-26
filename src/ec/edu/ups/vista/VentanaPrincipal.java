package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorCliente;
import ec.edu.ups.controlador.ControladorTicket;
import ec.edu.ups.controlador.ControladorVehiculo;
import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.dao.TicketDAO;
import ec.edu.ups.dao.VehiculoDAO;
import ec.edu.ups.idao.IClienteDAO;
import ec.edu.ups.idao.ITicketDAO;
import ec.edu.ups.idao.IVehiculoDAO;
import javax.swing.JDesktopPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private IClienteDAO clienteDAO;
    private ITicketDAO ticketDAO;
    private IVehiculoDAO vehiculoDAO;
    
    private ControladorCliente controladorCliente;
    private ControladorTicket controladorTicket;
    private ControladorVehiculo controladorVehiculo;
    
    private VentanaRegistrarTickets registrarTickets;
    private VentanaRegistroCliente registroCliente;
    private VentanaRegistroIngreso registroIngreso;
    private VentanaRegistroSalida registroSalida;
    private VentanaRegistroVehiculo registroVehiculo;
    private VentanaListarTickets listarTickets;
    
    public VentanaPrincipal() {
	initComponents();
	
	clienteDAO = new ClienteDAO();
	ticketDAO = new TicketDAO();
	vehiculoDAO = new VehiculoDAO();
	
	controladorCliente = new ControladorCliente(clienteDAO);
	controladorVehiculo = new ControladorVehiculo(vehiculoDAO, controladorCliente);
	controladorTicket = new ControladorTicket(ticketDAO, controladorVehiculo);
	
	String cedula = "0123456789";
	String nombre = "sebastian toledo";
	String direccion = "Av. Loja";
	String telefono = "(+593)-0-986-5212";
	controladorCliente.registrar(cedula, nombre, direccion, telefono);
	String placa = "AFI-8096";
	String marca = "Chevrolet";
	String modelo = "Spark";
	controladorVehiculo.registrar(placa, marca, modelo, cedula);
	cedula = "0105698123";
	nombre = "pedro perez";
	direccion = "Av. Don Bosco";
	telefono = "(+593)-0-983-6985";
	controladorCliente.registrar(cedula, nombre, direccion, telefono);
	placa = "ABA-8199";
	marca = "Toyota";
	modelo = "Corolla";
	controladorVehiculo.registrar(placa, marca, modelo, cedula);
	
	registrarTickets = new VentanaRegistrarTickets(controladorTicket);
	registroCliente = new VentanaRegistroCliente(controladorCliente);
	registroIngreso = new VentanaRegistroIngreso(controladorTicket, controladorVehiculo);
	registroSalida = new VentanaRegistroSalida(controladorTicket);
	registroVehiculo = new VentanaRegistroVehiculo(controladorCliente, controladorVehiculo);
	listarTickets = new VentanaListarTickets(controladorTicket);
	
	registrarTickets.setVentanaPrincipal(this);
	registroCliente.setVentanaPrincipal(this);
	registroIngreso.setVentanaPrincipal(this);
	registroSalida.setVentanaPrincipal(this);
	registroVehiculo.setVentanaPrincipal(this);
	
	desktopPane.add(registroCliente);
	desktopPane.add(registrarTickets);
	desktopPane.add(registroIngreso);
	desktopPane.add(registroSalida);
	desktopPane.add(registroVehiculo);
	desktopPane.add(listarTickets);
	
	setTitle("Parqueadero");
	setSize(700, 600);
    }

    public VentanaRegistrarTickets getRegistrarTickets() {
	return registrarTickets;
    }

    public void setRegistrarTickets(VentanaRegistrarTickets registrarTickets) {
	this.registrarTickets = registrarTickets;
    }

    public VentanaRegistroIngreso getRegistroIngreso() {
	return registroIngreso;
    }

    public void setRegistroIngreso(VentanaRegistroIngreso registroIngreso) {
	this.registroIngreso = registroIngreso;
    }

    public VentanaRegistroSalida getRegistroSalida() {
	return registroSalida;
    }

    public void setRegistroSalida(VentanaRegistroSalida registroSalida) {
	this.registroSalida = registroSalida;
    }

    public VentanaRegistroVehiculo getRegistroVehiculo() {
	return registroVehiculo;
    }

    public void setRegistroVehiculo(VentanaRegistroVehiculo registroVehiculo) {
	this.registroVehiculo = registroVehiculo;
    }

    public VentanaRegistroCliente getRegistroCliente() {
	return registroCliente;
    }

    public void setRegistroCliente(VentanaRegistroCliente registroCliente) {
	this.registroCliente = registroCliente;
    }

    public JDesktopPane getDesktopPane() {
	return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
	this.desktopPane = desktopPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Inicio");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Registrar Ticket");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Listar Tickets");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Idioma");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Inglés");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Español");
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
	System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
	desktopPane.remove(registrarTickets);
	desktopPane.add(registrarTickets);
	registrarTickets.setVisible(true);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        desktopPane.remove(listarTickets);
	desktopPane.add(listarTickets);
	listarTickets.actualizar();
	listarTickets.setVisible(true);
    }//GEN-LAST:event_saveMenuItemActionPerformed

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
	    java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new VentanaPrincipal().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
