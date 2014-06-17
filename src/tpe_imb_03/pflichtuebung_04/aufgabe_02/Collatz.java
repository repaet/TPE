package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.Iterator;

/**
 * Die Klasse Collatz kann man mit einem Startwert parameterisieren und über
 * einen Iterator die Elemente der Collatz-Folge nacheinander auslesen
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Collatz implements Iterable<Long> {
	private long zahl;
	private long startwert = 0;
	private int counter = 1;

	/**
	 * Konstruktor der Klasse <code> Collatz <code>
	 * 
	 * @param startwert
	 *            Der Startwert der Collatzfolge
	 */
	public Collatz(long startwert) {
		zahl = startwert;
		this.startwert = startwert;
		this.rechnen();
	}

	/**
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Long> iterator() {
		Iterator<Long> i = new Iterator<Long>() {

			@Override
			public boolean hasNext() {
				return zahl > 1;
			}

			@Override
			public Long next() {
				if (zahl % 2 == 0) {
					counter++;
					return zahl = zahl / 2;
				} else {
					counter++;
					return zahl = (3 * zahl) + 1;
				}
			}

			@Override
			public void remove() {
				zahl = 1;
			}
		};
		return i;
	}

	/**
	 * Rechnet die Collatzfolge
	 */
	private void rechnen() {
		Iterator<Long> tmp = this.iterator();
		while (tmp.hasNext()) {
			tmp.next();
		}
	}

	/**
	 * 
	 * @return Folgenlänge
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * 
	 * @return Startwert der Collatzfolge
	 */
	public long getStartwert() {
		return startwert;
	}
}
