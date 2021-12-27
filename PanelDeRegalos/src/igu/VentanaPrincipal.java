package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import logica.App;
import java.awt.Toolkit;

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
	private JLabel lblRelleno5;
	private JLabel lblRelleno4;
	private JLabel lblRelleno3;
	private JLabel lblRelleno2;
	private JLabel lblRelleno1;
	private JLabel lblRelleno01;
	private JLabel lblRelleno02;
	private JLabel lblRelleno04;
	private JLabel lblRelleno03;
	private JLabel lblRelleno05;
	private ProcesaCheck teclaEnter;
	private JButton btnDondeEncontrarIdentificador;
	private JPanel panelArticulos;
	private JPanel panelFiltrosYBusqueda;
	private JPanel panelArticulosAEscoger;
	private JPanel panelTotalDePuntos;
	private JComboBox comboBox;
	private JButton btnCarrito;
	private JTextField textFieldBusqueda;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logoPanelRegalos.jpg")));
		this.app = new App();
		this.teclaEnter = new ProcesaCheck();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelSelectLanguage(), "pnSelectLanguage");
		contentPane.add(getPanelIdentificador(), "pnIdentificador");
		contentPane.add(getPanelCasillas(), "pnCasillas");
		contentPane.add(getPanelArticulos(), "name_280997138969700");
		localizar(localizacion);
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
			panelSur.setLayout(new GridLayout(0, 6, 0, 0));
			panelSur.add(getLabel_3());
			panelSur.add(getLabel_2());
			panelSur.add(getLabel_1());
			panelSur.add(getLblRelleno02());
			panelSur.add(getLblRelleno01());
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
			panelSurI.setLayout(new GridLayout(0, 6, 0, 100));
			panelSurI.add(getLblRelleno1());
			panelSurI.add(getLblRelleno2());
			panelSurI.add(getLblRelleno3());
			panelSurI.add(getLblRelleno4());
			panelSurI.add(getLblRelleno5());
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
			btnNextCasilla.setEnabled(false);
			btnNextCasilla.setMnemonic('N');
			btnNextCasilla.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNextCasilla.setForeground(new Color(240, 255, 240));
			btnNextCasilla.setBackground(new Color(0, 139, 139));
		}
		return btnNextCasilla;
	}

	public void sumaPuntos(int i) {
		this.app.getPanel().sumaPuntos(i);
		getLblPuntosAcumulados()
				.setText(app.getPanel().getPuntosAcumulados() + " " + mensajes.getString("lblPuntosAcumulados"));
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

	private JLabel getLblRelleno5() {
		if (lblRelleno5 == null) {
			lblRelleno5 = new JLabel("");
		}
		return lblRelleno5;
	}

	private JLabel getLblRelleno4() {
		if (lblRelleno4 == null) {
			lblRelleno4 = new JLabel("");
		}
		return lblRelleno4;
	}

	private JLabel getLblRelleno3() {
		if (lblRelleno3 == null) {
			lblRelleno3 = new JLabel("");
		}
		return lblRelleno3;
	}

	private JLabel getLblRelleno2() {
		if (lblRelleno2 == null) {
			lblRelleno2 = new JLabel("");
		}
		return lblRelleno2;
	}

	private JLabel getLblRelleno1() {
		if (lblRelleno1 == null) {
			lblRelleno1 = new JLabel("");
		}
		return lblRelleno1;
	}

	private JLabel getLblRelleno01() {
		if (lblRelleno01 == null) {
			lblRelleno01 = new JLabel("");
		}
		return lblRelleno01;
	}

	private JLabel getLblRelleno02() {
		if (lblRelleno02 == null) {
			lblRelleno02 = new JLabel("");
		}
		return lblRelleno02;
	}

	private JLabel getLabel_1() {
		if (lblRelleno04 == null) {
			lblRelleno04 = new JLabel("");
		}
		return lblRelleno04;
	}

	private JLabel getLabel_2() {
		if (lblRelleno03 == null) {
			lblRelleno03 = new JLabel("");
		}
		return lblRelleno03;
	}

	private JLabel getLabel_3() {
		if (lblRelleno05 == null) {
			lblRelleno05 = new JLabel("");
		}
		return lblRelleno05;
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
			panelArticulos.setLayout(new BorderLayout(0, 0));
			panelArticulos.add(getPanelFiltrosYBusqueda(), BorderLayout.NORTH);
			panelArticulos.add(getPanelArticulosAEscoger(), BorderLayout.CENTER);
			panelArticulos.add(getPanelTotalDePuntos(), BorderLayout.SOUTH);
		}
		return panelArticulos;
	}
	private JPanel getPanelFiltrosYBusqueda() {
		if (panelFiltrosYBusqueda == null) {
			panelFiltrosYBusqueda = new JPanel();
			panelFiltrosYBusqueda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelFiltrosYBusqueda.add(getComboBox());
			panelFiltrosYBusqueda.add(getBtnCarrito());
			panelFiltrosYBusqueda.add(getTextFieldBusqueda());
		}
		return panelFiltrosYBusqueda;
	}
	private JPanel getPanelArticulosAEscoger() {
		if (panelArticulosAEscoger == null) {
			panelArticulosAEscoger = new JPanel();
		}
		return panelArticulosAEscoger;
	}
	private JPanel getPanelTotalDePuntos() {
		if (panelTotalDePuntos == null) {
			panelTotalDePuntos = new JPanel();
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
}
