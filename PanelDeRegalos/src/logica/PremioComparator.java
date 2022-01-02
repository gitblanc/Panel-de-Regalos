/**
 * 
 */
package logica;

import java.util.Comparator;

/**
 * @author UO285176
 *
 */
public class PremioComparator implements Comparator<Premio> {

	@Override
	public int compare(Premio o1, Premio o2) {
		Integer puntos1 = o1.getPuntos();
		Integer puntos2 = o2.getPuntos();
		return puntos1.compareTo(puntos2);
	}

}
