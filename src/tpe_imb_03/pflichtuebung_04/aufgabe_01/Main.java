package tpe_imb_03.pflichtuebung_04.aufgabe_01;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IllegalTimeException {

		Film tarkan = new Film("Tarkan", 120, 6);
		Film batman = new Film("Batman Begins", 134, 12);
		Film iceAge = new Film("Ice Age 3", 90, 0);
		Film machete = new Film("Machete", 100, 18);
		Film barbie = new Film("Barbie - Die Prinzessinnen-Akademie", 81, 0);
		Film trainspotting = new Film("Trainspotting", 89, 18);
		Film pulpFiction = new Film("Pulp Fiction", 148, 16);
		Film fromDuskTillDawn = new Film("From Dusk till Dawn", 87, 16);
		Film chocolat = new Film("Chocolat", 121, 6);

		ArrayList<Film> filmeInBlauerSaal = new ArrayList<Film>();
		filmeInBlauerSaal.add(iceAge);
		filmeInBlauerSaal.add(trainspotting);
		filmeInBlauerSaal.add(pulpFiction);
		filmeInBlauerSaal.add(fromDuskTillDawn);

		ArrayList<Film> filmeInStudio = new ArrayList<Film>();
		filmeInStudio.add(iceAge);
		filmeInStudio.add(trainspotting);
		filmeInStudio.add(pulpFiction);
		filmeInStudio.add(fromDuskTillDawn);

		Saal blauerSaal = new Saal("Blauer Saal", 250, filmeInBlauerSaal);
		// Saal gruenerSaal = new Saal("Grüner Saal", 200, null);
		Saal studio = new Saal("Studio", 150, filmeInStudio);
		// Saal kellerloch = new Saal("Kellerloch", 30, null);

		ArrayList<Saal> saele = new ArrayList<Saal>();
		saele.add(blauerSaal);
		// saele.add(gruenerSaal);
		saele.add(studio);
		// saele.add(kellerloch);

		saele.get(0).setStartzeit(iceAge, "15:00");
		saele.get(1).setStartzeit(iceAge, "23:00");

		System.out.println(saele.get(0).getStartzeit(iceAge));
		System.out.println(saele.get(1).getStartzeit(iceAge));

		Kino cinemaxx = new Kino("Cinemaxx", "Mannheim", saele);

	}

}
