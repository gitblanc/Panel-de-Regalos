/**
 * 
 */
package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.List;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JPanel;

import logica.Premio;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.awt.event.ActionEvent;

/**
 * @author UO285176
 *
 */
public class VentanaCarrito extends JDialog {
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vP;
	private List<Premio> premios;
	private Locale localizacion;
	private JScrollPane scrollPane;
	private JPanel panelCarrito;
	private JPanel panelBotonesAceptarYCancelarPremios;
	private JButton btnConfirmarPremios;
	private JButton btnCambiarPremios;

	public VentanaCarrito(VentanaPrincipal vp, List<Premio> premios) {
		setBounds(new Rectangle(0, 0, 810, 450));
		setResizable(false);
		this.vP = vp;
		this.localizacion = this.vP.localizacion;
		this.premios = premios;
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getScrollPane());
		getContentPane().add(getPanelBotonesAceptarYCancelarPremios(), BorderLayout.SOUTH);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle(this.vP.mensajes.getString("btnCarrito"));
		cargarAyuda();
	}

	private void crearPanelesArticulos() {
		PanelImagenCarrito elemento;
		for (Premio premio : this.premios) {
			elemento = new PanelImagenCarrito(this, premio);
			getPanelCarrito().add(elemento);
		}

	}

	public Locale getLocalizacion() {
		return localizacion;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getPanelCarrito());
		}
		return scrollPane;
	}

	private JPanel getPanelCarrito() {
		if (panelCarrito == null) {
			panelCarrito = new JPanel();
			panelCarrito.setBackground(new Color(255, 255, 255));
			panelCarrito.setLayout(new GridLayout(0, 1, 0, 0));
			crearPanelesArticulos();
		}
		return panelCarrito;
	}

	private JPanel getPanelBotonesAceptarYCancelarPremios() {
		if (panelBotonesAceptarYCancelarPremios == null) {
			panelBotonesAceptarYCancelarPremios = new JPanel();
			panelBotonesAceptarYCancelarPremios.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) panelBotonesAceptarYCancelarPremios.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonesAceptarYCancelarPremios.add(getBtnCambiarPremios());
			panelBotonesAceptarYCancelarPremios.add(getBtnConfirmarPremios());
		}
		return panelBotonesAceptarYCancelarPremios;
	}

	private JButton getBtnConfirmarPremios() {
		if (btnConfirmarPremios == null) {
			btnConfirmarPremios = new JButton("New button");
			btnConfirmarPremios.setMnemonic('r');
			btnConfirmarPremios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarViajes();
					if (vP.app.getPanel().getPuntosAcumulados() == 0) {// No le sobran puntos
						mostrarVentanaEstaSeguro();
					} else {
						mostrarVentanaSobranPuntos();
					}
				}
			});
			btnConfirmarPremios.setForeground(new Color(240, 255, 240));
			btnConfirmarPremios.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnConfirmarPremios.setBackground(new Color(0, 139, 139));
			btnConfirmarPremios.setText(this.vP.mensajes.getString("btnConfirmarPremios"));
		}
		return btnConfirmarPremios;
	}

	protected void mostrarViajes() {
		for (Premio p : premios) {
			if (vP.app.getC().isViaje(p)) {
				mostrarVentanaViajes(p);
			}
		}

	}

	private void mostrarVentanaViajes(Premio premio) {
		VentanaViajes vV = new VentanaViajes(this.vP, premio, this);
		vV.setLocationRelativeTo(this);
		vV.setModal(true);
		vV.setVisible(true);

	}

	private void mostrarVentanaSobranPuntos() {
		VentanaSobranPuntos vS = new VentanaSobranPuntos(this.vP, this);
		vS.setLocationRelativeTo(this);
		vS.setModal(true);
		vS.setVisible(true);

	}

	protected void mostrarVentanaEstaSeguro() {
		VentanaEstaSeguro vS = new VentanaEstaSeguro(this.vP, this);
		vS.setLocationRelativeTo(this);
		vS.setModal(true);
		vS.setVisible(true);

	}

	private JButton getBtnCambiarPremios() {
		if (btnCambiarPremios == null) {
			btnCambiarPremios = new JButton("");
			btnCambiarPremios.setMnemonic('c');
			btnCambiarPremios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					vP.cambiarPremios();
				}
			});
			btnCambiarPremios.setText(this.vP.mensajes.getString("btnCambiarPremios"));
			btnCambiarPremios.setForeground(new Color(240, 255, 240));
			btnCambiarPremios.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCambiarPremios.setBackground(new Color(123, 104, 238));
		}
		return btnCambiarPremios;
	}
	
	private void cargarAyuda() {

		URL hsURL;
		HelpSet hs;

		try {
			File fichero = new File("bin/help/Ayuda.hs");// bin pq es el paquete que entregamos
			hsURL = fichero.toURI().toURL();
			hs = new HelpSet(null, hsURL);
		}

		catch (Exception e) {
			System.out.println("Ayuda no encontrada");
			return;
		}

		HelpBroker hb = hs.createHelpBroker();
		hb.initPresentation();// evita darle dos veces al F1
		hb.enableHelpKey(getRootPane(), "carrito", hs);// usar F1 para acceder a la ayuda, carga el carrito
	}
}
