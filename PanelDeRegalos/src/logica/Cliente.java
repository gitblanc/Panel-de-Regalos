/**
 * 
 */
package logica;

/**
 * @author UO285176
 *
 */
public class Cliente {
	private String id_cliente;
	private String nameAndSurname;
	private int canPlay;
	
	public Cliente(String id, String name, int playOrNot) {
		this.id_cliente = id;
		this.nameAndSurname = name;
		this.setCanPlay(playOrNot);
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public String getNameAndSurname() {
		return nameAndSurname;
	}

	public int getCanPlay() {
		return canPlay;
	}

	public void setCanPlay(int canPlay) {
		this.canPlay = canPlay;
	}
	
	@Override
	public String toString() {
		return id_cliente + "//" + nameAndSurname+ "//" + canPlay;
		
	}
}
