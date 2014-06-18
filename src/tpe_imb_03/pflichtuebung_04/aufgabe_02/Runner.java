package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Speichert den Startwert und die Elementenlänge, der längsten Collatz-Folge
 * zwischen 1 und 1000000.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Runner implements Runnable {
	private long zahl = 1;
	private int laengesteFolge = 0;
	private long startwert = 0;
	private ArrayList<Long> elementeLaengsteReihe = new ArrayList<Long>();
	static CountDownLatch endLatch = new CountDownLatch(4);

	/**
	 * Ruft den Collatz-Konstruktor mit Zahlen zwischen 1 und 1000000 auf.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		ArrayList<Long> liste = new ArrayList<Long>();

		while (zahl < 1000000) {
			Collatz c = new Collatz(getZahl());
			checkFolge(c.getFolgenlaenge(), c.getStartwert());

			liste.add(c.getZahl());
		}

		checkNeueListeLaenger(liste);
		endLatch.countDown();
	}

	/**
	 * Auslesen der Elemente der längsten Collatz-Folge.
	 * 
	 * @return Elemente der längsten Collatz-Folge.
	 */
	public ArrayList<Long> getElementeLaengsteReihe() {
		return elementeLaengsteReihe;
	}

	/**
	 * Schaut ob die neue bearbeitete Collatzfolge länger ist als die aktuelle
	 * längste Collatz-Folge.
	 * 
	 * @param folge
	 *            Länge der Collatz-Folge.
	 * @param startwert
	 *            Startwert der Collatz-Folge.
	 */
	private synchronized void checkFolge(int folge, long startwert) {
		if (folge > laengesteFolge) {
			laengesteFolge = folge;
			this.startwert = startwert;
		}
	}

	/**
	 * Auslesen des Startwerts der längsten Collatz-Folge.
	 * 
	 * @return startwert
	 */
	public long getStartwert() {
		return startwert;
	}

	/**
	 * Auslesen der Länge der längsten Collatz-Folge.
	 * 
	 * @return laengesteFolge
	 */
	public int getLaengesteFolge() {
		return laengesteFolge;
	}

	/**
	 * 
	 * @return den Startwert mit dem der Collatz-Konstuktor aufgerufen wird.
	 */
	private synchronized long getZahl() {
		return zahl++;
	}

	public synchronized void checkNeueListeLaenger(ArrayList<Long> liste) {
		if (liste.size() > elementeLaengsteReihe.size()) {
			elementeLaengsteReihe = liste;
		}
	}

}
