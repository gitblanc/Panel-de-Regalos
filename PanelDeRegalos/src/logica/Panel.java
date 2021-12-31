/**
 * 
 */
package logica;

/**
 * @author UO285176
 *
 */
public class Panel {
	public static final int MAX_1000_CONT = 1;
	public static final int MAX_250_CONT = 5;
	public static final int MAX_50_CONT = 8;
	public static final int MAX_X2_CONT = 1;
	public static final int MAX_ESPECIAL_CONT = 2;
	public static final int MAX_SINPREMIO_CONT = 8;

	private Casilla[][] panel;
	private int cont1000;
	private int cont250;
	private int cont50;
	private int contX2;
	private int contEspecial;
	private int contSinPremio;
	private int puntosTotales;
	private int tiradas;
	private int copiaPuntosTotales;

	public Panel() {
		inicializarPanel();
		rellenarPanel();
		generarPuntos();
		this.tiradas = 3;
	}

	private void inicializarPanel() {
		this.panel = new Casilla[5][5];
	}

	private void rellenarPanel() {
		for (int i = 0; i < this.panel.length; i++) {
			for (int j = 0; j < this.panel[0].length; j++) {
				this.panel[i][j] = new Casilla(PuntosCasillas.SINPREMIO, false, false);
			}
		}
	}

	private void generarPuntos() {
		puntos1000();
		puntos250();
		puntos50();
		puntosX2();
		puntosEspecial();
		this.puntosTotales = 0;
	}

	private void puntosEspecial() {
		while (this.contEspecial < MAX_ESPECIAL_CONT) {
			int randomFila = (int) (Math.random() * 5);
			int randomColumna = (int) (Math.random() * 5);
			boolean cond1 = this.panel[randomFila][randomColumna].isOcupada();
			if (!cond1) {
				this.panel[randomFila][randomColumna] = new Casilla(PuntosCasillas.ESPECIAL, false, true);
				this.contEspecial++;
			}
		}

	}

	private void puntosX2() {
		while (this.contX2 < MAX_X2_CONT) {
			int randomFila = (int) (Math.random() * 5);
			int randomColumna = (int) (Math.random() * 5);
			boolean cond1 = this.panel[randomFila][randomColumna].isOcupada();
			if (!cond1) {
				this.panel[randomFila][randomColumna] = new Casilla(PuntosCasillas.X2P, false, true);
				this.contX2++;
			}
		}

	}

	private void puntos50() {
		while (this.cont50 < MAX_50_CONT) {
			int randomFila = (int) (Math.random() * 5);
			int randomColumna = (int) (Math.random() * 5);
			boolean cond1 = this.panel[randomFila][randomColumna].isOcupada();
			if (!cond1) {
				this.panel[randomFila][randomColumna] = new Casilla(PuntosCasillas.P50, false, true);
				this.cont50++;
			}
		}

	}

	private void puntos250() {
		while (this.cont250 < MAX_250_CONT) {
			int randomFila = (int) (Math.random() * 5);
			int randomColumna = (int) (Math.random() * 5);
			boolean cond1 = this.panel[randomFila][randomColumna].isOcupada();
			if (!cond1) {
				this.panel[randomFila][randomColumna] = new Casilla(PuntosCasillas.P250, false, true);
				this.cont250++;
			}
		}

	}

	private void puntos1000() {
		int randomFila = (int) (Math.random() * 5);
		int randomColumna = (int) (Math.random() * 5);
		this.panel[randomFila][randomColumna] = new Casilla(PuntosCasillas.P1000, false, true);
	}

	public Casilla[][] getPanel() {
		return panel;
	}

	public int getCont50() {
		return cont50;
	}

	public int getCont250() {
		return cont250;
	}

	public int getCont1000() {
		return cont1000;
	}

	public int getContEspecial() {
		return contEspecial;
	}

	public int getContX2() {
		return contX2;
	}

	public int getContSinPremio() {
		return contSinPremio;
	}

	@Override
	public String toString() {
		String cad = "";
		for (int i = 0; i < this.panel.length; i++) {
			for (int j = 0; j < this.panel[0].length; j++) {
				cad += this.panel[i][j].toString() + "\t";
			}
			cad += "\n";
		}
		return cad;
	}

	public void sumaPuntos(int i) {
		this.puntosTotales += i;
		this.copiaPuntosTotales = puntosTotales;
	}

	public int getPuntosAcumulados() {
		return this.puntosTotales;
	}

	public void setPuntosAcumulados(int puntos) {
		this.puntosTotales = puntos;
	}

	public int getTiradas() {
		return tiradas;
	}

	public void aumentaTiradas() {
		this.tiradas++;
	}

	public void multiplicaPuntos() {
		this.puntosTotales *= 2;
		this.copiaPuntosTotales = puntosTotales;

	}

	public void decrementarTiradas() {
		this.tiradas--;

	}

	public int getCopiaPuntosTotales() {
		return copiaPuntosTotales;
	}

}
