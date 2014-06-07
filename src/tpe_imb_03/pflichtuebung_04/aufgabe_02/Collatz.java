package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Collatz {
	protected static int startwert;
	public static ArrayList<Long> mainlist = new ArrayList<>();

	public Collatz(int startwert) {
		Collatz.startwert = startwert;

	}

	public void start() {
		Runner runner = new Runner();
		Thread t1 = new Thread(runner);
		Thread t2 = new Thread(runner);
		Thread t3 = new Thread(runner);
		Thread t4 = new Thread(runner);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		while(t1.isAlive()||t2.isAlive()||t3.isAlive()||t4.isAlive()){
			
		}
		System.out.println(mainlist);
		Iterator i = new Iterator() {
			public void getMaxFolge() {
				ListIterator<Long> i = mainlist.listIterator();
				while (i.hasNext()) {
					System.out.println(i.next());
				}
			}

			
			public Object next() {
				// TODO Auto-generated method stub
				return null;
			}

			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

		};
	}
}
