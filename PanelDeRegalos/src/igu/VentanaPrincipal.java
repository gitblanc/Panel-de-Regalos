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
import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.App;

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
	ResourceBundle mensajes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		this.app = new App();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1263, 750);
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
			panelSur.add(getBtnNext());
		}
		return panelSur;
	}

	private JLabel getLblSelectLanguage() {
		if (lblSelectLanguage == null) {
			lblSelectLanguage = new JLabel("New label");
			lblSelectLanguage.setFont(new Font("Tahoma", Font.BOLD, 40));
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
			btnSpanish.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
			btnEnglish.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btnEnglish;
	}

	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("New button");
			btnNext.setMnemonic('N');
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelIdentificador();
				}
			});
			btnNext.setHorizontalTextPosition(SwingConstants.LEFT);
			btnNext.setHorizontalAlignment(SwingConstants.LEFT);
			btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNext.setForeground(new Color(240, 248, 255));
			btnNext.setBackground(new Color(0, 139, 139));
			btnNext.setVerticalAlignment(SwingConstants.BOTTOM);
			btnNext.setVerticalTextPosition(SwingConstants.BOTTOM);
		}
		return btnNext;
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
			panelNorteI.add(getLblPanelRegalos());
		}
		return panelNorteI;
	}

	private JPanel getPanelCentroI() {
		if (panelCentroI == null) {
			panelCentroI = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelCentroI.getLayout();
			flowLayout.setHgap(50);
			flowLayout.setVgap(250);
			panelCentroI.add(getLblIdentificador());
			panelCentroI.add(getTextFieldIdentificador());
		}
		return panelCentroI;
	}

	private JPanel getPanelSurI() {
		if (panelSurI == null) {
			panelSurI = new JPanel();
			panelSurI.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelSurI.add(getBtnAccept());
		}
		return panelSurI;
	}

	private JLabel getLblPanelRegalos() {
		if (lblPanelRegalos == null) {
			lblPanelRegalos = new JLabel("New label");
			lblPanelRegalos.setFont(new Font("Tahoma", Font.PLAIN, 80));
		}
		return lblPanelRegalos;
	}

	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("New label");
			lblIdentificador.setLabelFor(getTextFieldIdentificador());
			lblIdentificador.setDisplayedMnemonic('I');
			lblIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblIdentificador;
	}

	private JTextField getTextFieldIdentificador() {
		if (textFieldIdentificador == null) {
			textFieldIdentificador = new JTextField();
			textFieldIdentificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String identificador = textFieldIdentificador.getText();
					if (app.getR().validateCredentials(identificador)) {// ¿está en la base de datos y puede jugar?
						getBtnAccept().setVisible(true);
						getTextFieldIdentificador().setEditable(false);
						app.getR().actualizarValor(identificador);// ponemos a 0
					} else {
						getBtnAccept().setVisible(false);
					}

				}
			});
			textFieldIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 20));
			textFieldIdentificador.setColumns(10);
		}
		return textFieldIdentificador;
	}

	private JButton getBtnAccept() {
		if (btnAccept == null) {
			btnAccept = new JButton("");
			btnAccept.setMnemonic('A');
			btnAccept.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelCasillas();
					pintarBotonesCasillas();
				}
			});
			btnAccept.setVisible(false);
			btnAccept.setBackground(new Color(0, 139, 139));
			btnAccept.setForeground(new Color(240, 248, 255));
			btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
			panelPuntuacion.add(getLblPuntosAcumulados());
			panelPuntuacion.add(getLblCasillasSinDestapar());
			panelPuntuacion.add(getBtnNextCasilla());
		}
		return panelPuntuacion;
	}

	private JButton getBtnComoFunciona() {
		if (btnComoFunciona == null) {
			btnComoFunciona = new JButton("New button");
			btnComoFunciona.setMnemonic('O');
			btnComoFunciona.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnComoFunciona.setBackground(new Color(205, 133, 63));
		}
		return btnComoFunciona;
	}

	private JLabel getLblCasillasSinDestapar() {
		if (lblCasillasSinDestapar == null) {
			lblCasillasSinDestapar = new JLabel("");
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
			lblPuntosAcumulados.setBackground(new Color(144, 238, 144));
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
}
