package tpe_imb_03.pflichtuebung_04.aufgabe_01.kino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Film;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Sort;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.IllegalTimeException;

/**
 * Jedes Kino hat einen Namen, liegt in einer Stadt und besitzt einen oder
 * mehrere Säle, in denen Filme gespielt werden können.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Kino extends ProgrammPlan {

	private String name;
	private String stadt;
	private HashMap<Saal, ArrayList<Programm>> saele;

	/**
	 * Konstruktor der Klasse <code>Kino</code>.
	 * 
	 * @param name
	 * @param stadt
	 * @param saele
	 */
	public Kino(String name, String stadt, ArrayList<Saal> saele) {
		try {

			if (name != "") {
				this.name = name;
				this.stadt = stadt;
				this.saele = new HashMap<Saal, ArrayList<Programm>>();

				for (Saal saal : saele) {
					this.saele.put(saal, new ArrayList<Programm>());
				}

			} else {
				throw new Exception("Das Kino muss einen Namen besitzen.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Fügt einen <code>Film</code> mit Startzeit in den jeweiligen
	 * <code>Saal</code> hinzu.
	 * 
	 * @param saal
	 * @param neuesProgramm
	 *            Film mit Startzeit.
	 * @throws IllegalTimeException
	 */
	public void addProgramm(Saal saal, Programm neuesProgramm)
			throws IllegalTimeException {
		if (saele.containsKey(saal)) {
			ArrayList<Programm> aktuellesProgramm = saele.get(saal);
			checkZeit(aktuellesProgramm, neuesProgramm);
			aktuellesProgramm.add(neuesProgramm);
		}
	}

	/**
	 * Fügt mehrere <code>Filme</code> mit deren Startzeiten in den jeweiligen
	 * <code>Saal</code> hinzu.
	 * 
	 * @param saal
	 * @param neuesProgramm
	 *            Filme mit Startzeiten.
	 * @throws IllegalTimeException
	 */
	public void addProgramm(Saal saal, ArrayList<Programm> neuesPorgramm)
			throws IllegalTimeException {
		for (Programm programm : neuesPorgramm) {
			addProgramm(saal, programm);
		}
	}

	/**
	 * Überprüft ob der neue <code>Film</code> sich im <code>Saal</code> mit dem
	 * bereits vorhanden Programm überschneidet.
	 * 
	 * @param aktuellesProgramm
	 * @param neuesProgramm
	 */
	private void checkZeit(ArrayList<Programm> aktuellesProgramm,
			Programm neuesProgramm) {
		int startzeitNeuesProgramm = neuesProgramm.getStartzeit()
				.getZeitInMinuten();
		int endZeitNeuesProgramm = startzeitNeuesProgramm
				+ neuesProgramm.getFilm().getLAUFZEIT();

		for (Programm programm : aktuellesProgramm) {
			int startzeitAktuellesProgramm = programm.getStartzeit()
					.getZeitInMinuten();
			int endzeitAktuellesProgramm = startzeitAktuellesProgramm
					+ programm.getFilm().getLAUFZEIT();

			try {

				if (startzeitNeuesProgramm >= startzeitAktuellesProgramm
						&& startzeitNeuesProgramm < endzeitAktuellesProgramm
						|| endZeitNeuesProgramm > startzeitAktuellesProgramm
						&& endZeitNeuesProgramm <= endzeitAktuellesProgramm) {
					throw new IllegalTimeException(
							"Filmzeiten überschneiden sich!");
				}

			} catch (IllegalTimeException e) {
				e.printStackTrace();

			}
		}
	}

	/**
	 * Auslesen des Kinos mit allen Sälen. Jeder <code>Saal</code> listet seine
	 * Filme mit Startzeit auf.
	 * 
	 * <pre>
	 * Cinemaxx in Mannheim
	 * Saal 'Kellerloch' (30 Plätze)
	 * 20:00 -- Chocolat [ab 6 Jahre] 121 min
	 * 23:00 -- Trainspotting [keine Jugendfreigabe] 89 min
	 * 
	 * Saal 'Grüner Saal' (200 Plätze)
	 * 15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne Altersbeschränkung] 81 min
	 * 17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	 * 
	 * Saal 'Blauer Saal' (250 Plätze)
	 * 14:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 17:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 20:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 23:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * </pre>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String kino = this.name + " in " + this.stadt;

		for (Saal saal : saele.keySet()) {
			kino += saal.toString() + "\n";

			for (Programm programm : this.saele.get(saal)) {
				kino += programm.toString() + "\n";
			}
		}

		return kino;
	}

	/**
	 * Auslesen aller Filme mit Ihren Anfangszeiten als Array sortiert nach der
	 * Anfangszeit. Filme können doppelt vorkommen, wenn sie unterschiedliche
	 * Anfangszeiten haben.
	 * 
	 * <pre>
	 * 14:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne Altersbeschränkung] 81 min
	 * 17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	 * 19:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min
	 * 20:00 -- Pulp Fiction [ab 16 Jahre] 148 min
	 * 21:00 -- Machete [keine Jugendfreigabe] 100 min
	 * 23:00 -- Trainspotting [keine Jugendfreigabe] 89 min
	 * </pre>
	 * 
	 * @return Alle Filme mit Zeiten.
	 */
	public Programm[] getAlleFilmeMitZeiten() {
		List<Programm> filmeMitZeiten = new ArrayList<Programm>();

		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : saele.entrySet()) {
			Object saal = entry.getKey();

			for (Programm programm : this.saele.get(saal)) {
				filmeMitZeiten.add(programm);
			}
		}

		// TODO sort anfangszeit
		Collections.sort((List<Film>) filmeMitZeiten.get(0));

		return filmeMitZeiten.toArray(new Programm[filmeMitZeiten.size()]);
	}

	/**
	 * Auslesen aller Filme in einem bestimmten Saal mit den entsprechenden
	 * Anfangszeiten als Array. Die Filme sind nach der Startzeit sortiert.
	 * 
	 * <pre>
	 * 14:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 17:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 20:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * 23:00 -- Batman Begins [ab 12 Jahre] 134 min
	 * </pre>
	 * 
	 * @param saal
	 * @return Alle Filme mit Zeiten im ausgewählten Saal.
	 */
	public Programm[] getFilmeFuerSaalMitZeiten(Saal saal) {
		List<Programm> filmeMitZeiten = new ArrayList<Programm>();

		for (Programm programm : this.saele.get(saal)) {
			filmeMitZeiten.add(programm);
		}

		// TODO sort anfangszeit
		Collections.sort((List<Film>) filmeMitZeiten.get(0));

		return filmeMitZeiten.toArray(new Programm[filmeMitZeiten.size()]);
	}

	/**
	 * Auslesen aller Filme, die im Kino laufen als Array. Hierbei ist jeder
	 * Film nur einmal enthalten, auch wenn er zu mehreren Zeiten und in
	 * unterschiedliche Sälen läuft. Die Methode erlaubt in einer Variante die
	 * Angabe eines Sortierkriteriums.
	 * 
	 * @param sort
	 * @return Alle Filme des Kinos.
	 */
	public Film[] getAlleFilme(Sort sort) {
		List<Film> filme = new ArrayList<Film>();

		for (@SuppressWarnings("rawtypes")
		Map.Entry entry : saele.entrySet()) {
			Object saal = entry.getKey();

			for (Programm programm : this.saele.get(saal)) {
				filme.add(programm.getFilm());
			}
		}

		switch (sort) {
		case ALTERSFREIGABE:

			break;
		case LAUFZEIT:

			break;
		case NAME:
		default:
			break;
		}

		Collections.sort((List<Film>) filme.get(0));

		return filme.toArray(new Film[filme.size()]);
	}

}
