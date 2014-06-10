package tpe_imb_03.pflichtuebung_04.aufgabe_02;

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
		equals(runner.getStartwert() == 837799);
	}

	@Test
	public void folgenLaenge() throws InterruptedException {
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		equals(runner.getLaengesteFolge() == 525);
	}

}
