package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logica.App;
import logica.Premio;
import javax.swing.ScrollPaneConstants;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Locale localizacion = Locale.getDefault(Locale.Category.FORMAT);

	private JPanel contentPane;
	private JPanel panelSelectLanguage;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JPanel panelSur;
	private JLabel lblSelectLanguage;
	private JButton btnSpanish;
	private JButton btnEnglish;
	private JButton btnNext;
	private JPanel panelIdentificador;
	private JPanel panelNorteI;
	private JPanel panelCentroI;
	private JPanel panelSurI;
	private JLabel lblPanelRegalos;
	private JLabel lblIdentificador;
	private JTextField textFieldIdentificador;
	private JButton btnAccept;
	private JPanel panelCasillas;
	private JPanel panelBotones;
	private JPanel panelPuntuacion;
	private App app;
	private JButton btnComoFunciona;
	private JLabel lblCasillasSinDestapar;
	private JButton btnNextCasilla;
	private JLabel lblPuntosAcumulados;
	private ResourceBundle mensajes;
	private ProcesaCheck teclaEnter;
	private JButton btnDondeEncontrarIdentificador;
	private JPanel panelArticulos;
	private JPanel panelFiltrosYBusqueda;
	private JPanel panelTotalDePuntos;
	private JComboBox comboBox;
	private JButton btnCarrito;
	private JTextField textFieldBusqueda;
	private JScrollPane scrArticulosAEscoger;
	private JPanel panelArticulosAEscoger;
	private JLabel lblTotalPuntos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoPanelRegalos.jpg")));
		this.app = new App();
		this.teclaEnter = new ProcesaCheck();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelSelectLanguage(), "pnSelectLanguage");
		contentPane.add(getPanelIdentificador(), "pnIdentificador");
		contentPane.add(getPanelCasillas(), "pnCasillas");
		contentPane.add(getPanelArticulos(), "pnArticulos");
		localizar(localizacion);
	}

	public ResourceBundle getMensajes() {
		localizar(this.localizacion);
		return this.mensajes;
	}

	private void localizar(Locale loc) {
		mensajes = ResourceBundle.getBundle("rcs/Textos", loc);
		DateFormat formatoHora = DateFormat.getTimeInstance(DateFormat.LONG, loc);
		this.setTitle(mensajes.getString("title"));
		getLblSelectLanguage().setText(mensajes.getString("lblLanguage"));
		getBtnNext().setText(mensajes.getString("next"));
		getLblPanelRegalos().setText(mensajes.getString("lblPanelRegalos"));
		getLblIdentificador().setText(mensajes.getString("lblIdentificador"));
		getBtnAccept().setText(mensajes.getString("btnAccept"));
		getBtnComoFunciona().setText(mensajes.getString("btnComoFunciona"));
		getBtnNextCasilla().setText(mensajes.getString("next"));
		getLblPuntosAcumulados()
				.setText(app.getPanel().getPuntosAcumulados() + " " + mensajes.getString("lblPuntosAcumulados"));
		getLblCasillasSinDestapar()
				.setText(mensajes.getString("lblTiradasRestantes") + "\n" + app.getPanel().getTiradas());
		getBtnDondeEncontrarIdentificador().setText(mensajes.getString("btnDondeEncuentroIdentificador"));
	}

	private JPanel getPanelSelectLanguage() {
		if (panelSelectLanguage == null) {
			panelSelectLanguage = new JPanel();
			panelSelectLanguage.setLayout(new BorderLayout(0, 0));
			panelSelectLanguage.add(getPanelNorte(), BorderLayout.NORTH);
			panelSelectLanguage.add(getPanelCentro(), BorderLayout.CENTER);
			panelSelectLanguage.add(getPanelSur(), BorderLayout.SOUTH);
		}
		return panelSelectLanguage;
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelNorte.getLayout();
			flowLayout.setVgap(120);
			panelNorte.add(getLblSelectLanguage());
		}
		return panelNorte;
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCentro.getLayout();
			flowLayout.setVgap(20);
			flowLayout.setHgap(50);
			panelCentro.add(getBtnSpanish());
			panelCentro.add(getBtnEnglish());
		}
		return panelCentro;
	}

	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelSur.add(getBtnNext());
		}
		return panelSur;
	}

	private JLabel getLblSelectLanguage() {
		if (lblSelectLanguage == null) {
			lblSelectLanguage = new JLabel("New label");
			lblSelectLanguage.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelectLanguage.setFont(new Font("Tahoma", Font.BOLD, 80));
		}
		return lblSelectLanguage;
	}

	private JButton getBtnSpanish() {
		if (btnSpanish == null) {
			btnSpanish = new JButton("Espa\u00F1ol");
			btnSpanish.setMnemonic('E');
			btnSpanish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("es"));
				}
			});
			btnSpanish.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return btnSpanish;
	}

	private JButton getBtnEnglish() {
		if (btnEnglish == null) {
			btnEnglish = new JButton("English");
			btnEnglish.setMnemonic('g');
			btnEnglish.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					localizar(new Locale("en"));
				}
			});
			btnEnglish.setFont(new Font("Tahoma", Font.PLAIN, 40));
		}
		return btnEnglish;
	}

	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("New button");
			btnNext.addKeyListener(teclaEnter);
			btnNext.setMnemonic('N');

			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelIdentificador();
				}
			});
			btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNext.setFont(new Font("Tahoma", Font.PLAIN, 30));
			btnNext.setForeground(new Color(240, 248, 255));
			btnNext.setBackground(new Color(0, 139, 139));
			btnNext.setVerticalAlignment(SwingConstants.BOTTOM);
			btnNext.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnNext;
	}

	class ProcesaCheck extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				mostrarPanelIdentificador();
		}
	}

	private void mostrarPanelIdentificador() {
		((CardLayout) contentPane.getLayout()).show(contentPane, "pnIdentificador");
	}

	private JPanel getPanelIdentificador() {
		if (panelIdentificador == null) {
			panelIdentificador = new JPanel();
			panelIdentificador.setLayout(new BorderLayout(0, 0));
			panelIdentificador.add(getPanelNorteI(), BorderLayout.NORTH);
			panelIdentificador.add(getPanelCentroI(), BorderLayout.CENTER);
			panelIdentificador.add(getPanelSurI(), BorderLayout.SOUTH);
		}
		return panelIdentificador;
	}

	private JPanel getPanelNorteI() {
		if (panelNorteI == null) {
			panelNorteI = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelNorteI.getLayout();
			flowLayout.setVgap(100);
			panelNorteI.add(getLblPanelRegalos());
		}
		return panelNorteI;
	}

	private JPanel getPanelCentroI() {
		if (panelCentroI == null) {
			panelCentroI = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCentroI.getLayout();
			flowLayout.setHgap(50);
			flowLayout.setVgap(20);
			panelCentroI.add(getLblIdentificador());
			panelCentroI.add(getTextFieldIdentificador());
			panelCentroI.add(getBtnDondeEncontrarIdentificador());
		}
		return panelCentroI;
	}

	private JPanel getPanelSurI() {
		if (panelSurI == null) {
			panelSurI = new JPanel();
			panelSurI.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelSurI.add(getBtnAccept());
		}
		return panelSurI;
	}

	private JLabel getLblPanelRegalos() {
		if (lblPanelRegalos == null) {
			lblPanelRegalos = new JLabel("New label");
			lblPanelRegalos.setHorizontalAlignment(SwingConstants.CENTER);
			lblPanelRegalos.setFont(new Font("Tahoma", Font.BOLD, 80));
		}
		return lblPanelRegalos;
	}

	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("New label");
			lblIdentificador.setHorizontalAlignment(SwingConstants.CENTER);
			lblIdentificador.setLabelFor(getTextFieldIdentificador());
			lblIdentificador.setDisplayedMnemonic('I');
			lblIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return lblIdentificador;
	}

	private JTextField getTextFieldIdentificador() {
		if (textFieldIdentificador == null) {
			textFieldIdentificador = new JTextField();
			textFieldIdentificador.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldIdentificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String identificador = textFieldIdentificador.getText();
					if (app.getR().validateCredentials(identificador)) {// ¿está en la base de datos y puede jugar?
						getBtnAccept().setEnabled(true);
						getTextFieldIdentificador().setEditable(false);
						app.getR().actualizarValor(identificador);// ponemos a 0
					}

				}
			});
			textFieldIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 30));
			textFieldIdentificador.setColumns(10);
		}
		return textFieldIdentificador;
	}

	private JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("");
			btnAccept.setEnabled(false);
			btnAccept.setMnemonic('A');
			btnAccept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelCasillas();
					pintarBotonesCasillas();
				}
			});
			btnAccept.setBackground(new Color(0, 139, 139));
			btnAccept.setForeground(new Color(240, 248, 255));
			btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 30));
		}
		return btnAccept;
	}

	private void mostrarPanelCasillas() {
		((CardLayout) contentPane.getLayout()).show(contentPane, "pnCasillas");

	}

	private JPanel getPanelCasillas() {
		if (panelCasillas == null) {
			panelCasillas = new JPanel();
			panelCasillas.setLayout(new BorderLayout(0, 0));
			panelCasillas.add(getPanelBotones(), BorderLayout.CENTER);
			panelCasillas.add(getPanelPuntuacion(), BorderLayout.EAST);
		}
		return panelCasillas;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setLayout(new GridLayout(5, 5, 0, 0));
		}
		return panelBotones;
	}

	private void pintarBotonesCasillas() {
		PanelImagenBoton elemento;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				elemento = new PanelImagenBoton(this, app.getPanel(), i, j);
				getPanelBotones().add(elemento);
			}
		}
		validate();

	}

	private JPanel getPanelPuntuacion() {
		if (panelPuntuacion == null) {
			panelPuntuacion = new JPanel();
			panelPuntuacion.setBounds(0, 0, 100, 100);
			panelPuntuacion.setLayout(new GridLayout(4, 1, 0, 0));
			panelPuntuacion.add(getBtnComoFunciona());
			panelPuntuacion.add(getLblCasillasSinDestapar());
			panelPuntuacion.add(getLblPuntosAcumulados());
			panelPuntuacion.add(getBtnNextCasilla());
		}
		return panelPuntuacion;
	}

	private JButton getBtnComoFunciona() {
		if (btnComoFunciona == null) {
			btnComoFunciona = new JButton("New button");
			btnComoFunciona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAyudaPuntos();
				}
			});
			btnComoFunciona.setMnemonic('O');
			btnComoFunciona.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnComoFunciona.setBackground(new Color(205, 133, 63));
		}
		return btnComoFunciona;
	}

	private void mostrarPanelAyudaPuntos() {
		((CardLayout) contentPane.getLayout()).show(contentPane, "pnAyudaPuntos");

	}

	private JLabel getLblCasillasSinDestapar() {
		if (lblCasillasSinDestapar == null) {
			lblCasillasSinDestapar = new JLabel("");
			lblCasillasSinDestapar.setBackground(new Color(230, 230, 250));
			lblCasillasSinDestapar.setOpaque(true);
			lblCasillasSinDestapar.setHorizontalAlignment(SwingConstants.CENTER);
			lblCasillasSinDestapar.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblCasillasSinDestapar;
	}

	private JButton getBtnNextCasilla() {
		if (btnNextCasilla == null) {
			btnNextCasilla = new JButton("New button");
			btnNextCasilla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelArticulos();
				}
			});
			btnNextCasilla.setEnabled(false);
			btnNextCasilla.setMnemonic('N');
			btnNextCasilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNextCasilla.setForeground(new Color(240, 255, 240));
			btnNextCasilla.setBackground(new Color(0, 139, 139));
		}
		return btnNextCasilla;
	}

	private void mostrarPanelArticulos() {
		((CardLayout) contentPane.getLayout()).show(contentPane, "pnArticulos");

	}

	public void sumaPuntos(int i) {
		this.app.getPanel().sumaPuntos(i);
		getLblPuntosAcumulados()
				.setText(app.getPanel().getPuntosAcumulados() + " " + mensajes.getString("lblPuntosAcumulados"));
		getLblTotalPuntos().setText(mensajes.getString("lblTotalPuntos") + app.getPanel().getPuntosAcumulados());
		validate();

	}

	private JLabel getLblPuntosAcumulados() {
		if (lblPuntosAcumulados == null) {
			lblPuntosAcumulados = new JLabel("");
			lblPuntosAcumulados.setOpaque(true);
			lblPuntosAcumulados.setBackground(new Color(250, 240, 230));
			lblPuntosAcumulados.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntosAcumulados.setFont(new Font("Tahoma", Font.BOLD, 18));
		}
		return lblPuntosAcumulados;
	}

	public void aumentaTiradas() {
		this.app.getPanel().aumentaTiradas();
		getLblCasillasSinDestapar()
				.setText(mensajes.getString("lblTiradasRestantes") + "\n" + app.getPanel().getTiradas());
		validate();
	}

	public void multiplicaPuntos() {
		this.app.getPanel().multiplicaPuntos();
		getLblPuntosAcumulados()
				.setText(app.getPanel().getPuntosAcumulados() + " " + mensajes.getString("lblPuntosAcumulados"));
		getLblTotalPuntos().setText(mensajes.getString("lblTotalPuntos") + app.getPanel().getPuntosAcumulados());
		validate();
	}

	public void decrementarTiradas() {
		this.app.getPanel().decrementarTiradas();
		getLblCasillasSinDestapar()
				.setText(mensajes.getString("lblTiradasRestantes") + "\n" + app.getPanel().getTiradas());
		if (this.app.getPanel().getTiradas() == 0) {
			habilitaBotonNext();
		}
		validate();
	}

	public void habilitaBotonNext() {
		getBtnNextCasilla().setEnabled(true);
	}

	private JButton getBtnDondeEncontrarIdentificador() {
		if (btnDondeEncontrarIdentificador == null) {
			btnDondeEncontrarIdentificador = new JButton("");
			btnDondeEncontrarIdentificador.setMnemonic('n');
			btnDondeEncontrarIdentificador.setBackground(Color.WHITE);
		}
		return btnDondeEncontrarIdentificador;
	}

	private JPanel getPanelArticulos() {
		if (panelArticulos == null) {
			panelArticulos = new JPanel();
			panelArticulos.setBackground(new Color(255, 255, 255));
			panelArticulos.setLayout(new BorderLayout(0, 0));
			panelArticulos.add(getPanelFiltrosYBusqueda(), BorderLayout.NORTH);
			panelArticulos.add(getPanelTotalDePuntos(), BorderLayout.SOUTH);
			panelArticulos.add(getScrArticulosAEscoger(), BorderLayout.CENTER);
		}
		return panelArticulos;
	}

	private JPanel getPanelFiltrosYBusqueda() {
		if (panelFiltrosYBusqueda == null) {
			panelFiltrosYBusqueda = new JPanel();
			panelFiltrosYBusqueda.setBackground(new Color(255, 255, 255));
			panelFiltrosYBusqueda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelFiltrosYBusqueda.add(getComboBox());
			panelFiltrosYBusqueda.add(getBtnCarrito());
			panelFiltrosYBusqueda.add(getTextFieldBusqueda());
		}
		return panelFiltrosYBusqueda;
	}

	private void crearPanelesArticulos() {
		PanelImagenArticulo elemento;
		List<Premio> premiosDisponibles = app.getC().getRegalosDisponibles();
		for (Premio premio : premiosDisponibles) {
			elemento = new PanelImagenArticulo(this, premio);
			getPanelArticulosAEscoger().add(elemento);
		}
	}

	private JPanel getPanelTotalDePuntos() {
		if (panelTotalDePuntos == null) {
			panelTotalDePuntos = new JPanel();
			panelTotalDePuntos.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelTotalDePuntos.add(getLblTotalPuntos());
		}
		return panelTotalDePuntos;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
		}
		return comboBox;
	}

	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("New button");
		}
		return btnCarrito;
	}

	private JTextField getTextFieldBusqueda() {
		if (textFieldBusqueda == null) {
			textFieldBusqueda = new JTextField();
			textFieldBusqueda.setColumns(10);
		}
		return textFieldBusqueda;
	}

	private JScrollPane getScrArticulosAEscoger() {
		if (scrArticulosAEscoger == null) {
			scrArticulosAEscoger = new JScrollPane();
			scrArticulosAEscoger.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrArticulosAEscoger.setViewportView(getPanelArticulosAEscoger());
		}
		return scrArticulosAEscoger;
	}

	private JPanel getPanelArticulosAEscoger() {
		if (panelArticulosAEscoger == null) {
			panelArticulosAEscoger = new JPanel();
			panelArticulosAEscoger
					.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
			panelArticulosAEscoger.setLayout(new GridLayout(0, 1, 0, 0));
			crearPanelesArticulos();
		}
		return panelArticulosAEscoger;
	}

	private JLabel getLblTotalPuntos() {
		if (lblTotalPuntos == null) {
			lblTotalPuntos = new JLabel("");
			lblTotalPuntos.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalPuntos.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lblTotalPuntos;
	}
}
