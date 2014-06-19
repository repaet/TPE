package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class JUnit {
	private Runner runner = new Runner();
	private Thread t1 = new Thread(runner);
	private Thread t2 = new Thread(runner);
	private Thread t3 = new Thread(runner);
	private Thread t4 = new Thread(runner);

	@Test
	public void startwertLaengsteFolge() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();

		assertTrue(runner.getStartwert() == 837799);
	}

	@Test
	public void elementeLaengsteFolge() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();

		assertTrue(runner.getLaengesteFolge() == 525);
	}
	@Test
	public void checkAufgabenblatt() {
		Collatz collatz = new Collatz(13);
		assertTrue(collatz.getFolgenlaenge() == 10);
	}
	
	@Test
	public void checkElementeAufgabenblatt() {
		Collatz collatz = new Collatz(13);
		
		ArrayList<Long> check = new ArrayList<Long>();
		check.add((long) 13);
		check.add((long) 40);
		check.add((long) 20);
		check.add((long) 10);
		check.add((long) 5);
		check.add((long) 16);
		check.add((long) 8);
		check.add((long) 4);
		check.add((long) 2);
		check.add((long) 1);
	
		assertEquals(check, collatz.getElementeReihe());
	}

}
