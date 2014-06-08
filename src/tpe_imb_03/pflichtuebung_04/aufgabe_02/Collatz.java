package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collatz {
	protected static int startwert;
	public static ArrayList<Long> mainlist = new ArrayList<>();

	public Collatz(int startwert) throws InterruptedException {
		Collatz.startwert = startwert;
		Join.Runner runner = new Join.Runner();
		Thread t1 = new Thread(runner);
		Thread t2 = new Thread(runner);
		Thread t3 = new Thread(runner);
		Thread t4 = new Thread(runner);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		Join.startLatch.countDown();
		Join.endLatch.await();
		new Iterator<Long>() {
			private int index = 0;
			public void ausgabe() {
				Iterator<Long> i = mainlist.iterator();
				while (i.hasNext()) {
					System.out.println(i.next());
					index++;
				}
				System.out.println("Die Folge ist "+ mainlist.size()+" Zahlen lang.");
			}

			public boolean hasNext() {
				return (index < mainlist.size());
			}

			public Long next() {
				return mainlist.get(index);
			}
		}.ausgabe();;
	}
}
