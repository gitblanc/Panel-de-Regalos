/**
 * 
 */
package igu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import logica.Premio;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

/**
 * @author UO285176
 *
 */
public class PanelImagenArticulo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResourceBundle mensajes2;
	private VentanaPrincipal vP;
	private Premio premio;
	private Adaptar aD;
	private JPanel panelBotonAdd;
	private JLabel lblImagenPremio;
	private ImageIcon imagen = null;
	private JButton btnAdd;
	private JPanel panelNombreArticulo;
	private JPanel panelBreveDescripcion;
	private JPanel panelSpinner;
	private JSpinner spinnerUnidades;
	private JPanel panelPuntos;
	private JLabel lblPuntos;
	private JScrollPane scrollPaneDescripcion;
	private JTextArea textAreaBreveDescripcion;
	private JTextArea textAreaNombreArticulo;

	public PanelImagenArticulo(VentanaPrincipal ventanaPrincipal, Premio premio) {
		setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		this.vP = ventanaPrincipal;
		this.premio = premio;
		this.aD = new Adaptar();
		setLayout(new GridLayout(0, 6, 0, 0));
		add(getLblImagenPremio());
		add(getPanelNombreArticulo());
		add(getPanelBreveDescripcion());
		add(getPanelPuntos());
		add(getPanelSpinner());
		add(getPanelBotonAdd());
		localizar(this.vP.localizacion);
	}

	private void localizar(Locale loc) {
		this.mensajes2 = ResourceBundle.getBundle("rcs/Textos", loc);
		getBtnAdd().setText(mensajes2.getString("btnAñadir"));

	}

	private JPanel getPanelBotonAdd() {
		if (panelBotonAdd == null) {
			panelBotonAdd = new JPanel();
			panelBotonAdd.setBackground(Color.WHITE);
			panelBotonAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
			panelBotonAdd.add(getBtnAdd());
		}
		return panelBotonAdd;
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

	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("");
			btnAdd.setMnemonic('a');
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int unidades = (int) getSpinner().getValue();
					vP.añadirACarrito(premio, unidades);
					if (vP.app.getC().getRegalosEscogidos().isEmpty()) {
						vP.getBtnCarrito().setEnabled(false);
					} else {
						vP.getBtnCarrito().setEnabled(true);
					}
				}
			});
			btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		}
		return btnAdd;
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

	private JPanel getPanelBreveDescripcion() {
		if (panelBreveDescripcion == null) {
			panelBreveDescripcion = new JPanel();
			panelBreveDescripcion.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) panelBreveDescripcion.getLayout();
			flowLayout.setVgap(30);
			panelBreveDescripcion.add(getScrollPaneDescripcion());
		}
		return panelBreveDescripcion;
	}

	private JPanel getPanelSpinner() {
		if (panelSpinner == null) {
			panelSpinner = new JPanel();
			panelSpinner.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) panelSpinner.getLayout();
			flowLayout.setVgap(48);
			panelSpinner.add(getSpinner());
		}
		return panelSpinner;
	}

	private JSpinner getSpinner() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();
			spinnerUnidades.setModel(new SpinnerNumberModel(1, null, null, 1));
		}
		return spinnerUnidades;
	}

	private JPanel getPanelPuntos() {
		if (panelPuntos == null) {
			panelPuntos = new JPanel();
			panelPuntos.setBackground(new Color(255, 255, 255));
			FlowLayout flowLayout = (FlowLayout) panelPuntos.getLayout();
			flowLayout.setVgap(50);
			panelPuntos.add(getLblPuntos());
		}
		return panelPuntos;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("");
			lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPuntos.setText("" + this.premio.getPuntos());
		}
		return lblPuntos;
	}

	private JScrollPane getScrollPaneDescripcion() {
		if (scrollPaneDescripcion == null) {
			scrollPaneDescripcion = new JScrollPane();
			scrollPaneDescripcion.setViewportView(getTextAreaBreveDescripcion());
		}
		return scrollPaneDescripcion;
	}

	private JTextArea getTextAreaBreveDescripcion() {
		if (textAreaBreveDescripcion == null) {
			textAreaBreveDescripcion = new JTextArea();
			textAreaBreveDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textAreaBreveDescripcion.setBorder(null);
			textAreaBreveDescripcion.setTabSize(10);
			textAreaBreveDescripcion.setRows(5);
			textAreaBreveDescripcion.setEditable(false);
			textAreaBreveDescripcion.setWrapStyleWord(true);
			textAreaBreveDescripcion.setLineWrap(true);
			textAreaBreveDescripcion.setText(this.premio.getDescripcion());
		}
		return textAreaBreveDescripcion;
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
