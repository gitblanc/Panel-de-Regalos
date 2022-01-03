/**
 * 
 */
package logica;

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
		int puntosTotales = getPanel().getPuntosAcumulados();
		int costePremio = premio.getPuntos() * unidades;// el premio por las unidades que haya
		if (costePremio <= puntosTotales) {
			for (int i = 0; i < unidades; i++) {
				getC().addRegaloEscogido(premio);
			}
			getPanel().setPuntosAcumulados(puntosTotales - costePremio);
			return true;

		}
		return false;

	}

	public void inicializar() {
		panel = new Panel();
		r = new Registro();
		c = new Carrito();
		System.out.println(panel.toString());

	}

	public void grabarPremios(String identificadorCliente) {
		r.grabarPremiosObtenidos(this.c.getRegalosEscogidos(), identificadorCliente, this.c.getViajes());

	}
}
