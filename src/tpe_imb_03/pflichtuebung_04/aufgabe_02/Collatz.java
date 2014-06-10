package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.Iterator;

public class Collatz implements Iterable<Long> {
	private long zahl;
	private long startwert = 0;
	private int counter = 0;

	public Collatz(long startwert) {
		zahl = startwert;
		this.startwert = startwert;
		this.rechnen();
	}

	@Override
	public Iterator<Long> iterator() {
		Iterator<Long> i = new Iterator<Long>() {

			public boolean hasNext() {
				return zahl > 1;
			}

			public Long next() {
				if (zahl % 2 == 0) {
					counter++;
					return zahl = zahl / 2;
				} else {
					counter++;
					return zahl = (3 * zahl) + 1;
				}
			}
		};
		return i;
	}

	private void rechnen() {
		Iterator<Long> tmp = this.iterator();
		while (tmp.hasNext()) {
			tmp.next();
		}
	}

	public int getCounter() {
		return counter;
	}

	public long getStartwert() {
		return startwert;
	}
}
