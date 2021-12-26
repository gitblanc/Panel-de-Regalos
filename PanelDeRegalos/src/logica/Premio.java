/**
 * 
 */
package logica;

/**
 * @author Tester2
 *
 */
public class Premio {
	private String codigo;
	private char seccion;
	private String denominacion;
	private String descripcion;
	private int puntos;

	public Premio(String code, char sect, String denom, String descr, int points) {
		this.codigo = code;
		this.seccion = sect;
		this.denominacion = denom;
		this.descripcion = descr;
		this.puntos = points;
	}

	public String getCodigo() {
		return codigo;
	}

	public char getSeccion() {
		return seccion;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public String toString() {
		return this.codigo + "//" + this.seccion + "//" + this.denominacion + "//" + this.descripcion + "//"
				+ this.puntos;
	}
}
