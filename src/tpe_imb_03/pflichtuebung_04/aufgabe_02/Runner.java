package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;

public class Runner implements Runnable {
	

	@Override
	public void run() {
		while (Collatz.startwert < 1000000) {
			folge(getzahl());
		}
	}

	private synchronized long getzahl() {
		return Collatz.startwert++;
	}

	private void folge(long zahl) {
		ArrayList<Long> list = new ArrayList<>();
		while (zahl > 1) {
			list.add(zahl);
			if (zahl % 2 == 0) {
				zahl = zahl / 2;
			} else {
				zahl = (3 * zahl) + 1;
			}
		}
		list.add(zahl);
		checkList(list);
	}

	private synchronized void checkList(ArrayList<Long> list) {
		if (list.size() > Collatz.mainlist.size()) {
			Collatz.mainlist.clear();
			Collatz.mainlist.addAll(list);
		}

	}
}
