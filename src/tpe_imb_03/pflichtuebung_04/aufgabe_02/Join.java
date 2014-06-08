package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Join {
	static CountDownLatch startLatch = new CountDownLatch(1);
	static CountDownLatch endLatch = new CountDownLatch(4);

	static class Runner implements Runnable {

		@Override
		public void run() {
			try {
				startLatch.await();
				while (Collatz.startwert < 1000000) {
					folge(getzahl());
				}
				endLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
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
				Collatz.mainlist=list;
			}

		}
	}
}
