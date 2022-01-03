/**
 * 
 */
package igu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import logica.Premio;

/**
 * @author UO285176
 *
 */
public class PanelImagenCarrito extends JPanel {
	private static final long serialVersionUID = 1L;
	private Premio premio;
	private Adaptar aD;
	private JLabel lblImagenPremio;
	private ImageIcon imagen = null;
	private JPanel panelNombreArticulo;
	private JTextArea textAreaNombreArticulo;

	public PanelImagenCarrito(VentanaCarrito ventanaCarrito, Premio premio) {
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		this.premio = premio;
		this.aD = new Adaptar();
		setLayout(new GridLayout(0, 2, 0, 0));
		add(getLblImagenPremio());
		add(getPanelNombreArticulo());
	}

	class Adaptar extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			adaptarImagenLabel();
		}
	}

	private JLabel getLblImagenPremio() {
		if (lblImagenPremio == null) {
			lblImagenPremio = new JLabel("");
			lblImagenPremio.setHorizontalAlignment(SwingConstants.CENTER);
			imagen = new ImageIcon(PanelImagenBoton.class.getResource("/img/" + this.premio.getCodigo() + ".png"));
			lblImagenPremio.setBackground(Color.WHITE);
			lblImagenPremio.addComponentListener(aD);
		}
		return lblImagenPremio;
	}

	public void adaptarImagenLabel() {
		Image imgOriginal = imagen.getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int) (90), (int) (90), Image.SCALE_FAST);
		getLblImagenPremio().setIcon(new ImageIcon(imgEscalada));

	}

	private JPanel getPanelNombreArticulo() {
		if (panelNombreArticulo == null) {
			panelNombreArticulo = new JPanel();
			panelNombreArticulo.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) panelNombreArticulo.getLayout();
			flowLayout.setVgap(50);
			panelNombreArticulo.add(getTextAreaNombreArticulo());
		}
		return panelNombreArticulo;
	}

	private JTextArea getTextAreaNombreArticulo() {
		if (textAreaNombreArticulo == null) {
			textAreaNombreArticulo = new JTextArea();
			textAreaNombreArticulo.setFont(new Font("Tahoma", Font.BOLD, 16));
			textAreaNombreArticulo.setBorder(null);
			textAreaNombreArticulo.setText(this.premio.getDenominacion());
			textAreaNombreArticulo.setRows(2);
			textAreaNombreArticulo.setTabSize(10);
			textAreaNombreArticulo.setEditable(false);
			textAreaNombreArticulo.setLineWrap(true);
			textAreaNombreArticulo.setWrapStyleWord(true);
		}
		return textAreaNombreArticulo;
	}
}
