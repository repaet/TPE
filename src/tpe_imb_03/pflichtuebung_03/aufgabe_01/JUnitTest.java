package tpe_imb_03.pflichtuebung_03.aufgabe_01;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeList;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.list.NodeListImpl;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Breitensuche;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.SearchStrategy;
import tpe_imb_03.pflichtuebung_03.aufgabe_01.search.Tiefensuche;

public class JUnitTest {
	Node<Integer> a = new Node<Integer>("A", 2);
	Node<Integer> b = new Node<Integer>("B", 4);
	Node<Integer> c = new Node<Integer>("C", 3);
	Node<Integer> d = new Node<Integer>("D", 5);
	Node<Integer> e = new Node<Integer>("E", 3);
	Node<Integer> f = new Node<Integer>("F", 2);
	Node<Integer> g = new Node<Integer>("G", 5);
	Node<Integer> h = new Node<Integer>("H", 7);
	Node<Integer> i = new Node<Integer>("I", 9);
	Node<Integer> j = new Node<Integer>("J", 7);
	Node<Integer> k = new Node<Integer>("K", 11);
	Node<Integer> l = new Node<Integer>("L", 4);
	Node<Integer> m = new Node<Integer>("M", 7);
	Node<Integer> n = new Node<Integer>("N", 0);
	Node<Integer> o = new Node<Integer>("O", 8);
	Node<Integer> p = new Node<Integer>("P", 5);

	// Breitensuche: [A, B, C, D, E, F, G, L, M, O, P, H, I, J, K, N]

	@Test
	public void simulationBreitensuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);

		Graph<Integer> graph = new Graph<Integer>(a);
		SearchStrategy<Integer> breit = new Breitensuche<Integer>();
		graph.search(breit, 11);
		NodeList<Integer> list = breit.getPath();

		assertTrue(list.toString().equals(
				"[A, B, C, D, E, F, G, L, M, O, P, H, I, J, K, N]"));
	}

	@Test
	public void testBreitensuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);

		Graph<Integer> graph = new Graph<Integer>(a);
		SearchStrategy<Integer> breit = new Breitensuche<Integer>();
		NodeList<Integer> list = graph.search(breit, 3);

		assertTrue(list.toString().equals("[C, E]"));
	}

	// Tiefensuche: [A, B, E, H, I, F, J, K, G, C, L, M, N, D, O, P]

	@Test
	public void simulationTiefensuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);

		Graph<Integer> graph = new Graph<Integer>(a);
		SearchStrategy<Integer> tief = new Tiefensuche<Integer>();
		graph.search(tief, 11);
		NodeList<Integer> list = tief.getPath();

		assertTrue(list.toString().equals(
				"[A, B, E, H, I, F, J, K, G, C, L, M, N, D, O, P]"));
	}

	@Test
	public void testTiefensuche() {
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		b.addChild(e);
		b.addChild(f);
		b.addChild(g);
		e.addChild(h);
		e.addChild(i);
		f.addChild(j);
		f.addChild(k);
		c.addChild(l);
		c.addChild(m);
		m.addChild(n);
		d.addChild(o);
		d.addChild(p);

		Graph<Integer> graph = new Graph<Integer>(a);
		SearchStrategy<Integer> tief = new Tiefensuche<Integer>();
		NodeList<Integer> list = graph.search(tief, 3);

		assertTrue(list.toString().equals("[E, C]"));
	}

	@Test
	public void copyInto() {
		a.addChild(b);
		a.addChild(c);
		b.addChild(d);
		
		Graph<Integer> graph = new Graph<Integer>(a);
		NodeList<Integer> list = new NodeListImpl<Integer>();
		graph.copyInto(list);

		assertTrue(list.toString().equals("[A, B, D, C]"));
	}

}
