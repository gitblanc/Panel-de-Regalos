/**
 * 
 */
package logica;

/**
 * @author UO285176
 *
 */
public class Casilla {
	private PuntosCasillas valorCasilla;
	private boolean isDestapada;
	private boolean isOcupada;

	public Casilla(PuntosCasillas nuevoValor, boolean cond, boolean ocupada) {
		this.valorCasilla = nuevoValor;
		this.isDestapada = cond;
		this.isOcupada = ocupada;
	}

	public PuntosCasillas getValorCasilla() {
		return valorCasilla;
	}

	public boolean isDestapada() {
		return isDestapada;
	}

	public void setDestapada(boolean isDestapada) {
		this.isDestapada = isDestapada;
	}

	public boolean isOcupada() {
		return isOcupada;
	}

	public void setOcupada(boolean isOcupada) {
		this.isOcupada = isOcupada;
	}

	@Override
	public String toString() {
		if (getValorCasilla().equals(PuntosCasillas.P1000)) {
			return "1000";
		} else if (getValorCasilla().equals(PuntosCasillas.P250)) {
			return "250";
		} else if (getValorCasilla().equals(PuntosCasillas.P50)) {
			return "50";
		} else if (getValorCasilla().equals(PuntosCasillas.X2P)) {
			return "x2";
		} else if (getValorCasilla().equals(PuntosCasillas.ESPECIAL)) {
			return "ESP";
		} else {
			return "0";
		}
	}
}
