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
}
