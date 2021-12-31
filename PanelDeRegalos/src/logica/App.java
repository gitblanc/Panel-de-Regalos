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
		panel = new Panel();
		r = new Registro();
		c = new Carrito();
		System.out.println(panel.toString());
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

	public boolean addRegaloEscogido(Premio premio) {
		String tipoPremio = premio.getCodigo().substring(0);
		int puntosTotales = getPanel().getPuntosAcumulados();
		int costePremio = premio.getPuntos();
		if (costePremio <= puntosTotales) {
			if (tipoPremio.equals("V")) {
				addViaje();
			} else {
				getC().addRegaloEscogido(premio);
				getPanel().setPuntosAcumulados(puntosTotales - costePremio);
				return true;
			}
		}
		return false;

	}

	private void addViaje() {
		// TODO Auto-generated method stub

	}
}
