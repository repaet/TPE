package tpe_imb_03.pflichtuebung_04.aufgabe_01;

import java.util.ArrayList;

public class Saal {

	private final String NAME;
	private final int SITZPLAETZE;
	private final ArrayList<Film> FILME;
	private int[] startzeit;

	public Saal(String name, int sitzplaetze, ArrayList<Film> filme) {
		this.NAME = name;
		this.SITZPLAETZE = sitzplaetze;
		this.FILME = filme;
		this.startzeit = new int[FILME.size()];
	}

	public void setStartzeit(Film film, String startzeit)
			throws IllegalTimeException {
		int counter = 0;

		for (Film checkFilm : FILME) {

			if (checkFilm.equals(film)) {
				this.startzeit[counter] = Zeit.parse(startzeit);
				break;
			}

			counter++;
		}
	}

	public String getStartzeit(Film film) {
		int counter = 0;
		String zeit = "Film in Saal nicht vorhanden!";

		for (Film checkFilm : FILME) {

			if (checkFilm.equals(film)) {
				zeit = Zeit.toString(startzeit[counter]);
				break;
			}

			counter++;
		}
		
		return zeit;
	}

}
