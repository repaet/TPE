package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class JUnit {
	Runner runner = new Runner();
	Thread t1 = new Thread(runner);
	Thread t2 = new Thread(runner);
	Thread t3 = new Thread(runner);
	Thread t4 = new Thread(runner);

	@Test
	public void ersteZahl() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		Runner.endLatch.await();
		
		assertEquals(runner.getStartwert(), 837799);
	}

	@Test
	public void folgenLaenge() throws InterruptedException {
		Runner.endLatch = new CountDownLatch(4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		Runner.endLatch.await();
		
		assertEquals(runner.getLaengesteFolge(), 525);
	}

	@Test
	public void check() {
		Collatz collatz = new Collatz(13);
		
		assertEquals(collatz.getCounter(), 10);
	}

}
