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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import logica.App;
import logica.Premio;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Dimension;

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
	protected App app;
	private JButton btnComoFunciona;
	private JLabel lblCasillasSinDestapar;
	private JButton btnNextCasilla;
	private JLabel lblPuntosAcumulados;
	ResourceBundle mensajes;
	private ProcesaCheck teclaEnter;
	private JButton btnDondeEncontrarIdentificador;
	private JPanel panelArticulos;
	private JPanel panelFiltrosYBusqueda;
	private JPanel panelTotalDePuntos;
	private JButton btnCarrito;
	private JScrollPane scrArticulosAEscoger;
	private JPanel panelArticulosAEscoger;
	private JLabel lblTotalPuntos;
	private JLabel lblIntroduzcaIdentificadorValido;
	private JButton btnFiltroPrecio;
	private JButton btnFiltroCategoria;
	private JPopupMenu popupMenu;
	private JMenuItem menuItPrecioAltoBajo;
	private JMenuItem menuItPrecioBajoAlto;
	private JPopupMenu popupMenu_1;
	private JMenuItem menuItAlimentacion;
	private JMenuItem menuItDeportes;
	private JMenuItem menuItElectronica;
	private JMenuItem menuItJuguetes;
	private JMenuItem menuItViajes;
	private JMenuItem menuItAll;
	private JSeparator separator;
	private JLabel lblOrdenarPor;
	DateFormat formatoHora;
	String identificadorCliente;

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
		this.setMinimumSize(new Dimension(980, 710));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelSelectLanguage(), "pnSelectLanguage");
		contentPane.add(getPanelIdentificador(), "pnIdentificador");
		contentPane.add(getPanelCasillas(), "pnCasillas");
		localizar(localizacion);
	}

	private void localizar(Locale loc) {
		this.localizacion = loc;
		this.mensajes = ResourceBundle.getBundle("rcs/Textos", loc);
		formatoHora = DateFormat.getTimeInstance(DateFormat.LONG, loc);
		this.setTitle(mensajes.getString("title"));
		getLblSelectLanguage().setText(mensajes.getString("lblLanguage"));
		getBtnNext().setText(mensajes.getString("next"));
		getLblPanelRegalos().setText(mensajes.getString("lblPanelRegalos"));
		getLblIdentificador().setText(mensajes.getString("lblIdentificador"));
		getLblIntroduzcaIdentificadorValido().setText(mensajes.getString("lblIdentificadorValido"));
		getBtnAccept().setText(mensajes.getString("btnAccept"));
		getBtnComoFunciona().setText(mensajes.getString("btnComoFunciona"));
		getBtnNextCasilla().setText(mensajes.getString("next"));
		getLblPuntosAcumulados()
				.setText(app.getPanel().getPuntosAcumulados() + " " + mensajes.getString("lblPuntosAcumulados"));
		getLblCasillasSinDestapar()
				.setText(mensajes.getString("lblTiradasRestantes") + "\n" + app.getPanel().getTiradas());
		getBtnDondeEncontrarIdentificador().setText(mensajes.getString("btnDondeEncuentroIdentificador"));
		contentPane.add(getPanelArticulos(), "pnArticulos");
		getBtnCarrito().setText(mensajes.getString("btnCarrito"));
		getPanelArticulosAEscoger().removeAll();
		crearPanelesArticulos();
		getBtnFiltroCategoria().setText(mensajes.getString("btnFiltroCategoria"));
		getBtnFiltroPrecio().setText(mensajes.getString("btnFiltroPrecio"));
		getMenuItAlimentacion().setText(mensajes.getString("btnAlimentacion"));
		getMenuItDeportes().setText(mensajes.getString("btnDeportes"));
		getMenuItElectronica().setText(mensajes.getString("btnElectronica"));
		getMenuItJuguetes().setText(mensajes.getString("btnJuguetes"));
		getMenuItViajes().setText(mensajes.getString("btnViajesExperiencias"));
		getMenuItAll().setText(mensajes.getString("btnAll"));
		getMenuItPrecioAltoBajo().setText(mensajes.getString("precioAltoBajo"));
		getMenuItPrecioBajoAlto().setText(mensajes.getString("precioBajoAlto"));
		getLblOrdenarPor().setText(mensajes.getString("ordenarPor"));
	}

	private JPanel getPanelSelectLanguage() {
		if (panelSelectLanguage == null) {
			panelSelectLanguage = new JPanel();
			panelSelectLanguage.setBackground(new Color(255, 255, 255));
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
			panelSurI.add(getLblIntroduzcaIdentificadorValido());
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
					identificadorCliente = textFieldIdentificador.getText();
					if (app.getR().validateCredentials(identificadorCliente)) {// ¿está en la base de datos y puede
																				// jugar?
						getLblIntroduzcaIdentificadorValido().setVisible(false);
						getBtnAccept().setEnabled(true);
						getTextFieldIdentificador().setEditable(false);
						// app.getR().actualizarValor(identificadorCliente);// ponemos a 0
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
			panelCasillas.setMinimumSize(new Dimension(970, 701));
			panelCasillas.setLayout(new BorderLayout(0, 0));
			panelCasillas.add(getPanelBotones(), BorderLayout.CENTER);
			panelCasillas.add(getPanelPuntuacion(), BorderLayout.EAST);
		}
		return panelCasillas;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(new Color(255, 255, 255));
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
					if (app.getPanel().getPuntosAcumulados() > 0) {
						mostrarPanelArticulos();
					} else {
						mostrarVentanaNoObtuvoPuntos();
					}
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

	private void mostrarVentanaNoObtuvoPuntos() {
		VentanaNoObtuvoPuntos vN = new VentanaNoObtuvoPuntos(this);
		vN.setLocationRelativeTo(this);
		vN.setModal(true);
		vN.setVisible(true);
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
			panelFiltrosYBusqueda.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panelFiltrosYBusqueda.add(getLblOrdenarPor());
			panelFiltrosYBusqueda.add(getBtnFiltroCategoria());
			panelFiltrosYBusqueda.add(getBtnFiltroPrecio());
			panelFiltrosYBusqueda.add(getBtnCarrito());
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

	protected JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("New button");
			btnCarrito.setEnabled(false);
			btnCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarVentanaCarrito();
				}
			});
			btnCarrito.setBackground(new Color(255, 127, 80));
		}
		return btnCarrito;
	}

	private void mostrarVentanaCarrito() {
		VentanaCarrito vC = new VentanaCarrito(this, this.app.getC().getRegalosEscogidos());
		vC.setLocationRelativeTo(this);
		vC.setModal(true);
		vC.setVisible(true);
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
			panelArticulosAEscoger.setBackground(new Color(255, 255, 255));
			panelArticulosAEscoger
					.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
			panelArticulosAEscoger.setLayout(new GridLayout(0, 1, 0, 0));
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

	public void añadirACarrito(Premio premio, int unidades) {
		if (!this.app.addRegaloEscogido(premio, unidades)) {
			mostrarVentanaErrorPuntos();
		}
		getLblTotalPuntos()
				.setText(mensajes.getString("lblTotalPuntos") + " " + this.app.getPanel().getPuntosAcumulados());

	}

	private void mostrarVentanaErrorPuntos() {
		VentanaErrorPuntos vError = new VentanaErrorPuntos(this);
		vError.setLocationRelativeTo(this);
		vError.setModal(true);
		vError.setVisible(true);

	}

	public void cambiarPremios() {
		this.app.getPanel().setPuntosAcumulados(this.app.getPanel().getCopiaPuntosTotales());
		this.app.getC().inicializarRegalosEscogidos();
		;
		getBtnCarrito().setEnabled(false);
		getLblTotalPuntos()
				.setText(this.mensajes.getString("lblTotalPuntos") + this.app.getPanel().getPuntosAcumulados());
	}

	private JLabel getLblIntroduzcaIdentificadorValido() {
		if (lblIntroduzcaIdentificadorValido == null) {
			lblIntroduzcaIdentificadorValido = new JLabel("");
			lblIntroduzcaIdentificadorValido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblIntroduzcaIdentificadorValido;
	}

	private JButton getBtnFiltroPrecio() {
		if (btnFiltroPrecio == null) {
			btnFiltroPrecio = new JButton("New button");
			btnFiltroPrecio.setBackground(new Color(95, 158, 160));
			addPopup(btnFiltroPrecio, getPopupMenu());
		}
		return btnFiltroPrecio;
	}

	private JButton getBtnFiltroCategoria() {
		if (btnFiltroCategoria == null) {
			btnFiltroCategoria = new JButton("New button");
			btnFiltroCategoria.setBackground(new Color(135, 206, 250));
			addPopup(btnFiltroCategoria, getPopupMenu_1());
		}
		return btnFiltroCategoria;
	}

	private void crearPanelesArticulos(char filtro) {
		getPanelArticulosAEscoger().removeAll();
		PanelImagenArticulo elemento;
		List<Premio> premiosDisponibles = app.getC().getRegalosDisponibles();
		for (Premio premio : premiosDisponibles) {
			if (premio.getCodigo().charAt(0) == filtro) {
				elemento = new PanelImagenArticulo(this, premio);
				getPanelArticulosAEscoger().add(elemento);
			}
		}
		repaint();
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMenuItPrecioAltoBajo());
			popupMenu.add(getMenuItPrecioBajoAlto());
		}
		return popupMenu;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JMenuItem getMenuItPrecioAltoBajo() {
		if (menuItPrecioAltoBajo == null) {
			menuItPrecioAltoBajo = new JMenuItem("New menu item");
			menuItPrecioAltoBajo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ordenarPrecioBajoAlto();
				}
			});
		}
		return menuItPrecioAltoBajo;
	}

	private void ordenarPrecioAltoBajo() {
		getPanelArticulosAEscoger().removeAll();
		this.app.getC().ordenarPrecioAltoBajo();
		crearPanelesArticulos();
		repaint();
	}

	private JMenuItem getMenuItPrecioBajoAlto() {
		if (menuItPrecioBajoAlto == null) {
			menuItPrecioBajoAlto = new JMenuItem("New menu item");
			menuItPrecioBajoAlto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ordenarPrecioAltoBajo();
					;
				}
			});
		}
		return menuItPrecioBajoAlto;
	}

	private void ordenarPrecioBajoAlto() {
		getPanelArticulosAEscoger().removeAll();
		this.app.getC().ordenarPrecioBajoAlto();
		crearPanelesArticulos();
		repaint();
	}

	private JPopupMenu getPopupMenu_1() {
		if (popupMenu_1 == null) {
			popupMenu_1 = new JPopupMenu();
			popupMenu_1.add(getMenuItAlimentacion());
			popupMenu_1.add(getMenuItDeportes());
			popupMenu_1.add(getMenuItElectronica());
			popupMenu_1.add(getMenuItJuguetes());
			popupMenu_1.add(getMenuItViajes());
			popupMenu_1.add(getSeparator());
			popupMenu_1.add(getMenuItAll());
		}
		return popupMenu_1;
	}

	private JMenuItem getMenuItAlimentacion() {
		if (menuItAlimentacion == null) {
			menuItAlimentacion = new JMenuItem("New menu item");
			menuItAlimentacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelesArticulos('A');
				}
			});
		}
		return menuItAlimentacion;
	}

	private JMenuItem getMenuItDeportes() {
		if (menuItDeportes == null) {
			menuItDeportes = new JMenuItem("New menu item");
			menuItDeportes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelesArticulos('D');
				}
			});
		}
		return menuItDeportes;
	}

	private JMenuItem getMenuItElectronica() {
		if (menuItElectronica == null) {
			menuItElectronica = new JMenuItem("New menu item");
			menuItElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelesArticulos('E');
				}
			});
		}
		return menuItElectronica;
	}

	private JMenuItem getMenuItJuguetes() {
		if (menuItJuguetes == null) {
			menuItJuguetes = new JMenuItem("New menu item");
			menuItJuguetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelesArticulos('J');
				}
			});
		}
		return menuItJuguetes;
	}

	private JMenuItem getMenuItViajes() {
		if (menuItViajes == null) {
			menuItViajes = new JMenuItem("New menu item");
			menuItViajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelesArticulos('V');
				}
			});
		}
		return menuItViajes;
	}

	private JMenuItem getMenuItAll() {
		if (menuItAll == null) {
			menuItAll = new JMenuItem("New menu item");
			menuItAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getPanelArticulosAEscoger().removeAll();
					crearPanelesArticulos();
					repaint();
				}
			});
		}
		return menuItAll;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JLabel getLblOrdenarPor() {
		if (lblOrdenarPor == null) {
			lblOrdenarPor = new JLabel("New label");
			lblOrdenarPor.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lblOrdenarPor;
	}

	public void finalizarApp() {
		this.app.grabarPremios(this.formatoHora, this.identificadorCliente);
		this.localizacion = Locale.getDefault(Locale.Category.FORMAT);
		getPanelBotones().removeAll();
		getPanelArticulosAEscoger().removeAll();
		this.app.inicializar();
		localizar(this.localizacion);
		mostrarPanelSelectLanguage();
		getTextFieldIdentificador().setText("");
		getTextFieldIdentificador().setEditable(true);
		getLblIntroduzcaIdentificadorValido().setVisible(true);
		getBtnAccept().setEnabled(false);
		getBtnCarrito().setEnabled(false);
		getBtnNextCasilla().setEnabled(false);
	}

	private void mostrarPanelSelectLanguage() {
		((CardLayout) contentPane.getLayout()).show(contentPane, "pnSelectLanguage");

	}
}
