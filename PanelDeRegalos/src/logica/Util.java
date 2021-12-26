/**
 * 
 */
package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author UO285176
 *
 */
public class Util {

	public static void saveToFile2(String nombreFicheroSalida, String txPedido) {
		try {
			String filePedido = "C:\\Pedidos\\" + nombreFicheroSalida + ".dat";
			Path path = Paths.get(filePedido);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter fichero = new BufferedWriter(new FileWriter(filePedido));
			fichero.write(txPedido);
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public static void loadFileCliente(String nombreFicheroEntrada, List<Cliente> clientes) {

		String linea;
		String[] datosCliente = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosCliente = linea.split("@");
				clientes.add(new Cliente(datosCliente[0], datosCliente[1], Integer.parseInt(datosCliente[2])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void loadFileRegalos(String nombreFicheroEntrada, List<Premio> regalos) {

		String linea;
		String[] datosRegalo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosRegalo = linea.split("@");
				regalos.add(new Premio(datosRegalo[0], datosRegalo[1].charAt(0), datosRegalo[2], datosRegalo[3],
						Integer.parseInt(datosRegalo[4])));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void saveToFile(String nombreFicheroSalida, List<Cliente> clientes) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
			String linea = clientes.toString();
			fichero.write(linea);
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
