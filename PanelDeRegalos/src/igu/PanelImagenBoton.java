/**
 * 
 */
package igu;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import logica.Panel;

/**
 * @author UO285176
 *
 */
public class PanelImagenBoton extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal vP;
	private Panel panelCasillas;
	private JPanel panel;
	private ImageIcon imagenPorDefecto;
	private JButton bt;
	private int fila;
	private int columna;

	public PanelImagenBoton(VentanaPrincipal vp, Panel panelC, int fila, int columna) {
		this.vP = vp;
		this.panelCasillas = panelC;
		this.fila = fila;
		this.columna = columna;
		this.imagenPorDefecto = new ImageIcon(VentanaPrincipal.class.getResource("/img/interrogacion.jpg"));
		add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			panel.add(getBt());
		}
		return panel;
	}

	private Component getBt() {
		if (bt == null) {
			bt = new JButton("");
			bt.setIcon(adaptarImagenLabel(imagenPorDefecto));
			bt.setBackground(Color.WHITE);
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean cond = panelCasillas.getTiradas() == 0;
					if (cond) {
						vP.habilitaBotonNext();
					} else {
						destaparCasilla();
					}
				}
			});
		}
		return bt;
	}

	protected void destaparCasilla() {
		String puntuacion = panelCasillas.getPanel()[fila][columna].toString();
		ImageIcon img;
		switch (puntuacion) {
		case "1000":
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/1000puntos.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			vP.sumaPuntos(1000);
			break;
		case "250":
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/250P.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			vP.sumaPuntos(250);
			break;
		case "50":
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/50P.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			vP.sumaPuntos(50);
			break;
		case "ESP":
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/ESP.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			vP.aumentaTiradas();
			break;
		case "x2":
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/x2P.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			vP.multiplicaPuntos();
			break;
		default:
			img = new ImageIcon(VentanaPrincipal.class.getResource("/img/OP.jpg"));
			bt.setIcon(adaptarImagenLabel(img));
			break;
		}
		vP.decrementarTiradas();

	}

	private ImageIcon adaptarImagenLabel(ImageIcon img) {
		Image imgOriginal = img.getImage();
		Image imgEscalada = imgOriginal.getScaledInstance((int) (125), (int) (115), Image.SCALE_FAST);
		return new ImageIcon(imgEscalada);

	}
}
