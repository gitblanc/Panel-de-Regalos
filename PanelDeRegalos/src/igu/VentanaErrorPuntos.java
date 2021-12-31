/**
 * 
 */
package igu;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

/**
 * @author UO285176
 *
 */
public class VentanaErrorPuntos extends JDialog {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vP;
	private JLabel lblFaltanPuntos;
	Locale localizacion;
	ResourceBundle mensajes;

	public VentanaErrorPuntos(VentanaPrincipal vP) {
		setBounds(new Rectangle(0, 0, 750, 425));
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		this.vP = vP;
		this.localizacion = this.vP.localizacion;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getLblFaltanPuntos());
		localizar(this.localizacion);
	}

	private void localizar(Locale loc) {
		this.mensajes = ResourceBundle.getBundle("rcs/Textos", loc);
		getLblFaltanPuntos().setText(mensajes.getString("lblFaltanPuntos"));

	}

	private JLabel getLblFaltanPuntos() {
		if (lblFaltanPuntos == null) {
			lblFaltanPuntos = new JLabel("New label");
			lblFaltanPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lblFaltanPuntos.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblFaltanPuntos.setBounds(101, 88, 515, 171);
		}
		return lblFaltanPuntos;
	}
}
