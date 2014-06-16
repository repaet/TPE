package tpe_imb_03.pflichtuebung_04.aufgabe_01.film;


/**
 * Ein Film zeichnet sich durch einen Titel, eine Laufzeit und eine
 * Altersfreigabe aus. Die Altersfreigabe eines Films kann die Stufen ohne
 * Altersbeschränkung, ab 6 Jahre, ab 12 Jahre, ab 16 Jahre und ohne
 * Jugendfreigabe haben.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Film {

	private final String TITEL;
	private final int LAUFZEIT;
	private final USK ALTERSFREIGABE;

	/**
	 * Konstruktor der Klasse <code>Film</code>.
	 * 
	 * @param titel
	 * @param laufzeit
	 * @param usk
	 */
	public Film(String titel, int laufzeit, USK usk) {
		this.TITEL = titel;
		this.LAUFZEIT = laufzeit;
		this.ALTERSFREIGABE = usk;
	}

	/**
	 * Auslesen der Laufzeit des Films in Minuten.
	 * 
	 * @return LAUFZEIT
	 */
	public int getLAUFZEIT() {
		return LAUFZEIT;
	}

	/**
	 * Auslesen des Titel des Films.
	 * 
	 * @return TITEL
	 */
	public String getTITEL() {
		return TITEL;
	}

	/**
	 * Auslesen der Altersfreigabe (USK) des Films.
	 * 
	 * @return ALTERSFREIGABE
	 */
	public USK getALTERSFREIGABE() {
		return ALTERSFREIGABE;
	}

	/**
	 * Auslesen des Films mit seinem Titel, der Altersfreigabe (USK) und der
	 * Laufzeit in Minuten.
	 * 
	 * <pre>
	 * Batman Begins [ab 12 Jahre] 134 min
	 * </pre>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return TITEL + " [" + ALTERSFREIGABE.toString() + "] " + LAUFZEIT
				+ " min";
	}

}
