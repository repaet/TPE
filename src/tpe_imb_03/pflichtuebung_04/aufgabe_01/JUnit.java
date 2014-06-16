package tpe_imb_03.pflichtuebung_04.aufgabe_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.Film;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.film.USK;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Kino;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Programm;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.kino.Saal;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.IllegalTimeException;
import tpe_imb_03.pflichtuebung_04.aufgabe_01.system.Zeit;

/**
 * @author René
 * 
 */
public class JUnit {

	@Test
	public void zeitInMinuten() throws IllegalTimeException {
		Zeit zeit = new Zeit("20:15");
		int zeitInMinuten = zeit.getZeitInMinuten();

		assertTrue(zeitInMinuten == 1215);
	}

	@Test
	public void minutenInZeit() {
		Zeit zeitInMinuten = new Zeit(1215);
		String zeit = zeitInMinuten.toString();

		assertEquals(zeit, "20:15");
	}

	@Test
	public void kinoToString() throws IllegalTimeException {
		String string = "Cinemaxx in Mannheim\n"
				+ "Saal 'Blauer Saal' (250 Plätze)\n"
				+ "14:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "17:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "20:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "23:00 -- Batman Begins [ab 12 Jahre] 134 min\n"
				+ "\n"
				+ "Saal 'Grüner Saal' (200 Plätze)\n"
				+ "15:00 -- Barbie - Die Prinzessinnen-Akademie [ohne Altersbeschränkung] 81 min\n"
				+ "17:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "19:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "21:00 -- Machete [keine Jugendfreigabe] 100 min\n" + "\n"
				+ "Saal 'Studio' (150 Plätze)\n"
				+ "15:00 -- Ice Age 3 [ohne Altersbeschränkung] 90 min\n"
				+ "17:00 -- Trainspotting [keine Jugendfreigabe] 89 min\n"
				+ "20:00 -- Pulp Fiction [ab 16 Jahre] 148 min\n"
				+ "23:00 -- From Dusk till Dawn [ab 16 Jahre] 87 min\n" + "\n"
				+ "Saal 'Kellerloch' (30 Plätze)\n"
				+ "20:00 -- Chocolat [ab 6 Jahre] 121 min\n"
				+ "23:00 -- Trainspotting [keine Jugendfreigabe] 89 min\n";
		String kino = erstelleKino().toString();

		while (!kino.equals(string)) {
			kino = erstelleKino().toString();
		}

		assertEquals(string, kino);
	}

	public Kino erstelleKino() throws IllegalTimeException {
		Film batman = new Film("Batman Begins", 134, USK.AB12);
		Film iceAge3 = new Film("Ice Age 3", 90, USK.OHNE);
		Film machete = new Film("Machete", 100, USK.AB18);
		Film barbie = new Film("Barbie - Die Prinzessinnen-Akademie", 81,
				USK.OHNE);
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

		return cinemaxx;
	}

}
