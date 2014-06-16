package tpe_imb_03.pflichtuebung_04.aufgabe_01.kino;

import java.util.Comparator;

import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Film;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.IllegalTimeException;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.Zeit;

/**
 * Ein Film kann zu verschiedenen Zeiten in verschiedenen Sälen laufen. Hierbei
 * sind die Zeiten frei wählbar zwischen 0:00 Uhr und 23:59 Uhr. Es kann auch
 * passieren, dass ein Film gleichzeitig oder zu sich überschneidenden Zeiten in
 * mehreren Sälen läuft.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Programm {

	private Film film;
	private Zeit startzeit;

	/**
	 * Konstruktor der Klasse <code>Programm</code>.
	 * 
	 * @param film
	 * @param startzeit
	 *            als Zeit.
	 */
	public Programm(Film film, Zeit startzeit) {
		setFilm(film);
		setStartzeit(startzeit);
	}

	/**
	 * Konstruktor der Klasse <code>Programm</code>.
	 * 
	 * @param film
	 * @param startzeit
	 *            als String.
	 * @throws IllegalTimeException
	 */
	public Programm(Film film, String startzeit) throws IllegalTimeException {
		this(film, new Zeit(startzeit));
	}

	/**
	 * Auslesen des Films (Titel, Altersfreigabe (USK), Laufzeit (in Minuten)).
	 * 
	 * @return Film
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * Setzen des Films (Titel, Altersfreigabe (USK), Laufzeit (in Minuten)).
	 * 
	 * @param film
	 */
	private void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * Auslesen der Startzeit des Films.
	 * 
	 * @return Startzeit
	 */
	public Zeit getStartzeit() {
		return startzeit;
	}

	/**
	 * Setzen der Startzeit des Films.
	 * 
	 * @param startzeit
	 */
	private void setStartzeit(Zeit startzeit) {
		this.startzeit = startzeit;
	}

	/**
	 * Auslesen des Films mit seiner Startzeit, dem Titel, der Altersfreigabe
	 * (USK) und der Laufzeit (in Minuten).
	 * 
	 * <pre>
	 * 17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	 * </pre>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return startzeit.toString() + " -- " + film.toString();
	}

	/**
	 * Comperator der Filme nach ihrem <code>Name</code> sotiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public class FilmNameComparator implements Comparator<Programm> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Programm o1, Programm o2) {
			return o1.getFilm().getTITEL().compareTo(o2.getFilm().getTITEL());
		}

	}

	/**
	 * Comperator der Filme nach ihrer <code>Alterfreigabe (USK)</code> sotiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public class FilmAltersfreigabeComparator implements Comparator<Programm> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Programm o1, Programm o2) {
			if (o1.getFilm().getALTERSFREIGABE().getUSK() == o2.getFilm()
					.getALTERSFREIGABE().getUSK()) {
				return 0;
			} else if (o1.getFilm().getALTERSFREIGABE().getUSK() > o2.getFilm()
					.getALTERSFREIGABE().getUSK()) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	/**
	 * Comperator der Filme nach ihrer <code>Laufzeit</code> sotiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public class FilmLaufzeitComparator implements Comparator<Programm> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Programm o1, Programm o2) {
			if (o1.getFilm().getLAUFZEIT() == o2.getFilm().getLAUFZEIT()) {
				return 0;
			} else if (o1.getFilm().getLAUFZEIT() > o2.getFilm().getLAUFZEIT()) {
				return -1;
			} else {
				return 1;
			}
		}

	}

	/**
	 * Comperator der Filme nach ihrer <code>Startzeit</code> sotiert.
	 * 
	 * @author Deniz Tas
	 * @author René Pätz
	 * @author Serhat Ekeyilmaz
	 * @version 1 15/06/2014
	 */
	public class FilmStartzeitComparator implements Comparator<Programm> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Programm o1, Programm o2) {
			if (o1.getStartzeit().getZeitInMinuten() == o2.getStartzeit()
					.getZeitInMinuten()) {
				return 0;
			} else if (o1.getStartzeit().getZeitInMinuten() > o2.getStartzeit()
					.getZeitInMinuten()) {
				return -1;
			} else {
				return 1;
			}
		}

	}

}
