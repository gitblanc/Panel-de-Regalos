/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tester2
 *
 */
public class Carrito {
	public static final String FICHERO_REGALOS = "files/regalos.dat";
	private List<Premio> regalosDisponibles;
	private List<Premio> regalosEscogidos;
	private String observaciones;

	public Carrito() {
		inicializarRegalosDisponibles();
		inicializarRegalosEscogidos();
	}

	public void inicializarRegalosEscogidos() {
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
		for (Premio p : regalosDisponibles) {
			cad += p.toString() + "\n";
		}
		return cad;
	}

	public void addRegaloEscogido(Premio premio) {
		getRegalosEscogidos().add(premio);

	}

	public void ordenarPrecioAltoBajo() {
		Collections.sort(this.regalosDisponibles, new PremioComparator());
	}

	public void ordenarPrecioBajoAlto() {
		Collections.sort(this.regalosDisponibles, Collections.reverseOrder(new PremioComparator()));
	}

	public String getObservaciones() {
		return this.observaciones;
	}
}
