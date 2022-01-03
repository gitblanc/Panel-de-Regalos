/**
 * 
 */
package igu;

import javax.swing.JDialog;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author UO285176
 *
 */
public class VentanaEstaSeguro extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblSeguroPremios;
	private JPanel panel;
	private JButton btnNo;
	private JButton btnSi;
	private VentanaPrincipal vP;
	private VentanaCarrito vC;

	public VentanaEstaSeguro(VentanaPrincipal vP, VentanaCarrito ventanaCarrito) {
		getContentPane().setBackground(new Color(255, 255, 255));
		this.vP = vP;
		this.vC = ventanaCarrito;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(new Rectangle(0, 0, 750, 420));
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getLblSeguroPremios());
		getContentPane().add(getPanel(), BorderLayout.SOUTH);

	}

	private JLabel getLblSeguroPremios() {
		if (lblSeguroPremios == null) {
			lblSeguroPremios = new JLabel("New label");
			lblSeguroPremios.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeguroPremios.setFont(new Font("Tahoma", Font.PLAIN, 40));
			lblSeguroPremios.setBackground(new Color(255, 255, 255));
			lblSeguroPremios.setText(this.vP.mensajes.getString("lblSeguroPremios"));
		}
		return lblSeguroPremios;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panel.setBackground(new Color(255, 255, 255));
			panel.add(getBtnSi());
			panel.add(getBtnNo());
		}
		return panel;
	}

	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					vP.app.getC().inicializarViajes();
				}
			});
			btnNo.setBackground(new Color(205, 92, 92));
			btnNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNo.setText(this.vP.mensajes.getString("no"));
		}
		return btnNo;
	}

	private JButton getBtnSi() {
		if (btnSi == null) {
			btnSi = new JButton("New button");
			btnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					vC.dispose();
					vP.finalizarApp();
				}
			});
			btnSi.setForeground(new Color(240, 255, 240));
			btnSi.setBackground(new Color(0, 139, 139));
			btnSi.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnSi.setText(this.vP.mensajes.getString("si"));
		}
		return btnSi;
	}
}
