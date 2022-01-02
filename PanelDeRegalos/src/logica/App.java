/**
 * 
 */
package logica;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author UO285176
 *
 */
public class App {
	private Panel panel;
	private Registro r;
	private Carrito c;

	public App() {
		inicializar();
	}

	public Panel getPanel() {
		return panel;
	}

	public Registro getR() {
		return r;
	}

	public Carrito getC() {
		return c;
	}

	public boolean addRegaloEscogido(Premio premio, int unidades) {
		String tipoPremio = premio.getCodigo().substring(0);
		int puntosTotales = getPanel().getPuntosAcumulados();
		int costePremio = premio.getPuntos() * unidades;// el premio por las unidades que haya
		if (costePremio <= puntosTotales) {
			if (tipoPremio.equals("V")) {
				addViaje();
			} else {
				for (int i = 0; i < unidades; i++) {
					getC().addRegaloEscogido(premio);
				}
				getPanel().setPuntosAcumulados(puntosTotales - costePremio);
				return true;
			}
		}
		return false;

	}

	private void addViaje() {
		// TODO Auto-generated method stub

	}

	public void inicializar() {
		panel = new Panel();
		r = new Registro();
		c = new Carrito();
		System.out.println(panel.toString());
		
	}
	
	public void grabarPremios(DateFormat formatoHora, String identificadorCliente) {
		Date date = new Date();
		formatoHora.format(date);
		r.grabarPremiosObtenidos(date, this.c.getRegalosEscogidos(), this.c.getObservaciones(), identificadorCliente);
		
	}
}
