package tpe_imb_03.pflichtuebung_04.aufgabe_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnit {

	
	@Test
	public void ersteZahl() throws InterruptedException{
		new Collatz(1);
		assertTrue(Collatz.mainlist.get(0)== 837799);
	}
	
	@Test
	public void letzeZahl() throws InterruptedException{
		new Collatz(1);
		assertTrue(Collatz.mainlist.get(Collatz.mainlist.size()-1)== 1);
	}
	
	@Test
	public void folgenLaenge() throws InterruptedException{
		new Collatz(1);
		assertTrue((long)Collatz.mainlist.size()==525);
	}
	
	
}
