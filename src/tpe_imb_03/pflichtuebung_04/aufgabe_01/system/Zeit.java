package tpe_imb_03.pflichtuebung_04.aufgabe_01.system;

/**
 * Zeit kann aus einem String im Format HH:MM erzeugt werden können (parse) und
 * wieder in einen solchen konvertiert werden.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Zeit {

	private int zeitInMinuten;

	/**
	 * Konstruktor der Klasse <code>Zeit</code>.
	 * 
	 * @param zeit
	 * @throws IllegalTimeException
	 */
	public Zeit(String zeit) throws IllegalTimeException {
		this(parse(zeit));
	}

	/**
	 * Konstruktor der Klasse <code>Zeit</code>.
	 * 
	 * @param zeit
	 */
	public Zeit(int zeit) {
		this.zeitInMinuten = zeit;
	}

	/**
	 * Auslesen der Zeit in Minuten.
	 * 
	 * @return zeitInMinuten
	 */
	public int getZeitInMinuten() {
		return zeitInMinuten;
	}

	/**
	 * Setzen von <code>zeitInMinuten</code> von HH:MM.
	 * 
	 * @param zeit
	 * @throws IllegalTimeException
	 */
	public void setZeitInMinuten(String zeit) throws IllegalTimeException {
		this.zeitInMinuten = parse(zeit);
	}

	/**
	 * Setzen von <code>zeitInMinuten</code> von HH:MM.
	 * 
	 * @param zeit
	 * @return zeitInMinuten
	 */
	public static int parse(String zeit) {
		String[] split = zeit.split(":");
		int std = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		int zeitInMinuten = 0;

		try {

			if (std > 23 || std < 0) {
				throw new IllegalTimeException("Stundenangabe falsch!");
			}

			if (min > 59 || min < 0) {
				throw new IllegalTimeException("Minutenangabe falsch!");
			}

			zeitInMinuten = (std * 60) + min;

		} catch (IllegalTimeException e) {
			e.printStackTrace();
		}

		return zeitInMinuten;
	}

	/**
	 * Auslesen der Zeit im Format HH:MM.
	 * 
	 * <pre>
	 * 20:15
	 * </pre>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		int std = (int) (this.zeitInMinuten / 60);
		int min = (int) (this.zeitInMinuten - (std * 60));
		String output = std + ":";

		if (std < 10) {
			output = "0" + output;
		}

		if (min < 10) {
			output += "0" + min;
		} else {
			output += min;
		}

		return output;
	}

}
