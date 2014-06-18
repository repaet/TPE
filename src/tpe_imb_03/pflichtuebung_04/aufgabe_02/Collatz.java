package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Die Klasse <code>Collatz</code> findet heraus, bei welcher Startzahl
 * unterhalb von einer Millionen die längste Collatz-Folge entsteht.
 * 
 * @author Deniz Tas
 * @author René Pätz
 * @author Serhat Ekeyilmaz
 * @version 1 15/06/2014
 */
public class Collatz implements Iterable<Long> {
	private long zahl;
	private long startwert = 0;
	private int folgenlaenge = 1;
	private ArrayList<Long> elementeReihe = new ArrayList<Long>();

	/**
	 * Konstruktor der Klasse <code>Collatz</code>.
	 * 
	 * @param startwert
	 *            Startwert der Collatzfolge.
	 */
	public Collatz(long startwert) {
		this.elementeReihe.add(startwert);
		this.zahl = startwert;
		setStartwert(startwert);
		this.rechnen();
	}

	/**
	 * Erechnet die Collatzfolge.
	 */
	private void rechnen() {
		Iterator<Long> iterator = this.iterator();

		while (iterator.hasNext()) {
			iterator.next();
		}
	}

	/**
	 * Auslesen der Folgenlänge.
	 * 
	 * @return folgenlaenge
	 */
	public int getFolgenlaenge() {
		return folgenlaenge;
	}

	/**
	 * Auslesen des Startwerts.
	 * 
	 * @return Startwert der Collatzfolge
	 */
	public long getStartwert() {
		return startwert;
	}

	/**
	 * Setzen des Startwerts.
	 * 
	 * @param startwert
	 *            Startwert der Collatzfolge
	 */
	private void setStartwert(long startwert) {
		if (startwert < 1) {
			this.startwert = 1;
		} else if (startwert > 1000000) {
			this.startwert = 1000000;
		}

		this.startwert = startwert;
	}

	/**
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Long> iterator() {
		Iterator<Long> iterator = new Iterator<Long>() {

			/**
			 * 
			 * @see java.util.Iterator#hasNext()
			 */
			@Override
			public boolean hasNext() {
				return zahl > 1;
			}

			/**
			 * 
			 * @see java.util.Iterator#next()
			 */
			@Override
			public Long next() {
				if (zahl % 2 == 0) {
					folgenlaenge++;
					zahl = zahl / 2;
				} else {
					folgenlaenge++;
					zahl = (3 * zahl) + 1;
				}
				
				elementeReihe.add(zahl);

				return zahl;
			}

			/**
			 * 
			 * @see java.util.Iterator#remove()
			 */
			@Override
			public void remove() {
				zahl = 1;
			}
		};

		return iterator;
	}

	/**
	 * Auslesen des aktuellen Elements.
	 * 
	 * @return aktuelles Element.
	 */
	public long getZahl() {
		return zahl;
	}
	
	/**
	 * Auslesen der Elemente der Collatz-Folge.
	 * 
	 * @return Elemente der Collatz-Folge.
	 */
	public ArrayList<Long> getElementeReihe() {
		return elementeReihe;
	}

}
