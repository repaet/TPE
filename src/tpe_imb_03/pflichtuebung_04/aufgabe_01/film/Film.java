package tpe_imb_03.pflichtuebung_04.aufgabe_01.film;

import java.util.Comparator;

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

	/**
	 * Comperator der <code>Filme</code> nach ihrem <code>Name</code> sortiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public static class FilmNameComparator implements Comparator<Film> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Film o1, Film o2) {
			return o1.getTITEL().compareTo(o2.getTITEL());
		}

	}

	/**
	 * Comperator der <code>Filme</code> nach ihrer
	 * <code>Alterfreigabe (USK)</code> sortiert, falls
	 * <code>Alterfreigaben (USK's)</code> doppelt vorkommen werden diese Filme
	 * zusätzliche nach ihrem <code>Namen</code> sortiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public static class FilmAltersfreigabeComparator implements
			Comparator<Film> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Film o1, Film o2) {
			if (o1.getALTERSFREIGABE().getUSK() == o2.getALTERSFREIGABE()
					.getUSK()) {
				return o1.getTITEL().compareTo(o2.getTITEL());
			} else if (o1.getALTERSFREIGABE().getUSK() < o2.getALTERSFREIGABE()
					.getUSK()) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	/**
	 * Comperator der <code>Filme</code> nach ihrer <code>Laufzeit</code>
	 * sortiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public static class FilmLaufzeitComparator implements Comparator<Film> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Film o1, Film o2) {
			if (o1.getLAUFZEIT() == o2.getLAUFZEIT()) {
				return 0;
			} else if (o1.getLAUFZEIT() < o2.getLAUFZEIT()) {
				return -1;
			} else {
				return 1;
			}
		}

	}

}
