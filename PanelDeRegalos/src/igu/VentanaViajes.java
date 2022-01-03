/**
 * 
 */
package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import logica.Premio;

/**
 * @author UO285176
 *
 */
public class VentanaViajes extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panelCalendario;
	private VentanaPrincipal vP;
	private Premio viaje;
	private JTextField textFieldObservaciones;
	private JPanel panelViaje;
	private JCalendar calendar;
	private JButton btnNextViajes;

	public VentanaViajes(VentanaPrincipal vP, Premio premio, VentanaCarrito ventanaCarrito) {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.vP = vP;
		this.viaje = premio;
		setResizable(false);
		setBounds(new Rectangle(0, 0, 1200, 700));
		getContentPane().add(getPanelCalendario());
	}

	private JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
			calendar.setBounds(490, 11, 648, 409);
			establecerFechas();
		}
		return calendar;
	}

	private void establecerFechas() {
		Calendar calendario = Calendar.getInstance();
		Date fechaMinima = calendario.getTime();
		calendar.setMinSelectableDate(fechaMinima);
	}

	private JPanel getPanelCalendario() {
		if (panelCalendario == null) {
			panelCalendario = new JPanel();
			panelCalendario.setBackground(Color.WHITE);
			panelCalendario.setLayout(null);
			panelCalendario.add(getCalendar());
			panelCalendario.add(getPanelViaje());
			panelCalendario.add(getTextFieldObservaciones());
			panelCalendario.add(getBtnNextViajes());
		}
		return panelCalendario;
	}

	private JTextField getTextFieldObservaciones() {
		if (textFieldObservaciones == null) {
			textFieldObservaciones = new JTextField();
			textFieldObservaciones.setBorder(new TitledBorder(null, this.vP.mensajes.getString("observaciones"),
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textFieldObservaciones.setBounds(490, 431, 648, 139);
			textFieldObservaciones.setColumns(10);
		}
		return textFieldObservaciones;
	}

	private JPanel getPanelViaje() {
		if (panelViaje == null) {
			panelViaje = new JPanel();
			panelViaje.setBackground(Color.WHITE);
			panelViaje.setBounds(10, 11, 470, 624);
			panelViaje.setLayout(new GridLayout(0, 1, 0, 0));
			panelViaje.add(new PanelImagenViaje(viaje));
		}
		return panelViaje;
	}

	private JButton getBtnNextViajes() {
		if (btnNextViajes == null) {
			btnNextViajes = new JButton("New button");
			btnNextViajes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int dia = calendar.getCalendar().get(Calendar.DAY_OF_MONTH);
					int mes = calendar.getCalendar().get(Calendar.MONTH) + 1;
					int year = calendar.getCalendar().get(Calendar.YEAR);
					String calendarioFinal = dia + "/" + mes + "/" + year;
					vP.addViaje(viaje, calendarioFinal, getTextFieldObservaciones().getText());
					dispose();
				}
			});
			btnNextViajes.setForeground(new Color(240, 255, 240));
			btnNextViajes.setBackground(new Color(0, 139, 139));
			btnNextViajes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNextViajes.setBounds(1027, 602, 111, 33);
			btnNextViajes.setText(this.vP.mensajes.getString("btnAccept"));
		}
		return btnNextViajes;
	}
}
