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
import java.util.Date;
import java.util.List;

/**
 * @author UO285176
 *
 */
public class Util {

	public static void saveToFilePremios(String nombreFicheroSalida, List<Premio> premiosEscogidos, Date date,
			String observaciones, String identificadorCliente) {
		try {
			String filePedido = "C:\\Pedidos\\" + nombreFicheroSalida + ".dat";
			Path path = Paths.get(filePedido);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter fichero = new BufferedWriter(new FileWriter(filePedido, true));
			fichero.write(identificadorCliente);
			for (Premio p : premiosEscogidos) {
				String linea = "@" + p.getCodigo() + "\n";
				fichero.write(linea);
			}
			fichero.write("@" + date);
			if (observaciones != null && !observaciones.isBlank()) {
				fichero.write("@" + observaciones);
			}
			fichero.write("\n--------------------------------------------Next Client\n");
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

	public static void saveToFileClientes(String nombreFicheroSalida, List<Cliente> clientes) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("files/" + nombreFicheroSalida + ".dat"));
			for (Cliente c : clientes) {
				String linea = c.toString();
				fichero.write(linea);
			}
			fichero.close();
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public static void saveToFilePremios(String nombreFicheroSalida, List<Premio> premiosEscogidos,
			String identificadorCliente, List<String> viajes) {
		try {
			String filePedido = "C:\\Pedidos\\" + nombreFicheroSalida + ".dat";
			Path path = Paths.get(filePedido);
			if (!Files.exists(path.getParent())) {
				Files.createDirectory(path.getParent());
			}
			BufferedWriter fichero = new BufferedWriter(new FileWriter(filePedido, true));
			for (Premio p : premiosEscogidos) {
				if (p.getCodigo().charAt(0) != 'V') {
					String linea = identificadorCliente + "@" + p.getCodigo() + "\n";
					fichero.write(linea);
				}
			}if(viajes != null && !viajes.isEmpty()) {
				for(String s : viajes) {
					fichero.write(identificadorCliente + s.toString() + "\n");
				}
			}
			fichero.write("\n--------------------------------------------Next Client\n\n");
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}

	}
}
