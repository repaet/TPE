package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.concurrent.CountDownLatch;

/**
 * Speichert die längste Collatzfolge zwischen 1 und 1000000.
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
	static CountDownLatch endLatch = new CountDownLatch(4);

	/**
	 * Ruft den Collatzkonstruktor mit Zahlen zwischen 1 und 1000000 auf.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (zahl < 1000000) {
			Collatz i = new Collatz(getzahl());
			checkFolge(i.getCounter(), i.getStartwert());
		}
		endLatch.countDown();
	}

	/**
	 * Schaut ob die neue bearbeitete Collatzfolge länger ist als die aktuelle
	 * längste Collatzfolge
	 * 
	 * @param folge
	 *            die Länge der Collatzfolge
	 * @param startwert
	 *            der Startwert der Collatzfolge
	 */
	private synchronized void checkFolge(int folge, long startwert) {
		if (folge > laengesteFolge) {
			laengesteFolge = folge;
			this.startwert = startwert;
		}
	}

	/**
	 * @return den Startwert der längsten Collatzfolge.
	 */
	public long getStartwert() {
		return startwert;
	}

	/**
	 * @return die Länge der längsten Collatzfolge.
	 */
	public int getLaengesteFolge() {
		return laengesteFolge;
	}

	/**
	 * 
	 * @return den Startwert mit dem der Collatzkonstuktor aufgerufen wird.
	 */
	private synchronized long getzahl() {
		return zahl++;
	}
}
