/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tester2
 *
 */
public class Carrito {
	public static final String FICHERO_REGALOS = "files/regalos.dat";
	private List<Premio> regalosDisponibles;
	private List<Premio> regalosEscogidos;
	
	public Carrito() {
		inicializarRegalosDisponibles();
		inicializarRegalosEscogidos();
	}

	private void inicializarRegalosEscogidos() {
		this.regalosEscogidos = new ArrayList<Premio>();
		
	}

	private void inicializarRegalosDisponibles() {
		this.regalosDisponibles = new ArrayList<Premio>();
		Util.loadFileRegalos(FICHERO_REGALOS, regalosDisponibles);
	}

	public List<Premio> getRegalosDisponibles() {
		return regalosDisponibles;
	}

	public List<Premio> getRegalosEscogidos() {
		return regalosEscogidos;
	}
	
	public String toStringRegalosDisponibles() {
		String cad = "";
		for(Premio p : regalosDisponibles) {
			cad += p.toString() + "\n";
		}
		return cad;
	}
}
