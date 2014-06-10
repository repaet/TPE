package tpe_imb_03.pflichtuebung_04.aufgabe_02;

public class Runner implements Runnable {
	private long zahl = 1;
	private int laengesteFolge = 0;
	private long startwert = 0;

	@Override
	public void run() {
		while (zahl < 1000000) {
			Collatz i = new Collatz(getzahl());
			checkFolge(i.getCounter(), i.getStartwert());
		}
	}

	private synchronized void checkFolge(int folge, long startwert) {
		if (folge > laengesteFolge) {
			laengesteFolge = folge;
			this.startwert = startwert;
		}
	}

	public long getStartwert() {
		return startwert;
	}

	public int getLaengesteFolge() {
		return laengesteFolge;
	}

	private synchronized long getzahl() {
		return zahl++;
	}

}
