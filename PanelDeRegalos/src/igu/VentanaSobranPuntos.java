/**
 * 
 */
package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author UO285176
 *
 */
public class VentanaSobranPuntos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnNo;
	private JButton btnSi;
	private VentanaPrincipal vP;
	private JPanel panelSobrantes;
	private JTextArea textAreaSobranPuntos;
	private VentanaCarrito vC;

	public VentanaSobranPuntos(VentanaPrincipal vP, VentanaCarrito vc) {
		this.vP = vP;
		this.vC = vc;
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 750, 420));
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanelSobrantes(), BorderLayout.CENTER);
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

	private JPanel getPanelSobrantes() {
		if (panelSobrantes == null) {
			panelSobrantes = new JPanel();
			panelSobrantes.setBackground(new Color(255, 255, 255));
			panelSobrantes.setLayout(null);
			panelSobrantes.add(getTextAreaSobranPuntos());
		}
		return panelSobrantes;
	}

	private JTextArea getTextAreaSobranPuntos() {
		if (textAreaSobranPuntos == null) {
			textAreaSobranPuntos = new JTextArea();
			textAreaSobranPuntos.setBorder(null);
			textAreaSobranPuntos.setEditable(false);
			textAreaSobranPuntos.setBounds(108, 41, 567, 286);
			textAreaSobranPuntos.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textAreaSobranPuntos.setLineWrap(true);
			textAreaSobranPuntos.setWrapStyleWord(true);
			textAreaSobranPuntos.setTabSize(10);
			textAreaSobranPuntos.setText(
					this.vP.mensajes.getString("lblSobranPuntos") + this.vP.app.getPanel().getPuntosAcumulados() + "\n"
							+ this.vP.mensajes.getString("recuerde") + this.vP.mensajes.getString("conservaryperder"));
		}
		return textAreaSobranPuntos;
	}
}
