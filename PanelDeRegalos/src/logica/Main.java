/**
 * 
 */
package logica;

/**
 * @author UO285176
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Panel panel = new Panel();
		Registro r = new Registro();
		Carrito c = new Carrito();
		//System.out.println(panel.toString());
		//System.out.println(r.toString());
		System.out.println(c.toStringRegalosDisponibles());
	}

}
