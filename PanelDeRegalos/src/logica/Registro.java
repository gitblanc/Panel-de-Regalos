/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UO285176
 *
 */
public class Registro {
	public static final String FICHERO_CLIENTES = "files/clientes.dat";
	private List<Cliente> clientes;

	public Registro() {
		inicializarClientes();
	}

	private void inicializarClientes() {
		this.clientes = new ArrayList<Cliente>();
		Util.loadFileCliente(FICHERO_CLIENTES, clientes);
	}

	@Override
	public String toString() {
		String cad = "";
		for (Cliente c : clientes) {
			cad += c.toString() + "\n";
		}
		return cad;
	}

	public boolean validateCredentials(String identificador) {
		for (Cliente c : clientes) {
			if (c.getId_cliente().equals(identificador) && c.getCanPlay() == 1) {
				return true;
			}
		}
		return false;

	}

	public void actualizarValor(String identificador) {
		for (Cliente c : clientes) {
			if (c.getId_cliente().equals(identificador) && c.getCanPlay() == 1) {
				c.setCanPlay(0);
				break;
			}
		}
		actualizarFicheroClientes();

	}

	public void grabarPremiosObtenidos(List<Premio> premiosEscogidos, String identificadorCliente, List<String> viajes) {
		Util.saveToFilePremios("entregas", premiosEscogidos, identificadorCliente, viajes);
	}

	private void actualizarFicheroClientes() {
		Util.saveToFileClientes("clientes", clientes);
	}
}
