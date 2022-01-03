/**
 * 
 */
package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author UO285176
 *
 */
public class VentanaNoObtuvoPuntos extends JDialog {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vP;
	private JPanel panelBotonContinuar;
	private JButton btnContinuar;
	private JPanel panelTxtArea;
	private JTextArea txtAreaNoObtuvoPuntos;

	public VentanaNoObtuvoPuntos(VentanaPrincipal vp) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 700, 420));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanelBotonContinuar(), BorderLayout.SOUTH);
		getContentPane().add(getPanelTxtArea(), BorderLayout.CENTER);
		this.vP = vp;
		localizar(this.vP.localizacion);

	}

	private void localizar(Locale localizacion) {
		getTxtAreaNoObtuvoPuntos().setText(this.vP.mensajes.getString("txtAreaNoObtuvoPuntos"));
		getBtnContinuar().setText(this.vP.mensajes.getString("next"));
	}

	private JPanel getPanelBotonContinuar() {
		if (panelBotonContinuar == null) {
			panelBotonContinuar = new JPanel();
			panelBotonContinuar.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelBotonContinuar.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonContinuar.add(getBtnContinuar());
		}
		return panelBotonContinuar;
	}

	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("New button");
			btnContinuar.setMnemonic('n');
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					vP.finalizarApp();
				}
			});
			btnContinuar.setForeground(new Color(240, 255, 240));
			btnContinuar.setBackground(new Color(0, 139, 139));
			btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btnContinuar;
	}

	private JPanel getPanelTxtArea() {
		if (panelTxtArea == null) {
			panelTxtArea = new JPanel();
			panelTxtArea.setBackground(new Color(255, 255, 255));
			panelTxtArea.setLayout(null);
			panelTxtArea.add(getTxtAreaNoObtuvoPuntos());
		}
		return panelTxtArea;
	}

	private JTextArea getTxtAreaNoObtuvoPuntos() {
		if (txtAreaNoObtuvoPuntos == null) {
			txtAreaNoObtuvoPuntos = new JTextArea();
			txtAreaNoObtuvoPuntos.setBounds(88, 11, 542, 317);
			txtAreaNoObtuvoPuntos.setWrapStyleWord(true);
			txtAreaNoObtuvoPuntos.setBorder(null);
			txtAreaNoObtuvoPuntos.setTabSize(10);
			txtAreaNoObtuvoPuntos.setFont(new Font("Tahoma", Font.PLAIN, 40));
			txtAreaNoObtuvoPuntos.setEditable(false);
			txtAreaNoObtuvoPuntos.setLineWrap(true);
		}
		return txtAreaNoObtuvoPuntos;
	}
}
