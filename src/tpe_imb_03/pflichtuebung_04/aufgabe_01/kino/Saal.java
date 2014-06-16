package tpe_imb_03.pflichtuebung_04.aufgabe_01.kino;

/**
 * Jeder Saal hat einen Namen und eine feste Anzahl von Sitzplatzen.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Saal {

	private final String NAME;
	private final int SITZPLAETZE;

	/**
	 * Konstruktor der Klasse <code>Saal</code>.
	 * 
	 * @param name
	 * @param sitzplaetze
	 */
	public Saal(String name, int sitzplaetze) {
		this.NAME = name;
		this.SITZPLAETZE = sitzplaetze;
	}

	/**
	 * Auslesen des Saals mit seinen <code>Sitzplätzen</code>.
	 * 
	 * <pre>
	 * Saal 'Grüner Saal' (200 Plätze)
	 * Saal 'Studio' (1 Platz)
	 * </pre>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nSaal '" + NAME + "' (" + SITZPLAETZE
				+ ((SITZPLAETZE == 1) ? " Platz)" : " Plätze)");
	}

}
