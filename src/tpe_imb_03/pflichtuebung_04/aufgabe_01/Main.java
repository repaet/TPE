package tpe_imb_03.pflichtuebung_04.aufgabe_01;

import java.util.ArrayList;
import java.util.Arrays;

import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Film;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Sort;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.USK;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Kino;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Programm;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Saal;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.IllegalTimeException;

public class Main {

	public static void main(String[] args) throws IllegalTimeException {

		Film batman = new Film("Batman Begins", 134, USK.AB12);
		Film iceAge3 = new Film("Ice Age 3", 90, USK.OHNE);
		Film machete = new Film("Machete", 100, USK.AB18);
		Film barbie = new Film("Barbie - Die Prinzessinnen-Akademie", 81, USK.OHNE);
		Film trainspotting = new Film("Trainspotting", 89, USK.AB18);
		Film pulpFiction = new Film("Pulp Fiction", 148, USK.AB16);
		Film fromDuskTillDawn = new Film("From Dusk till Dawn", 87, USK.AB16);
		Film chocolat = new Film("Chocolat", 121, USK.AB6);

		Saal blauerSaal = new Saal("Blauer Saal", 250);
		Saal gruenerSaal = new Saal("Grüner Saal", 200);
		Saal studio = new Saal("Studio", 150);
		Saal kellerloch = new Saal("Kellerloch", 30);

		ArrayList<Saal> saele = new ArrayList<Saal>();
		saele.add(blauerSaal);
		saele.add(gruenerSaal);
		saele.add(studio);
		saele.add(kellerloch);

		ArrayList<Programm> filmeInBlauerSaal = new ArrayList<Programm>();
		filmeInBlauerSaal.add(new Programm(batman, "14:00"));
		filmeInBlauerSaal.add(new Programm(batman, "17:00"));
		filmeInBlauerSaal.add(new Programm(batman, "20:00"));
		filmeInBlauerSaal.add(new Programm(batman, "23:00"));

		ArrayList<Programm> filmeInGruenerSaal = new ArrayList<Programm>();
		filmeInGruenerSaal.add(new Programm(barbie, "15:00"));
		filmeInGruenerSaal.add(new Programm(iceAge3, "17:00"));
		filmeInGruenerSaal.add(new Programm(iceAge3, "19:00"));
		filmeInGruenerSaal.add(new Programm(machete, "21:00"));

		ArrayList<Programm> filmeInStudio = new ArrayList<Programm>();
		filmeInStudio.add(new Programm(iceAge3, "15:00"));
		filmeInStudio.add(new Programm(trainspotting, "17:00"));
		filmeInStudio.add(new Programm(pulpFiction, "20:00"));
		filmeInStudio.add(new Programm(fromDuskTillDawn, "23:00"));

		ArrayList<Programm> filmeInKellerloch = new ArrayList<Programm>();
		filmeInKellerloch.add(new Programm(chocolat, "20:00"));
		filmeInKellerloch.add(new Programm(trainspotting, "23:00"));

		Kino cinemaxx = new Kino("Cinemaxx", "Mannheim", saele);
		cinemaxx.addProgramm(blauerSaal, filmeInBlauerSaal);
		cinemaxx.addProgramm(gruenerSaal, filmeInGruenerSaal);
		cinemaxx.addProgramm(studio, filmeInStudio);
		cinemaxx.addProgramm(kellerloch, filmeInKellerloch);

		System.out.println(cinemaxx.toString());
		
		System.out.println(Arrays.toString(cinemaxx.getAlleFilmeMitZeiten()));
		System.out.println(Arrays.toString(cinemaxx.getAlleFilme()));
		System.out.println(Arrays.toString(cinemaxx.getAlleFilme(Sort.NAME)));
		System.out.println(Arrays.toString(cinemaxx.getAlleFilme(Sort.ALTERSFREIGABE)));
		System.out.println(Arrays.toString(cinemaxx.getAlleFilme(Sort.LAUFZEIT)));
		System.out.println(Arrays.toString(cinemaxx.getFilmeFuerSaalMitZeiten(blauerSaal)));
	}

}
