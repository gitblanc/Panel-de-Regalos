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
		App app = new App();
		Panel p = app.getPanel();
		Registro r = app.getR();
		Carrito c = app.getC();
		System.out.println(p.toString());
		System.out.println(r.toString());
		System.out.println(c.toStringRegalosDisponibles());
	}

}
